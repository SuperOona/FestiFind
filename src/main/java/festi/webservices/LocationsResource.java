package festi.webservices;

import festi.model.Location;
import festi.model.Stage;
import festi.model.User;
import festi.request.LocationRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/locations")
public class LocationsResource {

    @POST
    @Path("/addLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLocation(@Context SecurityContext context, LocationRequest locationRequest){
        if (context.getUserPrincipal() instanceof User current){
            return Response.ok(current).build();
        }
        return Response.status(404).entity("No user found").build();
    }
}
