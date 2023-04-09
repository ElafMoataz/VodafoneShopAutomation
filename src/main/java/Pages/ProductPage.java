package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    private static final int waitInterval = 10;
    @FindBy(xpath = "//button[@class='btn btn-red btn-block fontLightEnAr']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"menu\"]/div")
    private WebElement priceTag;

    public void addToBasket(){
        waitElement(priceTag, waitInterval);
        addToCartButton.click();
    }
}
