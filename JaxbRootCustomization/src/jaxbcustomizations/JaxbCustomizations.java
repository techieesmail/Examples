/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbcustomizations;

import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import xmlAdpater.Course;
import xmlAdpater.Training;

/**
 *
 * @author Family
 */
public class JaxbCustomizations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

    //Marshallling
        Training training = new Training();
        HashMap<String, Course> map = new HashMap<String, Course>();
        Course course = new Course();
        course.setId("1");
        course.setName("Rahul");
        course.setPrice("1000");
        map.put("1", course);
        Course course1 = new Course();
        course1.setId("2");
        course1.setName("Raju");
        course1.setPrice("2000");
        map.put("2", course1);
        training.setCourses(map);

        JAXBContext context = JAXBContext.newInstance(Training.class);
        Marshaller marshal = context.createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshal.marshal(training, System.out);
//        
        Unmarshaller unmarshall = context.createUnmarshaller();
        Training t = (Training) unmarshall.unmarshal(new File("E:\\Rahul\\Tuition\\DemoFiles\\root.xml"));
        t.getLs();
        System.out.println("The value obtained is " + t.getCourses());

    }
}
