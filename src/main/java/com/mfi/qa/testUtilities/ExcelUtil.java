package com.mfi.qa.testUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String excelfilepath = "D:/Automation/WorkSpace2/MicroFocusIntegration/src/main/java/com/mfi/qa/testData/TestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetname) {
		try {
			FileInputStream file =new FileInputStream(excelfilepath);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetname);
			Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for (int k =0; k<sheet.getRow(0).getLastCellNum(); k++) {
					data [i][k] = sheet.getRow(i+1).getCell(k).toString();	
				}
			}
			return data;	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
