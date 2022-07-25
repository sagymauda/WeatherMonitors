package com.example.WeatherMonitors.model;

import com.example.WeatherMonitors.utils.FileUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@Slf4j
public class TaskSchedulerWeatherDispatcher {

    @Value("${jsonFile}")
    private String jsonFile;
    private List<CityConfiguration> FETCH_CITIES_CONFIGURATION;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @PostConstruct
    public void ScheduleTasks() {
        try {
            FETCH_CITIES_CONFIGURATION = FileUtil.getConfigsFromJson(jsonFile);
        } catch (Exception e) {
            log.error("there was a problem reading the json file Configuration {}", e.toString());
        }

        for (CityConfiguration conf : FETCH_CITIES_CONFIGURATION) {
            taskScheduler.scheduleWithFixedDelay(new WeatherCityFetcher(new RestTemplate(), conf.getCityName(), conf.getThreshold()), conf.getFrequency() * 1000);
        }
    }
}
