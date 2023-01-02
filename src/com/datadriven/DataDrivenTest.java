package com.datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;



public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		  System.setProperty("webdriver.chrome.driver", "D:\\Slenium Softwares\\chromedriver_win32\\chromedriver.exe"); 
		  WebDriver driver = new ChromeDriver(); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		  driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F&acntType=business&_trksid=p2052190.l44594");
		 
		
		Xls_Reader reader=new Xls_Reader("D:\\Selenium Naveen\\NaveenAutomation\\src\\com\\testdata\\Data.xlsx");
		int rowcount=reader.getRowCount("Register");
		System.out.println(rowcount);
		
		reader.addColumn("Register", "status");
		
		for(int rowNum=2;rowNum<=rowcount;rowNum++) {
			
			String businessname=reader.getCellData("Register", "businessname", rowNum);
			System.out.println(businessname);
			
			String businessemail=reader.getCellData("Register", "businessemail", rowNum);
			System.out.println(businessemail);
			
			String reenteremail=reader.getCellData("Register", "reenteremail", rowNum);
			System.out.println(reenteremail);
			
			String password=reader.getCellData("Register", "password", rowNum);
			System.out.println(password);
			
			String phone=reader.getCellData("Register", "phone", rowNum);
			System.out.println(phone);
			
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
			
			Thread.sleep(3000);			
			
			reader.setCellData("Register", "status", rowNum, "pass");
			
			
		}

		

	}

}
