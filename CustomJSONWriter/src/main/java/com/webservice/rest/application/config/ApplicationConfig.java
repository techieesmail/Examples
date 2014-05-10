/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webservice.rest.application.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Family
 */
@ApplicationPath("/rest")
public class ApplicationConfig extends Application{

    //used for returning instances
//    @Override
//    public Set<Object> getSingletons() {
//        Set set = new HashSet();
//        set.add(new JSONWriter());
//        return set;
//    }
    
//Below method is overridden if only specific classes are required to be binded to JAX-RS context.
//If the method is not overridden then all the classes in the application will be processed
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<Class<?>>();
//        s.add(StudentInfo.class);
//        s.add(JSONWriter.class);
//        return s;
//    }
    
    
}
