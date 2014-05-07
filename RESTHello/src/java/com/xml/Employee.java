/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
@XmlRootElement(name = "customer")
public class Employee {
    
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
