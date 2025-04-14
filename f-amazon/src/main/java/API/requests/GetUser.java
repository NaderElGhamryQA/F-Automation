package API.requests;

import API.Utils.APIPropertiesReader;
import GUI.amazon.Utils.ConfigUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUser {

    public static Response getUser(String id) {
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .get(APIPropertiesReader.getValue("APIBaseUrl") +
                        ConfigUtils.getInstance().getUserEndPoint().replace("id", id));

    }
}
