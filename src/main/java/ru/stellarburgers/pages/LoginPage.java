package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open login page")
    public void openLoginPage(WebDriver driver) {
        driver.get("https://stellarburgers.nomorepartiessite.ru/login");
    }

    @Step("Enter the email into the username field.")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Enter the password into the password field")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click on button: {buttonName}")
    public void clickButton(By buttonLocator, String buttonName) {
        driver.findElement(buttonLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver1 -> true);
    }

    @Step("Complete the login form")
    public void completeLoginForm(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField)).isDisplayed();
        setEmail(email);
        setPassword(password);
        clickButton(loginButton, "Login button");
    }
}
