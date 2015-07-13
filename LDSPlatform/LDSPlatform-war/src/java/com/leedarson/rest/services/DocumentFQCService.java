/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.fqc.DroidFqcBugHeader;
import com.leedarson.entities.fqc.DroidFqcBugLine;
import com.leedarson.entities.fqc.DroidFqcDocumentHeader;
import com.leedarson.entities.fqc.DroidFqcDocumentLine;
import com.leedarson.entities.fqc.BugResultLine;
import com.leedarson.entities.fqc.DocResultLine;
import com.leedarson.entities.pqc.HomeListInfo;
import com.leedarson.facades.fqc.DroidFqcBugHeaderFacadeLocal;
import com.leedarson.facades.fqc.DroidFqcBugLineFacadeLocal;
import com.leedarson.facades.fqc.DroidFqcDocumentHeaderFacadeLocal;
import com.leedarson.facades.fqc.DroidFqcDocumentLineFacadeLocal;
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
@Path("fqc")
@RequestScoped
public class DocumentFQCService {

    @Context
    private UriInfo context;
    
    @EJB
    private DroidFqcBugHeaderFacadeLocal fqcBugHeaderFacade;
    
    @EJB
    private DroidFqcBugLineFacadeLocal fqcBugLineFacade;
    
    @EJB
    private DroidFqcDocumentHeaderFacadeLocal fqcDocumentHeaderFacade;
    
    @EJB
    private DroidFqcDocumentLineFacadeLocal fqcDocumentLineFacade;
   
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(ResourceRecordService.class.getName());

    /**
     * Creates a new instance of DocumentFQCService
     */
    public DocumentFQCService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }
    
    //生成检验批:年月日+六位流水码;
    private static int serial = 0;
    public synchronized String generateOrder() {
        
        String documentNum = fqcDocumentHeaderFacade.getLastDocumentNum();
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
     * Retrieves representation of an instance of com.leedarson.rest.services.DocumentFQCService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getTest() {
        
        List<DroidFqcDocumentLine> result = fqcDocumentLineFacade.findAll();
//        List<DroidFqcBugHeader> result = fqcBugHeaderFacade.findAll();
        
        return gson.toJson(result, List.class);
    }
    
    @GET
    @Path("homelist")
    @Produces("application/json")
    public String getHomeList(@QueryParam("documentStatus") String documentStatus,@QueryParam("poNumber") String poNumber,
            @QueryParam("productionLine") String productionLine,@QueryParam("customer") String customer,
            @QueryParam("fromDate") String fromDate,@QueryParam("toDate") String toDate,
            @QueryParam("workOrderNum") String workOrderNum,@QueryParam("plantId") String plantId) {
        //TODO return proper representation object
        List<HomeListInfo> result = fqcDocumentHeaderFacade.getHomeList(documentStatus, poNumber, productionLine, customer, fromDate, toDate,workOrderNum,plantId);
        return gson.toJson(result, List.class);
    }
    
    @GET
    @Path("doc/result")
    @Produces("application/json")
    public String getDocResult(@QueryParam("documentNumber") String documentNumber) {
      
        List<DocResultLine> result = fqcDocumentLineFacade.getResultList(documentNumber);
        
        return gson.toJson(result, List.class);
    }
    
    @GET
    @Path("bug/result")
    @Produces("application/json")
    public String getBugResult(@QueryParam("documentNumber") String documentNumber,
            @QueryParam("bugLevel") String bugLevel) {
      
        List<BugResultLine> result = fqcBugLineFacade.getResultList(documentNumber,bugLevel);
        
        return gson.toJson(result, List.class);
    }
    
    @POST
    @Path("create/docheader")
    public String createDocHeader(String recordInfo){
        
        DroidFqcDocumentHeader docHeader = gson.fromJson(recordInfo, DroidFqcDocumentHeader.class);
        String documentNumber = docHeader.getDocumentNumber();
        logger.info("documentNumber : " + documentNumber);
        if(documentNumber == null || documentNumber.isEmpty() || documentNumber.equals("")){
            
            docHeader.setDocumentNumber(generateOrder());
//            docHeader.setCreatedBy(BigInteger.ZERO);
            docHeader.setCreationDate(new Date());
//            docHeader.setLastUpdatedBy(BigInteger.ZERO);
            docHeader.setLastUpdateDate(new Date());
        }
        
//        docHeader.setCreatedBy(BigInteger.ZERO);
        docHeader.setCreationDate(new Date());
//        docHeader.setLastUpdatedBy(BigInteger.ZERO);
        docHeader.setLastUpdateDate(new Date());
        
        fqcDocumentHeaderFacade.edit(docHeader);
        return docHeader.getDocumentNumber();
    }
    
    @POST
    @Path("create/docline")
    public String createDocLine(String recordInfo){
        
        DroidFqcDocumentLine docLine = gson.fromJson(recordInfo, DroidFqcDocumentLine.class);
        
//        docLine.setCreatedBy(BigInteger.ZERO);
        docLine.setCreationDate(new Date());
//        docLine.setLastUpdatedBy(BigInteger.ZERO);
        docLine.setLastUpdateDate(new Date());
        
        fqcDocumentLineFacade.edit(docLine);
        return docLine.getDocumentLineId();
    }

    @POST
    @Path("create/bugheader")
    public String createBugHeader(String recordInfo){
        
        DroidFqcBugHeader bugHeader = gson.fromJson(recordInfo, DroidFqcBugHeader.class);
        
//        bugHeader.setCreatedBy(BigInteger.ZERO);
        bugHeader.setCreationDate(new Date());
//        bugHeader.setLastUpdatedBy(BigInteger.ZERO);
        bugHeader.setLastUpdateDate(new Date());
        
        fqcBugHeaderFacade.edit(bugHeader);
        return bugHeader.getDocumentBugHeaderId();
    }
    
    @POST
    @Path("create/bugline")
    public String createBugLine(String recordInfo){
        
        DroidFqcBugLine bugLine = gson.fromJson(recordInfo, DroidFqcBugLine.class);
        
        bugLine.setCreatedBy(BigInteger.ZERO);
        bugLine.setCreationDate(new Date());
        bugLine.setLastUpdatedBy(BigInteger.ZERO);
        bugLine.setLastUpdateDate(new Date());
        
        fqcBugLineFacade.edit(bugLine);
        return bugLine.getDocumentBugLineId();
    }
    
    
}
