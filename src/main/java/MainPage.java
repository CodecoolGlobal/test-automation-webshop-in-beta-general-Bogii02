import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(css = "button[id='react-burger-menu-btn']")
    private WebElement menu;

    @FindBy(css = "a[id^='logout']")
    private WebElement logoutButton;

    @FindBy(css = "a[id^='logout']")
    private WebElement allItemsButton;

    @FindBy(css = "button[id='react-burger-cross-btn']")
    private WebElement menuCloseButton;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> products;

    @FindBy(css = "a[id='item_4_title_link'] div[data-test='inventory-item-name']")
    private WebElement itemName;

    @FindBy(css = "button[id='back-to-products']")
    private WebElement backProductsButton;

    @FindBy(css = "a[data-test='shopping-cart-link']")
    private WebElement shoppingCartButton;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int addAllElementToCart() {
        for (WebElement element : products) {
            element.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).click();
        }
        return products.size();
    }

    public void addOneElementToCart() {
        WebElement element = products.get(0);
        element.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).click();
    }

    public void navigateToCart() {
        shoppingCartButton.click();
    }
}
