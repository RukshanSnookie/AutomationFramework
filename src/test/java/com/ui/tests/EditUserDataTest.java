package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.PersonalInformationPage;
import com.ui.pojo.EditUserDataPOJO;
import com.utility.FakeUserDetailsUtility;

public class EditUserDataTest extends TestBase {

	private PersonalInformationPage persoanInformationPage;
	private EditUserDataPOJO editUserDataPOJO;

	@BeforeMethod(description = "User successfully navigates to the personal information page")
	public void setup() {
		persoanInformationPage = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password")
				.goToPersonalInfoPage();
		editUserDataPOJO = FakeUserDetailsUtility.getFakeUserData();
	}

	@Test(description = "User should edit personal data", groups = { "e2e", "sanity", "smoke" })
	public void editUserData() {

		Assert.assertEquals(persoanInformationPage.editUserData(editUserDataPOJO).getSuccesfullyUpdatedMessage(),
				"Your personal information has been successfully updated.");
	}
}
