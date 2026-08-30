package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(name = "firstName")
    public WebElement firstNameLoc;

    @FindBy(name = "middleName")
    public WebElement middleNameLoc;

    @FindBy(name = "lastName")
    public WebElement lastNameLoc;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')] //input")
    public WebElement idAutoGenField;

    //constructor
    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
