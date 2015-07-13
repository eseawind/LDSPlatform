/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.pqc.HcmPlant;
import com.leedarson.entities.pqc.HomeListInfo;
import com.leedarson.facades.pqc.DroidDocumentHeaderFacadeLocal;
import com.leedarson.facades.pqc.HcmPlantFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author chenfeng
 */
@Path("header")
@RequestScoped
public class DocumentHeaderService {

    @Context
    private UriInfo context;
    
    @EJB
    private DroidDocumentHeaderFacadeLocal documentHeaderFacade;
    
    @EJB
    private HcmPlantFacadeLocal plantFacade;
    
    private static Gson gson;
    private static final Logger LOG = Logger.getLogger(DocumentHeaderService.class.getName());
    

    /**
     * Creates a new instance of DocumentHeaderService
     */
    public DocumentHeaderService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.DocumentHeaderService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("homelist")
    @Produces("application/json")
    public String getHomeList(@QueryParam("documentStatus") String documentStatus,@QueryParam("poNumber") String poNumber,
            @QueryParam("productionLine") String productionLine,@QueryParam("customer") String customer,
            @QueryParam("fromDate") String fromDate,@QueryParam("toDate") String toDate,
            @QueryParam("workOrderNum") String workOrderNum,@QueryParam("plantId") String plantId) {
        //TODO return proper representation object
        List<HomeListInfo> result = documentHeaderFacade.getHomeList(documentStatus, poNumber, productionLine, customer, fromDate, toDate,workOrderNum,plantId);
        return gson.toJson(result, List.class);
    }
    
    
    @GET
    @Path("plant")
    @Produces("application/json")
    public String getPlants(){
        
        List<HcmPlant> result = plantFacade.findAll();
        
        return gson.toJson(result, List.class);
    }

    /**
     * PUT method for updating or creating an instance of DocumentHeaderService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
        
    }
}
