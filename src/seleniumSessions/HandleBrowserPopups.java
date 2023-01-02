package seleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserPopups {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Windows.html");

		driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows ')]")).click();

		// Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='    click   ']")).click();

		Set<String> handles = driver.getWindowHandles();

		for (String s : handles) {

			String t1 = driver.switchTo().window(s).getTitle();
			driver.switchTo().window(s);

			System.out.println(t1);

			/*
			 * if (t1.contains("SeleniumHQ Browser Automation")) {
			 * driver.findElement(By.xpath("//a[text()='Downloads']")).click(); }
			 */
			
			if(t1.contains("Frames & windows")) {
				driver.close();
			}
		}

	}

}
