/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Family
 */
@XmlRootElement(name="training")
@XmlAccessorType(XmlAccessType.FIELD)
public class Training {
    @XmlElement
    
    //Field Level annotation
    //@XmlJavaTypeAdapter(BrochureAdapter.class)
    public Brochure brochure;
    public Training(){}
//    public Training( Brochure b ){
//        brochure = b;
//    }

    public Brochure getBrochure() {
        return brochure;
    }

    public void setBrochure(Brochure brochure) {
        this.brochure = brochure;
    }
    
    
}
