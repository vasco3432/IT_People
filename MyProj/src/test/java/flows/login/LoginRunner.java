package flows.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/flows/login/LoginFlow.feature", //the path of the feature files
        glue={"flows.login"}, //the path of the step definition files
        plugin= {"pretty","html:Cucumber_Report/Login/cucumber.html", "json:Cucumber_Report/Login/cucumber.json", "junit:Cucumber_Report/Login/cucumber.xml"}, //to generate different types of reporting
        monochrome = true //display the console output in a proper readable format
)

public class LoginRunner {
}
