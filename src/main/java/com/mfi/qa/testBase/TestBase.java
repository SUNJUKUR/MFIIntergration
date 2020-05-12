package com.mfi.qa.testBase;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.mfi.qa.testUtilities.ReadConfig;

public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	
	

	public static WebDriver WebDriverInitialize() {
		
		logger = Logger.getLogger("microfocus");
		PropertyConfigurator.configure("Log4j.properties");
		
		String browserName = ReadConfig.getValue("./Configurations\\config.properties", "browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					ReadConfig.getValue("./Configurations\\config.properties", "chromepath"));
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					ReadConfig.getValue("./Configurations\\config.properties", "firefoxpath"));
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					ReadConfig.getValue("./Configurations\\config.properties", "iepath"));
			driver = new FirefoxDriver();
		} else {
			System.out.println(browserName + "is invalid browser");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(ReadConfig.getValue("./Configurations\\config.properties", "url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Driver of TsetBase   " + driver);
		return driver;
	}

	public static void takeScreenshotAtEndOfTest(String tname) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + tname + ".png"));
	}
	/*
	  @AfterClass public static void tearDown() { driver.close(); driver.quit(); }
	 */
	public static void reportLog(String message) {
		
	    logger.info("Message: " + message);
	    Reporter.log(message);
	}

}
