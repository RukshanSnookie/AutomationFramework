package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderCinfirmationPage extends BrowserUtility {

	private static final By ORDER_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[@class=\"alert alert-success\"]");

	public OrderCinfirmationPage(WebDriver driver) {
		super(driver);
	}

	public String getSuccessMessage() {
		return getVisibleText(ORDER_SUCCESS_MESSAGE_LOCATOR);
	}
}
