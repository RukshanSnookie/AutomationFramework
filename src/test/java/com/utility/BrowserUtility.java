package com.utility;

import java.io.File;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching " + browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			logger.info("Not launched " + browserName);
			System.err.println("Enter a valid browser");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		} else if (browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		} else if (browserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
	}

	public void goToWebSite(String url) {
		logger.info("Visiting the website " + url);
		driver.get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.findElement(locator);
		logger.info("Element found and performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.findElement(locator);
		logger.info("Element found and enter text" + textToEnter);
		element.sendKeys(textToEnter);

	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.findElement(locator);
		logger.info("Element found and returning the visible" + element.getText());
		return element.getText();
	}

	public void takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

	}

	public void exit() {
		driver.quit();
	}
}
