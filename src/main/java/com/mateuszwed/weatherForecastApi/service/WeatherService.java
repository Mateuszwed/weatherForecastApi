package com.mateuszwed.weatherForecastApi.service;

import com.mateuszwed.weatherForecastApi.client.OpenWeatherMapClient;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import com.mateuszwed.weatherForecastApi.exception.WrongCharacterFormatInCityNameException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class WeatherService {
    OpenWeatherMapClient openWeatherMapClient;

    public WeatherForecastDto getWeatherForecast(String city) {
        if(!city.matches("^[a-zA-Z]*$")){
            throw new WrongCharacterFormatInCityNameException("The city name contains special characters or digits");
        }
        return openWeatherMapClient.getWeatherForecast(city);
    }
}
