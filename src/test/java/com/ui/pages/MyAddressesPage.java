package com.ui.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAddressesPage extends BrowserUtility {

	private static final By ADD_NEW_ADDRESS_BUTTON_LOCATOR = By.xpath("//a[@title=\"Add an address\"]");
	private static final By NEWLY_ADDED_ADDRESS_TAG_LOCATOR = By.xpath("//h3[@class=\"page-subheading\"]");

	public MyAddressesPage(WebDriver driver) {
		super(driver);
	}

	public AddAddressesPage goToUserAddressPage() {
		clickOn(ADD_NEW_ADDRESS_BUTTON_LOCATOR);
		return new AddAddressesPage(getDriver());
	}

	public String getLastAddressHeading() {
		List<String> lastAddressHeading = getAllVisibleText(NEWLY_ADDED_ADDRESS_TAG_LOCATOR);
		System.out.println(lastAddressHeading);
		if (!lastAddressHeading.isEmpty()) {
			return lastAddressHeading.get(lastAddressHeading.size() - 1);
		} else {
			throw new NoSuchElementException("No Address Heading found!!!");
		}
	}

}
