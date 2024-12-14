package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class ContactCustomerServiceTest extends TestBase {

	private MyAccountPage myAccountPage;

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
	}

	@Test(description = "Veryfies if the user can send a message to customer support", groups = { "e2e", "sanity" })
	public void sendEmailToCustomerSupport() {
		String successMessage = myAccountPage.goToContactUsPage().selectSubjectHeading().selectOrderReference()
				.selectProductName().enterMessage().clickSendButton().getSuccessMessage();

		Assert.assertEquals(successMessage, "Your message has been successfully sent to our team.");
	}
}
