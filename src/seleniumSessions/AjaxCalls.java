package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxCalls {
	
	WebDriver driver;

	  @BeforeMethod
	  public void start(){
		  System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	  }

	 @Test
	 public void testGoogleSearch() {
	    // Open google.com
	    driver.get("http://www.google.com");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    // Enter "techlistic selenium tutorials" in google search box
	    driver.findElement(By.name("q")).sendKeys("selenium tutorials");    
	    // Wait for suggestions box to be appear for 20 seconds
	     WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe")));
	    
	    WebElement list = driver.findElement(By.className("erkvQe"));
	    List<WebElement> rows = list.findElements(By.tagName("li"));
	    
	    for(int i=0; i<rows.size();i++) {
	    	
	    		System.out.println(rows.get(i).getText());
	    		if(rows.get(i).getText().contains("selenium tutorial c#")) {
	    		break;
	    	}
	    	
	    }
	    
	    // Iterate over suggestions box and print suggestions one by one
		/*
		 * for (WebElement elem : rows) { System.out.println(elem.getText()); }
		 */
	 }

}
