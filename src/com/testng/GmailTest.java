package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailTest {

	@Test

	@Parameters({ "url", "emailid", "password" })

	public void logInTest(String url, String emailid, String password) {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(url);

		driver.findElement(By.id("email")).sendKeys(emailid);
		driver.findElement(By.id("pass")).sendKeys(password);

	}
}
