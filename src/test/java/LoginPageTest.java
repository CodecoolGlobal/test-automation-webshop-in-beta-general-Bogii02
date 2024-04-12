import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

class LoginPageTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginPage.LOGIN_URL);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid_user_credentials.csv")
    public void successfulLogin(String name, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn(name, password);
        Assertions.assertTrue(loginPage.areWeLoggedIn());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalid_user_credentials.csv")
    public void unsuccessfulLogin(String name, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn(name, password);
        Assertions.assertTrue(loginPage.isErrorMsgPopUp());
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