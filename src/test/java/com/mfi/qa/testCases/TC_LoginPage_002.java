package com.mfi.qa.testCases;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.mfi.qa.testBase.TestBase;
import com.mfi.qa.testPages.HomePage;
import com.mfi.qa.testPages.LoginPage;
import com.mfi.qa.testUtilities.ExcelUtil;

public class TC_LoginPage_002 extends TestBase {

	
	HomePage hp;
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() {
		driver = TestBase.WebDriverInitialize();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		hp.goToLoginPage();
		Reporter.log("Browser launched");
		
	}
		
	@Test(priority=1)
	public void LoginCheckTest() {
		lp.loginCheck("Sandeep","1234");
		Reporter.log("Login Succesful");
	}
	
/**
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = ExcelUtil.getTestData("loginsheet");
		Reporter.log("Test data retrievd from data sheet");
		return data;
	}
	
	@Test(priority=2, dataProvider = "getTestData")
	public void LoginCheckTest(String Email,String Password) {
		lp.loginCheck(Email, Password);
		Reporter.log("Login Successful");
	}
	*/
	
	@AfterMethod
	public void closeBrowser(Method method) throws IOException {
	//	TestBase.takeScreenshotAtEndOfTest();
		String testName=method.getName();
		System.out.println("Test Name :" +testName);
		TestBase.takeScreenshotAtEndOfTest(testName);
		driver.close();
		driver.quit();
		Reporter.log("Browser closed");
	}
	
	
}
