package browserfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class DriverListener extends AbstractWebDriverEventListener {

	
	
	
	
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.print("Поиск элемента : "
				+ by);
	 }
	
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		 System.out.println(" .....................OK");
	  }

	 @Override
	    public void beforeNavigateTo(String url, WebDriver driver) {
	        System.out.print("Переход на '" + url + "'");
	    }

	 @Override
	    public void afterNavigateTo(String url, WebDriver driver) {
	  System.out.println(".....................OK");
	    }
	 
	    @Override
	    public void beforeClickOn(WebElement element, WebDriver driver) {
	        System.out.print("Клик по елементу - "
	                            + elementDescription(element));
	    }
	    
	    @Override
	    public void afterClickOn(WebElement element, WebDriver driver) {
	       System.out.println(".....................OK");
	    }
	 
	    @Override
	    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
	        System.out.print("Изменение значение елемента - "
	                            + elementDescription(element));
	    }
	 
	    @Override
	    public void afterChangeValueOf(WebElement element, WebDriver driver) {
	     System.out.println(".....................OK");
	    }
	 
	    private String elementDescription(WebElement element) {
	        String description = "tag:" + element.getTagName();
	        if (element.getAttribute("id") != null) {
	            description += " id: " + element.getAttribute("id");
	        }
	        else if (element.getAttribute("name") != null) {
	            description += " name: " + element.getAttribute("name");
	        }
	         
	        description += " ('" + element.getText() + "')";

	         
	        return description;
	    }
}
