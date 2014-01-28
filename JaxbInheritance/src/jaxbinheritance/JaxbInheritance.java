/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbinheritance;

import com.inheritance.ContactInfo;
import com.inheritance.Customer;
import com.inheritance.HomeAdress;
import com.inheritance.OfficeAddress;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 *
 * @author Family
 */
public class JaxbInheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        
        Customer c  = new Customer();
        HomeAdress h = new HomeAdress();
        h.setStreetName("Hyderabad");
       // JAXBElement<HomeAdress> home = new JAXBElement<HomeAdress>(new QName("", "newHomeAddress"), HomeAdress.class, h);
        c.setContactInfo(h);
        
        //       We can have only Root class in the context and use @xmlSeeAlso annotation on contactInfo Class
//        Other wise if we donot want to use @xmlSeeAlso annotation then we will need to supply all the required class to the context.
//        JAXBContext jc = JAXBContext.newInstance(Customer.class,HomeAdress.class, OfficeAddress.class,ContactInfo.class);
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, System.out);
    }
}
