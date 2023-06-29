package festi.webservices;

import festi.model.Festival;
import festi.model.FriendGroup;
import festi.model.User;
import festi.request.GroupReqeust;
import festi.request.MakeGroupRequest;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.ArrayList;

import static festi.model.Festival.getAllFestivals;

@Path("/festival")
public class FestivalResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFestivals(){
        return Response.ok(getAllFestivals()).build();
    }

    @POST
    @Path("/makeGroup")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response makeGroup(@Context SecurityContext context, MakeGroupRequest groupReqeust){
        if (context.getUserPrincipal() instanceof User current){
            
            ArrayList<User> friends = new ArrayList<>();
            FriendGroup friendGroup = new FriendGroup(groupReqeust.groupname, groupReqeust.festival);
            friends.add(current);
            for (String name : groupReqeust.friends){
                User friend = User.getByUsername(name);
                friends.add(friend);
                friend.addGroup(friendGroup);
            }
            friendGroup.setFriends(friends);
            current.addGroup(friendGroup);
            return Response.ok().build();
        }
        return Response.status(404).entity("User not found").build();
    }


}
