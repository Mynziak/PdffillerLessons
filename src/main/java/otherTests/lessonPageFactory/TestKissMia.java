package otherTests.lessonPageFactory;

import browserfactory.BrowseFactory;
import org.testng.annotations.Test;

/**
 * Created by Dima on 05.07.2016.
 */
public class TestKissMia extends BrowseFactory {

    @Test
    public void testKiss() {
        KissMiaLoginPage kissMiaLoginPage = new KissMiaLoginPage(driver);
        driver.get("https://kismia.com/#sign_up");
        waitUntilPageLoaded();
        kissMiaLoginPage.email.sendKeys("dmitry.m@pdffiller.com");
        kissMiaLoginPage.password.sendKeys("111111");
        kissMiaLoginPage.submit.click();
    }
}
