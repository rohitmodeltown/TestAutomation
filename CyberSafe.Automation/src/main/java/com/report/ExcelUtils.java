package com.report;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constant.TestConstant;

public class ExcelUtils {

	private static XSSFSheet ExcelWorkSheet;

	private static XSSFWorkbook ExcelWorkBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	public ExcelUtils() {

		try {

			FileInputStream excelfile = new FileInputStream(TestConstant.path);
			ExcelWorkBook = new XSSFWorkbook(excelfile);
			ExcelWorkSheet = ExcelWorkBook.getSheetAt(0);
			String data = ExcelWorkSheet.getRow(5).getCell(5).getStringCellValue();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static String getCellData(int sheetnumber, int row, int col) throws IOException {

		FileInputStream excelfile = new FileInputStream(TestConstant.path);
		ExcelWorkBook = new XSSFWorkbook(excelfile);
		ExcelWorkSheet = ExcelWorkBook.getSheetAt(0);
		String data = ExcelWorkSheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

}
