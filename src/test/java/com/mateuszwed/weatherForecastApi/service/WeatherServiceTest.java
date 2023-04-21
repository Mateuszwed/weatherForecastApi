package com.mateuszwed.weatherForecastApi.service;

import com.mateuszwed.weatherForecastApi.BuildWeather;
import com.mateuszwed.weatherForecastApi.client.OpenWeatherMapClient;
import com.mateuszwed.weatherForecastApi.dto.WeatherDto;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import com.mateuszwed.weatherForecastApi.exception.WrongCharacterFormatInCityNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    @Mock
    OpenWeatherMapClient openWeatherMapClient;
    @InjectMocks
    WeatherService weatherService;

    @Test
    void correctCityNameShouldBeReturnWeatherForecast() {
        // given
        var weatherForecast = BuildWeather.buildWeatherForecastDto("London");
        when(openWeatherMapClient.getWeatherForecast("London"))
                .thenReturn(weatherForecast);

        // when
        var result = openWeatherMapClient.getWeatherForecast("London");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCity()).isEqualTo("London");
        assertThat(result.getWeather()).hasSize(5);
    }

    @Test
    void wrongCityNameShouldBeThrowWrongCharacterFormatInCityNameException() {
        //given
        when(openWeatherMapClient.getWeatherForecast(anyString()))
                .thenThrow(WrongCharacterFormatInCityNameException.class);

        //when, then
        assertThatThrownBy(() -> weatherService.getWeatherForecast(anyString()))
                .isInstanceOf(WrongCharacterFormatInCityNameException.class);

    }
}