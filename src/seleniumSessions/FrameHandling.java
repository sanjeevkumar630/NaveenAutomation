package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(By.name("username")).sendKeys("batchautomation");

		driver.findElement(By.name("password")).sendKeys("Test@12345");

		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.cssSelector("input[type=submit]")).click();//using css selector

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

	}

}
