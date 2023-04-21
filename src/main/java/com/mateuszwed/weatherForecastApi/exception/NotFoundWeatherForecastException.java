package com.mateuszwed.weatherForecastApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundWeatherForecastException extends NullPointerException {
    public NotFoundWeatherForecastException(String message){
        super(message);
    }
}
