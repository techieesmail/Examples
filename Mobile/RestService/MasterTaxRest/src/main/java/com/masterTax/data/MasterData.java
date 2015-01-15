/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterTax.data;

import com.masterTax.pojo.Ticket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Family
 */
public class MasterData {
    
    private static Map<String,String> usersMap = new HashMap<String,String>();
    
    private static List<Ticket> ticketList = new ArrayList<Ticket>();
    
    private static Map<String,Ticket> ticketMap = new HashMap<String, Ticket>();
    
    static{
        usersMap.put("Rahul", "Rahul123");
        usersMap.put("MTax", "MTax123");
        
        addDataToTicketList();
        
        
        
    }
    
    public static void addDataToTicketList(){
        try {
            Properties ticketsProp = new Properties();
            ticketsProp.load(MasterData.class.getResourceAsStream("/Tickets.properties"));
            Set keys = ticketsProp.keySet();
            System.out.println("Keys size "+keys.size());
            Iterator keysIter = keys.iterator();
            while(keysIter.hasNext()){
                String key = (String)keysIter.next();
                String value = ticketsProp.getProperty(key);
                System.out.println("The value is "+value);
                String v[] = value.split("\\|");
                //System.out.println("zi "+v.length);
                Ticket t = new Ticket();
                t.setId(Long.parseLong(key));
                //System.out.println("V0 "+v[0]);
                t.setCategory(v[0]);
                t.setDescription(v[1]);
                
                ticketList.add(t);
                
                ticketMap.put(key, t);
                
                
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, String> getUsersMap() {
        return usersMap;
    }

    public static List<Ticket> getTicketList() {
        return ticketList;
    }

    public static Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }
    
    
    
    
}
