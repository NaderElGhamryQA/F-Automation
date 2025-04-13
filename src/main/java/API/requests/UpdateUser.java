package API.requests;

import API.HelperClasses.API_Endpoints;
import API.HelperClasses.APIPropertiesReader;
import API.requestModels.UpdateUser_RequestMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateUser {
    public static Response updateUser(String id, String name, String job) {
        UpdateUser_RequestMapper updateUserReqModel = new UpdateUser_RequestMapper();
        updateUserReqModel.setName(name);
        updateUserReqModel.setJob(job);
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(updateUserReqModel)
                .put(APIPropertiesReader.getValue("APIBaseUrl") + API_Endpoints.updateUserEndpoint.replace("id", id));
    }
}
