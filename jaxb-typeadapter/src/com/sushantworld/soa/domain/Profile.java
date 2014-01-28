package com.sushantworld.soa.domain;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sushantworld.soa.jaxb.MessageAdapter;

@XmlRootElement(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {
    @XmlElement
    @XmlJavaTypeAdapter(MessageAdapter.class)
    private HashMap<String, Message> messages1;

//    public Profile() {
//    }
//
//    public Profile(HashMap<String, Message> b) {
//	messages1 = b;
//    }

    public HashMap<String, Message> getMessages() {
	return messages1;
    }

    public void setMessages( HashMap<String, Message> messages ) {
	this.messages1 = messages;
    }
}