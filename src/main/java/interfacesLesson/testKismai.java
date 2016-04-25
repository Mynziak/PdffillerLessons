package interfacesLesson;

import browserfactory.BrowseFactory;
import browserfactory.MethodsFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Dima on 22.04.2016.
 */
public class testKismai  extends BrowseFactory{

RegForm5 regForm5 = new RegForm5(driver);
User use = new User("dsdsd@dsdf.ds", "1");

   //@Test
    public void tws() {
        RegForm5 regForm5 = new RegForm5(driver);
        get("https://kismia.com/#registration");
        regForm5.registerNewUser(use);
    }

    @Test
    public void reg12 (){
        RegForm regForm = new RegForm(driver);
        get("http://kismia.ru/");
        regForm.registerNewUser(use);
    }




    @DataProvider(name="regForms")
    public Object[][] regForms() {
        return new Object[][] {
                { "https://kismia.com/#registration", new RegForm5(driver) },
                { "https://kismia.com/#registration", new RegForm5(driver) },
        };
    }

}
