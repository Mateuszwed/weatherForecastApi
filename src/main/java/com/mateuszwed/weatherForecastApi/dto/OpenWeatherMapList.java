package com.mateuszwed.weatherForecastApi.dto;

import lombok.Getter;

@Getter
public class OpenWeatherMapList {
    int dt;
    OpenWeatherMapTemperature temp;
    double speed;
    int pressure;
    int humidity;
}
