package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the Hompage of the website")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver LambdaDriver;
		if (isLambdaTest) {
			LambdaDriver = LambdaTestUtility.initializedLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(LambdaDriver);
		} else {
			// running tests on local machine
			logger.info("Load the Hompage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

//	@AfterMethod(description = "Closing the browser")
//	protected void tearDown() {
//		if (isLambdaTest) {
//			LambdaTestUtility.quitSession(); // cloud session in lambda
//		} else {
//			HomePage.exit(); // local session
//		}
//	}
}
