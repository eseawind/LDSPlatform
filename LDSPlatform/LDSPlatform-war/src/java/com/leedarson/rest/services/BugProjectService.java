/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.bugs.BugInfo;
import com.leedarson.facades.bugs.BugInfoFacadeLocal;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
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
@Path("buginfo")
@RequestScoped
public class BugProjectService {

    @Context
    private UriInfo context;
    
    @EJB
    private BugInfoFacadeLocal fqcBugInfoFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(ResourceRecordService.class.getName());

    /**
     * Creates a new instance of BugProjectService
     */
    public BugProjectService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.BugProjectService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getBugInfoByCode(@QueryParam("group") String group, @QueryParam("code") String code) {
      
        List<BugInfo> result = fqcBugInfoFacade.getBugInfo(group, code);
        
        return gson.toJson(result, List.class);
    }

    /**
     * PUT method for updating or creating an instance of BugProjectService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
