package org.pedrograciabernal.serverless.simple.function;

import lombok.extern.slf4j.Slf4j;
import org.pedrograciabernal.serverless.simple.model.WeatherDataModel;
import org.pedrograciabernal.serverless.simple.service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
@Slf4j
public class CityFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityFunctionApplication.class, args);
	}

	@Bean
	public Function<CityDataRequest, CityDataResponse> city() {
		return city -> {
			CityDataResponse response = new CityDataResponse();
			response.setCityName(city.getCityName());
			WeatherService weatherService = new WeatherService();
			weatherService.getWeatherInfo(city.getCityName());
			weatherService.getWeatherInfo(city.getCityName());
			WeatherDataModel weatherDataModel = weatherService.getWeatherInfo(city.getCityName());
			log.info(weatherDataModel.toString());
			response.setWeather(weatherDataModel);
		    return response;
        };
	}
}
