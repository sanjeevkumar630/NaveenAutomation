package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDyanamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com");
		
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//*[@id="vContactsForm"]/table/tbody/tr[8]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a
		
		//a[contains(text(),'a b')]/..//preceding-sibling::td//input[@name='contact_id']
		
		
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[1]/input
		//*[@id="vContactsForm"]/table/tbody/tr[7]/td[1]/input
		
		//==================== Method One=====================
		
		/*
		 * String before_xptah="//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		 * 
		 * String after_xpath="]/td[2]/a";
		 * 
		 * for(int i=4; i<=10;i++) { String
		 * name=driver.findElement(By.xpath(before_xptah + i + after_xpath)).getText();
		 * 
		 * if(name.contains("a b")) {
		 * driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr["+i+
		 * "]/td[1]/input")).click(); } }
		 */
		
		
		//=================== Method Two=============================
		
		driver.findElement(By.xpath("//a[contains(text(),'Aman Test')]/..//preceding-sibling::td//input[@name='contact_id']")).click();
		Thread.sleep(10);
		driver.findElement(By.xpath("//a[contains(text(),'david david')]/..//preceding-sibling::td//input[@name='contact_id']")).click();
		
		
		
		
		
		
	}

}
