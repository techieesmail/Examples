/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java.proxies;

/**
 *
 * @author Family
 */
public class TestImpl implements ITest{

    public TestImpl() {
        System.out.println("The constructor is "+this.hashCode());
    }

    
    @Override
    public String getName() {
        return "Rahul";
    }
    
}
