package com.qa.jambocloud.base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.jambocloud.factory.Driverfactory;
import com.qa.jambocloud.pages.LoginPage;
import com.qa.jambocloud.pages.TasksPage;

public class BaseTest {
	
	Driverfactory df;
	WebDriver browserDriver;
	protected Properties browserProperties;
	protected LoginPage loginPage;
	protected TasksPage taskPage;

	@BeforeTest
	public void setUp() {
		df = new Driverfactory();
		browserProperties = df.initProp();
		browserDriver = df.initDriver(browserProperties);
		loginPage = new LoginPage(browserDriver);
	}
	
	@AfterTest
	public void tearDown() {
		browserDriver.quit();
	}
}