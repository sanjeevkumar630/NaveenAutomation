package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DrogandDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		// https://jqueryui.com/slider/
		// driver.switchTo().frame(0);
		// System.out.println("raj");
		Actions action = new Actions(driver);
		Thread.sleep(5);

		action.clickAndHold(driver.findElement(By.cssSelector("div#box2")))
				.moveToElement(driver.findElement(By.id("box103"))).release().build().perform();

		/*
		 * WebElement src=driver.findElement(By.id("box1")); WebElement
		 * dest=driver.findElement(By.id("box103")); action.dragAndDrop(src,
		 * dest).build().perform();
		 */

		// new Actions(driver).dragAndDrop(new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(By.id("draggable"))), new
		// WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(By.id("droppable")))).build().perform();

	}

}
