package utils;

import pages.AddEmployeePage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {

    //this class is used to initialize all the page objects that we have created in
    // the pages package. We will call this method in the BaseClass before each
    // test method to make sure that all the page objects are initialized before
    // we use them in our test methods.

    public static AddEmployeePage addEmployeePage;
    public static LoginPage  loginPage;
    public static EmployeeSearchPage employeeSearchPage;


    public static void initializePageObjects(){
        addEmployeePage = new AddEmployeePage();
        employeeSearchPage = new EmployeeSearchPage();
        loginPage = new LoginPage();
    }

}
