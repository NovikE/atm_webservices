package webservice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetClient {

    public static Response getUsers(){
        return RestAssured.when()
                .get("/users")
                .andReturn();
    }

}
