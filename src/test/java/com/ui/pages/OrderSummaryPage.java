package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderSummaryPage extends BrowserUtility {

	private static final By ORDER_CONFIRM_BUTTON_LOCATOR = By.xpath("//button[contains(@class,\"button btn\")]");

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	public OrderCinfirmationPage goToOrderConfirmationPage() {
		clickOn(ORDER_CONFIRM_BUTTON_LOCATOR);
		return new OrderCinfirmationPage(getDriver());
	}
}
