package com.pop.forecast.service;

import com.pop.forecast.client.ForecastFeignClient;
import com.pop.forecast.model.ForecastResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ForecastService {
    private ForecastFeignClient forecastFeignClient;

    public ForecastService(ForecastFeignClient forecastFeignClient) {
        this.forecastFeignClient = forecastFeignClient;
    }

    public List<ForecastResult> getForecastForCities(List<String> cities){
        List<ForecastResult> results = new ArrayList<>();
        //Computations
        sortForecastResultList(results);
        return results;
    }

    private void sortForecastResultList(List<ForecastResult> results){
        results.sort(Comparator.comparing(ForecastResult::getName));
    }
}
