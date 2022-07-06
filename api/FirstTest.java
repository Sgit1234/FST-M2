package examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class FirstTest {
    final String baseURI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void simpleTest() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().get(baseURI + "/findByStatus?status=sold");
        System.out.println(response.getBody().asString());
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getHeaders().asList());


        String petStatus  = response.then().extract().body().path("[0].status");
        String dateHeader= response.then().extract().header("Date");
        System.out.println("Pet Status is : " +petStatus);
        System.out.println("Header date is : " +dateHeader);

        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));
    }
    }

