/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbvalidation;

import com.morning.Company;
import com.morning.Staff;
import java.io.File;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

/**
 *
 * @author Family
 */
public class JaxbValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
       
        JAXBContext context = JAXBContext.newInstance(com.morning.Company.class);
        Unmarshaller un = context.createUnmarshaller();
        File f = new File("E:\\Rahul\\Tuition\\NewBatch\\staff.xml");
        un.setSchema(SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                .newSchema(new File("E:\\Rahul\\Tuition\\NewBatch\\company.xsd")));
        un.unmarshal(f);
//        Company c = (Company)un.unmarshal(f);
//        System.out.println(c.getStaff().get(0).getFirstname());
        
        
        Company c = new Company();
        List<Staff> ls = c.getStaff();
        Staff s = new Staff();
        s.setFirstname("Vijay");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.com/address address.xsd");
marshaller.marshal(c, System.out);
        
        
        
    }
}
