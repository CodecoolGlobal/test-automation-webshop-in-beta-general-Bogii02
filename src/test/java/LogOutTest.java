import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogOutTest {

    private WebDriver webDriver;
    private LoginPage loginPage;


    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions().addArguments("--headless");
        webDriver = new ChromeDriver(options);
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
