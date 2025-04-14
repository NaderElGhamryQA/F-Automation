package API_Test_Cases.api;

import API.requests.UpdateUser;
import API.responseModels.UpdateUser_ResponseMapper;
import GUI.amazon.Utils.ConfigUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class UpdateUserTest {

    @Test(priority = 16)
    public void updateUserTest() {
        SoftAssert softAssert = new SoftAssert();

        log.info("Initiating the test to update user with ID: {}", ConfigUtils.getInstance().getID());

        Response updateUserResponse = UpdateUser.updateUser(ConfigUtils.getInstance().getID());
        UpdateUser_ResponseMapper updateUserResModel = updateUserResponse.as(UpdateUser_ResponseMapper.class);

        log.info("Response for user update: ");
        log.info("Last Updated: {}", updateUserResModel.getUpdatedAt());
        log.info("Updated Name: {}", updateUserResModel.getName());
        log.info("Updated Job: {}", updateUserResModel.getJob());

        softAssert.assertEquals(updateUserResponse.getStatusCode(), 200, "The update request failed with status code: ");
        softAssert.assertNotNull(updateUserResModel.getName(), "Failed: The updated name is missing.");
        softAssert.assertNotNull(updateUserResModel.getJob(), "Failed: The updated job is missing.");
        softAssert.assertNotNull(updateUserResModel.getUpdatedAt(), "Failed: The updated date is missing!");

        log.info("Assertions completed successfully, the test is finishing.");


        softAssert.assertAll();
    }

    @Test(priority = 17)
    public void updateUserWithInvalidIdTest() {
        SoftAssert softAssert = new SoftAssert();
        String invalidId = "99qoeuqwe99n9";

        log.info("Initiating test to update user with invalid ID: {}", invalidId);

        Response response = UpdateUser.updateUser(invalidId);
        log.info("Response for user update with invalid ID: {}", response.getBody().asString());

        softAssert.assertEquals(response.getStatusCode(), 404, "The update request should fail with status 404 for invalid user ID.");
        softAssert.assertTrue(response.getBody().asString().contains("not found"), "Expected 'not found' message in the response.");

        softAssert.assertAll();
    }
}
