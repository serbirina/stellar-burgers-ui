package ru.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.driver.DriverFactory;
import ru.stellarburgers.pages.MainPage;

@RunWith(Parameterized.class)
public class SelectCategoryTest extends BaseTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    private final By categoryLocator;
    private final String nameCategory;

    public SelectCategoryTest(By category, String nameCategory) {
        this.categoryLocator = category;
        this.nameCategory = nameCategory;
    }

    @Parameterized.Parameters(name="Selected category: {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {MainPage.bunCategory, "bun category"},
                {MainPage.sauceCategory, "sauce category"},
                {MainPage.fillingCategory, "filling category"}
        };
    }

    @Test
    @DisplayName("Select category test")
    @Description("Verify that the selected category becomes active and its class attribute contains \"tab_tab_type_current__\"")
    public void selectCategoryTest() {
        WebDriver driver = factory.getDriver();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage(driver);

        if(!"bun category".equals(nameCategory)) {
            objMainPage.clickButton(categoryLocator, nameCategory);
        }

        objMainPage.assertThatCategoryIsSelected(categoryLocator, nameCategory);
    }
}
