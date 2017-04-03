package com.readdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import wildcraft.model.User;

public class userList {
	static ReadProperty page = new ReadProperty();
	
	public static User getUser() throws IOException {
		File file = new File(page.readProperty("Userlist_Xls"));
		FileInputStream fis;

		User user = new User();
		try {
			
			//demo
			
			fis = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			HSSFRow row;
			HSSFCell cell1;
			HSSFCell cell2;

			String cell1Value;
			String cell2Value;

			// for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(0);
			cell1 = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
			cell2 = row.getCell(1, Row.CREATE_NULL_AS_BLANK);
			
			cell1Value = cell1.getStringCellValue();
			cell2Value = cell2.getStringCellValue();

			user.setUsername(cell1Value);
			user.setPassword(cell2Value);
			return user;
			/* System.out.println(cell1Value + "-" + cell2Value); */

		} catch (FileNotFoundException e) {
			// catch block
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
