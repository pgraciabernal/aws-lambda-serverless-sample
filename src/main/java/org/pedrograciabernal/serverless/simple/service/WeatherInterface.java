package org.pedrograciabernal.serverless.simple.service;

import org.pedrograciabernal.serverless.simple.model.WeatherDataModel;

public interface WeatherInterface {

    public WeatherDataModel getWeatherInfo(String cityName);
}
