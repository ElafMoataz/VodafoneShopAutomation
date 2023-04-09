package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    @FindBy(className = "lang")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//a[@href='/shop/shopByBrand/Apple']/div")
    private WebElement shopByBrandAppleButton;
    @FindBy(xpath = "//ul[@class='brandContainer-brands-list utag--brands']")
    private WebElement shopByBrandSection;
    private int waitIntervalInSecs = 5;
    public void changeLanguageToEnglish(){
        changeLanguageButton.click();
    }
    public void navigateToAppleBrandProducts() {
        waitElement(shopByBrandSection, waitIntervalInSecs);
        scrollElementIntoView(shopByBrandSection);
        shopByBrandAppleButton.click();
    }
}
