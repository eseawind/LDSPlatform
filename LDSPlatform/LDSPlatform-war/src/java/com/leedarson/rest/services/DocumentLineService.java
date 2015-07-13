/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.pqc.ResultLine;
import com.leedarson.facades.pqc.DroidDocumentLineFacadeLocal;
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
@Path("result")
@RequestScoped
public class DocumentLineService {

    @Context
    private UriInfo context;
    
    @EJB
    private DroidDocumentLineFacadeLocal documentLineFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(ResourceRecordService.class.getName());


    /**
     * Creates a new instance of DocumentLineService
     */
    public DocumentLineService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.DocumentLineService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("questionandresult")
    @Produces("application/json")
    public String getSingleResult(@QueryParam("documentNumber") String documentNumber) {
        
        
//        List<DroidDocumentLine> result = documentLineFacade.getResultBydocumentNumber("20140928012");
        List<ResultLine> result = documentLineFacade.getResultList(documentNumber);
        
        return gson.toJson(result, List.class);
    }

    /**
     * PUT method for updating or creating an instance of DocumentLineService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
