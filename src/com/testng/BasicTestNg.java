package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTestNg {
	@BeforeSuite
	public void setUp() {

		System.out.println("set the property correctly");

	}

	@BeforeTest
	public void lanchBrowser() {

		System.out.println("Launch browser");

	}

	@BeforeClass
	public void logIn() {

		System.out.println(" Login to the appp  ");

	}

	@BeforeMethod
	public void enterUrl() {

		System.out.println("enter url");

	}

	@Test
	public void titleVerify() {

		System.out.println("Title verified");

	}

	@AfterMethod
	public void logOut() {

		System.out.println("Log out to the app");

	}

	@AfterClass
	public void closeBrwoser() {

		System.out.println("close browser");

	}

	@AfterTest
	public void deleteAllCookies() {

		System.out.println("delete all cookies");

	}

	@AfterSuite
	public void generateTestReport() {

		System.out.println("Reports Generated");

	}

}
