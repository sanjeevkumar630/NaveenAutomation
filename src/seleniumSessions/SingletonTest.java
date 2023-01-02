package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		SingletonDriverInit instanceDriver = SingletonDriverInit.getInstance();
		driver = instanceDriver.openBrowser();

	}

	@Test
	public void testMethod() {
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
