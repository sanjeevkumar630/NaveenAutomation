package com.datadriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.TestUtil;

public class HalfEbayTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Related Files\\Selenium Naveen\\NaveenAutomation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F&acntType=business&_trksid=p2052190.l44594");

	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
		
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData",priority = 1)
	public void halfEbayTest(String businessname, String businessemail, String reenteremail, String password,
			String phone) {

		driver.findElement(By.name("businessname")).clear();
		driver.findElement(By.name("businessname")).sendKeys(businessname);

		driver.findElement(By.name("businessemail")).clear();
		driver.findElement(By.name("businessemail")).sendKeys(businessemail);

		driver.findElement(By.name("rbusinessemail")).clear();
		driver.findElement(By.name("rbusinessemail")).sendKeys(reenteremail);

		driver.findElement(By.name("PASSWORD_BIZREG")).clear();
		driver.findElement(By.name("PASSWORD_BIZREG")).sendKeys(password);

		driver.findElement(By.name("phoneFlagComp1Business")).clear();
		driver.findElement(By.name("phoneFlagComp1Business")).sendKeys(phone);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
