package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CodeReuseTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .expectBody("name", equalTo("Riley"))
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest() {
        String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec)
                .body(reqBody)
                .when().post();
        response.then().spec(responseSpec);
        System.out.println(response.getBody().asPrettyString());
    }

    @Test(priority = 2)
    public void getRequestTest()
    {
        Response response = given().spec(requestSpec)
                .when().get("/77232");
        response.then().spec(responseSpec);
        System.out.println(response.getBody().asPrettyString());
    }

    @Test(priority = 3)
    public void deleteRequestTest()
    {
        Response response = given().spec(requestSpec)
                .when().delete("/77232");
        response.then().statusCode(200);
        response.then().body("message", equalTo("77232"));
    }
}
