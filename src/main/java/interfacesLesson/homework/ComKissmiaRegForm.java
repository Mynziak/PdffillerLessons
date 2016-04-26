package interfacesLesson.homework;

import browserfactory.BrowseFactory;
import interfacesLesson.User;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dima on 25.04.2016.
 */
public class ComKissmiaRegForm extends BrowseFactory implements IRegFormHomeWork{
    private By men = By.xpath("//label[@for='iam-boy']");
    private By women = By.xpath("//label[@for='find-girl']");
    private By nameInput = By.id("user-reg-myname");
    private By submitButton = By.xpath("(//button[@class='submit'])[2]");
    private By submitButtonFinish = By.xpath("(//button[@class='submit'])[3]");

    private By emailInput = By.id("user-reg-myemail");
    private By passInput = By.id("user-reg-mypass");


    @Override
    public void registerNewUser(User user) {
        waitUntilPageLoaded();
        Assert.assertTrue(isElementPresent(men, 5), "Element " + men + " is not displayed");
        click(men);
        click(women);
        type(nameInput, user.name);
        click(submitButton);
        Assert.assertTrue(isElementDisplayed(emailInput, 2), "Element " + emailInput + " is not displayed");
        type(emailInput, user.email);
        type(passInput, user.password);
        Assert.assertTrue(isElementDisplayed(submitButtonFinish, 6), "Element " + submitButtonFinish + " is not displayed");
        click(submitButtonFinish);
    }

    @Override
    public boolean isRegSuccess() {
        waitUntilPageLoaded();
        System.out.println("!!!!!!!!!!!! URL  = "+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("/test"), "registration in not success");
        return true;
    }
}
