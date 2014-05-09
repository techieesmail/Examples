/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Family
 */
@XmlRootElement(name = "training")
@XmlAccessorType(XmlAccessType.FIELD)
public class Training {

    @XmlTransient
    HashMap<String, Course> courses = new HashMap<String, Course>();

    public Training() {
    }

    public HashMap<String, Course> getCourses() {

        return courses;
    }

    public void setCourses(HashMap<String, Course> courses) {
        this.courses = courses;
        //during marshalling 
        Set<String> keys = courses.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            ls.add(courses.get(iter.next()));
        }
    }

    @XmlElement(name = "course")
    private List<Course> ls = new ArrayList<Course>();

    public List<Course> getLs() {
        if (ls == null) {
            ls = new ArrayList<Course>();
        }
        System.out.println("The size of list is " + ls.size());
        //Unmarshalling
        for (Course c : ls) {
            courses.put(c.id, c);
        }
        return ls;
    }

    public void setLs(List<Course> ls) {
        this.ls = ls;
    }

}
