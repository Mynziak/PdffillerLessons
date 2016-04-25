package browserfactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchTo extends StaticDriver {
	
	
	
	 public void windowBefore() {
			mwh=driver.getWindowHandle();
	}
	 
	 public void windowAfter() {
			waitForWindowsNumber(2);
			Set s = driver.getWindowHandles();
			//this method will you handle of all opened windows
			Iterator ite = s.iterator();

			while(ite.hasNext())
			{
			    String popupHandle = ite.next().toString();
			    if(!popupHandle.contains(mwh))
			    {
			                driver.switchTo().window(popupHandle);
			                //here you can perform operation in pop-up window**
			    }
			}
			if(SessionInfo.browser.equalsIgnoreCase("IE")){
				 driver.manage().window().maximize();
			}
			
		}
	 
		//Переключиться на главное окно (Сохраненное зарание)
		public void mainWindow() {
			driver.switchTo().window(mwh);
		}
		
		protected boolean waitForWindowsNumber(final int numberOfWindows) {
			 log.log("Ожидаю появления окна");
			 try{
			    new WebDriverWait(driver, 5) {
			    }.until(new ExpectedCondition<Boolean>() {
			        @Override
			        public Boolean apply(WebDriver d) {  
			            return d.getWindowHandles().size() >= numberOfWindows;
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
	

}
