package com.mateuszwed.weatherForecastApi;

import com.mateuszwed.weatherForecastApi.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class BuildWeather {

    public static OpenWeatherMapDto buildOpenWeatherMapDto() {
        var openWeatherMapCityDto = OpenWeatherMapCityDto.builder()
                .name("London")
                .build();
        var openWeatherMapTemperature = OpenWeatherMapTemperatureDto.builder()
                .day(15)
                .night(10)
                .build();
        var openWeatherMapTemperature2 = OpenWeatherMapTemperatureDto.builder()
                .day(13)
                .night(9)
                .build();
        var openWeatherMapTemperature3 = OpenWeatherMapTemperatureDto.builder()
                .day(17)
                .night(7)
                .build();
        var openWeatherMapTemperature4 = OpenWeatherMapTemperatureDto.builder()
                .day(12)
                .night(5)
                .build();
        var openWeatherMapTemperature5 = OpenWeatherMapTemperatureDto.builder()
                .day(15)
                .night(11)
                .build();
        var openWeatherMapListDto = OpenWeatherMapListDto.builder()
                .temp(openWeatherMapTemperature)
                .dt(1646318698)
                .speed(15)
                .pressure(1014)
                .humidity(65)
                .build();
        var openWeatherMapListDto2 = OpenWeatherMapListDto.builder()
                .temp(openWeatherMapTemperature2)
                .dt(1646318698)
                .speed(13)
                .pressure(1015)
                .humidity(64)
                .build();
        var openWeatherMapListDto3 = OpenWeatherMapListDto.builder()
                .temp(openWeatherMapTemperature3)
                .dt(1646318698)
                .speed(14)
                .pressure(1015)
                .humidity(63)
                .build();
        var openWeatherMapListDto4 = OpenWeatherMapListDto.builder()
                .temp(openWeatherMapTemperature4)
                .dt(1646318698)
                .speed(16)
                .pressure(1016)
                .humidity(66)
                .build();
        var openWeatherMapListDto5 = OpenWeatherMapListDto.builder()
                .temp(openWeatherMapTemperature5)
                .dt(1646318698)
                .speed(13)
                .pressure(1013)
                .humidity(65)
                .build();
        var openWeatherMapDtoList = new ArrayList<OpenWeatherMapListDto>();
        openWeatherMapDtoList.add(openWeatherMapListDto);
        openWeatherMapDtoList.add(openWeatherMapListDto2);
        openWeatherMapDtoList.add(openWeatherMapListDto3);
        openWeatherMapDtoList.add(openWeatherMapListDto4);
        openWeatherMapDtoList.add(openWeatherMapListDto5);
        return new OpenWeatherMapDto(openWeatherMapCityDto, openWeatherMapDtoList);
    }

    public static List<WeatherDto> buildWeatherDtoList(){
        var weatherDto = WeatherDto.builder()
                .temperatureDay(15)
                .temperatureNight(10)
                .windSpeed(15)
                .pressure(1014)
                .humidity(65)
                .date(LocalDate.from(LocalDateTime.ofEpochSecond(1646318698, 0, ZoneOffset.UTC)))
                .build();
        var weatherDto2 = WeatherDto.builder()
                .temperatureDay(13)
                .temperatureNight(9)
                .windSpeed(13)
                .pressure(1013)
                .humidity(64)
                .date(LocalDate.from(LocalDateTime.ofEpochSecond(1646318698, 0, ZoneOffset.UTC)))
                .build();
        var weatherDto3 = WeatherDto.builder()
                .temperatureDay(17)
                .temperatureNight(7)
                .windSpeed(14)
                .pressure(1015)
                .humidity(63)
                .date(LocalDate.from(LocalDateTime.ofEpochSecond(1646318698, 0, ZoneOffset.UTC)))
                .build();
        var weatherDto4 = WeatherDto.builder()
                .temperatureDay(12)
                .temperatureNight(5)
                .windSpeed(16)
                .pressure(1016)
                .humidity(66)
                .date(LocalDate.from(LocalDateTime.ofEpochSecond(1646318698, 0, ZoneOffset.UTC)))
                .build();
        var weatherDto5 = WeatherDto.builder()
                .temperatureDay(15)
                .temperatureNight(11)
                .windSpeed(13)
                .pressure(1013)
                .humidity(65)
                .date(LocalDate.from(LocalDateTime.ofEpochSecond(1646318698, 0, ZoneOffset.UTC)))
                .build();
        var weatherDtoList = new ArrayList<WeatherDto>();
        weatherDtoList.add(weatherDto);
        weatherDtoList.add(weatherDto2);
        weatherDtoList.add(weatherDto3);
        weatherDtoList.add(weatherDto4);
        weatherDtoList.add(weatherDto5);
        return weatherDtoList;
    }

    public static WeatherForecastDto buildWeatherForecastDto(String city){
        return WeatherForecastDto.builder()
                .city(city)
                .weather(buildWeatherDtoList())
                .build();
    }
}
