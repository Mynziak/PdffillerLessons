package otherTests.lessonPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dima on 05.07.2016.
 */
public class KissMiaLoginPage {

    @FindBy(id = "user-email")
    WebElement email;

    @FindBy(id = "user-password")
    WebElement password;

    @FindBy(className = "submit")
    WebElement  submit;

    WebDriver driver;

    public KissMiaLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
