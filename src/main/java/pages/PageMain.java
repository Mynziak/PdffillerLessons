package pages;

import org.openqa.selenium.By;

/**
 * Created by DimaM on 9/16/2015.
 */
public class PageMain {


    public static final String MAIN_PAGE_URL = "https://www.pdffiller.com/";
    public static final String BOX_WINDOW_TITLE ="Customer Log In | Box";
    public static final String MAIN_PAGE_URL_ = "pdffiller.com";


    public By uploadDocumentBtn = By.xpath("//a [@href ='#uploadDocument']");
    public By boxBtn = By.xpath("//a [@href ='#load-box']");
   public By connectBoxBtn = By.xpath("//button [@class='new-btn btn--orange'and contains(.,'Connect to Box')] ");
    public By loginBtn = By.xpath("//a [@href='https://www.pdffiller.com/en/login.htm']");
    public By loginBoxField = By.id("login");
    public By passBoxField = By.id("password");
    public By loginBoxBtn = By.id("continue");
    public By firstFileInBox = By.xpath("//input[@class='item-selector' and @name ='f_37592747362']");
    public By selectBoxBtn = By.id("item-selected-counter");


}
