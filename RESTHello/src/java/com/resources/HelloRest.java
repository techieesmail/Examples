/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resources;

import com.xml.Address;
import com.xml.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

/**
 * REST Web Service
 *
 * @author Family
 */
@Path("hello")
public class HelloRest {

    @Context
    private UriInfo context;
    @Context
    private HttpHeaders headers;
    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse httpResponse;

    /**
     * Creates a new instance of HelloRest
     */
    public HelloRest() {
    }

    /**
     * Retrieves representation of an instance of com.resources.HelloRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getString() {
        //TODO return proper representation object
        System.out.println("This is simple rest method");
        UriBuilder builder = context.getAbsolutePathBuilder();
        URI uri = UriBuilder.fromPath("http://localhost:7001/hello").path("{a}/{b}").queryParam("name", "Rahul").build("products", "books");
        //return "Venkat. THis is an example of simple jax-rs";
        return uri.toString();
    }

    @GET
    @Path("xml")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getXml() {
        //TODO return proper representation object
        Employee e = new Employee();
        e.setId(1000);
        e.setName("Raj");
        Response r = Response.ok(e).build();

        System.out.println("This is the xml rest");
        //return r;
        throw new WebApplicationException();
    }

//     @GET
//     @Path("/json")
//     @Produces(MediaType.APPLICATION_JSON)
//     public Employee getJson()
//     {
//          Employee e = new Employee();
//        e.setId(1000);
//        e.setName("Raj");
//         return e;
//     }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getJson() {
        List<Address> lsAdd = new ArrayList<Address>();
        Address add = new Address();
        add.setCity("Hyderabad");
        add.setStreet("Street");
        Address add1 = new Address();
        add1.setCity("Mumbai");
        add1.setStreet("BankStreet");
        lsAdd.add(add);
        lsAdd.add(add1);
        return lsAdd;
    }
//     @GET
//    @Path("/xml")
//    @Produces("application/xml")
//    public Response getXml1() {
//        //TODO return proper representation object
//        Employee e = new Employee();
//        e.setId(1000);
//        e.setName("Raj");
//        Response r = Response.ok(e).build();
//         System.out.println("This is the xml rest");
//        return r;
//        //throw new WebApplicationException();
//    }

    /**
     * PUT method for updating or creating an instance of HelloRest
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Path("/consume")
    @Consumes("application/xml")
    public Response putXml(Employee o) {
        System.out.println("In the consume method");
        Employee e = (Employee) o;
        System.out.println("The id received is " + e.getId());

        return Response.ok().build();
        //throw new WebApplicationException();

    }

    @GET
    @Path("{name}/{action}")
    public Response getUserByName(@PathParam("name") String name, @QueryParam("hi") String hi, @QueryParam("num") String num, @PathParam("action") String action) {

        return Response.status(301).build();
        //return Response.status(200).entity("Name called is: " + name + " From " + hi + " " +"numbers "+num+ headers.getRequestHeader("user-agent")+request.getCookies()+" "+action).build();

    }

    @GET
    @Path("/redirect")
    public void getRedirection() {
        try {
            String redirectPath = request.getServletContext().getContextPath() + "/RedirectJSP.jsp";

            httpResponse.sendRedirect(redirectPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @GET
    @Path("/chunk")
    @Produces("application/pdf")
    public Response getFile() {

        FileInputStream fileInputStream = null;
        ResponseBuilder response = null;
        try {
            httpResponse.addHeader("Transfer-Encoding", "chunked");
            httpResponse.addHeader("Content-Disposition",
                    "attachment; filename=Demo.pdf");
            File file = new File("E:/Rahul/Books/Java The Complete Reference, 8th Edition.pdf");
            fileInputStream = new FileInputStream(file);
            ServletOutputStream out = httpResponse.getOutputStream();
            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();

            response = Response.ok();
//            response.header("DummyHeader", "dummy");
//            response.header("Transfer-Encoding", "chunked");      
//            response.entity((Object) file);
            //return response.build();
        } catch (Exception ex) {
            Logger.getLogger(HelloRest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(HelloRest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //return httpResponse;
        return response.build();

    }

    @GET
    @Path("/length")
    @Produces("application/pdf")
    public Response getFileLength() {
        ResponseBuilder response = null;
        File file = new File("E:/Rahul/Books/Java The Complete Reference, 8th Edition.pdf");
        response = Response.ok();
        response.header("Content-Disposition",
                    "attachment; filename=Demo.pdf");
        response.entity((Object) file);
        //return response.build();
        return response.build();

    }

    @GET
    @Path("/excel")
    @Produces("application/vnd.ms-excel")
    public Response getExcel() {

        File file = new File("E:\\Rahul\\Tuition\\DemoFiles\\RestExcel.xlsx");

        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=Demo.xlsx");
        return response.build();

    }

}
