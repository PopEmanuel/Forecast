package com.pop.forecast.service;

import com.pop.forecast.model.ForecastResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ForecastService {


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
