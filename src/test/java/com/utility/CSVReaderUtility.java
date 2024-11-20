package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.Users;

public class CSVReaderUtility {
	public static Iterator<Users> readCSVFile(String filename) {

		File csvFile = new File(System.getProperty("user.dir") + "//testData//" + filename + ".csv");

		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<Users> userList = null;
		Users userData;

		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // Skip the first row [col names]

			userList = new ArrayList<Users>();

			while ((line = csvReader.readNext()) != null) {
				userData = new Users(line[0], line[1]);
				userList.add(userData);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();
	}
}
