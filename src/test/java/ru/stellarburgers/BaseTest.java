package ru.stellarburgers;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Before;

import static ru.stellarburgers.config.RestConfig.BASE_URL;

public class BaseTest {
    @Before
    public void startUp() {
        RestAssured.baseURI = BASE_URL;

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig
                        .logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails());
    }
}
