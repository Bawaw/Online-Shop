/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.service;

import backend.database.IDatabase;
import backend.geoIP.ServiceIP;
import backend.model.Item;
import backend.model.User;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Bawaw
 */
public class Service{
    IDatabase database; 
    public Service(String databaseType) {
        //String databaseType = properties.getProperty("databaseType");
        System.out.println(databaseType);
        database = DatabaseFactory.create(databaseType);
    }
    
    public List<User> getUsers(){
        return database.getUsers();
    }
    
    public User getUser(String username){
        return database.getUser(username);
    }
    
    public Item getItem(String itemId){
        return database.getItem(itemId);
    }
    public void addUser(User user){
        database.addUser(user);
    }
    
    public List<Item> getItems(){
        return database.getItems();
    }
    
    public List<Item> getItemsFromUser(String username){
        return database.getItemsFromUser(username);
    }
    
    public void updateUser(User user){
        database.updateUser(user);
    }
    
    public List<Item> getItemsByCategory(String Category){
        return database.getItemsByCategory(Category);
    }
    
    public void removeUser(String username){
        database.removeUser(username);
    }
}
