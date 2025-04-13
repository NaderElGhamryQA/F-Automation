package API.requests;


import API.HelperClasses.API_Endpoints;
import API.HelperClasses.APIPropertiesReader;
import API.requestModels.CreateUser_RequestMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUser {

    public static Response createUser(String name, String job) {
        CreateUser_RequestMapper createUserReqModel = new CreateUser_RequestMapper();
        createUserReqModel.setName(name);
        createUserReqModel.setJob(job);
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(createUserReqModel)
                .post(APIPropertiesReader.getValue("APIBaseUrl") + API_Endpoints.createUserEndpoint);
    }
}
