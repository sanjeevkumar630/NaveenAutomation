package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowseTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("window-size=1400,800");
		
		options.addArguments("headless");
		
		
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");

		driver.findElement(By.id("btndropdown")).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@class='dropdown-menu']//li//label[@class='radio-btn']"));

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());
		}

	}
}
