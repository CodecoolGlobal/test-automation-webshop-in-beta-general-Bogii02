import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public final static String LOGIN_URL = "https://www.saucedemo.com/";

    @FindBy(css = "input[id='user-name']")
    private WebElement usernameField;

    @FindBy(css = "input[id='password']")
    private WebElement passwordField;

    @FindBy(css = "input[id='login-button']")
    private WebElement loginButton;

    @FindBy(css = "div[class='app_logo']")
    private WebElement swagLabsLogo;

    @FindBy(css = "h3[data-test='error']")
    private WebElement loginErrorMsg;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logIn(String userName, String password){
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean areWeLoggedIn(){
       return swagLabsLogo.isDisplayed();
    }

    public boolean isErrorMsgPopUp(){
        return loginErrorMsg.isDisplayed();
    }


}
