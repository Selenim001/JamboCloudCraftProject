package com.qa.jambocloud.utils;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver browserDriver;
	
	public ElementUtil(WebDriver browserDriver) {
		this.browserDriver = browserDriver;
	}
	
	/**
	 * This method helps in find an element on the page 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		try{
		WebElement element = browserDriver.findElement(locator);
		return element;
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This method helps to enter any value into the input box
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	/**
	 * This method helps to click on specific WebElement
	 * @param locator
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	/**
	 * This method helps to find the URL contains fraction value or not
	 * @param urlFraction
	 * @param timeOut
	 * @return
	 * @throws TimeoutException
	 */
	public String waitForURLContains(String urlFraction, int timeOut) throws TimeoutException {
		
		WebDriverWait wait = new WebDriverWait(browserDriver, Duration.ofSeconds(timeOut));
		
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return browserDriver.getCurrentUrl();
		}
		return browserDriver.getCurrentUrl();
	}
	
	/**
	 * An expectation for checking that an element is displayed on the DOM of a page 		
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {
		try {
		boolean flag = getElement(locator).isDisplayed();
		System.out.println("element is displayed" + locator);
		return flag;}
		catch(NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This method is used to enter the value in the text field with a pause of 500 ms(By default). 
	 * @param locator
	 * @param value
	 * @param pauseTime
	 */
	
	public void doActionSendKeysWithPause(By locator, String value, long pauseTime) {
		Actions act = new Actions(browserDriver);
		char ch[] = value.toCharArray();	
		for(char c : ch) {
			act.sendKeys(browserDriver.findElement(locator), String.valueOf(c)).pause(pauseTime).perform();
		}
	}
	
	/**
	 * An expectation for checking that all elements present on web page that match the locator are visible.
	 * Visibility means that elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator
	 * @param	 timeOut
	 * @return
	 */
	public List waitForVisibilityOfElementsLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(browserDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}