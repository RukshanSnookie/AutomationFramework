package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By PAY_BY_BANKWIRE_BUTTON_LOCATOR = By.xpath("//a[@title=\"Pay by bank wire\"]");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public OrderSummaryPage goToOrderSummaryPage() {
		clickOn(PAY_BY_BANKWIRE_BUTTON_LOCATOR);
		return new OrderSummaryPage(getDriver());
	}

}
