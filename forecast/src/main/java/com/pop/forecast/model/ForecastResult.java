package com.pop.forecast.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForecastResult {
    private String name;
    private Integer temperature;
    private Integer wind;
}
