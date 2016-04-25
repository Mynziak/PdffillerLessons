package interfacesLesson;
import browserfactory.BrowseFactory;
import browserfactory.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Lolik on 23.12.2015.
 */
public class RegForm5 extends MethodsFactory implements IRegForm {



    public RegForm5(EventFiringWebDriver driver){
        this.driver = driver;
    }


    private By maleBtn = By.cssSelector("label[for='iam-boy']");
    private By femaleBtn = By.cssSelector("label[for='iam-girl']");

    private By searchMaleBtn = By.cssSelector("label[for='find-boy']");
    private By searchFemaleBtn = By.cssSelector("label[for='find-girl']");

    private By nameFld = By.id("user-reg-myname");
    private By emailFld = By.id("user-reg-myemail");
    private By passwordFld = By.id("user-reg-mypass");

    private By submitBtn = By.cssSelector("#block-last[style='display: block;'] .submit");


    private By nextBtn = By.cssSelector("#block-first .submit");


    public void clickNextButton(){
        click(nextBtn);
    }


    @Override
    public void setDriver(EventFiringWebDriver driver) {

    }

    @Override
    public void selectGender(char gender) {
        if(gender == 'm'){
            click(maleBtn);
        } else if(gender == 'f'){
            click(femaleBtn);
        }
    }


    @Override
    public void selectSearchGender(char searchGender) {

    }

    @Override
    public void typeName(String name) {
        type(nameFld, name);
    }


    @Override
    public void typeEmail(String email) {
        type(emailFld, email);
    }


    @Override
    public void typePassword(String password) {
        type(passwordFld, password);
    }

    @Override
    public void clickSubmit() {
        click(submitBtn);
    }


    @Override
    public void registerNewUser(User user) {
        selectGender(user.gender);
        typeName(user.name);
        clickNextButton();
        isElementPresent(submitBtn, 10);
        typeEmail(user.email);
        typePassword(user.password);
        clickSubmit();

    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

}
