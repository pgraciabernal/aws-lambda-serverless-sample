package org.pedrograciabernal.serverless.simple.service;

import org.pedrograciabernal.serverless.simple.model.WeatherDataModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("weatherService")
public class WeatherService implements WeatherInterface {

    private static final String RESOURCE_URL_PROPERTY = "RESOURCE_URL";
    private static final String RESOURCE_CONTEXT_PROPERTY = "RESOURCE_CONTEXT";

    public WeatherDataModel getWeatherInfo(String cityName) {
        WeatherDataModel weatherDataModel = new WeatherDataModel();

        RestTemplate restTemplate = new RestTemplate();
        String weatherResourceUrl = System.getenv(RESOURCE_URL_PROPERTY)
                .concat(System.getenv(RESOURCE_CONTEXT_PROPERTY))
                .concat(cityName);
        ResponseEntity<WeatherDataModel> response
                = restTemplate.getForEntity(weatherResourceUrl, WeatherDataModel.class);

        return response.getBody();
    }
}
