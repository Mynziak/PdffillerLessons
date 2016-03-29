package accountTest;

import browserfactory.BrowseFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by DimaM on 8/28/2015.
 */
public class HelperMethods extends BrowseFactory {

    Pages page = new Pages();

    public  boolean isElementPresent(By locator, int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        List<WebElement> list =driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (list.size() == 0) {
            return false;
        } else {
            return list.get(0).isDisplayed();
        }
    }


    public void handleMultipleWindows(String windowTitle) {
        waitForWindowsNumber(2);
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(windowTitle)) {
                return;
            }
        }
    }


    public  boolean waitForWindowsNumber(final int numberOfWindows) {
        System.out.println("Ожидаю появления окна");
        try{
            new WebDriverWait(driver, 5) {
            }.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.getWindowHandles().size() == numberOfWindows;
                }

            });
            System.out.println("ПОСЛЕ ОЖИДАНИЯ В БЛОКЕ ТРАЙ");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Второго окна нет");
            return false;
        }
        // System.out.println("Возврат после блока");
        //return driver.getWindowHandles().size() >= numberOfWindows;
    }

         public  void selectFirstForm (By locator) {
        isElementPresent(locator,5);
        if (!driver.findElement(locator).isSelected()) {
            driver.findElement(locator).click();
                }
            }

    public void clickElement (By locator) {

        isElementPresent(locator, 7);
        driver.findElement(locator).isDisplayed();
        driver.findElement(locator).click();
    }

    public void enterText (By locator, String text){
        isElementPresent(locator, 7);
        driver.findElement(locator).isDisplayed();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }
}
