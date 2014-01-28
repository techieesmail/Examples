/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inheritance;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
//This annotation is required for substitution way of inhertiance
@XmlRootElement
public class OfficeAddress extends ContactInfo{
    
    private String cityName;

    @XmlElement(name="officeAddress")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    
    
}
