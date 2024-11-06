package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.Users;

public class LoginTest {

	private static HomePage homePage;

	@BeforeMethod(description = "Load the Hompage of the website")
	public void setup() {
		homePage = new HomePage(CHROME);
	}

	@Test(description = "Veryfies if the valid user is able to log in", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginJSONTestDataProvider")
	public void loginTest(Users user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rukshan Malinda");
	}

	@Test(description = "Veryfies if the valid user is able to log in", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginCSVTestDataProvider")
	public void loginCSVTest(Users user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rukshan Malinda");
	}

	@Test(description = "Veryfies if the valid user is able to log in", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelTestDataProvider")
	public void loginExcelTest(Users user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rukshan Malinda");
	}

}

//divibap269@aleitar.com
//password