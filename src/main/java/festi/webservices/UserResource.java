package festi.webservices;

import festi.model.User;
import festi.request.UserRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response giveAllUser(){
        return Response.ok(User.getAllUsers()).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserRequest request){
        if (User.createUser(request.username, request.password, request.email)){
        return Response.ok().build();
        }
        return Response.status(409).entity("user couldn't be made").build();
    }

    @POST
    @Path("/forgot")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response forgotPassword(UserRequest request){
        User replace = User.getByEmail(request.email);

        if (!replace.updatePassword(request.password)){
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Password couldn't be change, check email").build();
        }
        return Response.ok().build();
    }



}
