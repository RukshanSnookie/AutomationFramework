package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners({ com.ui.listner.TestListner.class })
public class InvalidLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL = "Rusjkf@gmail.com";
	private static final String INVALID_PASSWORD = "quodonf";

	@Test(description = "Veryfies if the error message popping up if user enters wrong credentials", groups = { "e2e",
			"sanity" })
	public void invalidLoginTest() {

		assertEquals(
				homePage.goToLoginPage().logInWithInvalidCredentials(INVALID_EMAIL, INVALID_PASSWORD).getErrorMessage(),
				"Authentication failed.");
		tearDown();
	}

}

//divibap269@aleitar.com
//password