package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

	WebDriver driver;

	@Test
	@Parameters("browser")
	public void setUp(String browser) {
		
		if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\Selenium Related Files\\Slenium Softwares\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();

			// Deleting all the cookies
			driver.manage().deleteAllCookies();

			// Specifiying pageLoadTimeout and Implicit wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// launching the specified URL
			driver.get("https://www.google.com/");

			// Locating the elements using name locator for the text box
			driver.findElement(By.name("q")).sendKeys("BrowserStack Guide");

		} else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Deleting all the cookies
			driver.manage().deleteAllCookies();

			// Specifiying pageLoadTimeout and Implicit wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// launching the specified URL
			driver.get("https://www.google.com/");

			// Locating the elements using name locator for the text box
			driver.findElement(By.name("q")).sendKeys("BrowserStack Guide");

		}

	}

}
