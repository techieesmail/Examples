package com.jsf.spring.bean;

import com.jsf.spring.service.impl.UserBoImpl;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.jsf.spring.service.inter.UserBo;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Named
//@Controller("userBean")
@Scope("session")
public class UserBean {

    //@Inject
//    @Autowired
//    UserBoImpl userBo;

    private HttpSession sess;
    @PostConstruct
    public void fetchSession(){
        System.out.println("Bean created");
        sess  = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
//    public void setUserBo(UserBo userBo) {
//        this.userBo = userBo;
//    }

//    public String printMsgFromSpring() {
//        return userBo.getMessage();
//    }
    
    private String name;

    public String getName() {
        System.out.println("The name in session is "+sess.getAttribute("name"));
       // System.out.println("The hashcode of singleton is "+userBo.hashCode());
        name = "Baba";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
