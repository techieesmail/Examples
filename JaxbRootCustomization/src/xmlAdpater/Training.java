/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Family
 */
@XmlRootElement(name="training")
@XmlAccessorType(XmlAccessType.FIELD)
public class Training {
   //@XmlElement(name = "course")
    
    //Field Level annotation
   // @XmlJavaTypeAdapter(BrochureAdapter.class)
    HashMap<String, Course> courses = new HashMap<String, Course>();
    //public Brochure brochure;
    public Training(){}

    //    public Training( Brochure b ){
    //        brochure = b;
    //    }
    //    public Brochure getBrochure() {
    //        return brochure;
    //    }
    //    }
    //    public void setBrochure(Brochure brochure) {
    //        this.brochure = brochure;
    //    }
    public HashMap<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<String, Course> courses) {
        this.courses = courses;
    }
    
     @XmlElement(name="course")
    private List<Course> ls;

    public List<Course> getLs() {
        if(ls==null)
        {
           ls = new ArrayList<Course>();
        }
        System.out.println("The size of list is "+ls.size());
        for(Course c : ls){
            courses.put(c.id, c);
        }
        return ls;
    }

    public void setLs(List<Course> ls) {
        this.ls = ls;
    }
   
//    public ArrayList<Course> getLs() {
//        System.out.println("The list called");
//        return new ArrayList<Course>();
//    }
    
}
