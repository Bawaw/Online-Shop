/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.database;
import java.util.List;
import backend.model.Item;
import backend.model.User;
/**
 *
 * @author Bawaw
 */
public class DatabaseTest {
    public static void main(String[] args) {
        SQLDatabase sqlDatabase = new SQLDatabase();
        List<User> items = sqlDatabase.getUsers();
        for (User item : items) {
            System.err.println(item.getUsername());
        }
    }
}
