package com.sushantworld.soa.domain;

import javax.xml.bind.annotation.XmlElement;
/**
 * @author Sushant
 */
public class Messages1 {
    @XmlElement(name="message")
    public Message[] messages;
}