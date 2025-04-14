package API.requests;


import API.Utils.APIPropertiesReader;
import API.requestPojoModels.CreateUser_RequestPojoMapper;

import GUI.amazon.Utils.ConfigUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUser {

    public static Response createUser() {
        CreateUser_RequestPojoMapper createUserReqModel = new CreateUser_RequestPojoMapper(ConfigUtils.getInstance().getApiName(),
                ConfigUtils.getInstance().getJob());
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(createUserReqModel)
                .post(APIPropertiesReader.getValue("APIBaseUrl") +
                        ConfigUtils.getInstance().getCreateUserEndpoint());
    }
}
