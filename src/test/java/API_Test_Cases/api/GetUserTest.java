package API_Test_Cases.api;

import API.requests.GetUser;
import API.responseModels.getUser_ResponseMapper.GetUser_ResModel;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class GetUserTest {

    @Test(priority = 2)
    public void getUserTest() {
        SoftAssert softAssert = new SoftAssert();

        log.info("Initiating the test to retrieve user with ID: {}", 2);


        Response getUserResponseObj = GetUser.getUser("2");
        GetUser_ResModel getUserResModel = getUserResponseObj.as(GetUser_ResModel.class);


        log.info("Response details for the requested user: ");
        log.info("User ID: {}", getUserResModel.getData().getId());
        log.info("First Name: {}", getUserResModel.getData().getFirstName());
        log.info("Last Name: {}", getUserResModel.getData().getLastName());
        log.info("Email Address: {}", getUserResModel.getData().getEmail());
        log.info("User Avatar: {}", getUserResModel.getData().getAvatar());
        log.info("Support Information: {}", getUserResModel.getSupport().getText());
        log.info("Support URL: {}", getUserResModel.getSupport().getUrl());


        softAssert.assertEquals(getUserResponseObj.getStatusCode(), 200, "The response code is not as expected.");
        softAssert.assertNotNull(getUserResModel.getData().getId(), "User ID is missing.");
        softAssert.assertNotNull(getUserResModel.getData().getFirstName(), "First Name is missing.");
        softAssert.assertNotNull(getUserResModel.getData().getLastName(), "Last Name is missing.");
        softAssert.assertNotNull(getUserResModel.getData().getEmail(), "Email is missing.");
        softAssert.assertNotNull(getUserResModel.getData().getAvatar(), "Avatar is missing.");
        softAssert.assertNotNull(getUserResModel.getSupport().getText(), "Support Text is missing.");
        softAssert.assertNotNull(getUserResModel.getSupport().getUrl(), "Support URL is missing.");


        log.info("Assertions completed successfully, the test is finishing.");


        softAssert.assertAll();
    }
}
