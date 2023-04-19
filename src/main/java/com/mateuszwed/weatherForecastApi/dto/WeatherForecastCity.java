package com.mateuszwed.weatherForecastApi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class WeatherForecastCity {
    String city;
    List<WeatherForecastDto> weather;
}
