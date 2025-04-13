package API_Test_Cases.api;

import API.requests.CreateUser;
import API.responseModels.CreateUser_ResponseMapper;
import GUI.amazon.Utils.ConfigUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class CreateUserTest {
    @Test(priority = 1)
    public void createUserPos() {
        SoftAssert softAssert = new SoftAssert();
        final String userName = ConfigUtils.getInstance().getApiName();
        final String job = ConfigUtils.getInstance().getJob();

        log.info("Starting the test to create a new user with name: {}, role: {}", userName, job);

        Response createUserResponseObj = CreateUser.createUser(userName, job);
        CreateUser_ResponseMapper createSingleUserModel = createUserResponseObj.as(CreateUser_ResponseMapper.class);

        log.info("Received response for user creation:");
        log.info("User ID: {}", createSingleUserModel.getId());
        log.info("User Name: {}", createSingleUserModel.getName());
        log.info("User Job: {}", createSingleUserModel.getJob());
        log.info("Account Creation Date: {}", createSingleUserModel.getCreatedAt());

        softAssert.assertEquals(createUserResponseObj.getStatusCode(), 201, "Request Failed");
        softAssert.assertEquals(createSingleUserModel.getName(), "morpheus");
        softAssert.assertEquals(createSingleUserModel.getJob(), "leader");
        softAssert.assertNotNull(createSingleUserModel.getId());
        softAssert.assertNotNull(createSingleUserModel.getCreatedAt());
        softAssert.assertAll();

        log.info("Test completed successfully without issues.");
    }

    @Test(priority = 2)
    public void createUserInvalidUserName() {
        SoftAssert softAssert = new SoftAssert();
        final String job = "leader";

        try {
            log.warn("Starting test with an empty username and job: {}", job);
            Response createUserResponseObj = CreateUser.createUser("", job);
            CreateUser_ResponseMapper createSingleUserModel = createUserResponseObj.as(CreateUser_ResponseMapper.class);

            log.warn("Response from user creation attempt with invalid username:");
            log.warn("User ID: {}", createSingleUserModel.getId());
            log.warn("User Name: {}", createSingleUserModel.getName());
            log.warn("User Job: {}", createSingleUserModel.getJob());
            log.warn("Account Creation Date: {}", createSingleUserModel.getCreatedAt());

            softAssert.assertEquals(createSingleUserModel.getName(), "");
            softAssert.assertEquals(createSingleUserModel.getJob(), "leader");
            softAssert.assertNotNull(createSingleUserModel.getId());
            softAssert.assertNotNull(createSingleUserModel.getCreatedAt());
            softAssert.assertAll();

        } catch (Exception e) {
            log.error("User creation failed due to error: {}", e.getMessage(), e);
        }

        log.warn("Test for invalid username finished with warnings.");
    }
}
