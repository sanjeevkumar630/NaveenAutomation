package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		 

		driver.manage().window().maximize();
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resizable/");

		driver.switchTo().frame(0);
		js.executeScript("scroll(250,0)");
		WebElement reSize=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		//scrollInToViewByJs(driver, reSize);
		
		
		
		Actions act=new Actions(driver);
		act.moveToElement(reSize).dragAndDropBy(reSize, 200, 200).build().perform();
		
		Thread.sleep(5);
		System.out.println("sanjeev");
	}
	public static void scrollInToViewByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

}
