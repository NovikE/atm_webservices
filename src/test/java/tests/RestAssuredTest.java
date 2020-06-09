package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webservice.GetClient;

public class RestAssuredTest {

    public static final String expectedContentType = "application/json; charset=utf-8";

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
            Assert.assertEquals(GetClient.getUsers().getStatusCode(), 200);
        }

    @Test
    public void checkResponseHeader(){

        String rpContentTypeHeader = GetClient.getUsers().getHeader("Content-Type");
        Assert.assertEquals(rpContentTypeHeader, expectedContentType);
        }

    @Test
    public void checkResponseBody(){

        ResponseBody responseBody = GetClient.getUsers().getBody();
        User[] users = responseBody.as(User[].class);
        Assert.assertEquals(users.length, 10);

    }
}
