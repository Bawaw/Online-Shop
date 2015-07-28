/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bawaw
 */
@XmlRootElement
public class User {
    private String username;
    private String nickname;
    private String password;
    private int level;
    private int gold;
    private List<Item> inventory;
    public User() {
        inventory = new ArrayList<>();
    }

    public User(String username, String nickname, String password, int level, int gold) throws DomainException{ 
        setUsername(username);
        setNickname(nickname);
        setPassword(password);
        setGold(gold);
        setLevel(level);
        inventory = new ArrayList<>();
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setGold(int gold) throws DomainException  {
        if(gold < 0) throw new DomainException("Gold can not be negative value");
        this.gold = gold;
    }

    public void setLevel(int level) throws DomainException  {
        if(level < 0) throw new DomainException("Level can not be negative value");
        this.level = level;
    }

    public void setNickname(String nickname) throws DomainException {
        if(nickname == null || nickname.equals("")) throw new DomainException("Nickname can not be empty");
        this.nickname = nickname;
    }

    public void setPassword(String password) throws DomainException{
        if(password == null || password.equals("")) throw new DomainException("Password can not be empty");
        this.password = password;
    }

    public void setUsername(String username) throws DomainException {
        if(username == null || username.equals("")) throw new DomainException("Username can not be empty");
        this.username = username;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }
}
