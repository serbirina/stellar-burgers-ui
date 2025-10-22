package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;

    private final By usernameField = By.xpath(".//label[text()='Имя']/../input");
    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By inputErrorPasswordField = By.xpath(".//p[text()='Некорректный пароль']");

    private final By loginButton = By.xpath(".//a[@href='/login']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLoginButton() {
        return loginButton;
    }

    @Step("Open the registration page")
    public void openRegistrationPage(WebDriver driver) {
        driver.get("https://stellarburgers.nomorepartiessite.ru/register");
    }

    @Step("Enter the username into the username field.")
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Enter the email into the email field")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Enter the password into the password field")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click on button: {buttonName}")
    public void clickButton(By buttonLocator, String buttonName) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();
    }

    @Step("Complete the registration form")
    public void completeRegistrationForm(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        clickButton(registrationButton, "registration button");
    }

    @Step("Assert input error in password field is displayed")
    public boolean isInputErrorPasswordFieldDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(inputErrorPasswordField)).isDisplayed();
    }
}
