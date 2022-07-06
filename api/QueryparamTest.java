package examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class QueryparamTest {

    final static String ROOT_URI = "http://ip-api.com/json";

    @Test
    public void getIPInformation() {
        Response response =
                given().contentType(ContentType.JSON)
                        .when().queryParam("fields", "query,country,city,timezone")
                        .get(ROOT_URI + "/125.219.5.94");

        System.out.println(response.getBody().asPrettyString());
    }
}
