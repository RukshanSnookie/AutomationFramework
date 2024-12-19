package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.EditUserDataPOJO;
import com.utility.BrowserUtility;

public class PersonalInformationPage extends BrowserUtility {

	private static final By FIRST_NAME_TEXTBOX_LOCATOR = By.id("firstname");
	private static final By LAST_NAME_TEXTBOX_LOCATOR = By.id("lastname");
	private static final By OLD_PASSWORDBOX_LOCATOR = By.id("old_passwd");
	private static final By NEWSLETTER_CHECKBOX_LOCATOR = By.xpath("//div[@id=\"uniform-newsletter\"]");
	private static final By SAVE_BUTTON_LOCATOR = By
			.xpath("//div[@class=\"form-group\"]/button[@name=\"submitIdentity\"]");
	private static final By SUCCESS_TEXT_MESSAGE_LOCATOR = By.xpath("//p[@class=\"alert alert-success\"]");

	public PersonalInformationPage(WebDriver driver) {
		super(driver);
	}

	public PersonalInformationPage editUserData(EditUserDataPOJO editUserDataPOJO) {
		clearText(FIRST_NAME_TEXTBOX_LOCATOR);
		enterText(FIRST_NAME_TEXTBOX_LOCATOR, editUserDataPOJO.getFirstName());
		clearText(LAST_NAME_TEXTBOX_LOCATOR);
		enterText(LAST_NAME_TEXTBOX_LOCATOR, editUserDataPOJO.getLastName());
		enterText(OLD_PASSWORDBOX_LOCATOR, editUserDataPOJO.getOldPassword());
		clickOnCheckBox(NEWSLETTER_CHECKBOX_LOCATOR);
		clickOn(SAVE_BUTTON_LOCATOR);

		return new PersonalInformationPage(getDriver());
	}

	public String getSuccesfullyUpdatedMessage() {
		return getVisibleText(SUCCESS_TEXT_MESSAGE_LOCATOR);
	}

}
