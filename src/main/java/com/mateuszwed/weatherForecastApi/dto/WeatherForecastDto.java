package com.mateuszwed.weatherForecastApi.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastDto {
    String city;
    List<WeatherDto> weather;
}
