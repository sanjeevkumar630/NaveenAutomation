package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {

	WebDriver driver;
	String baseUrl = "https://www.selenium.dev/";
	String exp = "";
	String act = "";

	@BeforeTest
	public void lunchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void verifyHomePage() {

		act = driver.getTitle();
		exp = "SeleniumHQ Browser Automation";
		Assert.assertEquals(act, exp);

	}

	@Test
	public void clickOnDownLoads() {
		driver.findElement(By.xpath("//a[text()='Downloads']")).click();
		act = driver.getTitle();
		exp = "Downloads";
		Assert.assertEquals(act, exp);

	}

	@Test
	public void clickOnProjects() {
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		act = driver.getTitle();
		exp = "Selenium Projects";
		Assert.assertEquals(act, exp);

	}

	@Test
	public void clickOnSupport() {
		driver.findElement(By.xpath("//a[text()='Support']")).click();
		act = driver.getTitle();
		exp = "Selenium Support";
		Assert.assertEquals(act, exp);

	}

	@AfterMethod
	public void goBackToHomePage() {

		driver.findElement(By.xpath("//img[@class='logo logo-large']")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
