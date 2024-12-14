package com.ui.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static MyAddressesPage myAddresses;

	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]//span");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");
	private static final By ADD_ADDRESS_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	private static final By MY_ADDRESSES_LOCATOR = By.xpath("//a[@title=\"Addresses\"]");
	private static final By CONTACT_US_LOCATOR = By.xpath("//div[@id=\"contact-link\"]/a");

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

		try {
			if (isElementVisible(ADD_ADDRESS_LOCATOR)) {
				System.out.println("Add New Address Button is visible.");
				clickOn(ADD_ADDRESS_LOCATOR);
				return new AddAddressesPage(getDriver());
			} else {
				throw new NoSuchElementException("Add New Address Button not found on My Account page");
			}

		} catch (NoSuchElementException e) {
			System.out.println("Navigating to My Addresses page due to missing Add Address button");
			clickOn(MY_ADDRESSES_LOCATOR);
			myAddresses = new MyAddressesPage(getDriver());
			return myAddresses.goToUserAddressPage();
		}

	}

	public ContactUsPage goToContactUsPage() {
		System.out.println("Navigating to contact us page!");
		clickOn(CONTACT_US_LOCATOR);
		return new ContactUsPage(getDriver());
	}

}
