package festi.webservices;

import festi.model.Artist;
import festi.model.Festival;
import festi.model.Stage;
import festi.model.User;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Date;

import static festi.model.Festival.getAllFestivals;
import static festi.model.Festival.getByName;

@Path("/festival")
public class FestivalResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFestivals(){
        return Response.ok(getAllFestivals()).build();
    }

    @GET
    @Path("/{selectedFestival}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStage(@PathParam("selectedFestival") String selected){
        Festival festival = getByName(selected);
        System.out.println(festival.getName());
        if (festival == null){
            return Response.status(401).entity("festival not found").build();
        }
        System.out.println(festival.getStages());
        ArrayList<Stage> stages = festival.getStages();
        if (stages.isEmpty()){
            return Response.status(404).entity("Festival has no stages").build();
        }
        return Response.ok(stages).build();
    }

}
