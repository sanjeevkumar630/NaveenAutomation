package seleniumSessions;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropRead {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		Properties prop = new Properties();

		FileInputStream fip = new FileInputStream(
				"D:\\Selenium Naveen\\NaveenAutomation\\src\\seleniumSessions\\config.prop");

		prop.load(fip);

		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));

		String url = prop.getProperty("url");

		System.out.println(url);

		String browsername = prop.getProperty("browser");
		System.out.println(browsername);

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		else if (browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Slenium Softwares\\chromedriver_win32\\gecko.exe");

			driver = new FirefoxDriver();

		}

		driver.get(url);

		Thread.sleep(3000);

		driver.findElement(By.name(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("firstname"));
		Thread.sleep(3000);
		driver.findElement(By.name(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("lastname"));

	}

}
