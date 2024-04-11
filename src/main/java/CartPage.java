import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='cart_list']/div[@class='cart_item']")
    private List<WebElement> itemsInCart;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean verifyItemsAdded(int amountOfItemsAdded) {
        return amountOfItemsAdded == itemsInCart.size();
    }

    public void removeAllItems() {
        for (WebElement item : itemsInCart) {
            item.findElement(By.xpath(".//*[starts-with(@id, 'remove-')]")).click();
        }
    }

    public boolean verifyCartIsEmpty() {
        return itemsInCart.isEmpty();
    }
  
    public void clickOnCheckout() {
        checkoutButton.click();
    }
}
