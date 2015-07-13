/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.leedarson.entities.pqc.DroidDocumentHeader;
import com.leedarson.entities.pqc.DroidDocumentLine;
import com.leedarson.entities.pqc.HeaderInfo;
import static com.leedarson.entities.util.EntityUtil.objectToBigDecimal;
import static com.leedarson.entities.util.EntityUtil.objectToBigInteger;
import com.leedarson.facades.pqc.DroidDocumentHeaderFacadeLocal;
import com.leedarson.facades.pqc.DroidDocumentLineFacadeLocal;
import com.leedarson.facades.pqc.HeaderInfoFacadeLocal;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author chenfeng
 */
@Path("recorder")
@RequestScoped
public class ResourceRecordService {

    @Context
    private UriInfo context;
    
    @EJB
    private DroidDocumentHeaderFacadeLocal documentHeaderFacade;
    
    @EJB
    private HeaderInfoFacadeLocal headerInfoFacade;
    
    @EJB
    private DroidDocumentLineFacadeLocal documentLineFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(ResourceRecordService.class.getName());

    /**
     * Creates a new instance of HeaderService
     */
    public ResourceRecordService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    //生成检验批:年月日+五位流水码;
    private static int serial = 0;
    public synchronized String generateOrder() {
        
//        System.out.println("最大检验批号 : " + documentHeaderFacade.getLastDocumentNum() );
        String documentNum = documentHeaderFacade.getLastDocumentNum();
        if(documentNum != null && !documentNum.equals("")){
            String lastDate = (documentNum.substring(0, 8));
            String lastOrderNum = (documentNum.substring(8)); 
            if(lastDate.equals(new SimpleDateFormat("yyyyMMdd").format(new Date()))){
            
                serial = Integer.parseInt(lastOrderNum);
            }else {
                serial = 0;
            }
        }
               
//        System.out.println("最大检验批号 : " + "[lastDate:" + lastDate + ", lastOrderNum:" + lastOrderNum );
        
//        System.out.println("isToday : " + lastDate.equals(new SimpleDateFormat("yyyyMMdd").format(new Date())));
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(++serial);

        while (sb.length() < 5) {
                sb.insert(0, "0");
        }

        sb.insert(0, new SimpleDateFormat("yyyyMMdd").format(new Date()));

        return sb.toString();
        
        
    }
    
    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.HeaderService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        
        List<DroidDocumentHeader> result = documentHeaderFacade.findAll();
        
        return gson.toJson(result, List.class);
    }
    
    @GET
    @Path("headerInfo")
    @Produces("application/json")
    public String getHeaderInfo(@QueryParam("workOrderNum") String workOrderNum) {
        
        List<HeaderInfo> result = headerInfoFacade.getHeaderInfo(workOrderNum);
        
        if(result != null && !result.isEmpty()){
            
            return gson.toJson(result, List.class);
        }
        
        return "";
    }
    
    @POST
    @Path("create/header")
    @Produces("application/json")
    public String createHeader(String recordInfo) {
        
        
        String result = "false";
        
        DroidDocumentHeader docHeader = gson.fromJson(recordInfo, DroidDocumentHeader.class);
        if(docHeader.getDocumentNumber() != null){
            
            Object obj = documentHeaderFacade.isExitAlready(docHeader.getDocumentNumber().toString());
        
//        System.out.println("+++++++++++++++++" + obj.toString());
        
//        
            docHeader.setDocumentHeaderId(objectToBigDecimal(obj));
            docHeader.setCreatedBy(BigInteger.ZERO);
            docHeader.setLastUpdatedBy(BigInteger.ZERO);
            docHeader.setLastUpdateLogin(BigInteger.ZERO);
            docHeader.setLastUpdateDate(new Date());
            docHeader.setCreationDate(new Date());
            
            documentHeaderFacade.edit(docHeader);
            
            result = "true";
//           
//           
        }else {
            
            String order = generateOrder();
            docHeader.setDocumentNumber(order);
//            docHeader.setCreatedBy(BigInteger.ZERO);
//            docHeader.setLastUpdatedBy(BigInteger.ZERO);
//            docHeader.setLastUpdateLogin(BigInteger.ZERO);
            docHeader.setCreationDate(new Date());
            docHeader.setLastUpdateDate(new Date());
            
            documentHeaderFacade.create(docHeader);
            result = order;
        }
        
        return result;
    }
    
    
//    @GET
//    @Path("lineInfo")
//    @Produces("application/json")
//    public String getLineInfo() {
//        
//        List<DroidDocumentLine> result = documentLineFacade.findAll();
//        
//        return gson.toJson(result, List.class);
//    }
    
    @POST
    @Path("create/line")
    @Produces("application/json; charset=UTF-8")
    public String createLine(String recordInfo) {
       
//        System.out.println("recordInfo : " + recordInfo);
        String result = "false";
        
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> map = gson.fromJson(recordInfo, type);
        DroidDocumentLine docLine = new DroidDocumentLine();
//        DroidDocumentLine docLine = gson.fromJson(recordInfo, DroidDocumentLine.class);
        
        if(map !=null){
            List<DroidDocumentLine> list = null;
            Object obj = documentHeaderFacade.getHeaderIdbyDocumentNum(map.get("documentNumber"));
            if(obj != null){
                list = documentLineFacade.getResultOfLine(obj.toString(), 
                        Integer.parseInt(map.get("level1")),
                        Integer.parseInt(map.get("level2")), 
                        Integer.parseInt(map.get("level3")));
            }
            
            docLine.setDocumentHeaderId(objectToBigInteger(obj));
            docLine.setLevel1(objectToBigInteger(map.get("level1")));
            docLine.setLevel2(objectToBigInteger(map.get("level2")));
            docLine.setLevel3(objectToBigInteger(map.get("level3")));
            docLine.setOptionId(objectToBigInteger(map.get("optionId")));
            docLine.setResultCode(map.get("resultCode"));
            docLine.setResultText(map.get("resultText"));
            docLine.setCreatedBy(objectToBigInteger(map.get("createdBy")));
            docLine.setCreationDate(new Date());
            docLine.setLastUpdatedBy(objectToBigInteger(map.get("lastUpdatedBy")));            
            docLine.setLastUpdateDate(new Date());
            docLine.setLastUpdateLogin(objectToBigInteger(map.get("lastUpdateLogin")));
            if(list == null || list.isEmpty()){
                documentLineFacade.create(docLine);
            }else{
                docLine.setDocumentLineId(objectToBigDecimal(list.get(0).getDocumentLineId()));
//                System.out.println("resultText : "+ map.get("resultText"));
                documentLineFacade.edit(docLine);
            }
            result = "true";
           
        }
        
        return result;
    }

    /**
     * PUT method for updating or creating an instance of HeaderService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    
//    @GET
//    @Path("test")
//    @Consumes("application/json")
//    public String test(@QueryParam("docHeaderId") String docHeaderId,@QueryParam("level1") String level1 ,@QueryParam("level2") String level2, @QueryParam("level3") String level3){
//        
//        
//        List<DroidDocumentLine> result = documentLineFacade.getResultOfLine(docHeaderId, Integer.parseInt(level1), Integer.parseInt(level2), Integer.parseInt(level3));
//        
//        if(result != null && !result.isEmpty()){
//        
//            return gson.toJson(result, List.class);
//        }
//        
//        return null;
//        
//    }
}
