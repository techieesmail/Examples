/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Family
 */
public class ListCourse {
    
    @XmlElement(name="course")
    public List<Course> ls = new ArrayList<Course>();
    
    @XmlElement
    public String id;

    //    public String getId() {
    //        return id;
    //    }
    //    public void setId(String id) {
    //        this.id = id;
    //    }
//    @XmlElement(name="course")
//    public List<Course> getLs() {
//        return ls;
//    }
//
//    public void setLs(List<Course> ls) {
//        this.ls = ls;
//    }
    
}
