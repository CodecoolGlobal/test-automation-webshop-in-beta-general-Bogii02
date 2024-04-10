import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='cart_list']/div[@class='cart_item']")
    private List<WebElement> itemsInCart;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean verifyItemsAdded(int amountOfItemsAdded) {
        return amountOfItemsAdded == itemsInCart.size();
    }
}
