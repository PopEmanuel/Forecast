package com.pop.forecast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WeeklyForecast {
    private Integer temperature;
    private Integer wind;
    private String description;
    private List<DailyForecast> forecast;
}
