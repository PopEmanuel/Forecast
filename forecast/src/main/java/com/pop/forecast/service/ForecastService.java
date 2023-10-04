package com.pop.forecast.service;

import com.pop.forecast.client.ForecastFeignClient;
import com.pop.forecast.model.DailyForecast;
import com.pop.forecast.model.MeanForecast;
import com.pop.forecast.model.WeeklyForecast;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class ForecastService {
    private final ForecastFeignClient forecastFeignClient;

    public ForecastService(ForecastFeignClient forecastFeignClient) {
        this.forecastFeignClient = forecastFeignClient;
    }

    public List<MeanForecast> getForecastForCities(List<String> cities) {
        List<MeanForecast> forecastMeans = new ArrayList<>();
        for (String city : cities) {
            WeeklyForecast forecast = new WeeklyForecast();
            try {
                forecast = forecastFeignClient.getForecastForCity(city);
            } catch (FeignException e) {
                log.error(e.getMessage());
            }

            MeanForecast meanForecast = getMeanFromWeeklyForecast(city, forecast);
            forecastMeans.add(meanForecast);
        }

        sortForecastResultList(forecastMeans);
        return forecastMeans;
    }

    private static MeanForecast getMeanFromWeeklyForecast(String city, WeeklyForecast forecast) {
        Integer windSum = forecast.getWind();
        Integer temperatureSum = forecast.getTemperature();
        int days = forecast.getForecast().size() + 1;

        for (DailyForecast dailyForecast : forecast.getForecast()) {
            windSum = dailyForecast.getWind();
            temperatureSum = dailyForecast.getTemperature();
        }

        Double windMean = (double) windSum / days;
        Double temperatureMean = (double) temperatureSum / days;
        return new MeanForecast(city, temperatureMean, windMean);
    }

    private void sortForecastResultList(List<MeanForecast> forecasts) {
        forecasts.sort(Comparator.comparing(MeanForecast::getName));
    }
}
