package com.mateuszwed.weatherForecastApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenWeatherMapListDto {
    OpenWeatherMapTemperatureDto temp;
    int dt;
    int speed;
    int pressure;
    int humidity;
}
