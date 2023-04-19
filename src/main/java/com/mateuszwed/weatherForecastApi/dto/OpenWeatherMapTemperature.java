package com.mateuszwed.weatherForecastApi.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OpenWeatherMapTemperature {
    double day;
    double night;
}
