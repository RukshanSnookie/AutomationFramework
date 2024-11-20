package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.Users;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginJSONTestDataProvider")
	private Iterator<Object[]> loginDataProvider() throws FileNotFoundException {

		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\testData\\logindata.json");
		FileReader fileReader = new FileReader(testDataFile);
		TestData data = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (Users user : data.getData()) {
			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();

	}

	@DataProvider(name = "LoginCSVTestDataProvider")
	public Iterator<Users> loginCSVDataprovider() {
		return CSVReaderUtility.readCSVFile("logindata");
	}

	@DataProvider(name = "LoginExcelTestDataProvider")
	public Iterator<Users> loginExcelDataprovider() {
		return ExcelReaderUtility.readExcelFile("logindata");
	}
}
