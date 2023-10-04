package com.pop.forecast.controller;

import com.pop.forecast.model.MeanForecast;
import com.pop.forecast.service.ForecastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1/weather")
@Slf4j
public class ForecastController {
    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping(path = "/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getForecastForCities(@RequestParam(value = "city") String city){
        List<String> cityList = Arrays.asList(city.split(","));
        log.info(cityList.toString());

        List<MeanForecast> result = forecastService.getForecastForCities(cityList);

        return ResponseEntity.ok(result);
    }
}
