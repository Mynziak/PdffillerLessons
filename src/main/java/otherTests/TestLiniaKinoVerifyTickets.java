package otherTests;

import browserfactory.BrowseFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Dima on 21.03.2016.
 */
public class TestLiniaKinoVerifyTickets extends BrowseFactory {

    private By date_seans = By.xpath("//div[@class='day-block showtime-day']//*[@class='vkino-link in-3d show actual']");

    @Test
    public void getPrice() {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        // driver.
//        h.enterText(emailField, "dmitry.m+6@pdffiller.com");
//        h.enterText(passField, "111");
//        h.clickElement(logInOrangeBtn);


    }
}