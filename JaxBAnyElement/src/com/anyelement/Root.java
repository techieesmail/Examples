/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anyelement;

/**
 *
 * @author Family
 */
import java.util.List;
import javax.xml.bind.annotation.*;
 
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
 
    @XmlAnyElement(lax = true)
    protected List<Object> any;
 
}
