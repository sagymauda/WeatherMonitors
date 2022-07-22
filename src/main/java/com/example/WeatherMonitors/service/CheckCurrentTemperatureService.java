package com.example.WeatherMonitors.service;

import org.springframework.stereotype.Service;

@Service
public class CheckCurrentTemperatureService {

    //When the current sample’s temperature result is higher or lower than the previous one
    //in percent (configurable, see threshold property bellow), print a warning message to the console.


    //shahf how i get the old temperature again ? each task should have her own old temperature >?
    public void checkTemperature(Double oldTemp ,Double currentTemp){

    }
}
