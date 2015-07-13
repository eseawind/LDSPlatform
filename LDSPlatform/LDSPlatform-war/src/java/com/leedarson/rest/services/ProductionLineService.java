/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.pqc.HcmProductionLine;
import static com.leedarson.entities.util.EntityUtil.objectToBigInteger;
import com.leedarson.facades.pqc.HcmProductionLineFacadeLocal;
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
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author chenfeng
 */
@Path("prodline")
@RequestScoped
public class ProductionLineService {

    @Context
    private UriInfo context;
    
    @EJB
    private HcmProductionLineFacadeLocal productionLineFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(ProductionLineService.class.getName());


    /**
     * Creates a new instance of ProdlineService
     */
    public ProductionLineService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.ProdlineService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("prodLineGroupId")
    @Produces("application/json")
    public String getProductionLineById(@QueryParam("prodLineGroupId") String prodLineGroupId) {
        //TODO return proper representation object
        List<HcmProductionLine> result = productionLineFacade.getProductionLineById(objectToBigInteger(prodLineGroupId));
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }

    /**
     * PUT method for updating or creating an instance of ProdlineService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
