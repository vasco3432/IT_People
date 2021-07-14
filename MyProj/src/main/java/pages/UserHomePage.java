package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class UserHomePage extends TestBase {

    @FindBy(xpath = "//*[contains(text(), 'Acesso não autorizado')]")
    WebElement UnauthorizedDisplay;

    public UserHomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean getVisibilityUnauthorizedElement(){
        boolean isVisible=UnauthorizedDisplay.isDisplayed();
        return isVisible;
    }
}
