/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import backend.model.Item;
import backend.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ApplicationController extends ControllerParent{
    public ApplicationController() {
    }
    
    @RequestMapping("/")
    protected ModelAndView getLogin() throws Exception {
        return new ModelAndView("Login","messages","");
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView Login(@FormParam("username") String param1, @FormParam("password") String param2, HttpServletRequest  request){ 
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        ArrayList<String> errorMessages = new ArrayList<>();
        try {
            User u = getService().getUser(username);
            if(u.getPassword().equals(password)){
                request.getSession().setAttribute("User", u);
                return ShopOverview("All",request);
            }
            else
                errorMessages.add("incorrect password");
        } catch (Exception e) {
            errorMessages.add("User does not exist");
        }
        return new ModelAndView("Login","errorMessages",errorMessages); //TODO: authentication and login error
    }
    
     @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView Register(HttpServletRequest  request){ 
        String username = (String)request.getParameter("username");
        String nickname = (String)request.getParameter("nickname");
        String password = (String)request.getParameter("password");
        ArrayList<String> errorMessages = new ArrayList<>();
        
        try {
            User u = new User(username, nickname, password, 0, 0);
            System.out.println("user regigister");
            getService().addUser(u);
            request.getSession().setAttribute("User", u);   
            return ShopOverview("All",request);
        } catch (Exception e) {
            errorMessages.add(e.getMessage());
        }
        return new ModelAndView("Login","errorMessages",errorMessages); //TODO: authentication and login error
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView LoginNavigation(HttpServletRequest  request){ 
        if(authenticated(request))
            return ShopOverview("All",request);
        else 
            return new ModelAndView("Login","messages","please login first");
    }
    
    @RequestMapping(value="/purchase", method=RequestMethod.POST)
    public String purchaseItem(@RequestParam(value = "itemId")String itemId,HttpServletRequest  request) {
        if(!authenticated(request)) return "";
        User u = getAuthenticatedUser(request);
        Item i = getService().getItem(itemId);
        String message = "You don't have enough money to make this purchase";
        if(i!=null && u.getGold() > i.getPrice()){
            u.setGold(u.getGold() - i.getPrice());
            u.addItemToInventory(i);
            getService().updateUser(u);
            message = "You've successfully purchased an item";
        }
        return "{\"message\":\""+message+"\",\"gold\":\""+u.getGold()+"\"}";
    }
    
    @RequestMapping(value = "/shop",method = RequestMethod.GET)
    public ModelAndView ShopOverview(@RequestParam(value = "category",defaultValue = "All") String category,HttpServletRequest  request){
        if(!authenticated(request)) return new ModelAndView("Login","messages","You have to login before you can acces the shop");
        if(category.equals("All"))
             return new ModelAndView("Shop","items",getService().getItems());
        return new ModelAndView("Shop","items",getService().getItemsByCategory(category));
    }
    
    @RequestMapping(value = "/inventory",method = RequestMethod.GET)
    public ModelAndView getInventory( HttpServletRequest  request){
        if(!authenticated(request)) return new ModelAndView("Login","messages","You have to login before you can acces the shop");
        return new ModelAndView("Inventory","items",getService().getItemsFromUser(getAuthenticatedUser(request).getUsername()));
    }
    
    @RequestMapping(value = "/ItemDetail",method = RequestMethod.GET)
    public ModelAndView ItemDetail(@RequestParam(value = "id") String itemId,HttpServletRequest  request){
        if(!authenticated(request)) return new ModelAndView("Login","messages","You have to login before you can acces the shop");
        return new ModelAndView("ItemDetail","item",getService().getItem(itemId));
    }
    
    @RequestMapping(value = "/location",method = RequestMethod.GET)
    public String location(){
        return "It seems you are logging in from " + getRestService().getCountry() + " in " + getRestService().getContinent() + " more specifically: " + getRestService().getCity() + ", you may experience some lagg, we're sorry for the inconvenience.";  
    }
    
    @RequestMapping(value = "/signOut",method = RequestMethod.GET)
    public ModelAndView signOutView(HttpServletRequest  request){
        signOut(request);
        return new ModelAndView("Login","messages","Sucesfully signed out");
    }
}
