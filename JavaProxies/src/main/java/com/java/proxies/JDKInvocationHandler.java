/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author Family
 */
public class JDKInvocationHandler implements InvocationHandler{
    private Object realObject;

    public JDKInvocationHandler(Object realObject) {
        this.realObject = realObject;
    }
    
    

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKInvocation called ");
        return method.invoke(realObject, args);
    }
}
