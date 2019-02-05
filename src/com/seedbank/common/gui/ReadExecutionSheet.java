package com.seedbank.common.gui;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * <copyright file="ReadExecutionSheet.java" company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author Deepa Elenor Mathias
 */

public class ReadExecutionSheet {

	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static List<String> excelData = new ArrayList<String>();
	public static final String DRIVER_SHEET_LOCATION = "resources\\Driver.xlsx";
	public static FileInputStream fis = null ;
	public static ArrayList<ExecutionSheetObject> list = new ArrayList<ExecutionSheetObject>();
	public static String deviceID, platformVersion,appPackage,appActivity;
	
	
	/**
	 * readDriverSheet() method reads "Execution" sheet of "Driver.xlsx" workbook. If execution status 
	 * is "Yes", test name and sheet name are added to ExecutionSheetObject.
	 * @return List of ExecutionSheetObject
	 * @author Deepa Elenor Mathias
	 */
	public static  ArrayList<ExecutionSheetObject> readDriverSheet() {
		try {
			fis = new FileInputStream(DRIVER_SHEET_LOCATION);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		sheet = workbook.getSheetAt(0);
		System.out.println("sheetName"+sheet.getSheetName());
		ExecutionSheetObject obj = null;

		for (int rowNo = 1; rowNo <= sheet.getLastRowNum() ; rowNo++) {
			String runStatus = sheet.getRow(rowNo).getCell(3)
					.getStringCellValue();
			if(runStatus.equals("Yes"))
			{
				String sheetName = sheet.getRow(rowNo).getCell(1)
						.getStringCellValue();
				String testName=sheet.getRow(rowNo).getCell(2)
				.getStringCellValue();
				obj=new ExecutionSheetObject(sheetName,testName);

				list.add(obj);
			}
		}
	
		return list;

	}

	
	

}
