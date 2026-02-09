package ru.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.driver.DriverFactory;
import ru.stellarburgers.pages.MainPage;

public class SelectCategoryTest extends BaseTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    @Test
    @DisplayName("Select bun category test")
    @Description("Verifies that the bun category becomes active and its class attribute contains \"tab_tab_type_current__\"")
    public void selectBunCategoryTest() {
        WebDriver driver = factory.getDriver();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage(driver);

        objMainPage.assertThatCategoryIsSelected(objMainPage.getBunCategory(), "bun category");
    }

    @Test
    @DisplayName("Select sauce category test")
    @Description("Verifies that the sauce category becomes active and its class attribute contains \"tab_tab_type_current__\"")
    public void selectSauceCategoryTest() {
        WebDriver driver = factory.getDriver();

        MainPage objMainPage = new MainPage(driver);

        By categoryLocator = objMainPage.getSauceCategory();
        String nameCategory = "sauce category";

        objMainPage.openMainPage(driver);
        objMainPage.clickButton(categoryLocator, nameCategory);

        objMainPage.assertThatCategoryIsSelected(categoryLocator, nameCategory);
    }

    @Test
    @DisplayName("Select filling category test")
    @Description("Verifies that the filling category becomes active and its class attribute contains \"tab_tab_type_current__\"")
    public void selectFillingCategoryTest() {
        WebDriver driver = factory.getDriver();

        MainPage objMainPage = new MainPage(driver);

        By categoryLocator = objMainPage.getFillingCategory();
        String nameCategory = "filling category";

        objMainPage.openMainPage(driver);
        objMainPage.clickButton(categoryLocator, nameCategory);

        objMainPage.assertThatCategoryIsSelected(categoryLocator, nameCategory);
    }
}
