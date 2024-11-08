package com.ui.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;

public class MyRretryAnalyser implements IRetryAnalyzer {

//	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer
//			.parseInt(PropertyUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
	
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int current_attempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (current_attempt <= MAX_NUMBER_OF_ATTEMPTS) {
			current_attempt++;
			return true;
		}
		return false;
	}

}
