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
public class TestUpload extends BrowseFactory {
    TestData data = new TestData();
    Pages page = new Pages(); //objec
    HelperMethods h = new HelperMethods(); // object for helpers methods

    @Test (enabled =true)
    public void boxUpload() throws InterruptedException {
        BrowseFactory.driver.get(page.mainPage.MAIN_PAGE_URL);
        BrowseFactory.driver.manage().deleteAllCookies();
        BrowseFactory.driver.findElement(page.mainPage.boxBtn).click();
        String mainWindow1 = driver.getWindowHandle(); //remember current window for possibility to back after switching
        BrowseFactory.driver.findElement(page.mainPage.connectBoxBtn).click();
        h.handleMultipleWindows(page.mainPage.BOX_WINDOW_TITLE); //switch to box window

        h.enterText(page.mainPage.loginBoxField,TestData.EMAIL);
        h.enterText(page.mainPage.passBoxField, TestData.EMAIL_PASSWORD);
        h.clickElement(page.mainPage.loginBoxBtn);


        h.isElementPresent(page.mainPage.firstFileInBox, 5);

        BrowseFactory.driver.findElement(page.mainPage.firstFileInBox).isEnabled();
        h.clickElement(page.mainPage.firstFileInBox);

        BrowseFactory.driver.findElement(page.mainPage.selectBoxBtn).isEnabled();
        h.clickElement(page.mainPage.selectBoxBtn);

        driver.switchTo().window(mainWindow1); //return to main window

        h.isElementPresent(data.flashEditor, 20);
        BrowseFactory.driver.navigate().back();
        Assert.assertTrue(BrowseFactory.driver.getCurrentUrl().contains(page.mainPage.MAIN_PAGE_URL_), "something wrong, user is not taken to main page");


    }

    @Test
 public void oneDriveUpload ()
    {

    }

}
