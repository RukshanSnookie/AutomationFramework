package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]//span");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);

	}
	
	public String getUserName() {
		return getVisibleText(USERNAME_LOCATOR);
	}
	

}
