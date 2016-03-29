package pages;

import org.openqa.selenium.By;

/**
 * Created by DimaM on 9/17/2015.
 */
public class PageLoginRegister {

    public  static final String LOGIN_URL = "https://www.pdffiller.com/en/login.htm";

    public By loginField = By.id("form-login-email");
    public By passField = By.id("form-login-password");
    public By loginBtn = By.id("form-login-submit");
    public By registerBtn = By.id("button-register");
    public By registerWithFbBtn = By.id("face_login");
}
