package org.pedrograciabernal.serverless.simple.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDataRequest {
    private String cityName;
}
