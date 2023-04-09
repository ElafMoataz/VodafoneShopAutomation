package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    @FindBy(xpath = "//ul[@class='shopingCartContainer-shopingCartItem-list devicesRow']")
    private List<WebElement> shoppingBasketItems;
    @FindBy(xpath = "//button[contains(.,'Proceed to Checkout ')]")
    private WebElement proceedToCheckoutButton;

    public int getBasketItemsCount(){
        return (shoppingBasketItems.size());
    }
    public void proceedToCheckout(){
        scrollElementIntoView(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
