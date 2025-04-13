package GUI.amazon.Pages;

import GUI.amazon.Base.PageBase;
import GUI.amazon.Locators.AmazonLocators;
import GUI.amazon.Utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

@Slf4j
public class HomePage extends PageBase {

    private final AmazonLocators locators;
    private int addedItemsCount;

    public HomePage(WebDriver driver) {
        super(driver);
        this.locators = new AmazonLocators(driver);
    }

    public HomePage verifyHomePageLogo() {
        String actualText = locators.getAmazonLogo().getText();
        String expectedText = ".eg";
        Assert.assertEquals(actualText, expectedText, "You are not in HomePage");
        return this;
    }

    public HomePage loadWebsite() {
        getDriver().get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    public LoginPage clickOnAccountsAndLists() {
        clickElementFallbackToJsClick(locators.getAccountsAndListsTab());
        return new LoginPage(getDriver());
    }

    public HomePage verifyHomePageAfterLogin() {
        String actualText = locators.deliverTo().getText();
        String expectedText = "Deliver to Nader";
        Assert.assertEquals(actualText, expectedText, "You are not logged in!!!");
        return this;
    }

    public HomePage clickOnAllMenu() {
        clickElementFallbackToJsClick(locators.allMenu());
        return this;
    }

    public HomePage clickOnSeeAll() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locators.seeAllCategoriesLocator));
        clickElementFallbackToJsClick(locators.getSeeAll());
        return this;
    }

    public HomePage clickOnVideoGamesTab() {
        clickElementFallbackToJsClick(locators.getVideoGamesTab());
        return this;
    }

    public HomePage clickOnAllVideoGames() {
        clickElementFallbackToJsClick(locators.getAllVideoGames());
        return this;
    }

    public HomePage clickOnFreeShippingCheckbox() {
        scrollIntoView(locators.getFreeShippingCheckBox());
        clickElementFallbackToJsClick(locators.getFreeShippingCheckBox());
        return this;
    }

    public HomePage clickOnNewCondition() {
        getWait().until(ExpectedConditions.visibilityOf(locators.getConditionNew()));
        scrollAndClick(locators.getConditionNew());
        return this;
    }

    public HomePage clickOnSortDropDown() {
        clickElementFallbackToJsClick(locators.sortDropDown());
        return this;
    }

    public HomePage selectPriceFromHighToLow(String optionText) {
        List<WebElement> options = getWait().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.sortOptionsLocator)
        );

        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(optionText)) {
                option.click();
                break;
            }
        }

        return this;
    }

    public HomePage addItemsToCart(int maxPrice) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locators.nextPageBtnLocator()));

        List<WebElement> validElements = getDriver().findElements(locators.getAddToCartButton(maxPrice));

        while (validElements.isEmpty() && isElementClickable(locators.nextPageButton())) {
            try {
                clickElementFallbackToJsClick(locators.nextPageButton());
                waitForElementToBeVisible(locators.getAddToCartButton(maxPrice));
                validElements = getDriver().findElements(locators.getAddToCartButton(maxPrice));
            } catch (NoSuchElementException e) {
                log.info("No next page button found or no more pages to navigate.");
                break;
            }
        }

        if (!validElements.isEmpty()) {
            for (WebElement element : validElements) {
                try {
                    clickElementFallbackToJsClick(element);
                    addedItemsCount++;
                    log.info("Item added to cart: {}", element.getText());
                } catch (Exception e) {
                    log.warn("Failed to click element: {}", e.getMessage());
                }
            }
            log.info("Total items added to cart: {}", addedItemsCount);
        } else {
            log.warn("No items to add to cart on this page.");
        }

        return this;
    }

    public HomePage verifyCartCount() {
        getDriver().navigate().refresh();
        String cartCountText = locators.cartIcon().getText();
        log.info("Cart count string: {}", cartCountText);

        int cartCount = Integer.parseInt(cartCountText);
        log.info("Cart count as int: {}", cartCount);

        if (addedItemsCount == cartCount) {
            log.info("Cart count matches the added items count.");
        } else {
            log.warn("Cart count mismatch. Expected: {}, Found: {}", addedItemsCount, cartCount);
        }

        return this;
    }

    public HomePage verifyNavBarLabel(String navText) {
        String navBarText = locators.navBarLabel().getText();
        Assert.assertEquals(navBarText, navText, "Label is not video games");
        return this;
    }

    public ShoppingCart clickOnGoToBasket() {
        getWait().until(ExpectedConditions.visibilityOf(locators.goToBasket()));
        scrollAndClick(locators.goToBasket());
        return new ShoppingCart(getDriver());
    }
}
