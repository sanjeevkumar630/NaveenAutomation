package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("java");

		// ul[@role='listbox']//li/descendant::div/span

		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div/span"));

		System.out.println("Total sugesstion liks for java======:" + list.size());

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("javascript")) {
				list.get(i).click();
				break;
			}

		}
	}
}
