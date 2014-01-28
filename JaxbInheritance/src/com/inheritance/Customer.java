/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inheritance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
@XmlRootElement
public class Customer {
 
     private ContactInfo contactInfo;
 
     // uses xsi-type by default
//    public ContactInfo getContactInfo() {
//        return contactInfo;
//    }
// 
//    public void setContactInfo(ContactInfo contactInfo) {
//        this.contactInfo = contactInfo;
//    }
    
     //uses substitution group
//     @XmlElementRef
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
 
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    
    
//    private JAXBElement<? extends ContactInfo> contactInfo;
//    
//     @XmlElementRef(name = "contactInfo", type = JAXBElement.class)
//     public JAXBElement<? extends ContactInfo> getContactInfo() {
//        return contactInfo;
//    }
//      public void setContactInfo(JAXBElement<? extends ContactInfo> value) {
//        this.contactInfo = ((JAXBElement<? extends ContactInfo> ) value);
//    }
}
