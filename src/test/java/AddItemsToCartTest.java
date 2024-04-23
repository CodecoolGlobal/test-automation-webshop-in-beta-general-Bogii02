import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AddItemsToCartTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginPage.LOGIN_URL);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("standard_user", "secret_sauce");
    }

    @Test
    public void addAllItemsTest() {
        MainPage shop = new MainPage(webDriver);
        CartPage cart = new CartPage(webDriver);

        int addedItemsAmount = shop.addAllElementToCart();
        shop.navigateToCart();

        Assertions.assertTrue(cart.verifyItemsAdded(addedItemsAmount));
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
