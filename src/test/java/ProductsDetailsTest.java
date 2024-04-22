import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ProductsDetailsTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginPage.LOGIN_URL);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("standard_user", "secret_sauce");
    }

    @Test
    public void productsDetailsTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.checkItemDetails();
        Assertions.assertTrue(mainPage.areWeOnProductsDetails());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
