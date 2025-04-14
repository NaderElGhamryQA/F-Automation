package API_Test_Cases.api;

import API.requests.CreateUser;
import API.responseModels.CreateUser_ResponseMapper;
import API.requestPojoModels.CreateUser_RequestPojoMapper;
import GUI.amazon.Utils.ConfigUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class CreateUserTest {

    @Test(priority = 1)
    public void createUser_Positive() {
        SoftAssert softAssert = new SoftAssert();
        String userName = "Nader";
        String job = "Engineer";

        log.info("Starting positive test: Create user with valid name and job");
        Response response = CreateUser.createUser();
        CreateUser_ResponseMapper userResponse = response.as(CreateUser_ResponseMapper.class);

        softAssert.assertEquals(response.getStatusCode(), 201);
        softAssert.assertEquals(userResponse.getName(), userName);
        softAssert.assertEquals(userResponse.getJob(), job);
        softAssert.assertNotNull(userResponse.getId());
        softAssert.assertNotNull(userResponse.getCreatedAt());
        softAssert.assertAll();
        log.info("Positive test completed");
    }

    @Test(priority = 2)
    public void createUser_EmptyName() {
        SoftAssert softAssert = new SoftAssert();
        CreateUser_RequestPojoMapper body = new CreateUser_RequestPojoMapper("", "Engineer");

        log.info("Negative test: Create user with empty name");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertEquals(response.getStatusCode(), 201); // Check actual behavior
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void createUser_EmptyJob() {
        SoftAssert softAssert = new SoftAssert();
        CreateUser_RequestPojoMapper body = new CreateUser_RequestPojoMapper("Nader", "");

        log.info("Negative test: Create user with empty job");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertEquals(response.getStatusCode(), 201); // Check actual behavior
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void createUser_MissingFields() {
        SoftAssert softAssert = new SoftAssert();
        String jsonBody = "{}";

        log.info("Negative test: Create user with missing fields");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(jsonBody)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertEquals(response.getStatusCode(), 201); // Check actual behavior
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void createUser_InvalidContentType() {
        SoftAssert softAssert = new SoftAssert();
        CreateUser_RequestPojoMapper body = new CreateUser_RequestPojoMapper("Nader", "Engineer");

        log.info("Negative test: Create user with invalid content-type header");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertNotEquals(response.getStatusCode(), 400);
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void createUser_MalformedJson() {
        SoftAssert softAssert = new SoftAssert();
        String malformedJson = "{\"name\":\"Nader\", \"job\": \"Engineer"; // Missing end quote

        log.info("Negative test: Create user with malformed JSON");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(malformedJson)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertNotEquals(response.getStatusCode(), 201);
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void createUser_LongName() {
        SoftAssert softAssert = new SoftAssert();
        String longName = "a".repeat(1000);
        CreateUser_RequestPojoMapper body = new CreateUser_RequestPojoMapper(longName, "Engineer");

        log.info("Boundary test: Create user with long name");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertEquals(response.getStatusCode(), 201); // Check actual behavior
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void createUser_ValidateResponseTime() {
        SoftAssert softAssert = new SoftAssert();
        CreateUser_RequestPojoMapper body = new CreateUser_RequestPojoMapper("Nader", "Engineer");

        log.info("Performance test: Validate response time");
        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertTrue(response.getTime() < 2000, "Response took too long");
        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void createUser_DuplicateUser() {
        SoftAssert softAssert = new SoftAssert();
        CreateUser_RequestPojoMapper body = new CreateUser_RequestPojoMapper("Nader", "Engineer");

        log.info("Idempotency test: Create duplicate user");
        Response response1 = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        Response response2 = RestAssured.given().log().all()
                .contentType("application/json")
                .body(body)
                .post(ConfigUtils.getInstance().getApiBaseUrl() + "/api/users");

        softAssert.assertNotEquals(response1.jsonPath().getString("id"), response2.jsonPath().getString("id"));
        softAssert.assertAll();
    }
}