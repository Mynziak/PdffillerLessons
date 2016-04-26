package interfacesLesson.homework;

import browserfactory.BrowseFactory;
import interfacesLesson.IRegForm;
import interfacesLesson.RegForm;
import interfacesLesson.RegForm5;
import interfacesLesson.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Dima on 25.04.2016.
 */
public class HomeWorkInterface extends BrowseFactory{


    //PdffillerRegForm pdffillerRegForm = new PdffillerRegForm();
    User user = new User("dsdsd@dsdf.ds", "1");
    User userWithName = new User ("dsdsd@dsdf.dis", "1", "Jack");


    @Test(dataProvider = "regForms")
    public void asfs(String url, IRegFormHomeWork regForm) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(url);
        regForm.registerNewUser(userWithName);
        Assert.assertTrue(regForm.isRegSuccess(), "Registration is not success");
    }



    @DataProvider(name="regForms")
    public Object[][] regForms() {
        return new Object[][] {
                { "https://www.pdffiller.com/en/login.htm", new PdffillerRegForm() },
                { "https://kismia.com/#registration", new ComKissmiaRegForm() },
                { "http://kismia.ru/#registration",  new RuLoveeto()  },
                { "http://loveeto.ru/", new RuLoveeto() },
                { "http://vk.com/", new ComVkRegForm()},
//                { "https://www.facebook.com/", new RegForm5(driver) },
//                { "http://oneamour.com/", new RegForm5(driver) }

        };
    }

}
