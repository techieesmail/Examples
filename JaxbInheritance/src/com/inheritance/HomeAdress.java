/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inheritance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
//This annotation is required for substitution way of inhertiance
@XmlRootElement
public class HomeAdress extends ContactInfo{
    
    private String streetName;

    @XmlElement(name="homeStreetName")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    
    
}
