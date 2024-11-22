package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listner.TestListner.class })
public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
	}

	@Test(description = "Verify if the logged in user able to search products and get correct search results", groups = {
			"e2e", "sanity" })
	public void verifyProductSearch() {
		String data = myAccountPage.searchForProduct("Printed Summer Dress").getSearchResultsTitle();
		System.out.println(data);
	}
}
