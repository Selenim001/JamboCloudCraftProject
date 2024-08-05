package com.qa.jambocloud.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.jambocloud.utils.ElementUtil;
import com.qa.jambocloud.utils.TimeUtil;
import com.qa.jambocloud.constants.AppConstants;

public class LoginPage {
	
	private WebDriver browserDriver;
	private ElementUtil eleUtil;
	
	//1. Page Objects: By locators -> All By locator should be private
	
	private By userName = By.id("user-name");
	private By userPassword = By.id("user-password");
	private By submitBtn = By.xpath("//input[@value='Submit']");
    	
	// 2. public constr... of the page
	
	public LoginPage(WebDriver browserDriver) {
		this.browserDriver = browserDriver;
		eleUtil = new ElementUtil(browserDriver);
	}
	
	public String getLoginPageURL() throws TimeoutException {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME);
		System.out.println("login page url : " + url);
		return url;
	}
	
	public TasksPage doLogin(String username,String pwd) {
		eleUtil.doActionSendKeysWithPause(userName, username, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.doSendKeys(userPassword, pwd);
		eleUtil.doClick(submitBtn);
		return new TasksPage(browserDriver);
	}
}