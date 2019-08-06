package net.vieland.reactive.example.javamagazine;

import java.util.ArrayList;
import java.util.List;

public class ServiceResponse {
    private long processingTime;
    private List<Forecast> forecasts = new ArrayList<>();

    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }

    public ServiceResponse forecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }
}
