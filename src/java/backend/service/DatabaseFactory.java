/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.service;

import backend.database.DatabaseException;
import backend.database.IDatabase;
import backend.database.InMemory;
import backend.database.SQLDatabase;
import java.util.Properties;

/**
 *
 * @author Bawaw
 */
public class DatabaseFactory{
    public static IDatabase create(String type){
        if(type.equals("inmemory"))
            return new InMemory();
        else if(type.equals("postgres"))
            return new SQLDatabase();
        else
            throw new DatabaseException("Database type not supported");
    }
}
