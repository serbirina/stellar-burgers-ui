package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath(".//a[@href='/login']");

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLoginButton() {
        return loginButton;
    }

    @Step("Open the reset page")
    public void openResetPage(WebDriver driver) {
        driver.get("https://stellarburgers.nomorepartiessite.ru/forgot-password");
    }

    @Step("Click on button: {buttonName}")
    public void clickButton(By buttonLocator, String buttonName) {
        driver.findElement(buttonLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver1 -> true);
    }
}
