package org.pedrograciabernal.serverless.simple.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pedrograciabernal.serverless.simple.model.WeatherDataModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CityDataResponse {
    private String cityName;
    private WeatherDataModel weather;
}
