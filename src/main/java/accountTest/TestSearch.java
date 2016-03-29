package accountTest;

import browserfactory.BrowseFactory;
import browserfactory.Listener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Pages;

/**
 * Created by DimaM on 9/18/2015.
 */

@Listeners({Listener.class})
public class TestSearch extends BrowseFactory {
    HelperMethods h = new  HelperMethods();
    Pages page = new Pages();

    @BeforeClass
    public void todoBeforeTests()  {
        //open My Account page
        BrowseFactory.driver.manage().deleteAllCookies();
        BrowseFactory.driver.get(TestData.URL_LOGIN_REGISTRATION);
        BrowseFactory.driver.findElement(page.loginRegisterPage.loginField).clear();
        BrowseFactory.driver.findElement(page.loginRegisterPage.loginField).sendKeys(TestData.ACCOUNT1);
        BrowseFactory.driver.findElement(page.loginRegisterPage.passField).clear();
        BrowseFactory.driver.findElement(page.loginRegisterPage.passField).sendKeys(TestData.ACCOUNT1_PASS);

        BrowseFactory.driver.findElement(page.loginRegisterPage.loginBtn).click();

    }


    @Test
    public void searchText()throws InterruptedException{
        //BrowseFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(h.isElementPresent(page.myFormsPage.searchBtn, 10), "Search button is absent");
        BrowseFactory.driver.findElement(page.myFormsPage.searchBtn).click();

    }

}
