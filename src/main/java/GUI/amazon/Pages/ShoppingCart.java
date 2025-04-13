package GUI.amazon.Pages;

import GUI.amazon.Base.PageBase;
import GUI.amazon.Locators.AmazonLocators;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends PageBase {

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    AmazonLocators locators = new AmazonLocators(getDriver());

    public CheckoutPage clickOnProceedToBuy() {
        clickElementFallbackToJsClick(locators.proceedToBuy());
        return new CheckoutPage(getDriver());
    }
}
