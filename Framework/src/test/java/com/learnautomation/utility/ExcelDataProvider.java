package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()                           //As soon as objct of this class is created, constructor will load the excel, so no need to load excel everytime
	{
	File src = new File("./TestData/Data.xlsx");
	try {
		FileInputStream fis = new FileInputStream(src);   //FileInputStream converts this file into raw data 
		wb= new XSSFWorkbook(fis);      			     //To read xlsx file we need a class called XSSFWorkbook //these fis and wb throws CHECKED exceptions-use trycatch
	} catch (Exception e)
	{
		System.out.println("Unable to read excel file "+e.getMessage());
	}
	
	}
	
	
	public String getStringData(String sheetName,int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName,int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		
	}
	

}
