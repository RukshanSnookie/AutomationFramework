package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";

	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs into the application and searches product")
	public void settup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password")
				.searchForProduct(SEARCH_TERM);
	}

	@Test(description = "verify if the logged in user able to buy a dress", groups = { "e2e", "sanity", "smoke" })
	public void checkoutTest() {
		searchResultPage.selectFirstproduct(0).changeSize(L).addProductToCart().proceedTOCheckout()
				.goToConfirmAddressPage().goToShipmentDetailsPage();
	}
}
