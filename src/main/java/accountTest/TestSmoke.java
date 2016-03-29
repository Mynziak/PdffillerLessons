package accountTest;

import browserfactory.BrowseFactory;
import browserfactory.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Pages;

/**
 * Created by DimaM on 9/17/2015.
 */

@Listeners({Listener.class})
public class TestSmoke extends BrowseFactory {
    Pages page = new Pages();
    HelperMethods h = new HelperMethods();
    TestData data = new TestData();

    @Test
    public void login() throws InterruptedException {
      driver.get(TestData.PDFFILLER_COM);
        h.clickElement(page.mainPage.loginBtn);
        h.enterText(page.loginRegisterPage.loginField, TestData.ACCOUNT1);
        h.enterText(page.loginRegisterPage.passField,TestData.ACCOUNT1_PASS );
        h.clickElement(page.loginRegisterPage.loginBtn);
        h.clickElement(page.myFormsPage.userHeader);

        String title2 = BrowseFactory.driver.findElement(TestData.userHeaderEmail).getAttribute("title");
        Assert.assertTrue(title2.contains(TestData.ACCOUNT1), "User is not logged in");
        h.clickElement(page.myFormsPage.userHeader);//close header


        h.clickElement(page.myFormsPage.myBoxTab);// Open first form in flash
       // verify is first form selected
         h.selectFirstForm(page.myFormsPage.firstForm);

        h.clickElement(page.myFormsPage.openActionBtn);
        h.isElementPresent(data.flashEditor, 20);
        BrowseFactory.driver.navigate().back();
        h.isElementPresent(page.myFormsPage.firstForm, 5);
        //
        Assert.assertTrue(BrowseFactory.driver.getCurrentUrl().contains(TestData.URL_MY_FORMS), "user is not returned to My forms");









    }















}
