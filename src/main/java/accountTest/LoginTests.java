package accountTest;

import browserfactory.BrowseFactory;
import browserfactory.Listener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Pages;

/**
 * Created by DimaM on 8/28/2015.
 */

@Listeners({Listener.class})

public class LoginTests extends BrowseFactory{
  Pages page = new Pages();
    HelperMethods h = new HelperMethods();
    TestData data = new TestData();


    @BeforeClass
    public void todoBeforeTests() {
        //open My Account page
        driver.get(TestData.URL_LOGIN_REGISTRATION);
    }


    @Test
            //(enabled = false)

    public void loginWithFacebook() {

        // Login to the website
        h.clickElement(page.loginRegisterPage.registerBtn);

        String mainWindow = driver.getWindowHandle(); //remember current window for possibility to back after switching
        h.clickElement(page.loginRegisterPage.registerWithFbBtn);
        h.handleMultipleWindows("Facebook");//switch to Fb window
            //login to FB
        h.enterText(TestData.emailFieldFbwindow,TestData.EMAIL_FB);
        h.enterText(TestData.passwordFieldFbwindow,TestData.EMAIL_PASSWORD);
        h.clickElement(TestData.logInFbBtn);

         driver.switchTo().window(mainWindow);

        //verification of photo in header

        h.isElementPresent(page.myFormsPage.userHeader, 5);
       String style = BrowseFactory.driver.findElement(page.myFormsPage.userHeader).getAttribute("style");
        Assert.assertTrue(style.contains(TestData.AVA_FB), "avatar from FB is not loaded");

        //deletion of account
        driver.get(TestData.URL_MY_ACCOUNT);
        driver.findElement(TestData.deleteAccount).isEnabled();
        h.clickElement(TestData.deleteAccount);

        driver.findElement(TestData.confirmDelete).isEnabled();
        h.clickElement(TestData.confirmDelete);

        h.isElementPresent(TestData.btnOkConfirm, 5);
        driver.navigate().refresh();
        h.isElementPresent(TestData.okBtnNotDisplayed,5);
         Assert.assertTrue(BrowseFactory.driver.getCurrentUrl().contains(page.loginRegisterPage.LOGIN_URL), "User is not deleted");


    }
}
