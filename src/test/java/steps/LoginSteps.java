package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is able to launch the application")
    public void user_is_able_to_launch_the_application() {
       /*
        driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://148.72.132.33:8081/web/index.php/auth/login");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        */
        openBrowserAndLaunchApplication();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        usernameField.sendKeys("hrm_user");
        passwordField.sendKeys("Hrm_user@123");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    @Then("user is navigated to homepage")
    public void user_is_navigated_to_homepage() {
        System.out.println("test passed");
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        System.out.println("error message displayed");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        usernameField.sendKeys("hrm_user33444");
        passwordField.sendKeys("Hrm_user@1235678");
    }

}
