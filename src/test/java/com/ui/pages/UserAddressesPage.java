package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class UserAddressesPage extends BrowserUtility {

	private static final By COMPANY_NAME_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS_LINE_1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS_LINE_2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By POSTAL_CODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_NUMBER_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_NUMBER_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR = By.id("alias");
	private static final By ADDRESS_TITLE_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");

	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");

	public UserAddressesPage(WebDriver driver) {
		super(driver);
	}

	public UserAddressesPage saveAddress() {

		enterText(COMPANY_NAME_TEXTBOX_LOCATOR, "JIT RCSss");
		enterText(ADDRESS_LINE_1_TEXTBOX_LOCATOR, "Address line 1");
		enterText(ADDRESS_LINE_2_TEXTBOX_LOCATOR, "Address line 2");
		enterText(CITY_TEXTBOX_LOCATOR, "New Jersey");
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, "3");
		enterText(POSTAL_CODE_TEXTBOX_LOCATOR, "40132");
		enterText(HOME_PHONE_NUMBER_TEXTBOX_LOCATOR, "1052356458");
		enterText(MOBILE_PHONE_NUMBER_TEXTBOX_LOCATOR, "9052356451");
		enterText(ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR, "fake address for testing");
		clearText(ADDRESS_TITLE_TEXTBOX_LOCATOR);
		enterText(ADDRESS_TITLE_TEXTBOX_LOCATOR, "Test Address One");
//		clickOn(SAVE_BUTTON_LOCATOR);

		UserAddressesPage userAddressesPage = new UserAddressesPage(getDriver());
		return userAddressesPage;
	}

}
