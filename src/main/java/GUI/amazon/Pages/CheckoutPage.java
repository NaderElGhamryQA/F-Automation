package GUI.amazon.Pages;

import GUI.amazon.Base.PageBase;
import GUI.amazon.Locators.AmazonLocators;
import GUI.amazon.Utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    AmazonLocators locators = new AmazonLocators(getDriver());

    public CheckoutPage clickOnShipToOneAddress() {
        locators.shipToOneAddress().click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locators.getAddNewAddressLink()));
        return this;
    }

    public CheckoutPage addNewAddress() {
        getWait().until(ExpectedConditions.elementToBeClickable(locators.addNewAddress()));
        clickElementFallbackToJsClick(locators.addNewAddress());
        return this;
    }

    public CheckoutPage addFullNameTextField() {
        scrollAndEnterText(locators.fullNameTextField(), ConfigUtils.getInstance().getFullName());
        return this;
    }

    public CheckoutPage addMobileNumber() {
        scrollAndEnterText(locators.phoneNumberField(), ConfigUtils.getInstance().getMobileNumber());
        return this;
    }

    public CheckoutPage enterStreetName() {
        scrollAndEnterText(locators.streetNameTextField(), ConfigUtils.getInstance().getStreetName());
        return this;
    }

    public CheckoutPage enterBuildingName() {
        scrollAndEnterText(locators.buildingName(), ConfigUtils.getInstance().getBuildingNo());
        return this;
    }

    public CheckoutPage enterCity() {
        scrollAndEnterText(locators.cityArea(), ConfigUtils.getInstance().getCityName());
        return this;
    }

    public CheckoutPage enterDistrict() {
        scrollAndEnterText(locators.district(), ConfigUtils.getInstance().getDistrict());
        return this;
    }

    public CheckoutPage getNearestLandMark() {
        scrollAndEnterText(locators.nearestLandmark(), ConfigUtils.getInstance().getNearestLandmark());
        return this;
    }

    public CheckoutPage clickOnHomeRadioButton() {
        scrollAndClick(locators.addressTypeHome());
        return this;
    }

    public CheckoutPage clickOnAddAddressButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(locators.addAddressButton()));
        clickElementFallbackToJsClick(locators.addAddressButton());
        return this;
    }


}
