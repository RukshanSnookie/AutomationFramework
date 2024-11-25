package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pages.UserAddressesPage;

public class AddNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private UserAddressesPage userAddressesPage;

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
	}

	@Test
	public void addNewAddress() {
		myAccountPage.goToUserAddressPage().saveAddress();
	}

}
