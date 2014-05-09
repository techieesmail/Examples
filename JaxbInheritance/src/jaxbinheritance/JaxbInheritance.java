/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbinheritance;

import choice.Customer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import substitution.Address;
import substitution.ObjectFactory;
import xsi.type.ContactInfo;
import xsi.type.OfficeAddress;

/**
 *
 * @author Family
 */
public class JaxbInheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //JaxBElement can be used only with ObjectFactory
        //uses substitution group
        //@XmlElementRef
        //We can have only Root class in the context and use @xmlSeeAlso annotation on contactInfo Class
//        Other wise if we donot want to use @xmlSeeAlso annotation then we will need to supply all the required class to the context.
//        JAXBContext jc = JAXBContext.newInstance(Customer.class,HomeAdress.class, OfficeAddress.class,ContactInfo.class);
        
        System.out.println("Printing the choice");
        choice();
        System.out.println("Printing the xsiType");
        xsi();
        System.out.println("Printing the substitution");
        substitution();
    }

    public static void choice() throws Exception {
        choice.Customer c = new choice.Customer();
        choice.HomeAdress home = new choice.HomeAdress();
        home.setHomeStreetName("ChoiceStreet");
        c.setHomeAdress(home);
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, System.out);
    }
    
    public static void xsi() throws Exception{
        xsi.type.Customer c = new xsi.type.Customer();
        xsi.type.OfficeAddress office = new xsi.type.OfficeAddress();
        office.setOfficeAddress("XSIStreet");
        c.setContactInfo(office);
        JAXBContext jc = JAXBContext.newInstance(xsi.type.Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, System.out);
    }
    
    public static void substitution()throws Exception{
        substitution.Customer c = new substitution.Customer();
        Address a =  new Address();
        a.setStreet("Bangalore");
        ObjectFactory of = new ObjectFactory();
        JAXBElement<? extends substitution.ContactInfo> jb = of.createAddress(a);
        c.setContactInfo(jb);
        
        JAXBContext jc = JAXBContext.newInstance(substitution.Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, System.out);
    }
    
}
