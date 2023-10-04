package com.pop.forecast.service;

import com.opencsv.CSVWriter;
import com.pop.forecast.model.MeanForecast;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class CsvWriterService {

    public void writeDataToCsv(List<MeanForecast> forecasts, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {"Name", "Temperature", "Wind"};
            writer.writeNext(header);

            for (MeanForecast forecast : forecasts) {
                String[] data = {forecast.getName(), forecast.getTemperature().toString(), forecast.getWind().toString()};
                writer.writeNext(data);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
