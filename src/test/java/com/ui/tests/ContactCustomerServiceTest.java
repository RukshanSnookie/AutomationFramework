package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class ContactCustomerServiceTest extends TestBase {
	
	private MyAccountPage myAccountPage;

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
	}

	@Test
	public void sendEmailToCustomerSupport() {
		myAccountPage.goToContactUsPage();
	}
}
