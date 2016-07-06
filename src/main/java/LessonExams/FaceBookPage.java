package LessonExams;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

/**
 * Created by Dima on 07.06.2016.
 */
public class FaceBookPage extends AbstractLogin implements InterReg {
    private By email_field = By.id("email");
    private By password_field = By.id("pass");
    private By login_button = By.id("loginbutton");
    // private By userNavigation_element = By.id("userNav");    //!!!!! (//*[@class='_42ef'])[73]//*[@class='_52eh']
    private By logoutMenu_menu = By.id("logoutMenu");
    private By joinToGroup_button = By.cssSelector("._42ft._4jy0._4jy4._4jy2.selected._51sy");
    private By pending_button = By.xpath("//span[contains(.,'Pending')]");
    private By memmersInGroup_element = By.xpath("(//div[@class='_ajw']/div[contains(.,'member')])");
    // private By membersElement = By.xpath("//div[@class='_glj']/*/*/div[@class='_ajw']");

    private By endOfResults_element = By.xpath("//div[@class='phm _64f'][contains(.,'End of Results')]");
    //  private By groupLink_link = By.xpath("//div[@class='_gll']/a");
    private By groupBlock_block1 = By.xpath("//div[@class='_glj']");
    private By groupBlock_block = By.cssSelector("._glj");
    // private By groupMembers = By.xpath("(//*[@class='_42ef'])");
    private By noResults_window = By.cssSelector("._43zr._8o._8s.lfloat._ohe.img");

    String loginF = "boomer.boomersgroup@gmail.com";
    String passF = "dataedu1";

    @Override
    public void openPage() {
        get("https://www.facebook.com/");
        waitUntilPageLoaded();
    }

    @Override
    public void typeLogin(String login) {
        assertTrue(isElementDisplayed(email_field, 5), "Email Field is not visible");
        type(email_field, login);
    }

    @Override
    public void typePassword(String password) {
        assertTrue(isElementDisplayed(password_field, 5), "Password Field is not visible");
        type(password_field, password);
    }

    @Override
    public void clickSubmit() {
        click(login_button);
        waitUntilPageLoaded();
        assertTrue(isElementDisplayed(logoutMenu_menu, 5), "User is not logged in");
    }

    @Override
    public void loginUser() {
        openPage();
        typeLogin(loginF);
        typePassword(passF);
        clickSubmit();
    }
}
