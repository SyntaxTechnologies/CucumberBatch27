package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//it controls the execution of the entire project
@RunWith(Cucumber.class)
@CucumberOptions(
        //it will execute all the featur files under features directory
        features = "src/test/resources/features/",
        //step definitions
        glue = "steps",
        //to generate step definition, we will use this
        // if this is true, it will stop the execution and will scan all the steps, if any step is missing, it will generate
        // if this is false, it will start the execution and will execute all the test cases
        dryRun = false,
        //execution will be controlled based on the tags from here
        // tags = "@sprint1"
        // tags = "@sprint1 and @smoke"
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
        //re run is pending
)

public class SmokeRunner {
}
