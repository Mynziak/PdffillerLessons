package pages;

import org.openqa.selenium.By;

/**
 * Created by DimaM on 9/18/2015.
 */
public class PageMyForms {

   // public static final String MAIN_PAGE_URL = "https://www.pdffiller.com/";
public final String PROJECT_URL = "en/project";




    public By searchBtn = By.id("btn_view_search_form");
   public By userHeader = By.id("user_logo_thumb_header");
    public By firstForm= By.xpath("//tr [@data-n='1']");
   // public By firstFormIsSelected = By.xpath("//tr [@data-n='1' and @class='draggable p-index-1  ui-draggable active']");
    public By openActionBtn = By.id("btn_action_fill");
    public By flashEditor = By.id("_HOSTNAME");
    public By myBoxTab = By.id("fnamemy_docs");
}
