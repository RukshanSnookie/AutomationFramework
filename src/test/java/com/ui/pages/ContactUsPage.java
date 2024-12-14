package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ContactUsPage extends BrowserUtility {

	private static final By SUBJECT_HEADING_LOCATOR = By.xpath("//select[@id=\"id_contact\"]");
	private static final By ORDER_REFERENCE_LOCATOR = By.xpath("//select[@name=\"id_order\"]/option[2]");
	private static final By PRODUCT_NAME_LOCATOR = By
			.xpath("//div[@class=\"selector\"]/select[@name=\"id_product\"]/option[2]");
	private static final By MESSAGE_TEXTAREA_LOCATOR = By.id("message");
	private static final By SEND_BUTTON_LOCATOR = By.id("submitMessage");
	private static final By SUCCESS_MESSAGE_LOCATOR = By.xpath("//div[@id=\"center_column\"]/p");
	private static final String CUSTOMER_SERVICE_HEADING = "Customer service";

	public ContactUsPage(WebDriver Driver) {
		super(Driver);
	}

	public ContactUsPage selectSubjectHeading() {
		System.out.println("Selecting the subject heading");
		selectFromDropdown(SUBJECT_HEADING_LOCATOR, CUSTOMER_SERVICE_HEADING);
		return new ContactUsPage(getDriver());
	}

	public ContactUsPage selectOrderReference() {
		clickOn(ORDER_REFERENCE_LOCATOR);
		return new ContactUsPage(getDriver());
	}

	public ContactUsPage selectProductName() {
		clickOn(PRODUCT_NAME_LOCATOR);
		return new ContactUsPage(getDriver());
	}

	public ContactUsPage enterMessage() {
		enterText(MESSAGE_TEXTAREA_LOCATOR, "this is the message");
		return new ContactUsPage(getDriver());
	}

	public ContactUsPage clickSendButton() {
		System.out.println("Sending the message");
		clickOn(SEND_BUTTON_LOCATOR);
		return new ContactUsPage(getDriver());
	}

	public String getSuccessMessage() {
		System.out.println("Getting Success Message");
		return getVisibleText(SUCCESS_MESSAGE_LOCATOR);
	}
}
