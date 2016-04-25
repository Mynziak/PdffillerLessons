package interfacesLesson;

import org.openqa.selenium.support.events.EventFiringWebDriver;


/**
 * Created by DM on 22.04.2016.
 */
public interface IRegForm {


    public void setDriver(EventFiringWebDriver driver);

    public void selectGender (char gender);


    public void selectSearchGender (char searchGender);


    public void typeName (String name);


    public void typeEmail (String email);


    public void typePassword (String password);


    public void clickSubmit();


    public void registerNewUser (User user);

}
