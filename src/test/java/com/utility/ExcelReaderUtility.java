package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.Users;

public class ExcelReaderUtility {
	public static Iterator<Users> readExcelFile(String fileName) {

		File excelFile = new File(System.getProperty("user.dir") + "/testData/" + fileName + ".xlsx");
		XSSFWorkbook xssfWorkbook = null;
		List<Users> userList = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		Users user;
		Row row;
		Cell emailCell;
		Cell passwordCell;

		try {
			xssfWorkbook = new XSSFWorkbook(excelFile);
			userList = new ArrayList<Users>();
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// skip col name

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new Users(emailCell.toString(), passwordCell.toString());
				userList.add(user);

			}
			xssfWorkbook.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();
	}
}
