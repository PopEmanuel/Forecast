package com.pop.forecast.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MeanForecast {
    private String name;
    private Double temperature;
    private Double wind;
}
