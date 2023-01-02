package seleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptConcept {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://classic.freecrm.com");

		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@145");

		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));

		flash(loginBtn, driver);

		drawBorder(loginBtn, driver);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("D:\\Selenium Naveen\\NaveenAutomation\\src\\seleniumSessions\\crm.png"));

		// genarateAlert("There is No Login Btn", driver);
		clickElementByJs(driver, loginBtn);
		//

		System.out.println(getTitleByJs(driver));

		System.out.println(getinnerTextByJs(driver));

		// scrollPageDownByJs(driver);
		WebElement password = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));

		scrollInToViewByJs(driver, password);
		
		 refreshByJs(driver);

	}

	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");

		for (int i = 0; i < 3; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);

		Thread.sleep(2000);
	}

	public static void drawBorder(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}

	public static void genarateAlert(String message, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public static void clickElementByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void refreshByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String Title = js.executeScript("return document.title;").toString();
		return Title;
	}

	public static String getinnerTextByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String Title = js.executeScript("return document.documentElement.innerText;").toString();
		return Title;
	}

	public static void scrollPageDownByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollInToViewByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public static void clickElementByJs(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

}
