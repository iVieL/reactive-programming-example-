package net.vieland.reactive.example.javamagazine.resources;

import net.vieland.reactive.example.javamagazine.Location;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/location")
public class LocationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocation() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location("London"));
        locations.add(new Location("Istabul"));
        locations.add(new Location("Prague"));

        return Response.ok(
                new GenericEntity(locations){}
        ).build();
    }
}
