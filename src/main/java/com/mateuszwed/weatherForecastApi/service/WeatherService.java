package com.mateuszwed.weatherForecastApi.service;

import com.mateuszwed.weatherForecastApi.dto.WeatherForecastCity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.mateuszwed.weatherForecastApi.client.OpenWeatherMapClient;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WeatherService {
    OpenWeatherMapClient openWeatherMapClient;

    public WeatherForecastCity getWeatherForecast(String city) {
        return openWeatherMapClient.getWeatherForecast(city);
    }
}
