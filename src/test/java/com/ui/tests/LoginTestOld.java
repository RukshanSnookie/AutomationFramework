package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();

		BrowserUtility browserUtility = new HomePage(CHROME);
		browserUtility.goToWebSite("http://www.automationpractice.pl/index.php");
		browserUtility.maximizeWindow();

		By signInLocator = By.xpath("//a[contains(text(),\"Sign in\")]");
		browserUtility.clickOn(signInLocator);

		By emailLocator = By.id("email");
		browserUtility.enterText(emailLocator, "divibap269@aleitar.com");

		By passwordLocator = By.id("passwd");
		browserUtility.enterText(passwordLocator, "password");

		By submitLoginButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonLocator);

	}

}

//divibap269@aleitar.com
//password