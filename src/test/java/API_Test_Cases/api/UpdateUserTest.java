package API_Test_Cases.api;

import API.requests.UpdateUser;
import API.responseModels.UpdateUser_ResponseMapper;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class UpdateUserTest {

    @Test(priority = 3)
    public void updateUserTest() {
        SoftAssert softAssert = new SoftAssert();

        log.info("Initiating the test to update user with ID: {}", 2);

        Response updateUserResponse = UpdateUser.updateUser("2", "morpheus_updated", "Manager");
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
}
