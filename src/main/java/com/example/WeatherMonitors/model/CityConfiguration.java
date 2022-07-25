package com.example.WeatherMonitors.model;

import lombok.Data;

@Data
public class CityConfiguration {

    private Long cityId;
    private String cityName;
    private Integer frequency;
    private Integer threshold;


}
