package interfacesLesson.homework;

import browserfactory.BrowseFactory;
import interfacesLesson.User;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dima on 25.04.2016.
 */
public class ComVkRegForm extends BrowseFactory implements IRegFormHomeWork {

    private By firstNameField = By.id("ij_first_name");
    private By lastNameField = By.id("ij_last_name");
    private By selectSexMenu = By.cssSelector(".selector_input.selected");
    private By female = By.xpath("//li[@class='first']");
    private By submit = By.id("ij_submit");
    private By sendPhone = By.id("join_send_phone");


    @Override
    public void registerNewUser(User user)  {
        Assert.assertTrue(isElementPresent(firstNameField, 5), "element" + firstNameField + " is not Displayed");
        type(firstNameField, user.name);
        type(lastNameField, user.name);
        click(submit);
        Assert.assertTrue(isElementDisplayed(selectSexMenu, 3), "element" + selectSexMenu + "  is not displayed");
        hoverOver(selectSexMenu, female);
        click(submit);
    }

    @Override
    public boolean isRegSuccess() {
        Assert.assertTrue(isElementPresent(sendPhone, 2), "REgistration is not succcess");
        return true;
    }
}
