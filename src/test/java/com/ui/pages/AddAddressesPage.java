package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddAddressesPage extends BrowserUtility {

	private static final By COMPANY_NAME_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS_LINE_1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS_LINE_2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By POSTAL_CODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_NUMBER_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_NUMBER_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR = By.id("other");
	private static final By ADDRESS_TITLE_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");

	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");

	public AddAddressesPage(WebDriver driver) {
		super(driver);
	}

	public MyAddressesPage saveAddress(AddressPOJO addressPOJO) {

		enterText(COMPANY_NAME_TEXTBOX_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS_LINE_1_TEXTBOX_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS_LINE_2_TEXTBOX_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPOJO.getCity());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
		enterText(POSTAL_CODE_TEXTBOX_LOCATOR, addressPOJO.getPostalCode());
		enterText(HOME_PHONE_NUMBER_TEXTBOX_LOCATOR, addressPOJO.getHomePhone());
		enterText(MOBILE_PHONE_NUMBER_TEXTBOX_LOCATOR, addressPOJO.getMobilePhone());
		enterText(ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR, addressPOJO.getAdditionalInfo());
		clearText(ADDRESS_TITLE_TEXTBOX_LOCATOR);
		enterText(ADDRESS_TITLE_TEXTBOX_LOCATOR, addressPOJO.getAddressTitle());
		clickOn(SAVE_BUTTON_LOCATOR);

		return new MyAddressesPage(getDriver());
	}

}
