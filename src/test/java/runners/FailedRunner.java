package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of the feature directory
        features = "@target/failed.txt",
        //path of the steps package, name must be same
        glue = "steps"
)

public class FailedRunner {
}
