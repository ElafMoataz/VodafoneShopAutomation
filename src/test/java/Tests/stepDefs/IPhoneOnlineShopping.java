package Tests.stepDefs;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class IPhoneOnlineShopping extends BaseTest{
    HomePage homePage = new HomePage(browser);
    AppleProductsPage appleProductsPage = new AppleProductsPage(browser);
    ProductPage productPage = new ProductPage(browser);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(browser);
    CheckOutPage checkoutPage = new CheckOutPage(browser);
    @Given("Navigates successfully to VfShop homepage")
    public void navigateSuccessfullyToVfShop() {
        BaseTest.loadVodafoneShopWebsite();
        Assert.assertTrue(browser.getCurrentUrl().contains("https://eshop.vodafone.com.eg/shop/"));
    }
    @When("User changes language to english")
    public void changeLanguageToEnglish() {
        homePage.changeLanguageToEnglish();
    }

    @When("User selects Apple products from shop by brand section")
    public void selectAppleProductsFromShopByBrandSection() {
        homePage.navigateToAppleBrandProducts();
    }

    @When("User selects any iPhone product from the shop")
    public void selectIphoneProductFromTheShop() {
        appleProductsPage.selectIphone13ProMaxProduct();
    }

    @When("User clicks on add to card")
    public void clickOnAddToCard() {
        productPage.addToBasket();
    }

    @When("User presses proceed to checkout")
    public void proceedToCheckout() {
        shoppingCartPage.proceedToCheckout();
    }

    @When("User enters delivery options as {string}, {string}")
    public void enterDeliveryOptionsAs(String cityName, String districtName) {
        checkoutPage.selectDeliveryCity(cityName);
        checkoutPage.selectDeliveryDistrict(districtName);
    }

    @When("User selects {string} at {string} street, Building {string}, floor {string}, apartment {string}")
    public void selectPickupOptionWithStreetBuildingFloorApartment(String pickupOption, String street, String building, String floor, String apartment) {
        checkoutPage.selectDeliveryOption(pickupOption);
        checkoutPage.submitDeliveryAddress(street, building, floor, apartment);
    }

    @When("User submits personal info tab empty")
    public void submitPersonalInfoTabEmpty() {
        checkoutPage.submitPersonalInfo("", "", "");
    }

    @Then("User should see an error message for {string} field")
    public void checkErrorMessageForTextField(String errorField) {
        switch (errorField.toLowerCase()){
            case "full name":
                Assert.assertEquals(checkoutPage.getNameFieldErrorMsg(), "Please enter a valid name");
                break;
            case "email":
                Assert.assertEquals(checkoutPage.getEmailFieldErrorMsg(), "Please enter a valid email address");
                break;
            case "mobile number":
                Assert.assertEquals(checkoutPage.getNumberFieldErrorMsg(), "Please enter a valid Mobile Number e.g. 01*********");
                break;
        }
    }
}
