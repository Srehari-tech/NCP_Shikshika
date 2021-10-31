package com.shikshika.model;

public class Category 
{
    private int cat_id;
    private String category;
 
    public Category() 
    {
	}
    
    public Category(int cat_id, String category) 
    {
        this.cat_id = cat_id;
        this.category = category;
    }
 
    public int getId() {
        return cat_id;
    }
 
    public void setId(int cat_id) {
        this.cat_id = cat_id;
    }
 
    public String getName() {
        return category;
    }
 
    public void setName(String category) {
        this.category = category;
    }
}