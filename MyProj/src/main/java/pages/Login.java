package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends TestBase {
    @FindBy(id = "Username")
    WebElement Email;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(xpath = "//button[contains(text(), 'Entrar')]")
    WebElement Login;


    @FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
    WebElement AcceptCookies;


    public Login() {
        PageFactory.initElements(driver, this);
        AcceptCookies.click();
    }


    public void insertUsername(String email) {
        Email.sendKeys(email);
    }

    public void insertPassword(String password) {
        Password.sendKeys(password);
    }

    public UserHomePage submitUsername() {
        Login.click();
        return new UserHomePage();
    }

    public UserHomePage loginUser() {
        Login.click();
        wait.until(ExpectedConditions.urlContains("Authorize"));
        return new UserHomePage();
    }

    public String getTitle(){
        String title=driver.getTitle();
        return title;
    }

}
