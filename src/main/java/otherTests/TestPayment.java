package otherTests;

import accountTest.HelperMethods;
import browserfactory.BrowseFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by DimaM on 11/5/2015.
 *
 */


public class TestPayment extends BrowseFactory {

    public By emailField =By.id("form-login-email");
    public By passField =By.id("form-login-password");
    public By logInOrangeBtn=By.id("form-login-submit");

    HelperMethods h = new HelperMethods();
    @Test
    public void login(){
        driver.get("https://www.pdffiller.com/en/login.htm");
       // driver.
        h.enterText(emailField, "dmitry.m+6@pdffiller.com");
        h.enterText(passField, "111");
        h.clickElement(logInOrangeBtn);


    /*    h.clickElement(page.myFormsPage.userHeader);

        String title2 = BrowseFactory.driver.findElement(TestData.userHeaderEmail).getAttribute("title");
        Assert.assertTrue(title2.contains(TestData.ACCOUNT1), "User is not logged in");
        h.clickElement(page.myFormsPage.userHeader);//close header */

    }

    @Test
    public void checkServicesPage (){

    }

    @Test
    public void checkSupportPage (){

    }

    @Test
    public void checkMyFormsPage (){

    }


}
