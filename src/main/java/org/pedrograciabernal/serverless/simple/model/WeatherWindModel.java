package org.pedrograciabernal.serverless.simple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherWindModel implements Serializable {

    private String km;
    private String mile;
}
