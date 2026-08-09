package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EmployeeSearchPage;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {

    EmployeeSearchPage employeeSearchPage = new EmployeeSearchPage();

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
       WebElement pimOption = driver.findElement(
               By.xpath("(//*[text()='PIM'])[1]"));
       pimOption.click();
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        WebElement empIdField = driver.findElement(
                By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        empIdField.sendKeys("5632");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(
                By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        searchButton.click();
    }

    @Then("user is able to see employee details")
    public void user_is_able_to_see_employee_details() {
        System.out.println("employee details can be seen now");
    }

    @When("user enters employee name")
    public void user_enters_employee_name() {
        WebElement empNameField = driver.findElement(
                By.xpath("(//*[@placeholder='Type for hints...'])[1]"));
        empNameField.sendKeys("Adam");
    }


}
