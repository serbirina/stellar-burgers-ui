package ru.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.driver.DriverFactory;
import ru.stellarburgers.model.request.UserRegistrationBody;
import ru.stellarburgers.pages.*;
import ru.stellarburgers.step.UserSteps;

import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UserLoginTest extends BaseTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    private final String email = "email@mail.test";
    private final String password = "interstellar";
    private String accessToken;
    private final UserSteps userSteps = new UserSteps();

    @Before
    public void setUp() {
        UserRegistrationBody userRegistrationBody = new UserRegistrationBody(email, password, "Pulsar");

        ValidatableResponse response = userSteps.createAUser(userRegistrationBody);
        response.statusCode(HTTP_OK).body("accessToken", notNullValue());

        accessToken = userSteps.getAccessToken(response);
    }

    @Test()
    @DisplayName("User login using the login button on the main page")
    @Description("Expected result: the username field on the profile page contains the value \"Pulsar\"")
    public void UserLoginWhenCLickLoginButtonHomePageTest() {
        WebDriver driver = factory.getDriver();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage(driver);
        objMainPage.clickButton(objMainPage.getLoginButton(), "login button on the main page");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.completeLoginForm(email, password);

        objMainPage.clickButton(objMainPage.getPersonalAccountButton(), "personal account button on the header");

        ProfilePage objProfilePage = new ProfilePage(driver);
        Assert.assertTrue(objProfilePage.isUsernameDisplayed());
    }

    @Test
    @DisplayName("User login using the personal account button on the main page")
    @Description("Expected result: the username field on the profile page contains the value \"Pulsar\"")
    public void UserLoginWhenCLickPersonalAccountButtonInHeaderTest() {
        WebDriver driver = factory.getDriver();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage(driver);
        objMainPage.clickButton(objMainPage.getPersonalAccountButton(), "personal account button on the header");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.completeLoginForm(email, password);

        objMainPage.clickButton(objMainPage.getPersonalAccountButton(), "personal account button on the header");

        ProfilePage objProfilePage = new ProfilePage(driver);
        Assert.assertTrue(objProfilePage.isUsernameDisplayed());
    }

    @Test
    @DisplayName("User login using the login button on the registration page")
    @Description("Expected result: the username field on the profile page contains the value \"Pulsar\"")
    public void UserLoginWhenCLickLoginButtonOnRegistrationPage() {
        WebDriver driver = factory.getDriver();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.openRegistrationPage(driver);
        objRegistrationPage.clickButton(objRegistrationPage.getLoginButton(), "login button on the registration page");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.completeLoginForm(email, password);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButton(objMainPage.getPersonalAccountButton(), "personal account button on the header");

        ProfilePage objProfilePage = new ProfilePage(driver);
        Assert.assertTrue(objProfilePage.isUsernameDisplayed());
    }

    @Test
    @DisplayName("User login using the login button on the reset password page")
    @Description("Expected result: the username field on the profile page contains the value \"Pulsar\"")
    public void UserLoginWhenCLickLoginButtonOnResetPasswordPage() {
        WebDriver driver = factory.getDriver();

        ResetPasswordPage objResetPasswordPage = new ResetPasswordPage(driver);
        objResetPasswordPage.openResetPage(driver);
        objResetPasswordPage.clickButton(objResetPasswordPage.getLoginButton(), "login button on the reset password page");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.completeLoginForm(email, password);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButton(objMainPage.getPersonalAccountButton(), "personal account button on the header");

        ProfilePage objProfilePage = new ProfilePage(driver);
        Assert.assertTrue(objProfilePage.isUsernameDisplayed());
    }

    @After
    public void cleanUp() {
        userSteps
                .deleteUser(accessToken)
                .statusCode(HTTP_ACCEPTED);
    }
}
