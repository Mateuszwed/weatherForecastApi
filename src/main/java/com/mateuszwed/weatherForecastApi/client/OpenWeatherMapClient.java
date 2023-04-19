package com.mateuszwed.weatherForecastApi.client;

import com.mateuszwed.weatherForecastApi.dto.OpenWeatherMapDto;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastCity;
import com.mateuszwed.weatherForecastApi.exception.EmptyWeatherForecastListException;
import com.mateuszwed.weatherForecastApi.exception.HttpException;
import com.mateuszwed.weatherForecastApi.exception.NotFoundWeatherForecastException;
import com.mateuszwed.weatherForecastApi.mapper.WeatherMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class OpenWeatherMapClient {
    final RestTemplate restTemplate;
    final WeatherMapper weatherMapper;
    @Value("${open.weather.map.url}")
    String URL;
    @Value("${open.weather.map.code}")
    String CODE;
    @Value("${open.weather.map.units}")
    String UNITS;
    @Value("${open.weather.map.days}")
    String DAYS;

    public WeatherForecastCity getWeatherForecast(String city) {
        ResponseEntity<OpenWeatherMapDto> response;
        var request = new HttpEntity<>(getHttpHeaders());
        try {
            response = restTemplate.exchange(URL + city + DAYS + CODE + UNITS, HttpMethod.GET, request, new ParameterizedTypeReference<>() {
            });
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new HttpException(e.getStatusCode(), "Problem with call to OpenWeatherMap");
        }
        var openWeatherMapDto = Optional.ofNullable(response.getBody())
                .orElseThrow(() -> new NotFoundWeatherForecastException("Api response have null value"));
        var weatherForecastDtoList = weatherMapper.openWeatherMapDtoToWeatherForecastDtoList(openWeatherMapDto);
        if(weatherForecastDtoList.isEmpty()) {
            throw new EmptyWeatherForecastListException("Weather forecast list is empty");
        }
        return weatherMapper.openWeatherMapToWeatherForecastCity(openWeatherMapDto.getCity(), weatherForecastDtoList);
    }

    private HttpHeaders getHttpHeaders() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
