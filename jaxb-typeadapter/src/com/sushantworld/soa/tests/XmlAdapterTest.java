package com.sushantworld.soa.tests;

import com.sushantworld.soa.domain.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



import com.sushantworld.soa.domain.Profile;
import java.util.HashMap;

public class XmlAdapterTest {
    public static void main(String[] args) throws Exception{
        
        JAXBContext context = JAXBContext.newInstance(Profile.class);
        Unmarshaller unmarshall = context.createUnmarshaller();
        Profile t = (Profile)unmarshall.unmarshal(new File("E:\\profile.xml"));
        System.out.println("The value obtained is "+t.getMessages());
        
       Profile p = new Profile();
        HashMap<String, Message> messages = new HashMap<String, Message>();
        Message m = new Message();
        m.setId("3");
        m.setSubject("Hello");
        messages.put("3", m);
        p.setMessages(messages);
        
       Marshaller marshal = context.createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshal.marshal(p, System.out);
    }
}
