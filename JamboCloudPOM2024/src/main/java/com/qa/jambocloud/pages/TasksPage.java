package com.qa.jambocloud.pages;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.jambocloud.constants.AppConstants;
import com.qa.jambocloud.utils.ElementUtil;
import com.qa.jambocloud.utils.TimeUtil;

/**
 * TC-01 
 * An expectations of searching task name using the keyword 
 */

public class TasksPage {
	
	private WebDriver browserDriver;
	private ElementUtil eleUtil;
	
	public TasksPage(WebDriver browserDriver) {
		this.browserDriver = browserDriver;
		eleUtil = new ElementUtil(browserDriver);
	}
	
	private By searchInput = By.xpath("//input[@placeholder='Search for a Task*']");
	private By searchIcon = By.name("div#search button");
	private By taskRows = By.id("taskRow");
	
	/**
	 * An expectations of checking the taskPage URL contains fraction value or not
	 * @return
	 * @throws TimeoutException
	 */
	public String getTasksPageURL() throws TimeoutException {
		String url = eleUtil.waitForURLContains(AppConstants.TASKS_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME);
		System.out.println("tasks page url : " + url);
		return url;
	}
	
	/**
	 * This method helps to find if the search input element is exist on the page or not
	 * @return
	 */
	public boolean isSearchExist() {
		return eleUtil.doIsDisplayed(searchInput);
	}
	
	/**
	 * An expectation of checking search input element on page DOM and entering value into input field 
	 * and performing search
	 * @param searchKey
	 * @return
	 */
	
	public void doSearch(String searchKey) {
		System.out.println("searching..." + searchKey);
		if(isSearchExist()) {
			eleUtil.doSendKeys(searchInput, searchKey);
			eleUtil.doClick(searchIcon);
		}
		else {
			System.out.println("search field is not present on the page");
		}
	}
	
	/**
	 * This method helps to get a list of task names getting after performing search 
	 * @return
	 */
	public List<String> getTasksValuesFromPage() {
		
		List<WebElement> tasksList = eleUtil.waitForVisibilityOfElementsLocated(taskRows, TimeUtil.DEFAULT_MEDIUM_TIME);
		List<String> taskValList = new ArrayList<String>();
		for(WebElement e : tasksList) {
			String text = e.getText();
			System.out.println(text);
				taskValList.add(text);
				System.out.println(taskValList);
			}
			return taskValList;
	}
}