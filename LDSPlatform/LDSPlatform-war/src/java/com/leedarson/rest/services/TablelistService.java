/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.pqc.TableList;
import com.leedarson.facades.pqc.TableListFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author chenfeng
 */
@Path("tablelist")
@RequestScoped
public class TablelistService {

    @Context
    private UriInfo context;
    
    @EJB
    private TableListFacadeLocal tableListFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(TablelistService.class.getName());

    /**
     * Creates a new instance of TablelistService
     */
    public TablelistService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.TablelistService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getPqcTableList() {
        
        List<TableList> result = tableListFacade.getTableList("S_","X_");
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return null;
    }
    
    @GET
    @Path("oqcj")
    @Produces("application/json")
    public String getOqcjTableList() {
        
        List<TableList> result = tableListFacade.getTableList("OQC_J","OQC_J");
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return null;
    }
    
    @GET
    @Path("fqc")
    @Produces("application/json")
    public String getFqcjTableList() {
        
        List<TableList> result = tableListFacade.getTableList("FQC","FQC");
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return null;
    }
    
}
