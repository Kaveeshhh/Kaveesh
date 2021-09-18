package com.scanwell.commands;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	//File file = null;
	//public static final String Path_TestData = "C:\\Users\\Janith C Jayasundera\\workspace\\Scanwell_New\\src\\com\\data\\";
	File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator+ "ScanwelNew.xlsx");

	//public static final String File_TestData = "ScanwelNew.xlsx";

	// private static String SheetName ="Sheet1";

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public void setExcelFile(String SheetName) throws Exception {

		try {

			String path = file.getAbsolutePath();

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		}

		catch (Exception e) {
			throw (e);
			
		}

	}

	public String getCellData(int RowNum, int ColNum) throws Exception {
		try {

			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(ExcelWSheet.getRow(RowNum).getCell(ColNum));
			return val;

		} catch (Exception e) {
 
			e.printStackTrace();
		}

		return null;
	}

}
