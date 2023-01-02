package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).sendKeys("Sanjeev");
		Thread.sleep(15);
		String text = driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).getAttribute("title");
        System.out.println(text);

	}

}
