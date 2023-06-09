package com.mateuszwed.weatherForecastApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenWeatherMapTemperatureDto {
    int day;
    int night;
}
