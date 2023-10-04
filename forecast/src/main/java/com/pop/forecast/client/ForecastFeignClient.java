package com.pop.forecast.client;

import com.pop.forecast.model.WeeklyForecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forecast-client", url = "${forecast.retrieval.url}")
public interface ForecastFeignClient {

    @GetMapping("/{city_name}")
    WeeklyForecast fetchData(@PathVariable(value = "city_name") String cityName);
}
