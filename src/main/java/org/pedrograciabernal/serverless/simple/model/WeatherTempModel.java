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
public class WeatherTempModel implements Serializable {

    @JsonProperty("c")
    private String celsius;
    @JsonProperty("f")
    private String fahrenheit;

}
