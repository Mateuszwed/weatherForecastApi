package mateuszwed.weatherForecastApi.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Getter
public class OpenWeatherMapDto {
    OpenWeatherMapCity city;
    List<OpenWeatherMapList> list;
}

@Getter
class OpenWeatherMapList {
    Date dt;
    OpenWeatherMapTemperature temp;
    BigDecimal speed;
    int pressure;
    int humidity;
}

@Getter
class OpenWeatherMapTemperature {
    BigDecimal day;
    BigDecimal night;
}

@Getter
class OpenWeatherMapCity {
    String name;
}
