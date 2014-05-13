package com.jsf.spring.service.impl;

import javax.inject.Named;

import com.jsf.spring.service.inter.UserBo;
import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Named
@Component
@Scope("session")
public class UserBoImpl implements UserBo,Serializable{
 
	public String getMessage() {
		
		return "JSF 2 + Spring Integration";
	
	}
 
}