package interfacesLesson.homework;

import browserfactory.BrowseFactory;
import interfacesLesson.User;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dima on 25.04.2016.
 */
public class RuLoveeto extends BrowseFactory implements IRegFormHomeWork {

    private By iButton = By.id("reg-genre-selector1");
    private By maleSelect = By.xpath("//a[@rel='m']");
    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By find = By.cssSelector(".btn.btn_yellow.btn_medium");

    @Override
    public void registerNewUser(User user) {
        Assert.assertTrue(isElementPresent(iButton, 5), "Element "+ iButton+"is not Displayed");
        click(iButton);
        click(maleSelect);
        type(nameInput, user.name);
        type(emailInput, user.email);
        type(passwordInput, user.password);
        click(find);

    }

    @Override
    public boolean isRegSuccess(){
        waitUntilPageLoaded();
        Assert.assertTrue(driver.getCurrentUrl().contains("/test"), "registration in not success");
        return true;
    }
}
