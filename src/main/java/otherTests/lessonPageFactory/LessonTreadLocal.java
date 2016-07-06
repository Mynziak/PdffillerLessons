package otherTests.lessonPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Dima on 05.07.2016.
 */
public class LessonTreadLocal {  //use it if u wanna run test simultaneously, but driver is static! write it in class with browser
    public static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    String DIR_CHROME ="C:\\chromedriver.exe ";
    public WebDriver driver (){
        return DRIVER.get();
    }

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", DIR_CHROME);
        WebDriver driver = new ChromeDriver();
        DRIVER.set(driver);
    }

    @AfterTest
    public  void afterTest (){
        driver().quit();
    }



}
