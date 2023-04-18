package mateuszwed.weatherForecastApi.client;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import mateuszwed.weatherForecastApi.dto.OpenWeatherMapDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class OpenWeatherMapClient {
    RestTemplate restTemplate;
    String URL = "https://api.openweathermap.org/data/2.5/forecast/daily?q=";
    String CODE = "542ffd081e67f4512b705f89d2a611b2";
    String METRIC = "&units=metric";

    public OpenWeatherMapDto getWeatherForecast(String city){
        ResponseEntity<OpenWeatherMapDto> response;
        var request = new HttpEntity<>(getHttpHeaders());
        response = restTemplate.exchange(URL + city + "&cnt=5&appid=" + CODE + METRIC, HttpMethod.GET, request, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
