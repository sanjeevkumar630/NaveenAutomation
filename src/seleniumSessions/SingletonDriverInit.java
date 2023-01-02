package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriverInit {

	private static SingletonDriverInit instanceDriver = null;

	private WebDriver driver;

	private SingletonDriverInit() {

	}

	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static SingletonDriverInit getInstance() {
		
		if(instanceDriver==null)
			instanceDriver=new SingletonDriverInit();
		return instanceDriver;
		
	}

}
