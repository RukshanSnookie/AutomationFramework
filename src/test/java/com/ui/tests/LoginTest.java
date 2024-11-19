package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.Users;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listner.TestListner.class })
public class LoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Veryfies if the valid user is able to log in", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginJSONTestDataProvider")
	public void loginTest(Users user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rukshan Malinda");
	}

//	@Test(description = "Veryfies if the valid user is able to log in", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginCSVTestDataProvider")
//	public void loginCSVTest(Users user) {
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Rukshan Malinda");
//	}
//
//	@Test(description = "Veryfies if the valid user is able to log in", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelTestDataProvider", retryAnalyzer = com.ui.listner.MyRretryAnalyser.class)
//	public void loginExcelTest(Users user) {
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Rukshan Malinda");
//	}

}

//divibap269@aleitar.com
//password