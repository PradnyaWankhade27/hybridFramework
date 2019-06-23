package com.qa.FreeCrmPro.VisIt.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File fs = new File(System.getProperty("user.dir") + "//TestData//TestingData.xlsx");

		try {
			FileInputStream fins = new FileInputStream(fs);
			try {
				wb = new XSSFWorkbook(fins);

			} catch (IOException e) {

				System.out.println("Not Able to Read and Write to the file :" + e.getMessage());
			}

		} catch (FileNotFoundException e) {

			System.out.println("Not able to found the File" + e.getMessage());
		}
	}

	public String getExcelStringData(String sheetName, int row, int col) {

		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

	public String getExcelStringData(int sheetIndex, int row, int col) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public int getExcelNumericData(String sheetName, int row, int col) {

		return (int) wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}

	public int getExcelNumericData(int sheetIndex, int row, int col) {

		return (int) wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getNumericCellValue();
	}

	public Object [][] getExcelTestData(String sheetName) {

		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int total_rows = sheet.getLastRowNum();
		
		int total_cols = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		
		
		Object [][] data=new Object[total_rows][total_cols];
		
		for(int i=0; i< total_rows; i++)
		{
			for(int j=0; j<total_cols; j++ ){
			
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		
		return data;
	}
}
