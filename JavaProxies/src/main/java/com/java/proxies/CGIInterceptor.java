/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java.proxies;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @author Family
 */
public class CGIInterceptor implements MethodInterceptor{

    private Object realObject;

    public CGIInterceptor(Object realObject) {
        this.realObject = realObject;
    }
    
    
    
    @Override
    public Object intercept(Object o, Method method, Object[] os, MethodProxy mp) throws Throwable {
            System.out.println("CGInterceptor called "+method.getName());
            return method.invoke(realObject, os);
    }
    
}
