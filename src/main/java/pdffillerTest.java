import browserfactory.BrowseFactory;
import org.testng.annotations.Test;

/**
 * Created by DimaM on 7/23/2015.
 */
public class pdffillerTest extends BrowseFactory {


    @Test
    public void pdfTest() throws InterruptedException {

        driver.get("http://pdffiller.com");
        Thread.sleep(5000);


    }




}
