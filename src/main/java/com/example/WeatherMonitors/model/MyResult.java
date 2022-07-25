package com.example.WeatherMonitors.model;

import lombok.Data;

@Data
public class MyResult {

        private String name;
        public Integer temp;
        public Double speed;
        private Long timezone;
    }