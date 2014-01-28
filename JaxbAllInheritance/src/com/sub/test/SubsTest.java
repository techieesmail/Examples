/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sub.test;

import generated.Address;
import generated.ContactInfo;
import generated.Customer;
import generated.ObjectFactory;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Family
 */
public class SubsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        Customer c = new Customer();
        Address a =  new Address();
        a.setStreet("Bangalore");
        ObjectFactory of = new ObjectFactory();
        JAXBElement<? extends ContactInfo> jb = of.createAddress(a);
        c.setContactInfo(jb);
        
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, System.out);
        
        Unmarshaller un = jc.createUnmarshaller();
        JAXBElement cust = (JAXBElement)un.unmarshal
                (new File("E:\\Rahul\\Learning\\jaxbInhertiance\\xml\\2.xml"));
        //Address ad = (Address)cust.getContactInfo().getValue();
        System.out.println("The value after unmarshalling is "+cust.getValue());
    }
}
