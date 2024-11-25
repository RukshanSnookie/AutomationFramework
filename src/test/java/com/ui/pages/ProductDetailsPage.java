package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@class=\"exclusive\"]");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title=\"Proceed to checkout\"]");

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailsPage changeSize(Size size) {

		selectFromDropdown(SIZE_DROPDOWN_LOCATOR, size.toString());
		return new ProductDetailsPage(getDriver());
	}

	public ProductDetailsPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}

	public ShoppingCartSummary proceedTOCheckout() {

		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartSummary(getDriver());
	}
}
