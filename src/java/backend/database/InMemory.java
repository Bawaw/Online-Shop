/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.database;

import backend.model.Item;
import backend.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 *
 * @author Bawaw
 */
public class InMemory implements IDatabase{

    Map<String,User> users;
    Map<String,Item> items;
    
    public InMemory() {
        users = new HashMap<>();
        items = new HashMap<>();
        User p1 = new User("Admin", "Admin", "t",9000 , 9000);
        User p2 = new User("Bawaw", "Bawaw", "t",500 , 500);
        User p3 = new User("Himitsu", "Himitsu", "t",500 , 500);
        
        Item i1 = new Item("1","Boots","Boots made of firm but light leather. Just wearing it arouses a desire to run.", "Leather Boots","DragonplateBoots.png", 1, 0, 0, 0,1);
        Item i2 = new Item("2","Sword", "An ancient greatsword of unknown origin. This sword was passed down through generations, until it reached Gordin, wandering knight of Forossa, and was lost upon his death. Uncannily, every last one of the prominent swordsmen who inherited this weapon was left-handed.","Majestic Greatsword","greatsword.png", 3, 0, 0, 0,1);
        Item i3 = new Item("3","Sword", " This blade belonged to Dabbar, a long dead servant of Bhaal that exercised control over his minions in the most brutal of ways. In addition to strengthening the mind against the guile of others, the sword absorbs life energy from an opponent with each successful hit, healing the user. Dabbar considered it a failure of his officers if he returned from battle in less than perfect health, and as the rest of the company watched, he would administer beatings until fully healed. ", "Longsword","longsword.png", 2, 0, 0, 0,1);
        
        Item i4 = new Item("4","Boots", "Leather boots covered by steel", "Plated boots","DaedricBoots.png", 4, 0, 0, 0,1);
        Item i5 = new Item("5","Armor", "Made from the skin of an Elk", "Rare Leather Armor","steelArmor.png", 3, 0, 0, 0,1);
        
        Item i6 = new Item("6","Armor", "Old armor, but very sturdy", "Ancient Armor","SickArmor.png", 5, 0, 0, 0,5028);
        Item i7 = new Item("7","Shield", "Old armor, but very sturdy", "Ancient Armor","steelclash.png", 5, 0, 0, 0,5028);
        Item i8 = new Item("8","Shield", "Old armor, but very sturdy", "Ancient Armor","kiteshield.png", 5, 0, 0, 0,5028);
        
        p1.addItemToInventory(i1);
        p2.addItemToInventory(i2);
        p3.addItemToInventory(i3);
        
        p1.addItemToInventory(i4);
        p1.addItemToInventory(i5);
        p3.addItemToInventory(i5);
        
        users.put(p1.getUsername(),p1);
        users.put(p2.getUsername(),p2);
        users.put(p3.getUsername(),p3);
        
        items.put(i1.getItemId(), i1);
        items.put(i2.getItemId(), i2);
        items.put(i3.getItemId(), i3);
        items.put(i4.getItemId(), i4);
        items.put(i5.getItemId(), i5);
        items.put(i6.getItemId(), i6);
        items.put(i7.getItemId(), i7);
        items.put(i8.getItemId(), i8);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<User>(users.values());
    }
    
    @Override
     public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void addUser(User user) {
        if(users.containsKey(user.getUsername())) throw new DatabaseException("User already exists");
        users.put(user.getUsername(), user);
    }

    @Override
    public void updateUser(User user) {
        if(!users.containsKey(user.getUsername())) throw new DatabaseException("User does not exists");
        users.put(user.getUsername(), user);
    }

    @Override
    public List<Item> getItems() {
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(String itemId) {
        return items.get(itemId);
        
    }

    @Override
    public List<Item> getItemsFromUser(String userName) {
        return users.get(userName).getInventory();
    }

    @Override
    public List<Item> getItemsByCategory(String Category) {
        List<Item> _t = new ArrayList<>();   
        for (Item i : items.values()) {
            if(i.getCategory().equals(Category)) _t.add(i);
        }
        if(_t.isEmpty()) _t = null;
        return _t;
    }

    @Override
    public void removeUser(String username) {
        users.remove(username);
    }
}
