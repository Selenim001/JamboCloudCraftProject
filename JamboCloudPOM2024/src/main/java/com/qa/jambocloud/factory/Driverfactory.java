package com.qa.jambocloud.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.jambocloud.constants.AppConstants;
import com.qa.jambocloud.errors.AppError;
import com.qa.jambocloud.exceptions.BrowserException;

public class Driverfactory {
	
	WebDriver browserDriver;
	Properties browserProperties;
	
	/**
	 * This is used to init the browserDriver on the basis of given browser name.
	 * @param browserName
	 */
	
	public WebDriver initDriver(Properties browserProperties) {
		
		String browserName = browserProperties.getProperty("browser");

		System.out.println("browser name is : " + browserName);
			
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			browserDriver = new ChromeDriver();
			break;
		case "firefox":
			browserDriver = new FirefoxDriver();
			break;
		case "edge":
			browserDriver = new EdgeDriver();
			break;
		case "safari":
			browserDriver = new SafariDriver();
			break;

		default:
			System.out.println("please pass the right browser : " + browserName);
			throw new BrowserException(AppError.BROWSER_NOT_FOUND);
		}
		
		browserDriver.manage().deleteAllCookies();
		browserDriver.manage().window().maximize();
		browserDriver.get(browserProperties.getProperty("url"));
		return browserDriver;
	}
	
	/**
	 * This is used to init the properties from the .properties file.
	 * @return this return properties(prop)
	 */
	
	public Properties initProp() {
		
		browserProperties = new Properties();
		try {
			FileInputStream ip = new FileInputStream(AppConstants.CONFIG_FILE_PATH);
			browserProperties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return browserProperties;
	}
}