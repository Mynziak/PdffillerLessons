package LessonExams;

import browserfactory.BrowseFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Dima on 07.06.2016.
 */
public class TestLogin extends BrowseFactory {

    @DataProvider(name = "pages")
    public Object[][] pages() {
        return new Object[][]{
                {new PdffillerPage(), "dmitry.m@pdffiller.com", "1"},
                {new FaceBookPage(), "boomer.boomersgroup@gmail.com", "dataedu1"},
        };
    }


    @Test (dataProvider = "pages")
    public void tryLogin(AbstractLogin login, String email, String password) {
        // AbstractLogin login = new PdffillerPage();
       // login.login("", "");
        login.login(email,password );
    }
}
