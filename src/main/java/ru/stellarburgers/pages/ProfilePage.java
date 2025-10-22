package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    private final By valueUsernameField = By.xpath(".//input[@value='Pulsar']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Assert username is displayed")
    public boolean isUsernameDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(valueUsernameField)).isDisplayed();
    }
}
