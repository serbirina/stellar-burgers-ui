package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//a[@href='/account']");

    private final By bunCategory = By.xpath(".//span[text()='Булки']/..");
    private final By sauceCategory = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingCategory = By.xpath(".//span[text()='Начинки']/..");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getPersonalAccountButton() {
        return personalAccountButton;
    }

    public By getBunCategory() {
        return bunCategory;
    }

    public By getSauceCategory() {
        return sauceCategory;
    }

    public By getFillingCategory() {
        return fillingCategory;
    }

    @Step("Open main page")
    public void openMainPage(WebDriver driver) {
        driver.get("https://stellarburgers.nomorepartiessite.ru/");
    }

    @Step("Click on button: {buttonName}")
    public void clickButton(By buttonLocator, String buttonName) {
        driver.findElement(buttonLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver1 -> true);
    }

    @Step("Assert that category \"{nameCategory}\" is selected")
    public void assertThatCategoryIsSelected(By categoryLocator, String nameCategory) {
        String attribute = driver.findElement(categoryLocator).getAttribute("class");
        Assert.assertNotNull(attribute);
        Assert.assertTrue(attribute.contains("tab_tab_type_current__"));
    }
}
