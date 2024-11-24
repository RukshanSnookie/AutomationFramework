package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
	private static final By PRODUCt_SEARCH_RESULTS_LOCATOR = By.xpath("//h5[@itemprop=\"name\"]/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getSearchResultsTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentInProductList(String searchTerms) {
		List<String> keywordsList = Arrays.asList(searchTerms.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(PRODUCt_SEARCH_RESULTS_LOCATOR);
		boolean result = productNamesList.stream()
				.anyMatch(name -> (keywordsList.stream().anyMatch(name.toLowerCase()::contains)));

		return result;
	}

}
