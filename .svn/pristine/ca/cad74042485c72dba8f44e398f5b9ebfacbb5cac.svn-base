/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.database;

import backend.model.Item;
import backend.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bawaw
 */
public class SQLDatabase implements IDatabase{

    Map<String,User> users;
    Map<String,Item> items;
    
    private Connection connection;
    private PreparedStatement prepairedStatement;
    Properties properties;
    
    public SQLDatabase() {
        try {
            properties = new Properties();
            properties.setProperty("user", "r0457098");
            properties.setProperty("password", "");     //PASSWORD MUST BE FILLED IN TO USE
            properties.setProperty("ssl", "true");
            properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    private void executeQuery(String query) throws SQLException{
        connection = DriverManager.getConnection("jdbc:postgresql://gegevensbanken.khleuven.be:51314/2TX33",properties);
        prepairedStatement = connection.prepareStatement(query);
    }
    
    private void closeConnection(){
        try {
            prepairedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> persons = new ArrayList<User>();
        try {
            String query = "SELECT * FROM project_r0457098.user";
            executeQuery(query);
            ResultSet result = prepairedStatement.executeQuery();
            while (result.next()) {
                String username = result.getString("email");
                String nickname = result.getString("nickname");
                String password = result.getString("password");
                int level = Integer.parseInt(result.getString("level"));
                int gold = Integer.parseInt(result.getString("gold"));
                User u = new User(username, nickname, password,level,gold);
                u.setInventory(getItemsFromUser(username));
                persons.add(u); 
            }
            return persons;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }
    
    @Override
    public User getUser(String username) {
        User person = null;
        try {
            String sql = "SELECT * FROM project_r0457098.user WHERE email= ?";
            executeQuery(sql);
            prepairedStatement.setString(1, username);
            ResultSet result = prepairedStatement.executeQuery();
            while (result.next()) {
                String nickname = result.getString("nickname");
                String password = result.getString("password");
                int level = Integer.parseInt(result.getString("level"));
                int gold = Integer.parseInt(result.getString("gold"));
                person = new User(username, nickname, password, level, gold);
                person.setInventory(getItemsFromUser(username));
            }
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
        return person;
    }

    @Override
    public void addUser(User user) {
        if(user == null)
			throw new DatabaseException("Please enter a valid user");
		String query = "INSERT INTO project_r0457098.user (email,nickname,password,level,gold) VALUES(?,?,?,?,?)";
		try {
                        executeQuery(query);
			prepairedStatement.setString(1, user.getUsername());
			prepairedStatement.setString(2, user.getNickname());
			prepairedStatement.setString(3, user.getPassword());
                        prepairedStatement.setString(4, Integer.toString(user.getLevel()));
			prepairedStatement.setString(5, Integer.toString(user.getGold()));
			prepairedStatement.execute();
		} catch (Exception e) {
			throw new DatabaseException("Could not process query",e);
		}finally{
			closeConnection();
		}
    }

    @Override
    public void updateUser(User user) {
       if (user == null) {
			throw new DatabaseException("Nothing to update.");
		}
		
		try {
                        String sql = "UPDATE project_r0457098.user SET nickname=?, password=?, level=?, gold=? WHERE email=?";
			executeQuery(sql);
			prepairedStatement.setString(1, user.getNickname());
			prepairedStatement.setString(2, user.getPassword());
                        prepairedStatement.setInt(3, user.getLevel());
			prepairedStatement.setInt(4, user.getGold());
                        prepairedStatement.setString(5, user.getUsername());
			prepairedStatement.execute();
                        for (Item i : user.getInventory()) {
                            sql = "INSERT INTO project_r0457098.inventory(email, \"itemId\") VALUES (?, ?);";
                            executeQuery(sql);
                            prepairedStatement.setString(1, user.getUsername());
                            prepairedStatement.setString(2, i.getItemId());
                            prepairedStatement.execute();
                        }
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(),e);
		} finally {
			closeConnection();
		}
    }

    @Override
    public List<Item> getItems() {
          List<Item> items = new ArrayList<Item>();
        try {
            String query = "SELECT * FROM project_r0457098.item";
            executeQuery(query);
            ResultSet result = prepairedStatement.executeQuery();
            while (result.next()) {
                int level = Integer.parseInt(result.getString("level"));
                int price = Integer.parseInt(result.getString("price"));
                int strength = Integer.parseInt(result.getString("strength"));
                int intelligence = Integer.parseInt(result.getString("intelligence"));
                int dexterity = Integer.parseInt(result.getString("dexterity"));
                String description = result.getString("description");
                String imagePath = result.getString("imagePath");
                
                String name = result.getString("name");
                String itemId = result.getString("itemId");
                String category = result.getString("category");
                items.add(new Item(itemId, category, description, name, imagePath, level, strength, intelligence, dexterity, price));
            }
            return items;
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public Item getItem(String itemId) {
           Item item = null;
        try {
            String query = "SELECT * FROM project_r0457098.item WHERE \"itemId\"=?";
            executeQuery(query);
            prepairedStatement.setString(1, itemId);
            ResultSet result = prepairedStatement.executeQuery();
            while (result.next()) {
                int level = Integer.parseInt(result.getString("level"));
                int price = Integer.parseInt(result.getString("price"));
                int strength = Integer.parseInt(result.getString("strength"));
                int intelligence = Integer.parseInt(result.getString("intelligence"));
                int dexterity = Integer.parseInt(result.getString("dexterity"));
                String description = result.getString("description");
                String imagePath = result.getString("imagePath");
                
                String name = result.getString("name");
                String category = result.getString("category");
                item = new Item(itemId, category, description, name, imagePath, level, strength, intelligence, dexterity, price);
            }
            return item;
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Item> getItemsFromUser(String userName) {
        List<Item> items = new ArrayList<Item>();
        try {
            String query = "SELECT * FROM project_r0457098.inventory inner join project_r0457098.item USING(\"itemId\") WHERE email=?";
            executeQuery(query);
            prepairedStatement.setString(1, userName);
            ResultSet result = prepairedStatement.executeQuery();
            while (result.next()) {
                String itemId = result.getString("itemId");
                int level = Integer.parseInt(result.getString("level"));
                int price = Integer.parseInt(result.getString("price"));
                int strength = Integer.parseInt(result.getString("strength"));
                int intelligence = Integer.parseInt(result.getString("intelligence"));
                int dexterity = Integer.parseInt(result.getString("dexterity"));
                String description = result.getString("description");
                String imagePath = result.getString("imagePath");
                
                String name = result.getString("name");
                String category = result.getString("category");
                items.add(new Item(itemId, category, description, name, imagePath, level, strength, intelligence, dexterity, price));
            }
            return items;
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Item> getItemsByCategory(String Category) {
                List<Item> items = new ArrayList<Item>();
        try {
            String query = "SELECT * FROM project_r0457098.item WHERE category=?";
            executeQuery(query);
            prepairedStatement.setString(1, Category);
            ResultSet result = prepairedStatement.executeQuery();
            while (result.next()) {
                String itemId = result.getString("itemId");
                int level = Integer.parseInt(result.getString("level"));
                int price = Integer.parseInt(result.getString("price"));
                int strength = Integer.parseInt(result.getString("strength"));
                int intelligence = Integer.parseInt(result.getString("intelligence"));
                int dexterity = Integer.parseInt(result.getString("dexterity"));
                String description = result.getString("description");
                String imagePath = result.getString("imagePath");
                
                String name = result.getString("name");
                items.add(new Item(itemId, Category, description, name, imagePath, level, strength, intelligence, dexterity, price));
            }
            return items;
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void removeUser(String username) {
        if (username == null) {
            throw new DatabaseException("Nothing to delete.");
        }
        String sql = "DELETE FROM project_r0457098.user WHERE email=?";
        try {
            executeQuery(sql);
            prepairedStatement.setString(1, username);
            prepairedStatement.execute();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            closeConnection();
        }
    }
}
