package ru.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.driver.DriverFactory;
import ru.stellarburgers.model.request.UserLoginBody;
import ru.stellarburgers.pages.LoginPage;
import ru.stellarburgers.pages.MainPage;
import ru.stellarburgers.pages.ProfilePage;
import ru.stellarburgers.pages.RegistrationPage;
import ru.stellarburgers.step.UserSteps;

import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;

public class UserRegistrationTest extends BaseTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    private final String username = "Pulsar";
    private final String email = "email@mail.test";
    private final String password = "interstellar";
    private final UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("User registration with valid required fields")
    @Description("Expected result: the username field on the profile page contains the value \"Pulsar\"")
    public void registrationUserWithValidRequiredFieldsTest() {
        WebDriver driver = factory.getDriver();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.openRegistrationPage(driver);

        objRegistrationPage.completeRegistrationForm(username, email, password);

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.openLoginPage(driver);
        objLoginPage.completeLoginForm(email, password);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButton(objMainPage.getPersonalAccountButton(), "personal account button on the header");

        ProfilePage objProfilePage = new ProfilePage(driver);
        Assert.assertTrue(objProfilePage.isUsernameDisplayed());
    }

    @Test
    @DisplayName("User registration with invalid password")
    @Description("Expected result: error message is displayed indicating invalid password")
    public void registrationUserWithInvalidPasswordTest() {
        WebDriver driver = factory.getDriver();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.openRegistrationPage(driver);

        objRegistrationPage.completeRegistrationForm(username, email, "qwer");

        Assert.assertTrue(objRegistrationPage.isInputErrorPasswordFieldDisplayed());
    }

    @After
    public void cleanUp() {
        UserLoginBody user = new UserLoginBody(email, password);
        ValidatableResponse response = userSteps.loginUser(user);

        if(response.extract().statusCode() == HTTP_OK) {
            String accessToken = userSteps.getAccessToken(response);

            userSteps
                    .deleteUser(accessToken)
                    .statusCode(HTTP_ACCEPTED);
        }
    }
}
