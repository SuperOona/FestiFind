package festi.webservices;

import festi.model.*;
import festi.request.GroupReqeust;
import festi.request.LocationRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@Path("/dashboard")
public class DashboardResource {

    @GET
    @Path("/locations/{groupID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocations(@Context SecurityContext context, @PathParam("groupID") String id){
        if (context.getUserPrincipal() instanceof User){
            User current = (User) context.getUserPrincipal();
                FriendGroup group = current.getGroupById(id);
                List<User> friends = group.getFriends();
                if (!friends.isEmpty()){
                    List<LocationRequest> locations = new ArrayList<>();
                    for (User friend : friends){
                        Location location = friend.getLocation();
                        LocationRequest lR = new LocationRequest();
                        lR.placing = location.getPlacing();
                        Stage stage = location.getStage();
                        lR.stage = stage.getStageName();
                        User user = location.getAccount();
                        String name = user.getName();
                        lR.account = name;
                        locations.add(lR);
                    }
                    if (locations.contains(null)){
                        return Response.status(404).entity("No locations found").build();
                    }
                    return Response.ok(locations).build();
                

            }
            return Response.status(404).entity("No friends found").build();
        }
        return Response.status(404).entity("No user found").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDashboard(@Context SecurityContext context){
        if (context.getUserPrincipal() instanceof User){
            User current = (User) context.getUserPrincipal();
            /*if (current.getRole() == "admin"){
                List<Festival> festivals = get
            }*/
            List<FriendGroup> friends = current.getGroups();
            if (!friends.isEmpty()){
                List<GroupReqeust> reqeustList = new ArrayList<>();
                for (FriendGroup friend : friends){
                    GroupReqeust lR = new GroupReqeust();
                    lR.groupName = friend.getGroupName();
                    Festival festival = friend.getFestival();
                    lR.festival = festival.getName();
                    lR.groupID = friend.getFriendGroupId();
                    reqeustList.add(lR);
                }
                if (reqeustList.contains(null)){
                    return Response.status(404).entity("No groups found").build();
                }
                return Response.ok(reqeustList).build();
            }
            return Response.status(404).entity("No gr found").build();
        }
        return Response.status(404).entity("No user found").build();
    }
}
