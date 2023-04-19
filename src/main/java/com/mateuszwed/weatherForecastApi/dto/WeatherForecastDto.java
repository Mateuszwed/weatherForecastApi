package com.mateuszwed.weatherForecastApi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherForecastDto {
    double temperatureDay;
    double temperatureNight;
    double windSpeed;
    int pressure;
    int humidity;
    String date;
}
