package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeOption = driver.
                findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
        click(addEmployeeOption);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstNameLoc = driver.findElement(By.name("firstName"));
        WebElement middleNameLoc = driver.findElement(By.name("middleName"));
        WebElement lastNameLoc = driver.findElement(By.name("lastName"));

        sendText("bryan", firstNameLoc);
        sendText("ms", middleNameLoc);
        sendText("belhoul", lastNameLoc);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        click(saveButton);
    }

    @Then("user is able to add employee sucessfully")
    public void user_is_able_to_add_employee_sucessfully() {
        System.out.println("Employee added sucessfully");
    }

    @When("user enters {string} and {string} and {string} values")
    public void user_enters_and_and_values
            (String firstName, String middleName, String lastName) {
        WebElement firstNameLoc = driver.findElement(By.name("firstName"));
        WebElement middleNameLoc = driver.findElement(By.name("middleName"));
        WebElement lastNameLoc = driver.findElement(By.name("lastName"));

        sendText(firstName, firstNameLoc);
        sendText(middleName, middleNameLoc);
        sendText(lastName, lastNameLoc);
    }

    @When("user enters {string} and {string} and {string} keys")
    public void user_enters_and_and_keys(String firstName, String middleName, String lastName) {
        WebElement firstNameLoc = driver.findElement(By.name("firstName"));
        WebElement middleNameLoc = driver.findElement(By.name("middleName"));
        WebElement lastNameLoc = driver.findElement(By.name("lastName"));

        sendText(firstName, firstNameLoc);
        sendText(middleName, middleNameLoc);
        sendText(lastName, lastNameLoc);
    }
}
