package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

	public HomePage(Browser browserName) {
		super(browserName); // calling parent class constructor from the child class constructor
		goToWebSite("http://www.automationpractice.pl/index.php");

	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
