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

	@BeforeMethod(description = "Valid first timme user logged into the system")
	public void login() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {
		String newAddress = myAccountPage.goToUserAddressPage().saveAddress(addressPojo).getLastAddressHeading();
		Assert.assertEquals(newAddress, addressPojo.getAddressTitle().toUpperCase());
	}

}
