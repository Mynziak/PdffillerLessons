package interfacesLesson.homework;

import browserfactory.MethodsFactory;
import interfacesLesson.User;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dima on 25.04.2016.
 */
public class PdffillerRegForm extends MethodsFactory implements IRegFormHomeWork {

    public By registerButton = By.id("button-register");
    private By emailField = By.id("form-register-email");
    private By passwordField = By.id("form-register-password");
    private By registrationButton = By.xpath("(//button[@class='btn -orange login-block__action-btn'])[1]");

    @Override
    public void registerNewUser(User user) {
        waitUntilPageLoaded();
        Assert.assertTrue(isElementPresent(registerButton, 6));
        click(registerButton);
        Assert.assertTrue(isElementPresent(emailField));
        type(emailField, user.email);
        type(passwordField, user.password);
        click(registrationButton);
    }

    @Override
    public boolean isRegSuccess() {
        waitUntilPageLoaded();
        Assert.assertTrue(driver.getCurrentUrl().contains("en/forms.htm"));
        return true;
    }
}
