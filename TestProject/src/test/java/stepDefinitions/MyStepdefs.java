package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import static io.restassured.RestAssured.given;

public class MyStepdefs {

    RequestSpecification request = RestAssured.given();
    Response response;

    @Given("^User hits the stories endpoint$")
    public void userHitsTheStoriesEndpoint() throws Exception {
        RestAssured.baseURI = "https://api.aylien.com/news";
    }

    @When("^User adds the credentials and send request$")
    public void userAddsTheCredentialsInHeaders() throws Exception {
        response = given()
                .contentType(ContentType.JSON)
                .header("X-Application-Id", "abc")
                .header("X-Application-Key", "1234")
                .when()
                .get("/stories")
                .then()
                .extract().response();
    }

    @Then("^the http status code is (\\d+)$")
    public void theHttpStatusCodeIs(int httpStatusCode) {
        Assert.assertEquals(httpStatusCode, response.statusCode());
    }


    @And("^Verify the content of the result$")
    public void verifyTheContentOfTheResult() {
        Assert.assertEquals("3056903", response.jsonPath().getString("stories[0].author.id"));
    }

    @When("^User sends request with out passing credentials$")
    public void userSendsRequestWithOutPassingCredentials() {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/stories")
                .then()
                .extract().response();
    }
}
