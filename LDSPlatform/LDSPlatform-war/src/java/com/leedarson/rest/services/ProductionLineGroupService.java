/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.pqc.HcmProductionLineGroup;
import com.leedarson.facades.pqc.HcmProductionLineGroupFacadeLocal;
import java.util.List;
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

/**
 * REST Web Service
 *
 * @author chenfeng
 */
@Path("linegroup")
@RequestScoped
public class ProductionLineGroupService {

    @Context
    private UriInfo context;
    
    @EJB
    private HcmProductionLineGroupFacadeLocal productionLineGroupFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(ProductionLineGroupService.class.getName());

    /**
     * Creates a new instance of LineGroupService
     */
    public ProductionLineGroupService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.LineGroupService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getProductionLineGroup() {
        //TODO return proper representation object
       
        List<HcmProductionLineGroup> result = productionLineGroupFacade.findAll();
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }

    /**
     * PUT method for updating or creating an instance of LineGroupService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
