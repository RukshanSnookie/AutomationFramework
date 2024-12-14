package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ContactUsPage extends BrowserUtility {

	private static final By SUBJECT_HEADING_LOCATOR = By.xpath("//select[@id=\"id_contact\"]");
	private static final String CUSTOMER_SERVICE_HEADING = "Customer service";

	public ContactUsPage(WebDriver Driver) {
		super(Driver);
	}

	public ContactUsPage selectSubjectHeading() {
		System.out.println("Selecting the subject heading");
		selectFromDropdown(SUBJECT_HEADING_LOCATOR, CUSTOMER_SERVICE_HEADING);
		return new ContactUsPage(getDriver());
	}

}
