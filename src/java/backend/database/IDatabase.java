/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.database;

import backend.model.Item;
import backend.model.User;
import java.util.List;

/**
 *
 * @author Bawaw
 */
public interface IDatabase {
       public List<User> getUsers();
        public void addUser(User user);
       public User getUser(String username);
       public void updateUser(User user);
       
       public List<Item> getItems();
       public Item getItem(String itemId);
     
       public List<Item> getItemsFromUser(String userName);
       public List<Item> getItemsByCategory(String Category);
       public void removeUser(String username);
       
}
