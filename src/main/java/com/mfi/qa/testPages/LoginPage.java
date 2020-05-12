package com.mfi.qa.testPages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mfi.qa.testBase.TestBase;
import com.mfi.qa.testUtilities.ElementUtil;

public class LoginPage extends TestBase{
	
	WebDriver driver;
	ElementUtil el;

	//1.Page elements
	
	By email = By.id("inputEmail");
	By password = By.id("inputPassword");
	By login = By.xpath("//input[@id='login']");
	By iframes = By.xpath("//iframe[@role='presentation']");
	By checkBox = By.xpath("//div[class ='recaptcha-checkbox-border']");
	
	//2.constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		el = new ElementUtil(driver);
	}
	
	//3.page opeations to perform
	
	public void loginCheck(String Email, String Password) {
		el.windowHandleHelper(1);
		el.sendKeys(email, Email);
		el.sendKeys(password, Password);
		//switoframe
		/*el.switchToFrame(iframes);
		System.out.println("Back in loincheck() method");
		el.doClick(checkBox);
		System.out.println("Back in loincheck() method");
		el.doClick(login);*/
		
	
	}
}
