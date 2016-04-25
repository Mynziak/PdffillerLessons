package browserfactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class StaticDriver {
	
	protected Log log = new Log();
	
	protected static WebDriver myDriver;
	protected static WebDriver[] drivers = new WebDriver[6];
	public static EventFiringWebDriver driver;
	
	protected static String mwh; //Main Window handle
	public static Browser browser;
}
