/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterTax.pojo;

/**
 *
 * @author Family
 */
public class Ticket {
    
    private long id;
    
    private String category;
    
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return (int)this.id;
    }

    @Override
    public boolean equals(Object obj) {
        Ticket t = (Ticket)obj;
        if(this.id == t.id){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
