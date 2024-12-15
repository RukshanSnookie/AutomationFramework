package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class LogOutTest extends TestBase {

	private MyAccountPage myAccountPage;

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
	}

	@Test(description = "Check if the loggedd in user can sign out from the account", groups = { "e2e", "sanity" })
	public void signout() {
		Assert.assertTrue(myAccountPage.signOut().validateSignOut(), "true");
	}
}
