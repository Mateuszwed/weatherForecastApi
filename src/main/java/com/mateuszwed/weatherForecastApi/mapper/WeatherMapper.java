package com.mateuszwed.weatherForecastApi.mapper;

import com.mateuszwed.weatherForecastApi.dto.OpenWeatherMapCity;
import com.mateuszwed.weatherForecastApi.dto.OpenWeatherMapDto;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastCity;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class WeatherMapper {
    public List<WeatherForecastDto> openWeatherMapDtoToWeatherForecastDtoList(OpenWeatherMapDto openWeatherMapDto) {
        return openWeatherMapDto.getList().stream()
                .map(listElement -> WeatherForecastDto.builder()
                        .temperatureDay(listElement.getTemp().getDay())
                        .temperatureNight(listElement.getTemp().getNight())
                        .windSpeed(listElement.getSpeed())
                        .pressure(listElement.getPressure())
                        .humidity(listElement.getHumidity())
                        .date(new Date(listElement.getDt() * 1000L).toString())
                        .build())
                .collect(Collectors.toList());
    }

    public WeatherForecastCity openWeatherMapToWeatherForecastCity(OpenWeatherMapCity openWeatherMapCity, List<WeatherForecastDto> weatherForecastDtoList) {
        return  WeatherForecastCity.builder()
                .city(openWeatherMapCity.getName())
                .weather(weatherForecastDtoList)
                .build();
    }
}
