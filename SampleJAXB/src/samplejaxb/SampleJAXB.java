/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package samplejaxb;

import com.morning.Company;
import com.morning.Staff;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Family
 */
public class SampleJAXB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        JAXBContext context = JAXBContext.newInstance(com.morning.Company.class);
        Unmarshaller unmarshal = context.createUnmarshaller();
        Company cc = (Company)unmarshal.unmarshal(new File("E:\\Rahul\\Tuition\\NewBatch\\Kapil\\staff.xml"));
        System.out.println("The first name is "+cc.getStaff().get(1).getFirstname());
        
        
        Company company = new Company();
        Staff s = new Staff();
        s.setFirstname("Kapil");
        s.setLastname("Chhatani");
        s.setNickname("KC");
        s.setSalary("600KDollars");
        company.getStaff().add(s);
        
        Marshaller marshal = context.createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshal.marshal(company, System.out);
        
    }
    
}
