package LessonExams;



import browserfactory.BrowseFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Dima on 10.06.2016.
 */

public class TestNgLes extends BrowseFactory {
    public void aTest() {
    }

    public void bTest() {
    }

    @Test
   @Parameters({"email", "password"})
    public void loginTest(@Optional("my@email") String email, @Optional("qwe") String pasword) {
    System.out.println(""+email+" "+pasword);
    }

}
