package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMove {

	WebDriver driver;

	public void moveTo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");

		Thread.sleep(5000);
		Actions actions = new Actions(driver);

		actions.moveToElement(driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']")))
				.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"))).build()
				.perform();
		// Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Member Login'])[2]")).click();

		System.out.println("sanjeev");
		// driver.close();
	}

	public void mouseHover() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");

		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Add-Ons')]"))).build().perform();
		System.out.println("raj");

	}

	public static void main(String[] args) throws InterruptedException {

		MouseMove m1 = new MouseMove();
		m1.mouseHover();
		m1.moveTo();

	}

}
