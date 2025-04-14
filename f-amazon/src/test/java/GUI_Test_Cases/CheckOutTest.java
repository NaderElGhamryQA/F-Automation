package GUI_Test_Cases;

import GUI.amazon.Base.TestBase;
import GUI.amazon.Pages.HomePage;
import org.testng.annotations.Test;

import static GUI.amazon.Base.PageBase.getDriver;

public class CheckOutTest extends TestBase {

    @Test
    public void validateAddress() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loadWebsite().
                verifyHomePageLogo().
                clickOnAccountsAndLists().
                enterMobileNumber().
                enterPassword().
                verifyHomePageAfterLogin().
                clickOnAllMenu().
                clickOnSeeAll().
                clickOnVideoGamesTab().
                clickOnAllVideoGames().
                clickOnFreeShippingCheckbox().
                clickOnNewCondition().
                clickOnSortDropDown().
                selectPriceFromHighToLow("Price: High to Low").
                addItemsToCart(15000).
                verifyCartCount().
                clickOnGoToBasket().
                clickOnProceedToBuy().
                clickOnShipToOneAddress().
                addNewAddress().
                addFullNameTextField().
                addMobileNumber().
                enterStreetName().
                enterBuildingName().
                enterCity().
                enterDistrict().
                getNearestLandMark().
                clickOnHomeRadioButton().
                clickOnAddAddressButton();
    }
}
