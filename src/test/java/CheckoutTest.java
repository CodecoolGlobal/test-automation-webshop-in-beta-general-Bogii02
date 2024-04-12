import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CheckoutTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginPage.LOGIN_URL);
    }


    @Test
    public void successfulCheckOutTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("standard_user", "secret_sauce");

        MainPage shop = new MainPage(webDriver);
        CartPage cart = new CartPage(webDriver);
        CheckoutPage checkout = new CheckoutPage(webDriver);

        shop.addOneElementToCart();
        shop.navigateToCart();

        cart.clickOnCheckout();
        checkout.fillInDataForCheckout("Test", "Test", 1234);
        checkout.clickOnContinueButton();
        checkout.clickOnFinishButton();

        Assertions.assertTrue(checkout.isCheckoutMessageDisplayed());
    }

    @Test
    public void unsuccessfulCheckOutTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("problem_user", "secret_sauce");

        MainPage shop = new MainPage(webDriver);
        CartPage cart = new CartPage(webDriver);
        CheckoutPage checkout = new CheckoutPage(webDriver);

        shop.addOneElementToCart();
        shop.navigateToCart();

        cart.clickOnCheckout();

        checkout.fillInDataForCheckout("Test", "Test", 1234);
        checkout.clickOnContinueButton();

        Assertions.assertTrue(checkout.isErrorMessageDisplayed());
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
