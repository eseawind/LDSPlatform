/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

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
@Path("softwareinfo")
@RequestScoped
public class SoftwareinfoSerivce {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SoftwareinfoSerivce
     */
    public SoftwareinfoSerivce() {
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.SoftwareinfoSerivce
     * @return an instance of java.lang.String
     */
    @Path("androidversion")
    @GET
    @Produces("application/json")
    public String getCurrentPQCVsersion() {
        return "{\"version\":\"1.03\"}";
    }
    
    @Path("oqcversion")
    @GET
    @Produces("application/json")
    public String getCurrentOQCVsersion() {
        return "{\"version\":\"1.01\"}";
    }
    
    @Path("fqcversion")
    @GET
    @Produces("application/json")
    public String getCurrentFQCVsersion() {
        return "{\"version\":\"1.01\"}";
    }
    
}
