package seleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToFindBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Related Files\\Slenium Softwares\\chromedriver_win32 (1)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/");

		/*
		 * driver.findElement(By.name("username")).sendKeys("batchautomation");
		 * 
		 * driver.findElement(By.name("password")).sendKeys("Test@12345");
		 * 
		 * driver.findElement(By.xpath("//input[@type='submit']")).click();
		 * 
		 * driver.switchTo().frame("mainpanel");
		 */

		// 1 get the list off all links and images
		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		linksList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Size of all Links and Images=======>" + linksList.size());

		// 2 iterate all the links:: exclude all the links/images -- doesn't have href
		// Attribute

		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for (int i = 0; i < linksList.size(); i++) {

			if (linksList.get(i).getAttribute("href") != null
					&& (!linksList.get(i).getAttribute("href").contains("javascript"))) {

				activeLinks.add(linksList.get(i));

			}

		}

		System.out.println("Size of Active Links========>" + activeLinks.size());

		// 3 check the href url connection

		for (int j = 0; j < activeLinks.size(); j++) {

			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();

			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();

			System.out.println(activeLinks.get(j).getAttribute("href") + "========>" + response);

		}

	}

}
