/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import backend.geoIP.ServiceIP;
import backend.model.User;
import backend.service.Service;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;


@RestController
public abstract class ControllerParent{
    private static final long serialVersionUID = 1L;
    private Service service;
    private ServiceIP restService;
   
    
    public ControllerParent() {
        super();
        service = new Service("inmemory");
        restService = new ServiceIP();
    }

    public ServiceIP getRestService() {
        return restService;
    }

    public Service getService() {
        return service;
    }
    
    //@Autowired
    public void setService(Service service){
        this.service = service;
    }
    
    public boolean authenticated(HttpServletRequest request){
        User u = (User)request.getSession().getAttribute("User");
        request.setAttribute("user", u);
        return u != null;
    }
    
    public User getAuthenticatedUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute("User");
    }
    
    public void signOut(HttpServletRequest request){
        request.getSession().invalidate();
    }
}
