package mateuszwed.weatherForecastApi.dto;

import java.math.BigDecimal;
import java.util.List;

public class OpenWeatherMapDto {
    List<OpenWeatherMapList> list;
}

class OpenWeatherMapList {
    OpenWeatherMapMain main;
    OpenWeatherMapWind wind;
}

class OpenWeatherMapMain {
    BigDecimal temp;
    int pressure;
    int humidity;
}

class OpenWeatherMapWind {
    BigDecimal speed;
}
