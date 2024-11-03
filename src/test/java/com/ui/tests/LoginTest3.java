package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest3 {

	public static void main(String[] args) {

		HomePage homePage = new HomePage(CHROME);
		String userName = homePage.goToLoginPage().doLoginWith("divibap269@aleitar.com", "password").getUserName();
		System.out.println(userName);
	}

}

//divibap269@aleitar.com
//password