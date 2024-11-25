package com.ui.tests;

import static com.constants.Size.L;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

		String result = searchResultPage.selectFirstproduct(0).changeSize(L).addProductToCart().proceedTOCheckout()
				.goToConfirmAddressPage().goToShipmentDetailsPage().goTOPaymentPage().goToOrderSummaryPage()
				.goToOrderConfirmationPage().getSuccessMessage();

		Assert.assertTrue(result.contains("complete"));
	}
}
