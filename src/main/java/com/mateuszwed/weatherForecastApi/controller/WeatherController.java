package com.mateuszwed.weatherForecastApi.controller;

import com.mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import com.mateuszwed.weatherForecastApi.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/weathers")
@RestController
public class WeatherController {
    WeatherService weatherService;

    @ApiOperation("Get weather forecast for 5 days.")
    @GetMapping("/{city}")
    public WeatherForecastDto getWeathersForecast(@PathVariable String city) {
        return weatherService.getWeatherForecast(city);
    }
}
