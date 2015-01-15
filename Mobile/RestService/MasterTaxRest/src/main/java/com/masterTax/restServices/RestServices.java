/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterTax.restServices;

import com.masterTax.data.MasterData;
import com.masterTax.pojo.Ticket;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Family
 */
@Path("/rs")
public class RestServices {

    @Context
    private HttpServletRequest httpRequest;

    @Context
    private HttpServletResponse httpResponse;

    @Path("/auth")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String authenticateUser(String jsonString) {
        System.out.println("The jsonString is " + jsonString);
        String[] params = jsonString.split("&");
        String userId = params[0].split("=")[1];
        String password = params[1].split("=")[1];
        String configUser = MasterData.getUsersMap().get(userId);
        if (configUser != null && configUser.equalsIgnoreCase(password)) {
            return "success";
        } else {
            return "failure";
        }

    }

    @GET
    @Path("/detail")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket displayDetailPage(@QueryParam("id") String ticketId) throws Exception {
        return MasterData.getTicketMap().get(ticketId);

    }

    @GET
    @Path("/complete/{tid}")
    public Response markTicketAsDone(@PathParam("tid") String ticketId) {
        Response.ResponseBuilder builder = null;
        try {
            Ticket t = MasterData.getTicketMap().get(ticketId);
            MasterData.getTicketList().remove(t);
            builder = Response.ok();
        } catch (Exception e) {
            builder = Response.serverError();
        }
        return builder.build();
    }

    @GET
    public Response populateData() {
        MasterData.getTicketList().clear();
        MasterData.addDataToTicketList();
        return Response.ok().build();
    }

}
