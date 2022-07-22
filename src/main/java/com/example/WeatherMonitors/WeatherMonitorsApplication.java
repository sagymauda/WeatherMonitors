package com.example.WeatherMonitors;

import com.example.WeatherMonitors.model.CityConfig;
import com.example.WeatherMonitors.utils.ReadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;


@SpringBootApplication
@EnableScheduling
public class WeatherMonitorsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WeatherMonitorsApplication.class, args);
    }

    @Value("${jsonFile.path}")
    private String path ;


    @Override
    public void run(String... args) throws Exception {

        //i need to create number of task as number of cities
        List<CityConfig> Cities = ReadFile.getJson(path);
    }
}

