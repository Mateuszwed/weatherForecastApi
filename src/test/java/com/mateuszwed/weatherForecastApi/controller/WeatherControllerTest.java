package com.mateuszwed.weatherForecastApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mateuszwed.weatherForecastApi.BuildWeather;
import com.mateuszwed.weatherForecastApi.dto.WeatherDto;
import com.mateuszwed.weatherForecastApi.dto.WeatherForecastDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getWeatherForecastShouldBeReturnStatus200() throws Exception {
        //given, when
        var weatherForecastDto = BuildWeather.buildWeatherForecastDto("London");
        var result = mockMvc.perform(get("/weathers/London").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(weatherForecastDto)).characterEncoding("utf-8")).andDo(print()).andExpect(status().isOk()).andReturn();
        var json = result.getResponse().getContentAsString();
        var weatherForecastDto1 = objectMapper.readValue(json, WeatherForecastDto.class);

        //then
        assertThat(weatherForecastDto1.getCity()).isEqualTo("London");
        assertThat(weatherForecastDto1.getWeather()).hasSize(5);
    }

    @Test
    void getUncorrectedCityNameShouldBeReturnStatus400() throws Exception {
        //given, when
        var weatherForecastDto = new WeatherForecastDto();
        mockMvc.perform(get("/weathers/123").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(weatherForecastDto)).characterEncoding("utf-8")).andDo(print()).andExpect(status().isBadRequest()).andReturn();
    }
}