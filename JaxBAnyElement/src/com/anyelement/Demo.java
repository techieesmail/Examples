/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anyelement;

/**
 *
 * @author Family
 */
import java.io.File;
import javax.xml.bind.*;
 
public class Demo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class, Foo.class, ObjectFactory.class);
         
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/com/anyelement/input.xml");
        Root payload = (Root) unmarshaller.unmarshal(xml);
         
        for(Object o : payload.any) {
            System.out.println(o);
        }
         
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(payload, System.out);
    }
 
}
