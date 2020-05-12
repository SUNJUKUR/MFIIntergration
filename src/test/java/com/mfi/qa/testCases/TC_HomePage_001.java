package com.mfi.qa.testCases;

import com.aventstack.extentreports.Status;
import com.mfi.qa.testBase.TestBase;
import com.mfi.qa.testPages.HomePage;
import com.mfi.qa.testPages.LoginPage;
import com.mfi.qa.testUtilities.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_HomePage_001 extends TestBase {
	
	
	HomePage hp ;
	LoginPage lp = new LoginPage(driver);
	public ExtentTest loggers;
	


	@BeforeMethod
	public void setup() {
		driver = TestBase.WebDriverInitialize();
		hp = new HomePage(driver);
		Reporter.log("Browser launched");
		
		
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() throws IOException{
		
		Assert.assertEquals(hp.getHomePageTitle(), Constants.Home_PAGE_TITLE);	
		
	    Reporter.log("Title Verified");
		
	}
		
	
   @Test(priority=2)
	public void loginPresent(){
		Assert.assertTrue(hp.isLoginBtnPresent());	
		logger.info("login button verified");
		Reporter.log("Login Button Verified");
	}
/**
	@Test(priority=3)
	public void logoPresent(){
		Assert.assertTrue(hp.isLogoPresent());
		
	}
	@Test(priority=4)
	public void demoPresent(){
		Assert.assertTrue(hp.isDemoIconPresent());
	}
	
	@Test(priority=5)
	public void clickLogin() {
		hp.goToLoginPage();
	}
	
	*/
	@AfterMethod
	public void closeBrowser(Method method) throws IOException {
		
		String testName=method.getName();
		System.out.println("Test Name :" +testName);
		TestBase.takeScreenshotAtEndOfTest(testName);
		driver.close();
		driver.quit();
		Reporter.log("Browser Closed");
	}
}
