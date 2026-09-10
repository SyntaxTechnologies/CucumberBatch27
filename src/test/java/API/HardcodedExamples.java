package API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class HardcodedExamples {

    String baseURI = RestAssured.baseURI = "https://www.syntaxhrm.com/web/index.php/";
    String token = "Bearer aHJtX3VzZXI6MTc4ODk5NjAxODpiOGViNjY5MjMxMWIzMWZiZjAzMzU0YWVmZDQ0NjUzMw==";
    static String empNumber;


   @Test
    public void acreateEmployee(){

        //prepare the request - given
        RequestSpecification request = given().header("Authorization", token).
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"firstName\": \"Hafida\",\n" +
                        "  \"lastName\": \"belhoul\",\n" +
                        "  \"middleName\": \"ms\",\n" +
                        "  \"gender\": \"F\",\n" +
                        "  \"birthday\": \"1990-01-15\",\n" +
                        "  \"job_title\": \"SDET\"\n" +
                        "}");

        //send the request - when
        Response response = request.when().post("api/v2/pim/create_employee");

        //validate the response - then
        response.then().assertThat().statusCode(201);
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


    @Test
    public void bgetCreatedEmployee(){
       //prepare the request
        RequestSpecification request = given().header("Authorization", token).
                header("Content-Type", "application/json");
        //send the request
        Response response = request.when().get("api/v2/pim/employee"+"/"+empNumber);
        //validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        //compare the employee numbers
        String tempEmpNumber = response.jsonPath().getString("data.empNumber");
        System.out.println(tempEmpNumber);
        Assert.assertEquals(empNumber, tempEmpNumber);
    }

    @Test
    public void cupdateEmployee(){
        RequestSpecification request = given().header("Authorization", token).
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"firstName\": \"Bryan\",\n" +
                        "  \"lastName\": \"Something\",\n" +
                        "  \"middleName\": \"sm\",\n" +
                        "  \"gender\": \"M\",\n" +
                        "  \"birthday\": \"1999-01-15\",\n" +
                        "  \"job_title\": \"SDET\"\n" +
                        "}");
        //send the request
        Response response = request.when().put("api/v2/pim/employee"+"/"+empNumber);
        //validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    public void deleteEmployee(){
        RequestSpecification request = given().header("Authorization", token);
        //send the request
        Response response = request.when().delete("api/v2/pim/employee"+"/"+empNumber);
        //validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

}
