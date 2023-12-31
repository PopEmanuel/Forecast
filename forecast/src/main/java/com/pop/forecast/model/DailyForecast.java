package com.pop.forecast.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DailyForecast {
    private Integer day;
    private Integer temperature;
    private Integer wind;
}
