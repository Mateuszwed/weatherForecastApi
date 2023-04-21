package com.mateuszwed.weatherForecastApi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class WeatherDto {
    int temperatureDay;
    int temperatureNight;
    int windSpeed;
    int pressure;
    int humidity;
    LocalDate date;
}
