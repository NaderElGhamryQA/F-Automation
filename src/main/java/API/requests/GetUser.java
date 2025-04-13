package API.requests;

import API.HelperClasses.API_Endpoints;
import API.HelperClasses.APIPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUser {

    public static Response getUser(String id) {
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .get(APIPropertiesReader.getValue("APIBaseUrl") + API_Endpoints.getUserEndpoint.replace("id", id));

    }
}
