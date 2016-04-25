package interfacesLesson;


import browserfactory.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by DM on 22.04.2016.
 */
public class RegForm extends MethodsFactory implements IRegForm{

    public By y = By.id("reg-genre-selector1");
    public By paren = By.xpath("//div[@class='options']//*");
    public By name = By.name("name");
    public By email = By.name("email");
    public By password = By.name("password");

public RegForm( EventFiringWebDriver driver){
    this.driver = driver;
    }



    @Override
    public void setDriver(EventFiringWebDriver driver) {
        
    }

    @Override
    public void selectGender(char gender) {

    }

    @Override
    public void selectSearchGender(char searchGender) {

    }

    @Override
    public void typeName(String name) {

    }

    @Override
    public void typeEmail(String email) {

    }

    @Override
    public void typePassword(String password) {

    }

    @Override
    public void clickSubmit() {

    }

    @Override
    public void registerNewUser(User user) {
        isElementPresent(y);
        click(y);
        isElementDisplayed(paren,5);
        click(paren);
        type(name, "namet");
        type(email, "emaol");
        type(password, "1");



    }

}
