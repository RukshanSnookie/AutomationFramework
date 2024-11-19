package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest = true;
	private boolean isHeadless = true;

	@BeforeMethod(description = "Load the Hompage of the website")
	public void setup(ITestResult result) {
		WebDriver LambdaDriver;
		if (isLambdaTest) {
			LambdaDriver = LambdaTestUtility.initializedLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(LambdaDriver);
		} else {
			// running tests on local machine
			logger.info("Load the Hompage of the website");
			homePage = new HomePage(Browser.CHROME, isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	private void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession(); // cloud session in lambda
		} else {
			HomePage.exit(); // local session
		}
	}
}
