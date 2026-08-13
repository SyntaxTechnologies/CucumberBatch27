package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='oxd-userdropdown-tab']")
    public WebElement adminIcon;

    @FindBy(xpath = "//*[text()='Time at Work']")
    public WebElement timeAtWorkLoc;


    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
