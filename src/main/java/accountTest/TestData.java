package accountTest;

import org.openqa.selenium.By;

/**
 * Created by DimaM on 8/27/2015.
 */
public class TestData {

    public static final String PDFFILLER_COM = "http://www.pdffiller.com/";
    public static final String URL_MY_ACCOUNT = "https://www.pdffiller.com/en/account/?op=account_info";
    public static final String EMAIL_PASSWORD = "Dm@!111111";
    public static final String URL_MY_ACCOUNT_NOT_LOGGED_IN = "login.htm?ref=%2Fen%2Faccount%2F&op=account_info";
    public static final String EMAIL = "mynziakd1@gmail.com";
    public static final String NEW_EMAIL = "mynziakd1+new1@gmail.com";
    public static final String PASS = "1";
    public static final String URL_MY_FORMS = "https://www.pdffiller.com/en/forms.htm";
    public static final String URL_MY_FORMS_ = "pdffiller.com/en/forms.htm";
    public static final String ACCOUNT1 = "dmitry.m@pdffiller.com";
    public static final String ACCOUNT1_PASS= "111";
    public static final String PASS_BOX = "mynziak";

public By flashEditor = By.id("mainContent");

    public By popupConfirmDelete = By.xpath("//*[@id='modalConfirm'][contains(@style,'display: none;')]"); //*[@id='modalConfirm' and class ='modal-alert info modal current'][contains(@style,'display: block;')]
  public By login = By.id("username2");
    static  By passFieldLogin = By.id("password2");
    static  By btnLogin = By.id("login_btn_site");
    static  By SEND_WITH_EMAIL = By.id("send-type-1") ;
    static  By SAVE_PREFERENCES = By.id("btn_saveSendPreferences");
    static  By  MY_BOX = By.xpath("//span[contains(.,'MyBox [All Documents]')]");
    static  By ANY_FORM = By.xpath("//td[@class= ' td0 brd name filetype-pdf ']");
    static  By accountInfTab = By.cssSelector("img[alt='Account Information']");
    static  By  EMAIL_SMS =By.id("btn_action_send") ;
    static  By  SEND_WITH_PMAIL = By.id("send-type-3");
    static  By PMAIL_BTN = By.id("btn_action_pmail");
    static  By newEmailField = By.id("form1_newmail");
    static  By confirmNewEmailField = By.id("form1_remail");
    static  By changeEmailsBtn = By.xpath("//a[@class='btn-gray' and contains(.,'Change Email')]");
    static  By btnOkConfirm = By.id("btn_popup_ok");
    static  By confirmPassField = By.id("passDlg");
    static  By emailOfUser = By.id("username");
            //By userHeader = By.id("user_logo_thumb_header");  //remove if code compilled
    static  By userHeaderEmail= By.xpath("//div[@class='ac-userInfo__email']");
    static  By flashSuccess = By.xpath("//*[@id='flash'][contains(@style,'block')]");
    static By  deleteAccount = By.id("deleteAccount");
    static By confirmDelete = By.xpath("//a[@onclick='removeUser(); return false;']");
    static  By okBtnDelet = By.xpath("//button[@class ='btn -sm -orange']");
    static  By okBtnNotDisplayed = By.xpath("//div[@id='modalConfirm'][contains(@style,'display: none')]");


    // Data for Login/Registration  page
    public static final String URL_LOGIN_REGISTRATION = "https://www.pdffiller.com/en/login.htm";

    static By registerBtn = By.xpath("//a[@class=\"btn-gray btns1\" and @ onclick=\"showReg(); return false;\"]");
    static By registerWithFacebookBtn = By.xpath("//span [@class='face_button_text_new'and contains (.,'Register with Facebook')]");

//Fb window

    public static final String EMAIL_FB ="qamynz@gmail.com";
    public static final String AVA_FB = "/tmp/ava";


    static By emailFieldFbwindow = By.id("email");
    static By passwordFieldFbwindow = By.id("pass");
    static By logInFbBtn= By.xpath("//input[@value='Log In' and @name='login']");
    static By okayFbBtn = By.xpath("//button [@value='1' and @name='__CONFIRM__']");

}
