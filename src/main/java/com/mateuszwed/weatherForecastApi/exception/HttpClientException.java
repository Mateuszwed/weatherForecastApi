package com.mateuszwed.weatherForecastApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HttpClientException extends HttpClientErrorException {
    public HttpClientException(HttpStatus status, String message){
        super(status, message);
    }
}
