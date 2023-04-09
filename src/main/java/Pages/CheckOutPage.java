package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    @FindBy(xpath = "//div[@class='col-md-4 col-sm-12 checkout-dropdownCity checkoutDeleiveryOptionsPhase2EditWidth']/select")
    private WebElement cityDropDown;
    @FindBy(xpath = "//div[@class='col-md-4 col-sm-12 checkoutDeleiveryOptionsPhase2EditWidth']/select")
    private WebElement districtDropDown;
    @FindBy(xpath = "//div[@class='checkout-DelivaryOptionsInfo checkout-DelivaryToAddress open firstOpen']")
    private WebElement deliverToMyAddressButton;
    @FindBy(xpath = "//div[@class='checkout-DelivaryOptionsInfo checkout-DelivaryFromStore storesInfo']")
    private WebElement pickUpFromStoreButton;
    @FindBy(xpath = "//div[@class='addressName']//input")
    private WebElement streetNameInput;
    @FindBy(xpath = "//div[@class='addressDetails'][1]//input")
    private WebElement buildingNumInput;
    @FindBy(xpath = "//div[@class='addressDetails'][2]//input")
    private WebElement floorNumInput;
    @FindBy(xpath = "//div[@class='addressDetails'][3]//input")
    private WebElement apartmentNumInput;
    @FindBy(xpath = "//button[@class='btn checkout-btn btn-red delievry--btn--checkout']")
    private WebElement submitDeliveryInfoButton;
    @FindBy(xpath = "//input[@placeholder='Full Name']")
    private WebElement fullNameInput;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@formcontrolname='phoneNum']")
    private WebElement mobileNumInput;
    @FindBy(id = "shippingAddressContinue")
    private WebElement submitPersonalInfoButton;
    private int waitIntervalInSecs = 3;
    @FindBy(xpath = "//div[@class='help-block alertComp']/div")
    private List<WebElement> infoErrorMsgs;
    public void selectDeliveryCity(String cityName){
        waitElement(cityDropDown,waitIntervalInSecs);
        scrollElementIntoView(cityDropDown);
        Select drpCountry = new Select(cityDropDown);
        drpCountry.selectByVisibleText(cityName);
    }
    public void selectDeliveryDistrict(String districtName){
        waitElement(districtDropDown,waitIntervalInSecs);
        scrollElementIntoView(districtDropDown);
        Select drpCountry = new Select(districtDropDown);
        drpCountry.selectByVisibleText(districtName);
    }
    public void selectDeliveryOption(String deliveryOption){
        switch(deliveryOption){
            case "Deliver to My Address":
                deliverToMyAddressButton.click();
                break;
            case "Store":
                pickUpFromStoreButton.click();
                break;
        }
    }
    public void submitDeliveryAddress(String streetName, String buildingNum, String floorNum, String appartmentNum){
        streetNameInput.clear();
        buildingNumInput.clear();
        floorNumInput.clear();
        apartmentNumInput.clear();
        streetNameInput.sendKeys(streetName);
        buildingNumInput.sendKeys(buildingNum);
        floorNumInput.sendKeys(floorNum);
        apartmentNumInput.sendKeys(appartmentNum);
        scrollElementIntoView(submitDeliveryInfoButton);
        submitDeliveryInfoButton.click();
    }
    public void submitPersonalInfo(String fullName, String email, String mobileNum){
        fullNameInput.clear();
        emailInput.clear();
        mobileNumInput.clear();
        fullNameInput.sendKeys(fullName);
        emailInput.sendKeys(email);
        mobileNumInput.sendKeys(mobileNum);
        scrollElementIntoView(submitPersonalInfoButton);
        submitPersonalInfoButton.click();
    }
    public String getNameFieldErrorMsg(){
        waitElement(infoErrorMsgs.get(0),waitIntervalInSecs);
        return infoErrorMsgs.get(0).getText();
    }
    public String getEmailFieldErrorMsg(){
        waitElement(infoErrorMsgs.get(2),waitIntervalInSecs);
        return infoErrorMsgs.get(2).getText();
    }
    public String getNumberFieldErrorMsg(){
        waitElement(infoErrorMsgs.get(1),waitIntervalInSecs);
        return infoErrorMsgs.get(1).getText();
    }
}
