package festi.webservices;

import festi.model.*;
import festi.request.LocationRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Path("/locations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocations(@Context SecurityContext context){
        if (context.getUserPrincipal() instanceof User current){
                List<User> friends = current.getFriends();
                if (!friends.isEmpty()){
                    List<LocationRequest> locations = new ArrayList<>();
                    for (User friend : friends){
                        Location location = friend.getLocation();
                        LocationRequest lR = new LocationRequest();
                        lR.placing = location.getPlacing();
                        Stage stage = location.getStage();
                        lR.stage = stage.getStageName();
                        User user = location.getAccount();
                        lR.account = user.getName();
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


}
