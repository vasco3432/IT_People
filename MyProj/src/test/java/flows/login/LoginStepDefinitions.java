package flows.login;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.Login;
import pages.UserHomePage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginStepDefinitions {

    HomePage homePage;
    Login login;
    UserHomePage userHomePage;

    @Before
    public void setUpTest(Scenario scenario) {
        try {
            System.out.println("\n\nThe execution of scenario: '" + scenario.getName() + "' has started\n");

            TestBase testBase = new TestBase();
            testBase.initialization();
            homePage = new HomePage();
            login=homePage.accessLogin();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
    @After
    public void afterScenario(Scenario scenario) {
        try {
            System.out.println("The execution of scenario: '" + scenario.getName() + "' has finished. It status is - " + scenario.getStatus());
            TestBase.tearDownTestBase();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    @Given("The user is already Login page")
    public void theUserIsAlreadyLoginPage() {
        String title= login.getTitle();
        Assert.assertEquals("NOSTV Authentication - NOS ID", title);
    }

    @When("^The user inserts ([^\"]*) and ([^\"]*)$")
    public void theUserInsertsEmailAndPassword(String email, String password) {
        login.insertUsername(email);
        login.submitUsername();
        login.insertPassword(password);
    }

    @And("The user clicks to submit")
    public void theUserClicksToSubmit() {
       userHomePage = login.loginUser();
    }

    @Then("a new page must be open displaying a message user not authorized")
    public void aNewPageMustBeOpenDisplayingAMessageUserNotAuthorized() {
        Assert.assertTrue(userHomePage.getVisibilityUnauthorizedElement());
    }
}

