package net.vieland.reactive.example.javamagazine;

import lombok.Data;

@Data
public class Forecast {
    private Location location;
    private Temperature temperature;

    public Forecast(Location location) {
        this.location = location;
    }

    public Forecast setTemperature(final Temperature temperature) {
        this.temperature = temperature;
        return this;
    }

}
