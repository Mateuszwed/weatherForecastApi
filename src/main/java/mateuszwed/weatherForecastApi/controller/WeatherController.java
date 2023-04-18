package mateuszwed.weatherForecastApi.controller;

import mateuszwed.weatherForecastApi.dto.WeatherDto;
import mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weathers")
public class WeatherController {

    @PostMapping
    public WeatherDto getWeather(@RequestBody WeatherDto weatherDto){
        return null;
    }

    @PostMapping("/forecast")
    public WeatherForecastDto getWeatherForecast(@RequestBody WeatherForecastDto weatherForecastDto){
        return null;
    }
}
