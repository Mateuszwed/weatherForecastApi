package com.mateuszwed.weatherForecastApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMapDto {
    OpenWeatherMapCityDto city;
    List<OpenWeatherMapListDto> list;
}

