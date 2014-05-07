/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Family
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder={"courses"})

//Class level annotation
@XmlJavaTypeAdapter(BrochureAdapter.class)
public class Brochure {
    
    @XmlElement
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
   //@XmlElement(type=ListCourse.class)
    HashMap<String, Course> courses;
//    ArrayList<Course> course;
//
//    public ArrayList<Course> getCourse() {
//        return course;
//    }
//
//    public void setCourse(ArrayList<Course> course) {
//        this.course = course;
//    }
    
    
    
    public Brochure() {
        //courses = new HashMap<String, Course>();
    }

    public HashMap<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<String, Course> courses) {
        this.courses = courses;
    }

    
    
    
}
