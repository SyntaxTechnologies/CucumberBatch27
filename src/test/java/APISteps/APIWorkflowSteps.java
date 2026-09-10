package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIWorkflowSteps {

    String baseURI = RestAssured.baseURI = "https://www.syntaxhrm.com/web/index.php/";
    String token = "Bearer aHJtX3VzZXI6MTc4ODk5NjAxODpiOGViNjY5MjMxMWIzMWZiZjAzMzU0YWVmZDQ0NjUzMw==";
    static String empNumber;
    RequestSpecification request;
    Response response;

    @Given("a request is prepared to create an employee using POST call")
    public void a_request_is_prepared_to_create_an_employee_using_post_call() {
        //prepare the request - given
         request = given().header("Authorization", token).
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"firstName\": \"Hafida\",\n" +
                        "  \"lastName\": \"belhoul\",\n" +
                        "  \"middleName\": \"ms\",\n" +
                        "  \"gender\": \"F\",\n" +
                        "  \"birthday\": \"1990-01-15\",\n" +
                        "  \"job_title\": \"SDET\"\n" +
                        "}");
    }

    @When("a POST call has been made")
    public void a_post_call_has_been_made() {
         response = request.when().post("api/v2/pim/create_employee");
    }

    @Then("employee should be created and status code should be {int}")
    public void employee_should_be_created_and_status_code_should_be(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        //print the response in console
        response.prettyPrint();
        response.then().assertThat().body("data.firstName",equalTo("Hafida"));
        //hamcrest matchers is in build library which allows comparison of values in the response of the API
        response.then().assertThat().body("data.lastName",equalTo("belhoul"));
        response.then().assertThat().header("Content-Type","application/json");
        //store the value of empNumber in global variable
        empNumber = response.jsonPath().getString("data.empNumber");
        System.out.println(empNumber);
    }
}
