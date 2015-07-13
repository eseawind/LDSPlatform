/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.oqc.DroidOqcDocumentHeader;
import com.leedarson.entities.oqc.DroidOqcDocumentLine;
import com.leedarson.entities.oqc.FqcHeader;
import com.leedarson.entities.oqc.HeaderSoNumber;
import com.leedarson.entities.pqc.ResultLine;
import com.leedarson.facades.fqc.DroidFqcDocumentHeaderFacadeLocal;
import com.leedarson.facades.oqc.DroidOqcDocumentHeaderFacadeLocal;
import com.leedarson.facades.oqc.DroidOqcDocumentLineFacadeLocal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("oqc")
@RequestScoped
public class DocumentOQCService {

    @Context
    private UriInfo context;
    
    @EJB
    private DroidOqcDocumentHeaderFacadeLocal documentOQCHeaderFacade;
    
    @EJB
    private DroidOqcDocumentLineFacadeLocal documentOQCLineFacade;
    
    @EJB
    private DroidFqcDocumentHeaderFacadeLocal documentFQCHeaderFacade;

    private static Gson gson;
    private static Logger logger = Logger.getLogger(ResourceRecordService.class.getName());
    /**
     * Creates a new instance of DocumentHeaderOQCService
     */
    public DocumentOQCService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }
    
    
    //生成检验批:年月日+六位流水码;
    private static int serial = 0;
    public synchronized String generateOrder() {
        
        String documentNum = documentOQCHeaderFacade.getLastDocumentNum();
        if(documentNum != null && !documentNum.equals("")){
            String lastDate = (documentNum.substring(0, 8));
            String lastOrderNum = (documentNum.substring(8)); 
            if(lastDate.equals(new SimpleDateFormat("yyyyMMdd").format(new Date()))){
            
                serial = Integer.parseInt(lastOrderNum);
            }else {
                serial = 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(++serial);

        while (sb.length() < 6) {
                sb.insert(0, "0");
        }

        sb.insert(0, new SimpleDateFormat("yyyyMMdd").format(new Date()));

        return sb.toString();
        
        
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.DocumentHeaderOQCService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("sonumber")
    @Produces("application/json")
    public String getByInnerSoNumber(@QueryParam("innerPoNumber") String innerPoNumber) {
        
        List<HeaderSoNumber> result = documentOQCHeaderFacade.getSoNumbers(innerPoNumber);
        return gson.toJson(result, List.class);
    }
    
    /**
     * 
     * GET & POST for Header
     */

    @GET
    @Path("headerinfo")
    @Produces("application/json")
    public String getHeaderInfo() {
        
        List<DroidOqcDocumentHeader> result = documentOQCHeaderFacade.findAll();
        return gson.toJson(result, List.class);
    }
    
    @POST
    @Path("create/header")
    @Produces("application/json")
    public String createHeader(String recordInfo) {
        
        DroidOqcDocumentHeader docHeader = gson.fromJson(recordInfo, DroidOqcDocumentHeader.class);
        String documentNumber = docHeader.getDocumentNumber();
        logger.info("documentNumber : " + documentNumber);
        
        if(documentNumber == null || documentNumber.isEmpty() || documentNumber.equals("")){
            
            docHeader.setDocumentNumber(generateOrder());
            docHeader.setCreatedBy(BigInteger.ZERO);
            docHeader.setCreationDate(new Date());
            docHeader.setLastUpdatedBy(BigInteger.ZERO);
            docHeader.setLastUpdateLogin(BigInteger.ZERO);
            docHeader.setLastUpdateDate(new Date());
        } 

        docHeader.setCreatedBy(BigInteger.ZERO);
        docHeader.setCreationDate(new Date());
        docHeader.setLastUpdatedBy(BigInteger.ZERO);
        docHeader.setLastUpdateLogin(BigInteger.ZERO);
        docHeader.setLastUpdateDate(new Date());
        
        
        documentOQCHeaderFacade.edit(docHeader);
        
        return docHeader.getDocumentNumber();
    }
    
    /**
     * 
     * GET & POST for Line
     */
    
    @GET
    @Path("lineresult")
    @Produces("application/json")
    public String getLineResult() {
        
        List<DroidOqcDocumentLine> result = documentOQCLineFacade.findAll();
        return gson.toJson(result, List.class);
    }
    
    @GET
    @Path("questionandresult")
    @Produces("application/json")
    public String getSingleResult(@QueryParam("documentNumber") String documentNumber) {
      
        List<ResultLine> result = documentOQCLineFacade.getResultList(documentNumber);
        
        return gson.toJson(result, List.class);
    }
    
    @POST
    @Path("create/line")
    @Produces("application/json")
    public String createLine(String recordInfo) {
        
        DroidOqcDocumentLine docLine = gson.fromJson(recordInfo, DroidOqcDocumentLine.class);
        
        docLine.setCreatedBy(BigInteger.ZERO);
        docLine.setCreationDate(new Date());
        docLine.setLastUpdatedBy(BigInteger.ZERO);
        docLine.setLastUpdateLogin(BigInteger.ZERO);
        docLine.setLastUpdateDate(new Date());
        
        
        documentOQCLineFacade.edit(docLine);
        
        return "{\"documentLineId\":\""+docLine.getDocumentLineId()+"\"}";
    }
    
    
    /**
     * GET home page list
     */
    @GET
    @Path("homelist")
    @Produces("application/json")
    public String getHomeList(@QueryParam("documentStatus") String documentStatus,
            @QueryParam("documentNumber") String documentNumber,@QueryParam("resultCode") String resultCode,
            @QueryParam("outboundNumber") String outboundNumber,@QueryParam("soNumber") String soNumber,
            @QueryParam("cabinetNumber") String cabinetNumber,@QueryParam("lockNumber") String lockNumber,
            @QueryParam("customer") String customer,@QueryParam("inspector") String inspector,
            @QueryParam("fromDate") String fromDate,@QueryParam("toDate") String toDate){
        
        List<DroidOqcDocumentHeader> result = documentOQCHeaderFacade.getHomeList(documentStatus ,documentNumber, resultCode, outboundNumber, soNumber, cabinetNumber, lockNumber, customer, inspector, fromDate, toDate);

        return gson.toJson(result, List.class);
    }
    
    @GET
    @Path("fqclist")
    @Produces("application/json")
    public String getFqcList(@QueryParam("plantId") String plantId, @QueryParam("status") String status,
            @QueryParam("customer") String customer,@QueryParam("itemCode") String itemCode,@QueryParam("workOrderNum") String workOrderNum,
            @QueryParam("fromDate") String fromDate,@QueryParam("toDate") String toDate){
        
        List<FqcHeader> result = documentFQCHeaderFacade.getFqcList(plantId, status, customer, itemCode, workOrderNum, fromDate, toDate);

        return gson.toJson(result, List.class);
    }

}
