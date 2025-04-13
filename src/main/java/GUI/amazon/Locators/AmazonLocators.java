package GUI.amazon.Locators;

import GUI.amazon.Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonLocators extends PageBase {
    public AmazonLocators(WebDriver driver) {
        super(driver);
    }

    public WebElement getAmazonLogo() {
        return getDriver().findElement(By.id("nav-logo-sprites"));
    }

    public WebElement getAccountsAndListsTab() {
        return getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
    }

    public WebElement getPhoneNumberField() {
        return getDriver().findElement(By.xpath("//input[contains(@id, 'ap_email')]"));
    }

    public WebElement getContinueButton() {
        return getDriver().findElement(By.xpath("//span[contains(@id, 'continue')]"));
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(By.xpath("//input[@id='ap_password']"));
    }

    public WebElement clickOnSignInButton() {
        return getDriver().findElement(By.id("signInSubmit"));
    }

    public WebElement deliverTo() {
        return getDriver().findElement(By.id("glow-ingress-line1"));
    }

    public WebElement allMenu() {
        return getDriver().findElement(By.cssSelector("a#nav-hamburger-menu"));
    }

    public WebElement getSeeAll() {
        return getDriver().findElement(By.xpath("(//a[@class='hmenu-item hmenu-compressed-btn' and @aria-label='See All Categories'])[1]"));
    }

    public By seeAllCategoriesLocator = By.xpath("(//a[@class='hmenu-item hmenu-compressed-btn' and @aria-label='See All Categories'])[1]");

    public WebElement getVideoGamesTab() {
        return getDriver().findElement(By.xpath("//a[@class='hmenu-item' and @data-menu-id='16']/div[text()='Video Games']"));
    }

    public WebElement getAllVideoGames() {
        return getDriver().findElement(By.cssSelector("a.hmenu-item[href*=\"node=18022560031\"]"));
    }

    public WebElement navBarLabel() {
        return getDriver().findElement(By.xpath("//div[@class='nav-search-facade']//span[@id='nav-search-label-id']"));
    }

    public WebElement getFreeShippingCheckBox() {
        return getDriver().findElement(By.xpath("//span[text()='All customers get FREE Shipping on orders shipped by Amazon']"));
    }

    public WebElement getConditionNew() {
        return getDriver().findElement(By.xpath("//li[@id='p_n_condition-type/28071525031']//a"));
    }

    public WebElement sortDropDown() {
        return getDriver().findElement(By.xpath("//span[@id='a-autoid-0-announce']"));
    }

    public By sortOptionsLocator = By.xpath("//li[contains(@aria-labelledby, 's-result-sort-select')]/a");

    public List<WebElement> pricesList() {
        return getDriver().findElements(By.xpath(".//span[contains(@class, 'a-price')]/span[@class='a-offscreen']"));
    }

    public WebElement nextPageButton() {
        return getDriver().findElement(By.xpath("//a[contains(@class, 's-pagination-next')]"));
    }

    public WebElement productName() {
        return getDriver().findElement(By.xpath(".//h2[contains(@class, 'a-size-medium')]/span/text()"));
    }

    public WebElement productPrice() {
        return getDriver().findElement(By.xpath(".//span[contains(@class, 'a-price')]/span[@class='a-offscreen']/text()"));
    }

    public By getAddToCartButton(double maxPrice) {
        return By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < " + maxPrice + "] /ancestor::div[contains(@class,'puis-price-instructions-style')] /following-sibling::div[contains(@class,'top-mini')] //div[contains(@class,' aok-inline-block')]");
    }

    public By nextPageBtnLocator() {
        return By.cssSelector("a.s-pagination-next");
    }

    public WebElement cartIcon() {
        return getDriver().findElement(By.xpath("//span[@id='nav-cart-count' and contains(@class, 'nav-cart-count')]"));
    }

    public WebElement goToBasket() {
        return getDriver().findElement(By.xpath("//a[contains(@href, '/-/en/cart?ref_=ewc_gtc')]"));
    }

    public WebElement proceedToBuy() {
        return getDriver().findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
    }

    public WebElement addNewAddress() {
        return getDriver().findElement(By.xpath("//a[@class='a-size-base a-link-normal' and @href='#']"));
    }

    public By getAddNewAddressLink() {
        return By.xpath("//a[@class='a-size-base a-link-normal' and @href='#']");
    }

    public WebElement fullNameTextField() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']"));
    }

    public WebElement phoneNumberField() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']"));
    }

    public WebElement streetNameTextField() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']"));
    }

    public WebElement buildingName() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enter-building-name-or-number']"));
    }

    public WebElement cityArea() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']"));
    }

    public WebElement district() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']"));
    }

    public WebElement government() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressStateOrRegion']"));
    }

    public WebElement nearestLandmark() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-landmark']"));
    }

    public WebElement addressTypeHome() {
        return getDriver().findElement(By.xpath("//input[@id='address-ui-widgets-addr-details-res-radio-input']"));
    }

    public WebElement addAddressButton() {
        return getDriver().findElement(By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']"));
    }

    public WebElement shipToOneAddress() {
        return getDriver().findElement(By.xpath("//a[@data-pipeline-link-from-page='spp-itemselect']"));
    }

}
