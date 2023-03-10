package starter.Reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                    .pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
}
