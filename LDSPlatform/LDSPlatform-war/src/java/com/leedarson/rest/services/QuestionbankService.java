/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leedarson.entities.pqc.DroidQuestionBank;
import com.leedarson.entities.pqc.DroidQuestionOptions;
import com.leedarson.facades.pqc.DroidQuestionBankFacadeLocal;
import com.leedarson.facades.pqc.DroidQuestionOptionsFacadeLocal;
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
@Path("questionbank")
@RequestScoped
public class QuestionbankService {

    @Context
    private UriInfo context;
    
    @EJB
    private DroidQuestionBankFacadeLocal questionBankFacade;
    @EJB
    private DroidQuestionOptionsFacadeLocal questionOptionsFacade;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(QuestionbankService.class.getName());

    /**
     * Creates a new instance of QuestionbankService
     */
    public QuestionbankService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    /**
     * Retrieves representation of an instance of com.leedarson.rest.services.QuestionbankService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("firstQuestion")
    @Produces("application/json")
    public String getFirstQuestion(@QueryParam("questionType") String questionType) {
        
        //TODO return proper representation object
        List<DroidQuestionBank> result = questionBankFacade.getFirstQuestion(questionType);
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }
    
    @GET
    @Path("questionContents")
    @Produces("application/json")
    public String getQuestionContents(@QueryParam("questionType") String questionType) {
        
        //TODO return proper representation object
        List<DroidQuestionBank> result = questionBankFacade.getQuestionContents(questionType);
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }
    
    @GET
    @Path("questionOptions")
    @Produces("application/json")
    public String getQuestionOptions(@QueryParam("questionId") int questionId) {
 
        //TODO return proper representation object
        List<DroidQuestionOptions> result = questionOptionsFacade.getQuestionOptions(questionId);
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return null;
    }
    
    @GET
    @Path("nextQuestion")
    @Produces("application/json")
    public String getNextQuestion(@QueryParam("questionType") String questionType, @QueryParam("level_1") int level_1, @QueryParam("level_2") int level_2, @QueryParam("level_3") int level_3) {
 
//        System.out.println("questionType="+questionType+", level_1="+" ,level_2="+level_2+" ,level_3="+level_3);
        //TODO return proper representation object
        List<DroidQuestionBank> result = questionBankFacade.getNextQuestion(questionType, level_1, level_2, level_3);
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }

    @GET
    @Path("getQuestion")
    @Produces("application/json")
    public String getQuestionById(@QueryParam("questionId") int questionId) {
 
        //TODO return proper representation object
        List<DroidQuestionBank> result = questionBankFacade.getQuestionById(questionId);
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }
    
    
    @GET
    @Path("questionlist")
    @Produces("application/json")
    public String getQuestionsByType(@QueryParam("questionType") String questionType) {
        
        //TODO return proper representation object
        List<DroidQuestionBank> result = questionBankFacade.getQuestionsByType(questionType);
        
        if(result != null && !result.isEmpty()){
        
            return gson.toJson(result, List.class);
        }
        
        return "";
    }
    
    /**
     * PUT method for updating or creating an instance of QuestionbankService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
