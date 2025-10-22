package ru.stellarburgers.step;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import ru.stellarburgers.model.request.UserLoginBody;
import ru.stellarburgers.model.request.UserRegistrationBody;

import static io.restassured.RestAssured.given;
import static ru.stellarburgers.config.RestConfig.*;

public class UserSteps {
    @Step("Create a user")
    public ValidatableResponse createAUser(UserRegistrationBody user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(CREATE_USER)
                .then();
    }

    @Step("Login user")
    public ValidatableResponse loginUser(UserLoginBody user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then();
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .auth()
                .oauth2(accessToken)
                .when()
                .delete(DELETE_USER)
                .then();
    }

    public String getAccessToken(ValidatableResponse response) {
        return response
                .extract()
                .body()
                .jsonPath()
                .getString("accessToken")
                .replace("Bearer ", "").trim();
    }
}
