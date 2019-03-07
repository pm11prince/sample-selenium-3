package com.seedbank.common.utils;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * <copyright file="ExcelFunction.java" company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author Deepa Elenor Mathias
 */

public class ExcelFunctions {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static int sheetNumber;
	public static LinkedHashMap<String, String> dataMap = null;
	
	/**
	 * @param File
	 *            Location Location of the excel file
	 */

	public static void initializeExcelSheet(String fileLocation) {
		try {
			FileInputStream fis = new FileInputStream(fileLocation);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param Configuration
	 *            Name of the configuration to be executed.
	 * @return Returns the sheet number of corresponding configuration Name
	 */

	public static int getSheetNumber(String configurationName) {
		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet aSheet = workbook.getSheetAt(i);
			if (aSheet.getSheetName().equals(configurationName)) {
				sheetNumber = i;

			}
		}
		return sheetNumber;
	}

	/**
	 * @param Configuration
	 *            Name of the configuration to be executed.
	 * @return Row number corresponding to the configuration name
	 * 
	 */

	public static int locateConfigurationNameRow(String configurationName,int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim()
							.equals(configurationName)) {
						return row.getRowNum();
					}
				}
			}
		}
		return 0;
	}

	/**
	 * @param sheetNumber
	 *            Sheet number of the configuration
	 * @param value
	 *            Value to be searched
	 * @return Returns start row number based on the value
	 * 
	 */

	public static int findStartRow(int sheetNumber, String value) {
		sheet = workbook.getSheetAt(sheetNumber);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim()
							.equals(value)) {
						return row.getRowNum();
					}
				}
			}
		}
		return 0;
	}
	

	
	/**
	 * @param sheetNumber
	 *            Sheet number of the configuration
	 * @param value
	 *            Value to be searched
	 * @return Returns last row number based on the value
	 * 
	 */

	public static int findEndRow(int sheetNumber, int startRowNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		int rowNo;
		for(rowNo=startRowNumber+1;rowNo<=sheet.getLastRowNum();rowNo++)
		{
			Row row = sheet.getRow(rowNo);
			Cell cell = row.getCell(1);
			if (!(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK))
				break;
			
		}
		return rowNo;
		}
	
	/**
	 * @param sheetNumber
	 *            Sheet number of the configuration
	 * @param value
	 *            Value to be searched
	 * @return Returns last row number of a particular sheet
	 * 
	 */

	public static int findLastRow(int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
	
	
		return sheet.getLastRowNum();
		}
	/**
	 * @param row
	 *            number row number of the configuration
	 * @param sheet
	 *            number sheet number of the configuration
	 * @return Returns the operation type (Insert/Update/Delete)
	 * 
	 */

	public static String getCellData(int RowNo, int columnNumber,int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		Row row = sheet.getRow(RowNo);
		Cell cell = row.getCell(columnNumber);
		if (!(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK))
			return sheet.getRow(RowNo).getCell(columnNumber).getStringCellValue();
		else
		 return "";
	}

	/**
	 * @param key
	 *            row number row number of the headers in excel.
	 * @param value
	 *            row number row number of the configuration to be executed
	 * @param column
	 *            name column name for which data is to be fetched
	 * @param sheetnumber
	 *            sheet number of the configuration
	 * @return Returns cell data for the corresponding row and columns number
	 * 
	 */
	public static String getCellData(int keyRowNo, int valueRowNo,
			String columnName, int sheetNumber) {

		sheet = workbook.getSheetAt(sheetNumber);
		int noOfColumns = sheet.getRow(keyRowNo).getLastCellNum();

		int colNo;
		for (colNo = 0; colNo <= noOfColumns - 1; colNo++) {
			String key = sheet.getRow(keyRowNo).getCell(colNo)
					.getStringCellValue();
			if (key.contains(columnName))
				break;
		}

		return sheet.getRow(valueRowNo).getCell(colNo).getStringCellValue();

	}

	/**
	 * @param sheetNumber
	 *            Sheet number of the configuration
	 * @return Returns number of the iterations
	 * 
	 */

	public static int getNumberofIterations(int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		return sheet.getLastRowNum();
	}



	/**
	 * @param cell
	 *            cell of the excel sheet
	 * 
	 * @return Returns the String value of each cell irrespective of its data
	 *         type
	 * 
	 */
	public static String getExcelDataBasedOnCellType(Cell cell) {
		String value = null;

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			 Double value1 = cell.getNumericCellValue();
			 Long longValue = value1.longValue();
			 value = new String(longValue.toString());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = Boolean.toString(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			System.out.println(cell.getCellFormula());
			break;
		default:
			break;
		}
		return value;
	}

	
	

}
