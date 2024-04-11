import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public final static String LOGIN_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    private WebElement swagLabsLogo;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement loginErrorMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    private WebElement loginLogo;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logIn(String userName, String password) {
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean areWeLoggedIn() {
        return swagLabsLogo.isDisplayed();
    }

    public boolean isErrorMsgPopUp() {
        return loginErrorMsg.getText().contains("sadface");
    }
    public boolean isLoginLogoAppear(){
        return loginLogo.isDisplayed();
    }
}
