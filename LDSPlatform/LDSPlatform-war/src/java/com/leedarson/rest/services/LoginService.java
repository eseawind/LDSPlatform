/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author chenfeng
 */
@Path("login")
@RequestScoped
public class LoginService {

    @Context
    private UriInfo context;
    
    @Context
    private HttpServletRequest request;
    
    @Context
    private HttpServletResponse response;
    
    private static Gson gson;
    private static Logger logger = Logger.getLogger(LoginService.class.getName());

    /**
     * Creates a new instance of LoginService
     */
    public LoginService() {
        
        if(gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss Z")
                    .create();
        }
    }

    private void sessionProcess() {
        //getSession:if there's no current session，return null
        HttpSession session = request.getSession(false);
        if (session != null && !session.isNew()) {
            //如果当前有session,销毁session
            session.invalidate();
        }
        //重新获取session
        session = request.getSession(true);
    }
    
    @POST
    @Produces("application/json")
    public String login(String content) {
        
        this.sessionProcess();
        
        String result = "false";
        
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> namepass = gson.fromJson(content, type);
        
        if (namepass != null && namepass.size() > 0) {
            
            try {
                if (request.getUserPrincipal() != null) {
                    request.logout();
                }
                request.login(namepass.get("username"), namepass.get("password"));
                logger.info("response : " + request.getRemoteUser());
            } catch (ServletException ex) {
                    Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        response.sendError(response.SC_UNAUTHORIZED);
                    } catch (IOException ex1) {
                        Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    return result;
            }
            result = "true";
        }        
        
        return result;
    }
    
}
