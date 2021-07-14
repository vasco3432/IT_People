package flows.register;

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
import pages.Registration;

public class RegistrationStepDefinitions {

    HomePage homePage;
    Registration registration;

    @Before
    public void setUpTest(Scenario scenario) {
        try {
            System.out.println("\n\nThe execution of scenario: '" + scenario.getName() + "' has started\n");

            TestBase testBase = new TestBase();
            testBase.initialization();
            homePage = new HomePage();
            registration=homePage.accessRegistration();
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

    @Given("The user is already registration page")
    public void theUserIsAlreadyRegistrationPage() {
        String title= registration.getTitle();

        Assert.assertEquals( "Registo - NOS ID", title);
    }

    @When("^The user inserts ([^\"]*) and ([^\"]*)$")
    public void theUserInsertsEmailAndPhone(String email, String phone) {
        registration.insertEmail(email);
        registration.insertPhone(phone);
    }

    @And("The user clicks to accept terms and conditions")
    public void theUserClicksToAcceptTermsAndConditions() {
        registration.acceptTermsAndConditions();
    }

    @And("The user clicks Next")
    public void theUserClicksNext() {
        registration.submit();
    }

    @Then("A modal of email sent must be displayed")
    public void aModalOfEmailSentMustBeDisplayed() {
        Assert.assertTrue(registration.getVisibilityEmailValidationButton());
    }

    @And("A text box to insert the code sent to phone must be displayed")
    public void aTextBoxToInsertTheCodeSentToPhoneMustBeDisplayed() {
        Assert.assertTrue(registration.getVisibilityEmailValidationCodeInput());
    }
}
