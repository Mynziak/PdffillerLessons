package browserfactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MethodsFactory extends StaticDriver {





    protected String loginPageURL = "/en/logout.htm";

    public Object executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }


    protected void disableAdobeFlashPlayerChrome() {
        get("chrome://plugins/");
        click(By.xpath("//*[text()='Adobe Flash Player']/../../../../../..//*[@class='plugin-actions']//a"));
    }




    public SwitchTo switchTo = new SwitchTo();


    public long getCurrentTimestamp() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        return ts.getTime();
    }


    protected void setDriver(WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        System.err.println("Переключаюсь на браузер  " + driver);
    }

    protected String getDomen(String url) {
        String domen = url.replaceAll("http://", "");
        if (domen.contains("/")) {
            domen = domen.substring(0, domen.indexOf("/"));
        }
        if (domen.contains("?")) {
            domen = domen.substring(0, domen.indexOf("?"));
        }
        return domen;
    }


    protected static Random rnd = new Random();

    public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            log.log(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }









    public static void shootWebElement(WebElement element, String name) throws IOException {

        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Point p = element.getLocation();


        int x = p.getX();
        int y = p.getY();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        BufferedImage img = ImageIO.read(screen);

        BufferedImage dest = img.getSubimage(x, y, width, height);

        ImageIO.write(dest, "png", screen);

        File f = null;

        File expectedFile = new File("C:/testScreensoots/expected/" + name + ".png");
        boolean exists = expectedFile.exists();
        if (!exists) {
            System.out.println("Скриншота к элементу не существует, создаю копию скриншота");
            FileUtils.copyFile(screen, expectedFile);
        }


        f = new File("C:/testScreensoots/actual/" + name + ".png");
        FileUtils.copyFile(screen, f);

    }

    public static void shootPageScreen(String name) throws IOException {

        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        BufferedImage img = ImageIO.read(screen);

        ImageIO.write(img, "png", screen);

        File f = null;

        File expectedFile = new File("C:/testScreensoots/expected/" + name + ".png");
        boolean exists = expectedFile.exists();
        if (!exists) {
            System.out.println("Скриншота к элементу не существует, создаю копию скриншота");
            FileUtils.copyFile(screen, expectedFile);
        }


        f = new File("C:/testScreensoots/actual/" + name + ".png");
        FileUtils.copyFile(screen, f);

    }


    /**
     * Вывод информации об Элементе
     *
     * @param element
     * @return
     */
    private String elementDescription(WebElement element) {
        String description = "tag:" + element.getTagName();
        if (element.getAttribute("id") != null) {
            description += " id: " + element.getAttribute("id");
        } else if (element.getAttribute("name") != null) {
            description += " name: " + element.getAttribute("name");
        }

        description += " ('" + element.getText() + "')";

        return description;
    }


    /**
     * Очистить массив drivers
     */
    protected void resetDriver() {
        int i = 1;
        while (drivers[i] != null) {
            drivers[i] = null;
            i++;
        }
    }


    protected void get(String url) {
        try {
            driver.get(url);
            log.log("open URL :  " + url);

        } catch (TimeoutException e) {
            stopLoadingPage();
            // throw e;
        }
    }

    protected void stopLoadingPage() {
        if (browser == Browser.IE) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.stopLoad");
        } else {
            log.error("jsExecutor........StopLoadingPage");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.stop();");
        }
        log.error("Превышено время ожидания загрузки страницы");
    }

    protected boolean docReturnStatement(int sec) {
        System.out.println("проверка document.readyState");
        for (int i = 0; i <= sec; i++) {
            boolean pageStatus;
            try {
                pageStatus = executeScript("return document.readyState").toString().contains("interactive") || executeScript("return document.readyState").toString().contains("complete");
            } catch (WebDriverException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (pageStatus) {
                return true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    protected boolean docReturnStatementComplite(int sec) {
        System.out.println("проверка document.readyState");
        for (int i = 0; i <= sec; i++) {
            boolean pageStatus;
            try {
                pageStatus = executeScript("return document.readyState").toString().contains("complete");
            } catch (WebDriverException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (pageStatus) {
                return true;

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    //Поиск елемента на странице
    protected WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
            //log.log("Элемент найден: "+locator);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.stop();");
            log.error("Превышено время ожидания загрузки страницы findElement");
            // throw e;
        } catch (NoSuchElementException e) {
            log.error("Элемент '" + locator + "' НЕ НАЙДЕН на странице " + driver.getCurrentUrl());
            NoSuchElementException ne = new NoSuchElementException("Елемент '" + locator + "' не нанайден на странице " + driver.getCurrentUrl());
            ne.setStackTrace(e.getStackTrace());
            throw ne;

        }
        return driver.findElement(locator);
    }

    protected String getAttribute(final By locator, final String attribute) {
        try {
            findElement(locator).getAttribute(attribute);
            log.log("Взять аттрибут: " + locator);
        } catch (ElementNotVisibleException e) {
            // "   "+currentLocator == null ? "":currentLocator+
            log.error("Элемент '" + locator + "' НЕ ВИДЕН на странице " + driver.getCurrentUrl());
            ElementNotVisibleException nv = new ElementNotVisibleException("Элемент '" + locator + "' НЕ ВИДЕН на странице " + driver.getCurrentUrl());
            nv.setStackTrace(e.getStackTrace());
            throw nv;
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    try {
                        d.findElement(locator).getAttribute(attribute);
                        return true;
                    } catch (StaleElementReferenceException e) {                      // try again
                        return false;
                    }

                }
            });
        }
        return findElement(locator).getAttribute(attribute);
    }


    protected void click(final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            findElement(locator).click();
            log.log("Клик по элементу: " + locator);
        } catch (TimeoutException e) {
            stopLoadingPage();
            log.error("Превышено время ожидания загрузки страницы after click");
            //log.log("Клик по элементу: "+locator);
            // throw e;
        } catch (ElementNotVisibleException e) {
            wait = new WebDriverWait(driver, 10);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    try {
                        d.findElement(locator).click();
                        return true;
                    } catch (ElementNotVisibleException e) {                      // try again
                        return false;
                    }
                }
            });

					/*
			  // "   "+currentLocator == null ? "":currentLocator+
			  log.error("Элемент '"+locator+"' НЕ ВИДЕН на странице "+driver.getCurrentUrl());
			  ElementNotVisibleException nv = new ElementNotVisibleException("Элемент '"+locator+"' НЕ ВИДЕН на странице "+driver.getCurrentUrl());
			  nv.setStackTrace(e.getStackTrace());
			  throw nv;
			  */
        } catch (StaleElementReferenceException e) {
            wait = new WebDriverWait(driver, 10);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    try {
                        d.findElement(locator).click();
                        return true;
                    } catch (StaleElementReferenceException e) {                      // try again
                        return false;
                    }
                }
            });
        } catch (WebDriverException e) {
            if (e.getMessage().contains("Element is not clickable at point")) {
                wait = new WebDriverWait(driver, 10);
                wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver d) {
                        try {
                            d.findElement(locator).click();
                            return true;
                        } catch (WebDriverException e) {                      // try again
                            return false;
                        }
                    }
                });
            } else {
                throw e;
            }
        }
    }

    public String getText(final By by) {
        try {
            findElement(by).getText();
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    try {
                        d.findElement(by).getText();
                        return true;
                    } catch (StaleElementReferenceException e) {                      // try again
                        return false;
                    }
                }
            });
        }
        return findElement(by).getText();

    }

    protected static void mouseClick(int x, int y) throws AWTException {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    protected static void mouseMove(int x, int y) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
    }

    public String getText(final WebElement element) {
        try {
            element.getText();
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    try {
                        element.getText();
                        return true;
                    } catch (StaleElementReferenceException e) {                      // try again
                        return false;
                    }
                }
            });
        }
        return element.getText();

    }


    /**
     * Сохранить окно
     *
     * @return
     */
    protected String saveWindow() {
        return driver.getWindowHandle();
    }

    /**
     * Переключится на окно исключающее сохраненное(параметр)
     *
     * @param excludeWindow
     */
    protected void switchToWindowExclude(String excludeWindow) {
        waitForWindowsNumber(2);
        Set s = driver.getWindowHandles();
        //this method will you handle of all opened windows
        Iterator ite = s.iterator();

        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(excludeWindow)) {
                driver.switchTo().window(popupHandle);
                //here you can perform operation in pop-up window**
            }
        }
        if (SessionInfo.browser.equalsIgnoreCase("IE")) {
            driver.manage().window().maximize();
        }

    }

    protected void switchToWindowBefore() {
        mwh = driver.getWindowHandle();
    }

    protected void switchToWindowAfter() {
        waitForWindowsNumber(2);
        Set s = driver.getWindowHandles();
        //this method will you handle of all opened windows
        Iterator ite = s.iterator();

        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(mwh)) {
                driver.switchTo().window(popupHandle);
                //here you can perform operation in pop-up window**
            }
        }
        if (SessionInfo.browser.equalsIgnoreCase("IE")) {
            driver.manage().window().maximize();
        }

    }

    //Переключиться на главное окно (Сохраненное зарание)
    protected void switchToWindowMain() {
        driver.switchTo().window(mwh);
    }

    /**
     * Переключится на окно (параметр имя окна)
     *
     * @param window
     */
    protected void switchToWindow(String window) {
        driver.switchTo().window(window);
    }

    protected void switchToNextWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    //Ожидание появления окна (true, false)  ПЕРЕДЕЛАТЬ

    protected boolean waitForWindowsNumber(final int numberOfWindows) {
        log.log("Ожидаю появления окна");
        try {
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
            log.log("Второго окна нет");
            return false;
        }
        // System.out.println("Возврат после блока");
        //return driver.getWindowHandles().size() >= numberOfWindows;
    }

    protected boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (list.size() == 0) {
            log.log("Element is NOT present: " + locator);
            return false;
        } else {
            log.log("Элемент есть на странице: " + locator);
            return list.get(0).isDisplayed();
        }
    }

    protected boolean isElementPresent(By locator, int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (list.size() == 0) {
            log.log("Element is NOT present: " + locator);
            return false;
        } else {
            log.log("Элемент есть на странице: " + locator);
            return waitForIsDisplayed(list.get(0), sec);
        }
    }

    protected boolean waitForIsDisplayed(WebElement element, int sec) {
        for (int i = 0; i <= sec * 10; i++) {
            if (element.isDisplayed()) {
                return true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    protected boolean isElementDisplayed(By locator, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    List<WebElement> list = driver.findElements(locator);
                    if (list.size() == 0) {
                        log.log("Element is NOT present: " + locator);
                        return false;
                    } else {
                        log.log("Элемент есть на странице: " + locator);
                        return list.get(0).isDisplayed();
                    }
                } catch (StaleElementReferenceException e) {                      // try again
                    return false;
                }

            }
        });
        return true;
    }


    //Ожидание элемента 10 сек
    protected void waitFor(final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return driver.findElement(locator);
            }
        });
    }

    //Ожидание элемента N сек
    protected void waitFor(final By locator, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                try {
                    driver.findElement(locator);
                    return driver.findElement(locator);
                } catch (StaleElementReferenceException e) {
                    log.error("catch (StaleElementReferenceException e)");
                    return driver.findElement(locator);
                }

            }
        });
    }

    protected boolean waitFor(final Boolean bool) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    return bool;
                } catch (StaleElementReferenceException e) {
                    return false;
                }

            }
        });
        return bool;
    }


    protected boolean waitFor(final Boolean bool, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    return bool;
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            }
        });
        return bool;
    }



    //Наведение на элемент
    protected void hoverOver(By locator) {
        Actions builder = new Actions(driver);
        Actions hoverOverRegistrar = builder.moveToElement(driver.findElement(locator));
        hoverOverRegistrar.build().perform();
    }

    //Наведение и Клик
    protected void hoverOver(By hoverLocator, final By clickLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions builder = new Actions(driver);
        Actions hoverOverRegistrar = builder.moveToElement(driver.findElement(hoverLocator));
        hoverOverRegistrar.build().perform();
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return driver.findElement(clickLocator);
            }
        });
        driver.findElement(clickLocator).click();
    }

    protected void switchToVkontakteFrame() {
        driver.switchTo().frame(driver.findElement(By.xpath("//div[4]/div/iframe")));
    }

    protected void switchToFacebookFrame() {
        driver.switchTo().frame("iframe_canvas");
    }

    //Генерация рандомного числа с заданием диапазона и +1
    protected int getRandomInt(int g) {
        int i;
        i = rnd.nextInt(g) + 1;
        return i;
    }

    protected String getRandomString(int len) {
        final String AB = "!@#$%^&*()_+;:?";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    /**
     * Очистка и ввод символов в поле
     *
     * @param locator
     * @param text
     */
    protected void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Скрол к елементу
     *
     * @param locator елемент к которому скролится
     * @param x       - смещение по шырыне относительно заданного елемента
     * @param y       - смещение по высоте относительно заданного елемента
     */
    protected void scrollToElement(By locator, int x, int y) {
        Reporter.log("Скролимся к елементу " + locator);
        String code = "window.scroll("
                + (findElement(locator).getLocation().x + x) + ","
                + (findElement(locator).getLocation().y + y) + ");";

        ((JavascriptExecutor) driver).executeScript(code, findElement(locator),
                x, y);
    }


    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Скролит страницу вне звисимости от елементов
     * +value - скрол вверх
     * -value - скрол вниз
     *
     * @param value
     */
    protected void scrollPage(int value) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0," + value + ")", "");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            //exception handling
        }
    }

    public void autorizationAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.authenticateUsing(new UserAndPassword("root", "letmein"));
        } catch (Exception e) {
            //exception handling
        }
    }


    public boolean waitForUrlContains(String text, int sec) {
        for (int i = 0; i <= sec; i++) {
            if (driver.getCurrentUrl().contains(text)) {
                return true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    protected boolean docReturnIsPagesLoaded(int sec) {
        System.out.println("проверка isPagesLoaded");
        for (int i = 0; i <= sec * 10; i++) {
            boolean pageStatus = false;
            try {
                pageStatus = executeScript("return document['pdfForms'].isPagesLoaded()").toString().contains("true");
                System.out.println(pageStatus);
            } catch (WebDriverException e) {
                System.out.println(e.getMessage());
            }
            if (pageStatus) {
                return true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected boolean waitUntilPageLoaded() {
        int time = 60;
        System.out.println(("Waiting [" + time + "] sec until page is loaded"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
                }
            });
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }




    public static String getCurrentDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

}
