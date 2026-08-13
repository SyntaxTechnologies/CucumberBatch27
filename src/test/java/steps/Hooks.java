package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //we have 2 hooks in cucumber for pre condition and post condition
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        //this scenario class holds the complete information  of the execution
        byte[] pic;
        //put the condition for pass and fail test cases, if the scenario is failed, then take a screenshot and attach it to the report

        //put the condition for pass and fail test cases, if the scenario is failed, then take a screenshot and attach it to the report
        if(scenario.isFailed()) {
           pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        //it will attach the screenshot to the report
        scenario.attach(pic,"image/png", scenario.getName());
        closeBrowser();
    }

}
