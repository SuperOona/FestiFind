package festi.webservices;

import festi.model.Festival;
import festi.model.FriendGroup;
import festi.model.User;
import festi.request.GroupReqeust;
import festi.request.MakeGroupRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response makeGroup(MakeGroupRequest groupReqeust){
        ArrayList<User> friends = new ArrayList<>();
        for (String name : groupReqeust.friends){
            friends.add(User.getByUsername(name));
        }
        FriendGroup friendGroup = new FriendGroup(groupReqeust.groupname, groupReqeust.festival, friends);

        return Response.ok().build();
    }


}
