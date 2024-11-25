package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShipmentDetailsPage extends BrowserUtility {

	private static final By CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name=\"processCarrier\"]");

	public ShipmentDetailsPage(WebDriver driver) {
		super(driver);
	}

	public PaymentPage goTOPaymentPage() {
		clickOn(CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
