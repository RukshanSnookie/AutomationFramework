package com.ui.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static AddAddressesPage yourAddresses;
	private static MyAddressesPage myAddresses;

	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]//span");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");
	private static final By ADD_ADDRESS_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	private static final By MY_ADDRESSES = By.xpath("//a[@title=\"Addresses\"]");

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

	public AddAddressesPage goToUserAddressPage() {

//		try {
		String newAddressElement = getVisibleText(ADD_ADDRESS_LOCATOR);
		clickOn(ADD_ADDRESS_LOCATOR);
		yourAddresses = new AddAddressesPage(getDriver());
		return yourAddresses;
//
//		} catch (NoSuchElementException e) {
//			clickOn(MY_ADDRESSES);
//			myAddresses = new MyAddressesPage(getDriver());
//			return myAddresses;
//		}

	}

}
