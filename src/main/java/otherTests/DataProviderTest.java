package otherTests;

/**
 * Created by Dima on 29.03.2016.
 */


import browserfactory.BrowseFactory;
import com.sun.jna.platform.win32.Netapi32Util;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
     * Created by lolik on 29.03.2016.
     */
    public class EmailValidationTest extends BrowseFactory {


        public boolean isUrlEquals(String expectedUrl, int sec) throws InterruptedException {
            for(int i = 0; i<sec*10; i++){
                if(driver.getCurrentUrl().equals(expectedUrl)){
                    return true;
                } else {
                    Thread.sleep(100);
                }
            }
            return false;
        }




        String expectedURL = "https://kismia.com/test";



        @DataProvider(name = "emails")
        public Object[][] emails() {
            return new Object[][] {
                    { "jack@sfsaf.sf" },
                    { "ככאכא" },
                    { "³פא³אפ³א" },
                    { "kjksd@gmail.com" },
                    { "asfasfs+212412421@gmail.com" },
                    { "gdgsdg@sfsfq.wf" },
            };
        }





        @Test(dataProvider = "emails")
        public void regWithValidEmail(String email) throws InterruptedException {
            driver.manage().deleteAllCookies();
            driver.get("https://kismia.com/");
//            Netapi32Util.User user = new Netapi32Util.User(email,"qwe1rty");
//            MainPage mainPage = new MainPage(driver);
//            mainPage.registerNewUserByForm(user);
//            Assert.assertTrue(isUrlEquals(expectedURL, 5), "WRONG URL actual: "+driver.getCurrentUrl()+" expected: "+expectedURL);
        }








    }

