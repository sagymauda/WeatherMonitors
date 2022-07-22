package com.example.WeatherMonitors.configuration;

import com.example.WeatherMonitors.model.CityConfig;
import com.example.WeatherMonitors.model.CityWeatherResult;
import com.example.WeatherMonitors.utils.ReadFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class MyTask {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${appId}")
    private String appId;

    // i cant pass the url its throw me an error for some reason but when ido it in the command line runner it work

//    @Value("${jsonFile.path}")
//    private String path;
//
//    List<CityConfig> Cities = ReadFile.getJson(path);

    public MyTask() {
    }

    @Scheduled(fixedRate = 1000 * 5)
    public void doTheThing() throws JsonProcessingException {

        ResponseEntity<CityWeatherResult> resultFromApi = restTemplate.getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + "London" + "&appid=" + appId + "&units=metric", CityWeatherResult.class);

        Objects.requireNonNull(resultFromApi.getBody()).setTimestamp(new Timestamp(System.currentTimeMillis()));

      log.info(resultFromApi.getBody().toString());




    }
}


