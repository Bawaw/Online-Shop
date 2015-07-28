/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import backend.model.Item;
import backend.model.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/DataManageController")
public class ItemDatabaseRestController extends ControllerParent{
    
    //create
    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody User u){ 
        getService().addUser(u);
    }
    
    //read
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public User getUser(){
        User user = getService().getUser("Admin");
        return user;
    }
    
    @RequestMapping(value="/users",method = RequestMethod.GET, produces = "application/json")
    public List<User> getUsers(){
        List<User> user = getService().getUsers();
        return user;
    }
    
    @RequestMapping(value = "/ShopItems",method = RequestMethod.GET)
    public @ResponseBody List<Item>ShopItemsXML(@RequestParam(value = "category",defaultValue = "All") String category,HttpServletRequest  request){
            List<Item> l;
            if(category.equals("All"))
                l = getService().getItems();
            else
                l = getService().getItemsByCategory(category);
            return l;
    }
    
    @RequestMapping(value = "/ItemDetail",method = RequestMethod.GET)
    public @ResponseBody Item ItemDetailXML(@RequestParam(value = "id") String itemId,HttpServletRequest  request){
        return getService().getItem(itemId);
    }
    
    //update
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTweet(@RequestBody User u) {
        getService().updateUser(u);
    }
    
    //delete
    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTweet(@RequestParam String name) {
        getService().removeUser(name);
    }
}
