package LessonExams;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

/**
 * Created by Dima on 07.06.2016.
 */
public class PdffillerPage extends AbstractLogin implements InterReg{

    String loginP = "dmitry.m@pdffiller.com";
    String passP = "1";

    private By loginPageIdentifier_element = By.xpath("//*[@class='h-nav__link active' and contains(@href,'login')]");
    private By login_form = By.xpath("//*[text()='Log In']");
    private By loginFormEmail_field = By.id("form-login-email");
    private By loginFormPassword = By.id("form-login-password");
    private By logIn_button = By.id("form-login-submit");
    private By openRegForm_button = By.id("button-register");
    private By openLoginForm_button = By.id("button-login");
    private By reg_form = By.xpath("//*[text()='Create an Account']");
    private By regFormEmail_field = By.id("form-register-email");
    private By regFormPassword_field = By.id("form-register-password");
    private By register_button = By.xpath("//*[contains(@onclick, 'register')]");
    private By registerByFacebbok_button = By.id("face_login");
    private By facebookEmail_input = By.id("email");
    private By facebookPassword_input = By.id("pass");
    private By facebookSubmit_button = By.id("u_0_2");
    private By loginByFacebbok_button = By.id("face_login");
    private By loginByGoogle_button = By.id("btn-google");
    private By registerByGoogle_button = By.id("btn-google");
    private By forgotPassword_button = By.id("btn-forgot-password");
    private By resetPasswordEmail_field = By.id("form-reset-password-email-or-phone");
    private By resetPassword_button = By.id("form-reset-password-submit");
    private By passwordReset_dialog = By.id("modal-password-restore-message");
    private By passwordResetDialogOk_button = By.id("btn-modal-password-restore-ok");
    private By facebookLikes_block = By.xpath("(//iframe[contains(@src, 'facebook')])[2]");

    @Override
    public void openPage() {
        get("https://www.pdffiller.com/en/login.htm");
        waitUntilPageLoaded();
    }

    @Override
    public void typeLogin(String login) {
        if (!driver.findElement(login_form).isDisplayed()) {
            click(openLoginForm_button);
        }
        assertTrue(isElementPresent(login_form), "Login form is not visible");
        type(loginFormEmail_field, login);
    }

    @Override
    public void typePassword(String password) {
        type(loginFormPassword, password);
    }

    @Override
    public void clickSubmit() {
        click(logIn_button);
    }

    @Override
    public void loginUser() {
        openPage();
        typeLogin(loginP);
        typePassword(passP);
        clickSubmit();
    }
}
