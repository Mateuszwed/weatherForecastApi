package com.mateuszwed.weatherForecastApi.service;

import com.mateuszwed.weatherForecastApi.dto.WeatherForecastCity;
import com.mateuszwed.weatherForecastApi.exception.WrongCharacterFormatInCityName;
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
        if(!city.matches("^[a-zA-Z]*$")){
            throw new WrongCharacterFormatInCityName("The city name contains special characters or digits");
        }
        return openWeatherMapClient.getWeatherForecast(city);
    }
}
