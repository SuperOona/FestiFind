package festi.webservices;

import festi.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response giveUser(){
        return Response.ok(User.getAllUsers()).build();
    }
}
