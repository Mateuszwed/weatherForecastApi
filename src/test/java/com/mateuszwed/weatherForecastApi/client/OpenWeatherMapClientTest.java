package com.mateuszwed.weatherForecastApi.client;

import com.mateuszwed.weatherForecastApi.BuildWeather;
import com.mateuszwed.weatherForecastApi.dto.*;
import com.mateuszwed.weatherForecastApi.exception.EmptyWeatherForecastListException;
import com.mateuszwed.weatherForecastApi.exception.HttpClientException;
import com.mateuszwed.weatherForecastApi.exception.HttpServerException;
import com.mateuszwed.weatherForecastApi.exception.NotFoundWeatherForecastException;
import com.mateuszwed.weatherForecastApi.mapper.WeatherDtoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OpenWeatherMapClientTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    WeatherDtoMapper weatherDtoMapper;
    @InjectMocks
    OpenWeatherMapClient openWeatherMapClient;

    @Test
    void getWeatherForecastShouldBeReturnListOfWeathersToFiveDaysAndStatusCode200(){
        // given
        var openWeatherMapDto = BuildWeather.buildOpenWeatherMapDto();
        var city = openWeatherMapDto.getCity().getName();
        var weatherDtoList = BuildWeather.buildWeatherDtoList();
        var weatherForecastDto = BuildWeather.buildWeatherForecastDto(city);
        var responseEntity = new ResponseEntity<>(openWeatherMapDto, HttpStatus.OK);
        when(weatherDtoMapper.openWeatherMapDtoToWeatherDtoList(openWeatherMapDto))
                .thenReturn(weatherDtoList);
        when(weatherDtoMapper.openWeatherMapToWeatherForecastDto(openWeatherMapDto.getCity(), weatherDtoList))
                .thenReturn(weatherForecastDto);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }))).thenReturn(responseEntity);

        // when
        var result = openWeatherMapClient.getWeatherForecast(city);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getWeather()).hasSize(5);
        assertThat(result.getCity()).isEqualTo(city);
        assertThat(result.getWeather()).isEqualTo(weatherForecastDto.getWeather());
    }

    @Test
    void wrongUrlToApiShouldBeReturnThrowHttpServerExceptionWithStatusCode500() {
        // given
        var httpServerException = new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }))).thenThrow(httpServerException);

        // when, then
        assertThrows(HttpServerException.class, () -> openWeatherMapClient.getWeatherForecast("city"));
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }));
    }

    @Test
    void wrongDataFromClientShouldBeReturnThrowHttpClientExceptionWithStatusCode404() {
        // given
        var httpClientException = new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }))).thenThrow(httpClientException);

        // when, then
        assertThrows(HttpClientException.class, () -> openWeatherMapClient.getWeatherForecast("city"));
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }));
    }

    @Test
    void whenMethodReturnEmptyListShouldBeThrowEmptyWeatherForecastListException() {
        //given
        var responseEntity = ResponseEntity.ok(new OpenWeatherMapDto());
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }))).thenReturn(responseEntity);

        //when, then
        assertThatThrownBy(() -> openWeatherMapClient.getWeatherForecast("city"))
                .isInstanceOf(EmptyWeatherForecastListException.class)
                .hasMessage("Weather forecast list is empty");
    }

    @Test
    void whenRequestReturnNullThenThrowsNotFoundWeatherForecastException() {
        //given
        ResponseEntity<OpenWeatherMapDto> responseEntity = ResponseEntity.ok(null);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<OpenWeatherMapDto>() {
        }))).thenReturn(responseEntity);

        //when, then
        assertThatThrownBy(() -> openWeatherMapClient.getWeatherForecast("city")).isInstanceOf(NotFoundWeatherForecastException.class).hasMessage("Api response have null value");
    }
}