package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //we have 2 hooks in cucumber for pre condition and post condition
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(){
        closeBrowser();
    }

}
