/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbparsing;

import com.sample.schema.Company;
import com.sample.schema.Staff;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Family
 */
public class JaxbParsing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        //Without root element we cannot parse the xml
        File f = new File("E:\\Rahul\\Tuition\\NewBatch\\Sarath\\xmls\\staff.xml");

        //if packages are mentioned for JaxbContext then we will be getting the elements as JAXBElement<?> type
        JAXBContext context = JAXBContext.newInstance("com.sample.schema");
        //JAXBContext context = JAXBContext.newInstance(Company.class);
        Unmarshaller un = context.createUnmarshaller();
        //Company c = (Company)JAXBIntrospector.getValue(un.unmarshal(f));
        JAXBElement<Company> jaxb = (JAXBElement<Company>) un.unmarshal(f);
        Company c = jaxb.getValue();
        //Company c = (Company)un.unmarshal(f);
        Staff s = c.getStaff().get(1);
        System.out.println(s.getFirstname());

        //Marshalling
        Company marshalCompany = new Company();
        Staff mStaff = new Staff();
        mStaff.setFirstname("FirstName");
        mStaff.setLastname("LastName");
        mStaff.setMiddlename("MiddleName");
        mStaff.setNickname("nickName");
        mStaff.setSalary("2560");
        marshalCompany.getStaff().add(mStaff);

        Marshaller marshal = context.createMarshaller();

        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshal.marshal(marshalCompany, System.out);

    }

}
