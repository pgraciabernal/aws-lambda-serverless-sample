package org.pedrograciabernal.serverless.simple.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherCurrentModel implements Serializable {

    private String dayhour;
    private WeatherTempModel temp;
    @JsonProperty("precip")
    private String precipitation;
    private String humidity;
    private String comment;
    private WeatherWindModel wind;

}
