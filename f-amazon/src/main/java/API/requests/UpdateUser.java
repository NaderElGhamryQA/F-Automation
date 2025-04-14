package API.requests;

import API.Utils.APIPropertiesReader;
import API.requestPojoModels.UpdateUser_RequestPojoMapper;
import GUI.amazon.Utils.ConfigUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateUser {
    public static Response updateUser(String id) {
        UpdateUser_RequestPojoMapper updateUserReqModel = new UpdateUser_RequestPojoMapper(ConfigUtils.getInstance().getApiName(), ConfigUtils.getInstance().getJob());
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(updateUserReqModel)
                .put(APIPropertiesReader.getValue("APIBaseUrl") +
                        ConfigUtils.getInstance().getUpdateUserEndpoint().replace("id", id));
    }
}
