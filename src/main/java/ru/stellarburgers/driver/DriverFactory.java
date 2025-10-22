package ru.stellarburgers.driver;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            startYandex();
        } else {
            startChrome();
        }
    }

    private void startYandex() {
        String path = System.getProperty("yandex-browser-driver");
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        String browserPath = System.getProperty("yandex-browser");
        options.setBinary(browserPath);
        driver = new ChromeDriver(options);
    }

    private void startChrome() {
        driver = new ChromeDriver();
    }

    @Override
    public void before() {
        initDriver();
    }

    @Override
    public void after() {
        driver.quit();
    }

}
