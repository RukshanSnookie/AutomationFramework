package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.ManifestReading.SealBaseLocator.ForTypeResourceUrl;

public class MyAddressesPage extends BrowserUtility {

	private static AddAddressesPage addAddressesPage;

	private static final By ADD_NEW_ADDRESS_BUTTON_LOCATOR = By.xpath("//a[@title=\"Add an address\"]");

	public MyAddressesPage(WebDriver driver) {
		super(driver);
	}

	public AddAddressesPage goToUserAddressPage() {
		clickOn(ADD_NEW_ADDRESS_BUTTON_LOCATOR);
		addAddressesPage = new AddAddressesPage(getDriver());
		return addAddressesPage;
	}

}
