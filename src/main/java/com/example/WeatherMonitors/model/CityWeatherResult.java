package com.example.WeatherMonitors.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.tomcat.jni.Time;

import java.sql.Timestamp;


@Data
public class CityWeatherResult{

    private Timestamp timestamp;

    private String name;

    private Main main;

    private Wind wind;
    @Data
    class Main{
        @JsonProperty("temp")
        public Double temp;
    }

    @Data
    class Wind{
        @JsonProperty("speed")
        public Double speed;
    }


}
