package net.vieland.reactive.example.javamagazine.resources;

import net.vieland.reactive.example.javamagazine.Forecast;
import net.vieland.reactive.example.javamagazine.Location;
import net.vieland.reactive.example.javamagazine.ServiceResponse;
import net.vieland.reactive.example.javamagazine.Temperature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/forecast")
public class ForecastResource {

    @Uri("location")
    private WebTarget locationTarget;

    @Uri("temperature/{city}")
    private WebTarget temperatureTarget;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocationWithTemperatures() {
        long startTime = System.currentTimeMillis();

        ServiceResponse response = new ServiceResponse();

        List<Location> locations = locationTarget.request()
                .get(new GenericType<List<Location>>() {});

        locations.forEach( location -> {
            Temperature temperature = temperatureTarget
				.resolveTemplate("city", location.getName())
                    .request()
                    .get(Temperature.class);

            response.getForecasts().add(
                    new Forecast(location).setTemperature(temperature);
			);
        });

        long endTime = System.currentTimeMillis();
        response.setProcessingTime(endTime - startTime);

        return Response.ok(response).build();
    }
}
