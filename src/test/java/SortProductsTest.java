import enums.ProductSortOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortProductsTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginPage.LOGIN_URL);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("standard_user", "secret_sauce");
    }

    @Test
    public void sortAtoZTest() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.sortProducts(ProductSortOption.NAME_A_TO_Z);
        List<String> actual = mainPage.getAllProductsName();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(String::compareTo);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortPrizeLowToHighTest() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.sortProducts(ProductSortOption.PRICE_LOW_TO_HIGH);
        List<Double> actual = mainPage.getAllProductsPrice();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Double::compareTo);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortZtoATest() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.sortProducts(ProductSortOption.NAME_Z_TO_A);
        List<String> actual = mainPage.getAllProductsName();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(Comparator.reverseOrder());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortPrizeHighToLowTest() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.sortProducts(ProductSortOption.PRICE_HIGH_TO_LOW);
        List<Double> actual = mainPage.getAllProductsPrice();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Comparator.reverseOrder());

        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
