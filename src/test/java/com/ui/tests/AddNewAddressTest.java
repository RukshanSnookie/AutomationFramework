package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO addressPojo;

	@BeforeMethod(description = "Valid first time user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}

	@Test(description = "Veryfies if the user can add new addresses", groups = { "e2e", "sanity" })
	public void addNewAddress() {
		String newAddress = myAccountPage.goToUserAddressPage().saveAddress(addressPojo).getLastAddressHeading();
		Assert.assertEquals(newAddress, addressPojo.getAddressTitle().toUpperCase());
	}

}
