package com.mateuszwed.weatherForecastApi.controller;

import com.mateuszwed.weatherForecastApi.client.OpenWeatherMapClient;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastCity;
import com.mateuszwed.weatherForecastApi.service.WeatherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {
    WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherForecastCity getWeathersForecast(@PathVariable String city) {
        return weatherService.getWeatherForecast(city);
    }
}
