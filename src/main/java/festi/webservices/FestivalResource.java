package festi.webservices;

import festi.model.Festival;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

import static festi.model.Festival.getAllFestivals;

@Path("/festival")
public class FestivalResource {
    @GET
    @RolesAllowed({"admin", "user"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFestivals(){
        return Response.ok(getAllFestivals()).build();
    }

}
