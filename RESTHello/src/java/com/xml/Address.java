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
@XmlRootElement(name="myAdd")
public class Address {
    
    private String street;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
