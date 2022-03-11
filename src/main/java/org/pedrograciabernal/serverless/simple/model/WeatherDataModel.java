package org.pedrograciabernal.serverless.simple.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataModel implements Serializable {

    private String region;
    private WeatherCurrentModel currentConditions;
    // Error keys
    private String status;
    private String message;
    private String query;

}
