package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AppleProductsPage extends BasePage{
    public AppleProductsPage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    @FindBy(id = "home-0")
    private WebElement productsList;
    @FindBy(xpath = "//button[contains(.,'Show more')]")
    private WebElement showMoreButton;
    @FindBy(xpath = "//*[@id=\"home-0\"]//span[contains(.,'iPhone 13 Pro Max')]")
    private WebElement iPhone13ProMax;
    private By iPhone13ProMaxDevices = By.xpath("//*[@id=\"home-0\"]//span[contains(.,'iPhone 13 Pro Max')]");
    private int waitIntervalInSecs = 15;

    public void selectIphone13ProMaxProduct(){
        waitElement(productsList,waitIntervalInSecs);
        List<WebElement> elements = browser.findElements(iPhone13ProMaxDevices);
        while (elements.size() == 0) {
            scrollElementIntoView(showMoreButton);
            showMoreButton.click();
            elements = browser.findElements(iPhone13ProMaxDevices);
        }
        if (iPhone13ProMax.isDisplayed() && iPhone13ProMax.isEnabled()) {
            iPhone13ProMax.click();
        }
    }
}
