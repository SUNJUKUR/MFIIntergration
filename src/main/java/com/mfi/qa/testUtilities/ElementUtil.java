package com.mfi.qa.testUtilities;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.mfi.qa.testBase.TestBase;

public class ElementUtil extends TestBase {

	/**
	 * Method to find Element on webpage
	 * 
	 * @param driver
	 */

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
            System.out.println(driver);
			WebDriverWait w = new WebDriverWait(driver, 15);
			w.until(ExpectedConditions.elementToBeClickable(locator));
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Exception Occured");
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * This is method to click on any web element.
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			Reporter.log("click on the element");
			getElement(locator).click();
		} catch (Exception e) {
			Reporter.log("Exception occured while clicking on the element");
			System.out.println("Exception Occured");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * this is the method for send keys
	 * 
	 * @param locator
	 * @param value
	 */
	public void sendKeys(By locator, String value) {
		try {
			Reporter.log("send key value");
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			Reporter.log("Exception occured while sending key");
			System.out.println("Exception Occured");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to get the text of a web element
	 * 
	 * @param locator
	 */
	public String getText(By locator) {
		try {
			Reporter.log("get the text");
			return getElement(locator).getText();
		} catch (Exception e) {
			Reporter.log("Exception occured while retriving text");
			System.out.println("Exception Occured while fetching text of element");
			System.out.println(e.getMessage());
			return null;

		}
	}

	public String getTittleExplicit() {
		
		Reporter.log("Get page Title");
		String title = driver.getTitle();
		System.out.println("Inside Util : Page title" + title);
		return title;
	}

	public boolean isDisplayed(By locator) {
		try {
			
			Reporter.log("Check element isDisplayed");
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Exception Occured while fetching element");
			Reporter.log("Exception while checking element isDisplayed");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public WebElement explicitWait(By locator, int TimeOuts) {
		WebDriverWait w = new WebDriverWait(driver, TimeOuts);
		WebElement element1 = w.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element1;
	}

	public void windowHandleHelper(int index) {
		Reporter.log("Moved to new window");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);
		System.out.println(tabs.size());
		for (int i = 0; i < tabs.size(); i++) {
			if (i == index) {

				driver.switchTo().window(tabs.get(i));
				System.out.println(driver.getTitle());
			}

		}

	}

	public void switchToFrame(By locator) {
		
		Reporter.log("Moved to frame");
		int numberOfTags = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
		driver.switchTo().frame(getElement(locator));
		System.out.println("inside switch method");
		
	}
	
	public void dropDownHandler() {
		
	}

}
