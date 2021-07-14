package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {

    @FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
    WebElement AcceptCookies;

    @FindBy(xpath = "//button[starts-with(text(), 'Iniciar ')]")
    WebElement Login;

    @FindBy(xpath = "//button[contains(text(), 'Registar')]")
    WebElement Registration;

    public HomePage() {

        PageFactory.initElements(driver, this);
        AcceptCookies.click();
    }

    public Registration accessRegistration(){
        Registration.click();
        wait.until(ExpectedConditions.urlContains("signup"));
        return new Registration();
    }

    public Login accessLogin(){
        Login.click();
        wait.until(ExpectedConditions.urlContains("login"));
        return new Login();
    }


}
