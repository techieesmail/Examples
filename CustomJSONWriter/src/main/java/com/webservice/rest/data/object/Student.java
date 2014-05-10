/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.rest.data.object;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Family
 */
@XmlRootElement
public class Student {

    private String name;
    private int age;
    private List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<Course>();
        }
        return courses;
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/address")
    public StudentAddress getAddress() {
        StudentAddress address = new StudentAddress();
        if (name.equalsIgnoreCase("Rajesh")) {
            address.setCity("Hyderabad");
            address.setStreet("Secunderabad");
            address.setCountry("India");
        } else {
            address.setCity("CommonCity");
            address.setStreet("CommonStreet");
            address.setCountry("UK");
        }
        return address;

    }
    
    @GET
    //@Produces(MediaType.APPLICATION_XML)
    public Student showDetails(){
         System.out.println("The size of list is "+courses.size());
        return this;
    }

}
