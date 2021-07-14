package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends TestBase {

    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id = "phone")
    WebElement Phone;

    @FindBy(xpath = "//label[@for='Eula']")
    WebElement CheckBoxForTermsAndConditions;

    @FindBy(xpath = "//button[contains(text(), 'AVANÇAR')]")
    WebElement Next;

    @FindBy(xpath = "//button[@data-label='Valide o seu Email']")
    WebElement EmailValidationButton;

    @FindBy(xpath = "//input[@data-label='PhoneNumberConfirmationCode']")
    WebElement EmailValidationCodeInput;

    @FindBy(id = "CybotCookiebotDialogBodyButtonAccept")
    WebElement AcceptCookies;

    public Registration() {
        PageFactory.initElements(driver, this);
        AcceptCookies.click();
    }

    public void insertEmail(String email){
        Email.sendKeys(email);
    }

    public void insertPhone(String phone){
        Phone.sendKeys(phone);
    }

    public void acceptTermsAndConditions(){
        Actions actions = new Actions(driver);
        actions.moveByOffset(CheckBoxForTermsAndConditions.getLocation().getX()+1, CheckBoxForTermsAndConditions.getLocation().getY()+1).click().build().perform();
    }

    public void submit(){
        Next.click();
    }

    public String getTitle(){
        String title=driver.getTitle();
    return title;
    }

    public boolean getVisibilityEmailValidationButton(){
        boolean isVisible=EmailValidationButton.isDisplayed();
        return isVisible;
    }

    public boolean getVisibilityEmailValidationCodeInput(){
        boolean isVisible=EmailValidationCodeInput.isDisplayed();
        return isVisible;
    }
}
