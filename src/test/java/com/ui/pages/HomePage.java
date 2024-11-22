package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.JSONUtility.*;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // calling parent class constructor from the child class constructor
		goToWebSite(readJson(QA).getUrl());
		maximizeWindow();

	}

	public HomePage(WebDriver lambdaDriver) {
		super(lambdaDriver);
		goToWebSite(readJson(QA).getUrl());
		maximizeWindow();
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform Click to Sign in");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
