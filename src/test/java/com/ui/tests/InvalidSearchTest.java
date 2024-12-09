package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class InvalidSearchTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String INVALID_SEARCH_TERM = "142kkso";

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
	}

	@Test(description = "verify user gets the validation messages if the user enters invalid search inputs ", groups = {
			"e2e", "sanity" })
	public void searchInvalidProduct() {
		Assert.assertTrue(
				myAccountPage.searchForProduct(INVALID_SEARCH_TERM).getInvalidSearchMessage(INVALID_SEARCH_TERM).contains(INVALID_SEARCH_TERM),
				"Validation message does not contain the search term. Actual message: " + INVALID_SEARCH_TERM);
	}

}
