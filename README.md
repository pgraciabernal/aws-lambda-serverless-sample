# aws-lambda-serverless-sample
Simple demo for a microservice serverless deploy in AWS Lambda

# Scenario
Very simple use case for this example. A request that returns current weather for a city.

Once the request is executed using the key ```cityName``` like in the following example:
```json
{
  "cityName": "london",
}
```
Service will invoke a public API endpoint that response with data about current time based on city criteria in JSON format.

# Deployment
Related to deployment this project uses serverless platform. You can take a look on this platform and further information in [serverless web page](https://www.serverless.com/)

In that case is very important to fulfill properly file **serverless.yml**. Take a look in ```functions``` properties:
```yaml
functions:
  request:
    handler: org.pedrograciabernal.serverless.simple.function.AwsLambdaHandler
    environment:
      FUNCTION_NAME: city
      RESOURCE_URL: "https://weatherdbi.herokuapp.com/"
      RESOURCE_CONTEXT: "data/weather/"
```
It is mandatory to set complete package path value pointing to class **AwsLambdaHandler** in order than AWS Lambda has an starting point.

Take a look as well to the environment variables block:
- FUNCTION_NAME: point to the endpoint context that matches with the name of the method who receives the request.
- RESOURCE_URL: information with the public API url used by the service to send the request about weather in a city.
- RESOURCE_CONTEXT: context into endpoint to address API request.

All these variables will be send to AWS Lambda as **Environment variables** into **Configuration** tab lambda information deployed:

![Environment variables](/_images/environment_variables.png)


Once you check code, and after install serverless bundle in your local machine, execute ```serverless``` from a command line. You will have a very similar response like this (maybe region is differente to *us-east-1*):

```
Deploying aws-spring-cloud-function-city to stage dev (us-east-1)

✔ Service deployed to stack aws-spring-cloud-function-city-dev (51s)

endpoint: GET - https://xxxxx.execute-api.us-east-1.amazonaws.com/city
functions:
  request: aws-spring-cloud-function-city-dev-request (14 MB)
```

Really ```serverless``` platform has proceed to execute some tasks using CloudFormation feature from AWS, creating an ```API Gateway``` and deployment this project into ```AWS Lambda```

# Execution

Once ```serverless``` has finished succesfully you can visit your aws console and go to ```AWS Lambda``` service. You will see the new function in the grid, just click on its name and, once in the **Function overview**, select **Test** tab.

Check **New event** option and set the following json format message into the text area:
```json
{
  "cityName": "london",
}
```

And finally click on **Test** button:

![Execution](/_images/function_execution.png)

After a few seconds, into **Execution result** section you must check a succesfull answer very similar to this one:

```json
{
  "cityName": "london",
  "weather": {
    "region": "London, UK",
    "currentConditions": {
      "dayhour": "Friday 1:00 PM",
      "temp": {
        "celsius": "12",
        "fahrenheit": "53"
      },
      "precipitation": "85%",
      "humidity": "73%",
      "comment": "Cloudy",
      "wind": {
        "km": "19",
        "mile": "12"
      }
    }
  }
}
```

# Other considerations
Like this project uses ```serverless``` platform, you can check what deployment file has been configured by this platform into ```CloudFormation``` services for AWS