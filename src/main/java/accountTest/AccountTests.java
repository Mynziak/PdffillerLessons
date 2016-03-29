package accountTest;

import browserfactory.BrowseFactory;
import browserfactory.Listener;
import imap.EmailWorker;
import org.apache.xpath.operations.String;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Pages;

import java.io.File;

/**
 * Created by DimaM on 7/20/2015.
 */

@Listeners({Listener.class})

public class AccountTests extends BrowseFactory {

HelperMethods h   = new HelperMethods(); //create object of helperMethod class for using mehods in current class
    Pages page = new Pages();
TestData data  = new TestData();
    public static void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(BrowseFactory.driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = BrowseFactory.driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {

        }
    }


    public boolean isTextPresentOnPage(String text) {
        return this.driver.getPageSource().contains((CharSequence) text);

    }
    // Boolean isPresent = driver.findElements(By.yourLocator).size() > 0
  /*  public boolean isPresentElement(String locator){

 return this.driver.findElements(By.locator).size() > 0;
    } */





    @BeforeClass
    public void todoBeforeTests() throws InterruptedException {
        //open My Account page
        BrowseFactory.driver.get(TestData.URL_MY_ACCOUNT);
        //Verify is user logged in?
        Assert.assertTrue(BrowseFactory.driver.getCurrentUrl().contains(TestData.URL_MY_ACCOUNT_NOT_LOGGED_IN), "User is looged in");
        // Login to the website
        BrowseFactory.driver.findElement(page.loginRegisterPage.loginField).sendKeys(TestData.EMAIL);
        BrowseFactory.driver.findElement(page.loginRegisterPage.passField).sendKeys(TestData.PASS);
        BrowseFactory.driver.findElement(page.loginRegisterPage.loginBtn).click();

       h.isElementPresent(TestData.accountInfTab, 5);
        BrowseFactory.driver.findElement(TestData.accountInfTab).click();

    }

    @Test(enabled = false)

    public void sendPreferences() throws InterruptedException {
        //Verify is Preferences exist? for subscribed user only

        if (h.isElementPresent(TestData.SAVE_PREFERENCES, 5) == true) {

            //Verification of Email preferences

            BrowseFactory.driver.findElement(TestData.SEND_WITH_EMAIL).click();
            BrowseFactory.driver.findElement(TestData.SAVE_PREFERENCES).click();

            //Verification if flash message  is displayed
            h.isElementPresent(TestData.flashSuccess, 7);
            //verification of Email/SMS button on My forms
            BrowseFactory.driver.get(TestData.URL_MY_FORMS);
            BrowseFactory.driver.findElement(TestData.MY_BOX).click();
            BrowseFactory.driver.findElement(TestData.ANY_FORM).click();

            //Verify that Email/SMS button is present
            Assert.assertTrue(h.isElementPresent(TestData.EMAIL_SMS, 2), "Email//SMS action button is absent");


            // Verification of pMail Preferences
            BrowseFactory.driver.navigate().back();
            BrowseFactory.driver.findElement(TestData.SEND_WITH_PMAIL).click();
            BrowseFactory.driver.findElement(TestData.SAVE_PREFERENCES).click();
            //Verification if flash message  is displayed
           h.isElementPresent(TestData.flashSuccess, 5);

            //verification of pMail button on My forms
            BrowseFactory.driver.get(TestData.URL_MY_FORMS);
            BrowseFactory.driver.findElement(TestData.MY_BOX).click();
            BrowseFactory.driver.findElement(TestData.ANY_FORM).click();
            //Verify that pMail button is present
            Assert.assertTrue(h.isElementPresent(TestData.PMAIL_BTN, 10), "pMail action button is absent");

        }

    }


    @Test
    public void changeEmail() throws InterruptedException {
        //delete all letters from the gmail for verification of notifications:
        EmailWorker gmailDM = new EmailWorker();
        gmailDM.deleteAllMessages(TestData.EMAIL, TestData.EMAIL_PASSWORD);


        //Enter new Email:
        BrowseFactory.driver.findElement(TestData.newEmailField).sendKeys(TestData.NEW_EMAIL);
        BrowseFactory.driver.findElement(TestData.confirmNewEmailField).sendKeys(TestData.NEW_EMAIL);
        BrowseFactory.driver.findElement(TestData.changeEmailsBtn).click();
        // COnfirmation

        BrowseFactory.driver.switchTo();

        BrowseFactory.driver.findElement(TestData.confirmPassField).sendKeys(TestData.PASS);
          BrowseFactory.driver.findElement(TestData.btnOkConfirm).click();
        // verification of changing e-mail;

       h.isElementPresent(TestData.flashSuccess, 5);
        BrowseFactory.driver.navigate().refresh();

        java.lang.String title = BrowseFactory.driver.findElement(TestData.emailOfUser).getAttribute("title");
        System.out.println(title);

        Assert.assertTrue(title.contains(TestData.NEW_EMAIL), "email is not changed - assert of attribute");


        //verification of new email in user header

        h.isElementPresent(page.myFormsPage.userHeader, 5);
        BrowseFactory.driver.findElement(page.myFormsPage.userHeader).click();
        java.lang.String title2 = BrowseFactory.driver.findElement(TestData.userHeaderEmail).getAttribute("title");
        Assert.assertTrue(title2.contains(TestData.NEW_EMAIL), "email is not changed -> in User header");

        // return back email to previous
        BrowseFactory.driver.findElement(TestData.newEmailField).sendKeys(TestData.EMAIL);
        BrowseFactory.driver.findElement(TestData.confirmNewEmailField).sendKeys(TestData.EMAIL);
        BrowseFactory.driver.findElement(TestData.changeEmailsBtn).click();
        // Confirmation

        BrowseFactory.driver.switchTo();
        BrowseFactory.driver.findElement(TestData.confirmPassField).sendKeys(TestData.PASS);
        BrowseFactory.driver.findElement(TestData.btnOkConfirm).click();

        h.isElementPresent(TestData.flashSuccess, 5);
        // verification of changing e-mail;
        BrowseFactory.driver.navigate().refresh();

        java.lang.String title3 = BrowseFactory.driver.findElement(TestData.emailOfUser).getAttribute("title");
        Assert.assertTrue(title3.contains(TestData.EMAIL), "email is not changed to old");

        //Verification of notifications by e-mail:

        // EmailWorker gmailDM = new EmailWorker();
        File mail = gmailDM.findMessageBySubject(TestData.EMAIL, TestData.EMAIL_PASSWORD, "[PDFfiller] Your email address has been changed!");  //
        Assert.assertTrue(mail != null);

    }



}