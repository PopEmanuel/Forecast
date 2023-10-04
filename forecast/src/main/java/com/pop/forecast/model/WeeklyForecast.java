package com.pop.forecast.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class WeeklyForecast {
    private Integer temperature;
    private Integer wind;
    private String description;
    private List<DailyForecast> forecast;

    public WeeklyForecast() {
        temperature = 0;
        wind = 0;
        description = "";
        forecast = new ArrayList<>();
    }
}
