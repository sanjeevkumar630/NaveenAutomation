package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://classic.freecrm.com");

		boolean b1 = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed();

		System.out.println(b1);

		/*
		 * boolean b2 = driver.findElement(By.name("username")).isEnabled();
		 * 
		 * System.out.println(b2);
		 */

		driver.navigate().to("https://register.freecrm.com/register/");

		boolean b2 = driver.findElement(By.id("terms")).isSelected();

		System.out.println(b2);

		driver.findElement(By.id("terms")).click();
		
		boolean b3 = driver.findElement(By.id("terms")).isSelected();

		System.out.println(b3);
	}

}
