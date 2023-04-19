package com.mateuszwed.weatherForecastApi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class WeatherExceptionHandler {
    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<String> handleHttpException(HttpException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body("Problem with call to OpenWeatherMap");
    }

    @ExceptionHandler(value = EmptyWeatherForecastListException.class)
    public ResponseEntity<String> handleEmptyWeatherForecastListException(EmptyWeatherForecastListException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body("Weather forecast list is empty");
    }

    @ExceptionHandler(value = NotFoundWeatherForecastException.class)
    public ResponseEntity<String> handleNotFoundWeatherForecastException(NotFoundWeatherForecastException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body("Api response have null value");
    }

    @ExceptionHandler(value = WrongCharacterFormatInCityName.class)
    public ResponseEntity<String> handleWrongCharacterFormatInCityName(WrongCharacterFormatInCityName e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body("The city name contains special characters or digits");
    }
}
