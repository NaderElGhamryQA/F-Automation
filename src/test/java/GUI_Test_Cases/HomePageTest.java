package GUI_Test_Cases;

import GUI.amazon.Base.PageBase;
import GUI.amazon.Base.TestBase;
import GUI.amazon.Pages.HomePage;
import org.testng.annotations.Test;

import static GUI.amazon.Base.PageBase.getDriver;

public class HomePageTest extends TestBase {


    @Test
    public void verifyLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loadWebsite().
                verifyHomePageLogo().
                clickOnAccountsAndLists();
    }

    @Test
    public void selectPricesLessThan15K(){
        HomePage homePage = new HomePage(getDriver());
        homePage.
                loadWebsite().
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
                addItemsToCart(15000);
    }
    @Test
    public void verifySelectedItemsInCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.
                loadWebsite().
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
                verifyCartCount();

    }
}
