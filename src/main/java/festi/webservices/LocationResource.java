package festi.webservices;

import festi.model.*;
import festi.request.LocationPush;
import festi.request.LocationRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;

@Path("/location")
public class LocationResource {

    @POST
    @Path("/add")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLocations(@Context SecurityContext context, LocationPush locationPush){
        if (context.getUserPrincipal() instanceof User current){
            Festival at = Festival.getByName(locationPush.festival);
            if (at == null){
                return Response.status(404).entity("festival not found").build();
            }
            ArrayList<Stage> stages = at.getStages();
            for (Stage stage : stages){
                System.out.println("\n STAGE:"+stage.getStageName());
                if (stage.getStageName().equals(locationPush.stage)){
                    Location location = new Location(stage);
                    location.setPlacing(Placing.valueOf(locationPush.placing));
                    current.setLocation(location);
                    return Response.ok().build();
                }
            }
            return Response.status(404).entity("stage not found").build();

        }
        return Response.status(404).entity("user not found").build();

    }
 }
