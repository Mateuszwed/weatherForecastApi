package com.mateuszwed.weatherForecastApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyWeatherForecastListException extends NoSuchElementException {
    public EmptyWeatherForecastListException(String message){
        super(message);
    }
}
