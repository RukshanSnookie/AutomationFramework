package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]//span");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	public String getUserName() {
		return getVisibleText(USERNAME_LOCATOR);
	}

	public SearchResultPage searchForProduct(String productName) {
		enterText(SEARCH_TEXTBOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXTBOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	}

}
