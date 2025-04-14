package GUI_Test_Cases;

import GUI.amazon.Base.TestBase;
import GUI.amazon.Pages.HomePage;
import org.testng.annotations.Test;

import static GUI.amazon.Base.PageBase.getDriver;

public class LoginTest extends TestBase {


    @Test
    public void loginToWebSite() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .loadWebsite().
                verifyHomePageLogo().
                clickOnAccountsAndLists().
                enterMobileNumber().
                enterPassword().
                verifyHomePageAfterLogin();
    }
}