import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "checkout_complete_container")
    private WebElement checkoutMessage;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")
    private WebElement informationErrorMessage;

    private void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    private void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    private void fillPostalCode(int postalCode) {
        postalCodeInput.sendKeys(String.valueOf(postalCode));
    }

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void fillInDataForCheckout(String firstName, String lastName, int postalCode) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillPostalCode(postalCode);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public boolean isCheckoutMessageDisplayed() {
        return checkoutMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return informationErrorMessage.getText().contains("Error");
    }
}
