package mateuszwed.weatherForecastApi.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import mateuszwed.weatherForecastApi.client.OpenWeatherMapClient;
import mateuszwed.weatherForecastApi.dto.OpenWeatherMapDto;
import mateuszwed.weatherForecastApi.dto.WeatherDto;
import mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import org.springframework.web.bind.annotation.*;


@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {
OpenWeatherMapClient openWeatherMapClient;

    @PostMapping
    public WeatherDto getCurrencyWeather(@RequestBody WeatherDto weatherDto){
        return null;
    }

    @PostMapping("/forecast")
    public WeatherForecastDto getWeatherForecast(@RequestBody WeatherForecastDto weatherForecastDto){
        return null;
    }

    @GetMapping("/{city}")
    public OpenWeatherMapDto getWeathers(@PathVariable String city){
        return openWeatherMapClient.getWeatherForecast(city);
    }
}
