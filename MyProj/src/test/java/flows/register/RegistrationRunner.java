package flows.register;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/flows/register/RegistrationFlow.feature", //the path of the feature files
        glue={"flows.register"}, //the path of the step definition files
        plugin= {"pretty","html:Cucumber_Report/Registration/cucumber.html", "json:Cucumber_Report/Registration/cucumber.json", "junit:Cucumber_Report/Registration/cucumber.xml"}, //to generate different types of reporting
        monochrome = true //display the console output in a proper readable format
        )

public class RegistrationRunner {

}
