package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {

	public static void main(String[] args) {
		//Setting system properties of EdgeDriver
		System.setProperty("webdriver.edge.driver", "D:\\Selenium Related Files\\Slenium Softwares\\edgedriver_win64\\msedgedriver.exe");

		//Creating an object of EdgeDriver
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		//Deleting all the cookies
		driver.manage().deleteAllCookies();

		//Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//launching the specified URL
		driver.get("https://www.google.com/");

		//Locating the elements using name locator for the text box
		driver.findElement(By.name("q")).sendKeys("BrowserStack Guide");

		// locator for Google search button
		WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();
		

	}

}
