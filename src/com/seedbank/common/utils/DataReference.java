package com.seedbank.common.utils;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Pratyush Choudhary
 */
public class DataReference {
	private static final String DATA_REFERENCES_FILE_LOCATION = "resources\\Data References.xlsx";
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	private static int sheetCount = 0;
	
	public static HashMap<String, String> references = null;

	/**
	 * Method to read data from excel sheet and store them in a hash map.
	 */
	public static void initializeData() {
		try {
			FileInputStream fis = new FileInputStream(DATA_REFERENCES_FILE_LOCATION);
			workbook=new XSSFWorkbook(fis);	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		references = new HashMap<String, String>();
		
		sheetCount = workbook.getNumberOfSheets();
		for(int i = 0; i < sheetCount; i++) {
			sheet = workbook.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			for(int j = 1; j <= sheet.getLastRowNum(); j++) {
				String alias = sheetName + " " + sheet.getRow(j).getCell(0).getStringCellValue();
				String value = sheet.getRow(j).getCell(1).getStringCellValue();
				references.put(alias, value); 
				//System.out.println(alias + ":"+ value);
			}
		}
	}
}
