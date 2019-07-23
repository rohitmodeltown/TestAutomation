package com.common;

/**
 * @author A1SKIVA4
 *
 */
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook ExcelWorkBook;

	private static XSSFSheet ExcelWorkSheet;
	
	private static XSSFRow Row;
	
	private static XSSFCell Cell;



	public void readExcelFile() throws Exception{
		
		FileInputStream fis = new FileInputStream(new File("D:\\Airtel\\Requirement\\Test Data\\Type of All Data.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
				
	}
	
	public void getReadData() throws Exception {
		
		
		
	}
	
	
	
	

	public ExcelUtils(String execlPath) {
		
		try {
			
			File srcFile = new File(execlPath);
			FileInputStream fis = new FileInputStream(srcFile);
			ExcelWorkBook = new XSSFWorkbook(fis);
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
	}
	
	
	public String getData(int sheet, int row, int column) {
		
		ExcelWorkSheet = ExcelWorkBook.getSheetAt(sheet);
		String data = ExcelWorkSheet.getRow(2).getCell(2).getStringCellValue();
		return data;
	}
	
	public  int getRowCount(int sheet) {
		
		int row = ExcelWorkBook.getSheetAt(0).getLastRowNum();
		row = row+1;
		return row;
	}
	
	
	
	public static String getTestCaseName(String sTestCase){
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			value = value.substring(posi);
			return value;
		} catch (Exception e) {
			throw (e);
		}
	}
	
}