package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    private final By valueUsernameField = By.xpath(".//label[text()='Имя']/../input");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Assert username is displayed")
    public void AssertThatUsernameDisplayed(String name) {
        String attribute = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(valueUsernameField)).getAttribute("value");
        Assert.assertNotNull(attribute);
        Assert.assertTrue(attribute.contains(name));
    }
}
