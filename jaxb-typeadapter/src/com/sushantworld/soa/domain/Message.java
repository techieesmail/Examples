package com.sushantworld.soa.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
	@XmlAttribute
	private String id;
	@XmlElement
	private String subject;
	@XmlElement
	private String body;
	
	@XmlElement
	@XmlSchemaType(name="anyUri")
	private String extLink;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getExtLink() {
		return extLink;
	}
	public void setExtLink(String extLink) {
		this.extLink = extLink;
	}
}
