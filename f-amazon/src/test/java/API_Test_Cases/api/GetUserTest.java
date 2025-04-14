package API_Test_Cases.api;

import API.requests.GetUser;
import API.responseModels.getUser_ResponseMapper.GetUser_ResModel;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class GetUserTest {

    @Test(priority = 10)
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

    @Test(priority = 11)
    public void getUserInvalidIdTest() {
        SoftAssert softAssert = new SoftAssert();
        final String invalidUserId = "99asdfdsaf99";

        log.info("Starting negative test: trying to retrieve user with invalid ID: {}", invalidUserId);

        Response response = GetUser.getUser(invalidUserId);

        log.info("Response status code: {}", response.getStatusCode());
        log.info("Response body: {}", response.getBody().asPrettyString());


        softAssert.assertEquals(response.getStatusCode(), 404, "Expected status code 404 for invalid user ID.");
        softAssert.assertEquals(response.getBody().asString(), "{}", "Expected empty response body for invalid user.");

        log.info("Negative test with invalid user ID completed.");
        softAssert.assertAll();
    }

    @Test(priority = 12)
    public void getUserWithEmptyIdTest() {
        SoftAssert softAssert = new SoftAssert();
        final String emptyId = "";

        log.info("Starting  test with empty user ID");

        Response response = GetUser.getUser(emptyId);

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asPrettyString());

        softAssert.assertEquals(response.getStatusCode(), 200, "Expected 200 when ID is empty.");
        softAssert.assertTrue(!response.getBody().asString().isEmpty(), "Expected full response body.");
        softAssert.assertAll();
    }

    @Test(priority = 13)
    public void getUserWithNonNumericIdTest() {
        SoftAssert softAssert = new SoftAssert();
        final String nonNumericId = "abc";

        log.info("Starting negative test with non-numeric user ID: {}", nonNumericId);

        Response response = GetUser.getUser(nonNumericId);

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asPrettyString());

        softAssert.assertEquals(response.getStatusCode(), 404, "Expected 404 for non-numeric user ID.");
        softAssert.assertEquals(response.getBody().asString(), "{}", "Expected empty response.");
        softAssert.assertAll();
    }

    @Test(priority = 14)
    public void getUserWithNegativeIdTest() {
        SoftAssert softAssert = new SoftAssert();
        final String negativeId = "-1";

        log.info("Starting negative test with negative user ID: {}", negativeId);

        Response response = GetUser.getUser(negativeId);

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asPrettyString());

        softAssert.assertEquals(response.getStatusCode(), 404, "Expected 404 for negative ID.");
        softAssert.assertEquals(response.getBody().asString(), "{}", "Expected empty response.");
        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void getUserWithSpecialCharIdTest() {
        SoftAssert softAssert = new SoftAssert();
        final String specialCharId = "@!#";

        log.info("Starting negative test with special character ID: {}", specialCharId);

        Response response = GetUser.getUser(specialCharId);

        log.info("Response Code: {}", response.getStatusCode());
        log.info("Response Body: {}", response.getBody().asPrettyString());

        softAssert.assertEquals(response.getStatusCode(), 404, "Expected 404 for special character ID.");
        softAssert.assertEquals(response.getBody().asString(), "{}", "Expected empty response.");
        softAssert.assertAll();
    }
}
