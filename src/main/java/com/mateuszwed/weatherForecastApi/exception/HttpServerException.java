package com.mateuszwed.weatherForecastApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class HttpServerException extends HttpServerErrorException {
    public HttpServerException(HttpStatus status, String message){
        super(status, message);
    }
}
