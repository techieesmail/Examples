/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java.proxies;

import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;

/**
 *
 * @author Family
 */
public class Main {
    public static void main(String[] args) {
        
        TestImpl impl = new TestImpl();
        //CGLIB
        TestImpl cgLibProxy = (TestImpl)createProxy(impl);
        System.out.println("CGLib Proxy created");
        System.out.println("From CGLIB "+cgLibProxy.getName());
        
        //JDK
        
        ITest jdkProxy = (ITest)Proxy.newProxyInstance(TestImpl.class.getClassLoader(), 
                new Class<?>[]{ITest.class}, new JDKInvocationHandler(impl));
        System.out.println("JDK proxy created");
        System.out.println("From JDK "+jdkProxy.getName());
    }
    
    static Object createProxy(Object obj){
        Enhancer e = new Enhancer();
        e.setSuperclass(TestImpl.class);
        CGIInterceptor c = new CGIInterceptor(obj);
        e.setCallback(c);
        return e.create();
    }
}
