package LessonExams;

import browserfactory.MethodsFactory;

/**
 * Created by Dima on 07.06.2016.
 */
public abstract class AbstractLogin extends MethodsFactory{

    public  abstract void openPage ();
    public  abstract void typeLogin (String login);
    public  abstract void typePassword (String password);
    public  abstract void clickSubmit  ();

    public void login (String login, String password){
        openPage();
        typeLogin(login);
        typePassword(password);
        clickSubmit();
    }

}
