package enums;

import org.openqa.selenium.By;

public enum ProductSortOption {
    NAME_A_TO_Z(By.xpath("//option[@value='az']")),
    NAME_Z_TO_A(By.xpath("//option[@value='za']")),
    PRICE_LOW_TO_HIGH(By.xpath("//option[@value='lohi']")),
    PRICE_HIGH_TO_LOW(By.xpath("//option[@value='hilo']"));

    private final By locator;

    ProductSortOption(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
