package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDyanamicCalender {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(By.name("username")).sendKeys("batchautomation");

		driver.findElement(By.name("password")).sendKeys("Test@12345");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.xpath("//a[text()='Calendar']")).click();
		
		//driver.switchTo().frame("mainpanel");
		
		Thread.sleep(3000);
		String date="29-March-2022";
		String dateArr[]=date.split("-");
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];

		Select select=new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Thread.sleep(3000);
		
		Select select1=new Select(driver.findElement(By.name("slctYear")));
		select.selectByVisibleText(year);
		
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]
		
		String before_xpath="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		
		String after_xpath="]/td[";
		
		 final int toatalWeekDays=7;
		 
		 boolean flag=false;
		 
		 for(int rows=2;rows<=6;rows++)
		 {
			 for(int columns=1;columns<=toatalWeekDays;columns++)
			 {
				 String dayval=driver.findElement(By.xpath(before_xpath+rows+after_xpath+columns+"]")).getText();
				 
				 System.out.println(dayval);
				 
				 if(dayval.equals(day)) {
					 
					 driver.findElement(By.xpath(before_xpath+rows+after_xpath+columns+"]")).click();
					 
					 flag=true; 
					 break;
					 
				 }
			 }
			 if(flag)
			 {
				 break;
			 }
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
