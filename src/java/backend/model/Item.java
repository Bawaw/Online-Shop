/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.model;

import java.io.File;

/**
 *
 * @author Bawaw
 */
public class Item {
    private String itemId;
    private String description;
    private String name;
    private File imagePath;
    private int level;
    private int price;
    private int strength;
    private int intelligence;
    private int dexterity; 
    private String category;

    public Item() {
    }

    public Item(String itemId, String category ,String description, String name,String imagePath ,int level, int strength, int intelligence, int dexterity,int price) {
        this.itemId = itemId;
        this.description = description;
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.category = category;
        this.imagePath = new File(imagePath);
        this.price = price;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getItemId() {
        return itemId;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public String getDescription() {
        return description;
    }

    public void setDexterity(int dexterity) throws DomainException{
        if(dexterity < 0) throw new DomainException("Dexterity can not be negative value");
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) throws DomainException{
        if(intelligence < 0) throw new DomainException("Intelligence can not be negative value");
        this.intelligence = intelligence;
    }

    public void setItemId(String itemId) throws DomainException{
        this.itemId = itemId;
    }

    public void setLevel(int level) throws DomainException{
        if(level < 0) throw new DomainException("Level can not be negative value");
        this.level = level;
    }

    public void setName(String name) throws DomainException{
        if(name != null || name.equals("")) throw new DomainException("Naam can not be null or empty");
        this.name = name;
    }

    public void setDescription(String omschrijving) throws DomainException{
        if(omschrijving != null) throw new DomainException("Omschrijving can not be null");
        this.description = omschrijving;
    }

    public void setStrength(int strength) throws DomainException{
        if(strength < 0) throw new DomainException("Gold can not be negative value");
        this.strength = strength;
    }

    public String getImagePath() {
        return imagePath.getPath();
    }

    public void setImagePath(File imagePath) {
        this.imagePath = imagePath;
    }
    
      public void setImagePath(String imagePath) {
          if(imagePath != null || imagePath.equals("")) throw new DomainException("ImagePath can not be null or empty");
        this.imagePath = new File(imagePath);
    }

    public void setCategory(String category) {
        if(category != null || category.equals("")) throw new DomainException("Category can not be null or empty");
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
      
}
