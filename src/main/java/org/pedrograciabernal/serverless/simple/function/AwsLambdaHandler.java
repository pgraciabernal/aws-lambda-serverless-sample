package org.pedrograciabernal.serverless.simple.function;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class AwsLambdaHandler extends SpringBootRequestHandler<CityDataRequest, CityDataResponse> {
}