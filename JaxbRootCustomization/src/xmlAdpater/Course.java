/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Family
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
    
    @XmlAttribute
	String id;
    @XmlElement
	String name;
    @XmlAttribute
	String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    
}
