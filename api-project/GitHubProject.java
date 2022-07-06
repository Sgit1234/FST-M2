package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GitHubProject {
    RequestSpecification requestSpec;
    String sshkey;
    int num;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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")
                .build();

    }

    @Test(priority = 1)
    public void postRequestTest() {
        String reqBody = "{\"title\":\"TestAPIKey\",\"key\":\"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCGtG6oTE7MZGOXrSdDaGs26ditwjDsrQ7nFl02+AIIQaoTooeDDEqAD4dy15ZJxXVC+HcWcfgJJoBAiISC6svnsH8QNBK+1dpAN/c/hcP/rZ1DPrgCBowW4LNc9LwLLBB/jUDWRof0Cb29539mLvAnL56338xwIbCBhcg8mrb3FF46rTmvNZyuPepTyv5br00FyfByVQLfU7bo8VhQdfBjsAns4HWpYP3b5l5k8q+aOQ2SatSKiL/0iD4slhrLXopMdFqwxnnH438yPM6mJxLsYAQWpP7zbYq/u+GBu8gaxnweIc34iTmApR3uHrPSUcV4Hwq3L9VCaODtQRYYE8pf\"}";
        Response response = given().spec(requestSpec)
                .body(reqBody)
                .when().post("/user/keys");
        System.out.println(response.getBody().asPrettyString());
        num = response.then().extract().body().path("id");
        response.then().statusCode(201);

    }

  @Test(priority = 2)
    public void getRequestTest()
    {
        Response response = given().spec(requestSpec)
                .when().get("/user/keys/" + num);

        System.out.println(response.getBody().asPrettyString());
        response.then().statusCode(200);
    }

    @Test(priority = 3)
    public void deleteRequestTest()
    {
        Response response = given().spec(requestSpec)
                .when().delete("/user/keys/" + num);

        System.out.println(response.getBody().asPrettyString());
        response.then().statusCode(204);

    }


}
