package com.stc7c7.utils;

import java.io.File;  
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Cell;  
//import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelFile 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ReadExcelFile(String exlFilePath)
	{
		try
		{
			//File file = new File(excelFilePath);
			//FileInputStream fis = new FileInputStream(file);
			FileInputStream fis=new FileInputStream(new File(exlFilePath)); 			
			wb = new XSSFWorkbook(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Error in ReadExcelFile() : " + e.getClass().getName());
			System.out.println("Error in ReadExcelFile() : " + e.getMessage());
		}
	}
	
	public String getData(int sheetno,int row, int col)
	{
		 sheet = wb.getSheetAt(sheetno);
		 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		 Cell cell = sheet.getRow(row).getCell(col);
		 String cellValue = formatter.formatCellValue(cell).toString();
		 //return sheet.getRow(row).getCell(col).getStringCellValue().toString();
		 return cellValue;
	}
	
	public int getRowCount(int sheetno)
	{
		return wb.getSheetAt(sheetno).getLastRowNum() ;
	}
	

	

}
