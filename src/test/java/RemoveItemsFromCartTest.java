import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RemoveItemsFromCartTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginPage.LOGIN_URL);
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("standard_user", "secret_sauce");
        MainPage shop = new MainPage(webDriver);
        shop.addAllElementToCart();
        shop.navigateToCart();
    }

    @Test
    public void removeAllItemsTest() {
        CartPage cart = new CartPage(webDriver);

        cart.removeAllItems();

        Assertions.assertTrue(cart.verifyCartIsEmpty());
    }

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            webDriver.quit();
        }
    }
}
