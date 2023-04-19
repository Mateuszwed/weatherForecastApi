package com.mateuszwed.weatherForecastApi.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OpenWeatherMapDto {
    OpenWeatherMapCity city;
    List<OpenWeatherMapList> list;
}

