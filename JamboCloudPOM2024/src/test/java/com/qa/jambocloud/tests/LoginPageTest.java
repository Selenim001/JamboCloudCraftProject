package com.qa.jambocloud.tests;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.jambocloud.base.BaseTest;
import com.qa.jambocloud.constants.AppConstants;
import com.qa.jambocloud.errors.AppError;

public class LoginPageTest extends BaseTest{	
		
	@Test(priority = 1)
	public void loginPageURLTest() throws TimeoutException {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL),AppError.URL_NOT_FOUND);
	}
	
	@Test(priority = 2)
	public void loginTest() throws TimeoutException {
		taskPage = loginPage.doLogin(browserProperties.getProperty("username"),browserProperties.getProperty("password"));
		Assert.assertEquals(taskPage.getTasksPageURL(),AppConstants.TASKS_PAGE_TITLE,AppError.TITLE_NOT_FOUND);
	}
}