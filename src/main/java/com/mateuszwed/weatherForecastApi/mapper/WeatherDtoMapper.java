package com.mateuszwed.weatherForecastApi.mapper;

import com.mateuszwed.weatherForecastApi.dto.OpenWeatherMapCityDto;
import com.mateuszwed.weatherForecastApi.dto.OpenWeatherMapDto;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import com.mateuszwed.weatherForecastApi.dto.WeatherDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherDtoMapper {
    public List<WeatherDto> openWeatherMapDtoToWeatherDtoList(OpenWeatherMapDto openWeatherMapDto) {
        return openWeatherMapDto.getList().stream()
                .map(listElement -> WeatherDto.builder()
                        .temperatureDay(listElement.getTemp().getDay())
                        .temperatureNight(listElement.getTemp().getNight())
                        .windSpeed(listElement.getSpeed())
                        .pressure(listElement.getPressure())
                        .humidity(listElement.getHumidity())
                        .date(LocalDate.from(LocalDateTime.ofEpochSecond(listElement.getDt(), 0, ZoneOffset.UTC)))
                        .build())
                .collect(Collectors.toList());
    }

    public WeatherForecastDto openWeatherMapToWeatherForecastDto(OpenWeatherMapCityDto openWeatherMapCityDto, List<WeatherDto> weatherDtoList) {
        return  WeatherForecastDto.builder()
                .city(openWeatherMapCityDto.getName())
                .weather(weatherDtoList)
                .build();
    }
}
