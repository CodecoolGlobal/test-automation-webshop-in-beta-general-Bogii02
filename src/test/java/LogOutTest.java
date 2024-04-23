import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LogOutTest {

    private WebDriver webDriver;
    private LoginPage loginPage;


    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.navigate().to(LoginPage.LOGIN_URL);
        loginPage.logIn("standard_user", "secret_sauce");
    }

    @Test
    public void successfulLogout() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.logOut();
        Assertions.assertTrue(loginPage.isLoginLogoAppear());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
