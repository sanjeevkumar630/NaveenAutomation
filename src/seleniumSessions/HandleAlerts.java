package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();
		// System.out.println("sanjeev");

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		if (text.equals("Please enter a valid user name")) {
			System.out.println("correct alert");

		} else {
			System.out.println("in correct alert");
		}

		alert.accept();
		driver.close();
	}

}
