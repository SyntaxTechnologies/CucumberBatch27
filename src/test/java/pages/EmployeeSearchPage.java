package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage  extends CommonMethods {


    //pim option, add employee option, empid, empname

    @FindBy(xpath = "(//*[text()='PIM'])[1]")
    public WebElement pimOption;

    @FindBy(xpath = "(//*[text()='Add Employee'])[1]")
    public WebElement addEmpOption;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement empIdField;

    @FindBy(xpath = "(//*[@placeholder='Type for hints...'])[1]")
    public WebElement empNameField;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchButton;

    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }

}
