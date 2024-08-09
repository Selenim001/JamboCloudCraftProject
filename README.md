### Jambo Cloud Craft Project

This project contains an automated test script for verifying task search functionality on a web application. It checks that the tasks displayed in the grid contain a specific search keyword.

**About the Framework**

This frameworkis a detailed design of a test automation framework that leverages the Page Object Model (POM) design pattern combined with some components of a Hybrid Framework.

I'll break down each section and its components:

1.**Page Layer:**
 - Represents different web pages, which are abstracted using the POM design pattern.
 - Examples given are LoginPage.java and TaskPage.java where each .java file likely contains page locators and methods to interact with specific elements on the respective page.

2.**DriverFactory.java:**
- This is responsible for instantiating the web driver (could be local or remote depending on requirements).
- It reads from configurations (config.properties) to determine settings like browser type, environment (QA, STG, DEV, PROD), etc.
  
3.**Test Cases:**
- These are the actual test scripts which will make use of page objects and carry out the testing.
- They might include setup (@BT) and teardown (@AT) methods, and tests may use assertions to validate behavior.
- Test data can be parameterized using the @DP (data provider) annotation.

4.**Utilities/Libraries:**
- ElementUtil.java: Contains common methods and utilities to interact with web elements (like click, sendKeys, wait).
- JavaScriptUtil.java: Used to execute JavaScript commands on the web page, useful for operations like scrolling.
- ExcelUtil.java: Utility to read data from Excel files, which can be used for data-driven testing.
- Errors.java & Constants.java: Might contain error handling logic and static constant values respectively.
  
5.**BaseTest.java:**
- This could be a base class from which all test classes inherit.
- Provides setup and teardown logic, common functionalities, and initializes other common properties.
  
6.**Test Runners:**
- These are configurations or XML files used by test frameworks (like TestNG) to execute specific test suites/cases. Example runners provided: testsng.sanity.xml, testsng.regression.xml, etc.
  
7.**Test Data:**
- Data, possibly in an Excel file, used for testing.
  
8.**Reports/Logs:**
- Outputs of test runs, possibly in HTML format.Tools like Allure and ExtentReport can be used to generate rich, graphical reports.Logs can be generated using utilities like Log4j.

**_As per requirement in future we can add following things as well_**


9.**Infrastructure:**
- Docker GRID: An infrastructure where Selenium Grid runs inside Docker containers. It has nodes for different browsers like Chrome (CH) and Firefox (FF).
- Jenkins Server: Used for Continuous Integration and Continuous Deployment (CI/CD). It can run jobs, pipelines, and has various views. c. Compute Service: Indicates cloud infrastructure (like AWS EC2) where tests might run on Dockerized grids.
- GITHUB Repo: Source code repository where the test scripts, page objects, utilities, etc., are stored. It's integrated with Jenkins using webhooks.

10.**Infrastructure Setup/Env Setup:**
- Consists of setup on cloud platforms like AWS, the use of proxies like NGROK, etc.

This framework is designed to be modular, scalable, and maintainable. It leverages various tools and technologies to achieve automation, from writing test cases to executing them on different environments and generating detailed reports.

**Prerequisites**
Java 8 or above
Maven
Selenium WebDriver
A WebDriver (ChromeDriver, GeckoDriver, etc.)
An IDE like IntelliJ IDEA or Eclipse (optional)

**Installation**
1. Clone the repository:
   git clone https://github.com/Selenim001/jambo_cloudPOM2024
2. Navigate to the project directory:
   cd jambo_cloudPOM2024

3. Install the dependencies:
mvn clean install


**Project Structure**

![structure](https://github.com/user-attachments/assets/b0ece58d-2f83-492c-9084-d91da847c70b)


**Key Classes and Methods**
**DriverFactory.java**
This class is responsible for initializing and managing the WebDriver instance.

**ElementUtil.java**
This utility class provides common methods for interacting with web elements, such as waiting for visibility, clicking, sending text, etc.

**LoginPage.java**
Contains methods for interacting with the login page, such as entering username, entering password, and clicking the login button.

**TasksPage.java**
Contains methods for interacting with the tasks page, such as getting the list of tasks, applying filters, and verifying task details.

**LoginPageTest.java**
Vaidate login page URl and do login using username and password, it provides an object of TasksPage so that we can do method chanining to execute code from the nect page

**TasksPageTest.java**
It validates Task page URL and also perform search using a search key, it gets list of tasks from the list after performing search and also verfies that all the search results contains the search key

**AppConstants**
It provides all the constants variables for the testing 

**AppErrors**
It provides all the general errors wich we can use in the code without typing hard error message


