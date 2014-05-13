package com.jsf.spring.service.inter;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public interface UserBo extends Serializable{
 
	public String getMessage();
 
}