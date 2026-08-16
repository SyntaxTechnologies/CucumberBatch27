package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    //AddEmployeePage addEmployeePage = new AddEmployeePage();


    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeOption = driver.
                findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
        click(addEmployeeOption);

    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
      //  WebElement firstNameLoc = driver.findElement(By.name("firstName"));
      //  WebElement middleNameLoc = driver.findElement(By.name("middleName"));
      //  WebElement lastNameLoc = driver.findElement(By.name("lastName"));

        sendText("bryan", addEmployeePage.firstNameLoc);
        sendText("ms", addEmployeePage.middleNameLoc);
        sendText("belhoul", addEmployeePage.lastNameLoc);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
    //    WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        click(addEmployeePage.saveButton);
    }

    @Then("user is able to add employee sucessfully")
    public void user_is_able_to_add_employee_sucessfully() {
        System.out.println("Employee added sucessfully");
    }

    @When("user enters {string} and {string} and {string} values")
    public void user_enters_and_and_values
            (String firstName, String middleName, String lastName) {
       // WebElement firstNameLoc = driver.findElement(By.name("firstName"));
       // WebElement middleNameLoc = driver.findElement(By.name("middleName"));
       // WebElement lastNameLoc = driver.findElement(By.name("lastName"));

        sendText(firstName, addEmployeePage.firstNameLoc);
        sendText(middleName, addEmployeePage.middleNameLoc);
        sendText(lastName, addEmployeePage.lastNameLoc);
    }

    @When("user enters {string} and {string} and {string} keys")
    public void user_enters_and_and_keys(String firstName, String middleName, String lastName) {
      //  WebElement firstNameLoc = driver.findElement(By.name("firstName"));
      //  WebElement middleNameLoc = driver.findElement(By.name("middleName"));
      //  WebElement lastNameLoc = driver.findElement(By.name("lastName"));

        sendText(firstName, addEmployeePage.firstNameLoc);
        sendText(middleName, addEmployeePage.middleNameLoc);
        sendText(lastName, addEmployeePage.lastNameLoc);
    }

    @When("user adds employees from datatable and verify them")
    public void user_adds_employees_from_datatable_and_verify_them(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        //this variable will give us list of maps which we can put in loop
        for (Map<String, String> employee : employeeNames){

            WebElement firstNameLoc = driver.findElement(By.name("firstName"));
            WebElement middleNameLoc = driver.findElement(By.name("middleName"));
            WebElement lastNameLoc = driver.findElement(By.name("lastName"));

            sendText(employee.get("firstName"), addEmployeePage.firstNameLoc);
            sendText(employee.get("middleName"), addEmployeePage.middleNameLoc);
            sendText(employee.get("lastname"), addEmployeePage.lastNameLoc);

            WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
            click(saveButton);

            //homework for validating the employee added

            //after adding the button

            WebElement addEmployeeOption = driver.
                    findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            click(addEmployeeOption);

        }
    }

    @When("user adds employees from excel file and validate them")
    public void user_adds_employees_from_excel_file_and_validate_them() throws IOException {
        List<Map<String, String>> employeeNames = ExcelReader.read();
        //this variable will give us list of maps which we can put in loop
        for (Map<String, String> employee : employeeNames) {

            WebElement firstNameLoc = driver.findElement(By.name("firstName"));
            WebElement middleNameLoc = driver.findElement(By.name("middleName"));
            WebElement lastNameLoc = driver.findElement(By.name("lastName"));

            sendText(employee.get("firstName"), firstNameLoc);
            sendText(employee.get("middleName"), middleNameLoc);
            sendText(employee.get("lastName"), lastNameLoc);

            WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
            click(saveButton);

            //homework for validating the employee added

            //after adding the button

            WebElement addEmployeeOption = driver.
                    findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            click(addEmployeeOption);
        }
    }
}
