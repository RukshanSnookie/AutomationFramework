package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pages.AddAddressesPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddAddressesPage userAddressesPage;
	private AddressPOJO addressPojo;

	@BeforeMethod(description = "Valid user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {
		myAccountPage.goToUserAddressPage().saveAddress(addressPojo);
	}

}
