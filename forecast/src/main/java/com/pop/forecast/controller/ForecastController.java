package com.pop.forecast.controller;

import com.pop.forecast.model.MeanForecast;
import com.pop.forecast.service.CsvWriterService;
import com.pop.forecast.service.ForecastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    private final CsvWriterService csvWriterService;

    @Value("${forecast.csv.path}")
    private String csvFilePath;

    public ForecastController(ForecastService forecastService, CsvWriterService csvWriterService) {
        this.forecastService = forecastService;
        this.csvWriterService = csvWriterService;
    }

    @GetMapping(path = "/ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getForecastForCities(@RequestParam(value = "city") String city){
        List<String> cityList = Arrays.asList(city.split(","));
        log.info(cityList.toString());

        List<MeanForecast> result = forecastService.getForecastForCities(cityList);
        csvWriterService.writeDataToCsv(result, csvFilePath);
        return ResponseEntity.ok(result);
    }
}
