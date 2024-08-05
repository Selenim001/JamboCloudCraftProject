package com.qa.jambocloud.tests;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.jambocloud.base.BaseTest;
import com.qa.jambocloud.constants.AppConstants;
import com.qa.jambocloud.errors.AppError;

public class TasksPageTest extends BaseTest {
	
	@BeforeClass
	public void TasksPageSetup() {
		taskPage = loginPage.doLogin(browserProperties.getProperty("username"), browserProperties.getProperty("password"));	
	}
	
	@Test(priority = 1)	
	public void getURLTest() throws TimeoutException {
		String actURL = taskPage.getTasksPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.TASKS_PAGE_FRACTION_URL) ,AppError.URL_NOT_FOUND);
	}

	@Test(priority = 2)
	public void taskPageSearchTest() {
		taskPage.doSearch(AppConstants.SEARCH_KEY);
		List<String> searchResultsList = taskPage.getTasksValuesFromPage();
		for(String task : searchResultsList) {
			Assert.assertTrue(task.contains(AppConstants.SEARCH_KEY), AppError.TASK_DOES_NOT_CONTAIN_KEYWORD);	 
	 	}
	}
}