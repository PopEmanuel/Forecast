package com.pop.forecast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DailyForecast {
    private Integer day;
    private Integer temperature;
    private Integer wind;
}
