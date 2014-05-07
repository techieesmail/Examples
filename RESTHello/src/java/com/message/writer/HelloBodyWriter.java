/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.writer;

import com.xml.Employee;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;

/**
 *
 * @author Family
 */
@Provider
 @Produces("application/xml")
public class HelloBodyWriter implements MessageBodyWriter<Employee> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Employee t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Employee t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        
        Employee e = t;
        try{
        System.out.println("In the message body writer");
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller marshal = context.createMarshaller();
        marshal.marshal(t, entityStream);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
