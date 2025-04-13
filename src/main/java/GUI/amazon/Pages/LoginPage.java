package GUI.amazon.Pages;

import GUI.amazon.Base.PageBase;
import GUI.amazon.Locators.AmazonLocators;
import GUI.amazon.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    AmazonLocators locators = new AmazonLocators(getDriver());

    public LoginPage enterMobileNumber() {
        getWait().until(ExpectedConditions.visibilityOf(locators.getPhoneNumberField()));
        clickElementFallbackToJsClick(locators.getPhoneNumberField());
        locators.getPhoneNumberField().sendKeys(ConfigUtils.getInstance().getMobileNumber());
        clickElementFallbackToJsClick(locators.getContinueButton());
        return this;
    }

    public HomePage enterPassword() {
        clickElementFallbackToJsClick(locators.getPasswordField());
        locators.getPasswordField().sendKeys(ConfigUtils.getInstance().getPassword());
        clickElementFallbackToJsClick(locators.clickOnSignInButton());
        return new HomePage(getDriver());
    }
}


