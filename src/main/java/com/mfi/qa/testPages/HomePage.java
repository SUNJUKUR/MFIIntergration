package com.mfi.qa.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.mfi.qa.testBase.TestBase;
import com.mfi.qa.testUtilities.ElementUtil;



public class HomePage extends TestBase {
	
	//public WebDriver driver = TestBase.WebDriverInitialize(ReadConfig.getValue("./Configurations\\config.properties", "browser"));;
	ElementUtil el ;
	
	//1.Page objects/elements
	
	By loginButn = By.xpath("//a[@class='login log']");
	By logo = By.xpath("//img[@class='brand']");
	By Demo = By.xpath("//li[1][@class ='has-drop']/a/span");
	
	
	//2.constructor
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		el = new ElementUtil(driver);
		
		
	}
	
	//3.page actions to perform
	
	public String getHomePageTitle(){
		return el.getTittleExplicit();
		
		
	}
	
	public boolean isLoginBtnPresent(){
		
		return el.isDisplayed(loginButn);
	}
	
	public boolean isLogoPresent(){
		
	    return el.isDisplayed(logo)	;
	}
	public boolean isDemoIconPresent(){
		
		return el.isDisplayed(Demo);
		
	}
	
   public LoginPage goToLoginPage() {
	   el.doClick(loginButn);
	   return new LoginPage(driver);
   }
	
}
