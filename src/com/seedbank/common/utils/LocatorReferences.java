package com.seedbank.common.utils;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

/**
 * @author Pratyush Choudhary
 */
public class LocatorReferences {
	private static final String LOCATOR_REFERENCES_FILE_LOCATION = "resources/Locator References.xlsx";
	private static final String CLASS_NAME = "CLASS_NAME";
	private static final String CSS_SELECTOR = "CSS_SELECTOR";
	private static final String ID = "ID";
	private static final String LINK_TEXT = "LINK_TEXT";
	private static final String NAME = "NAME";
	private static final String PARTIAL_LINK_TEXT = "PARTIAL_LINK_TEXT";
	private static final String TAG_NAME = "TAG_NAME";
	private static final String XPATH = "XPATH";

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	private static int sheetCount = 0;
	
	public static HashMap<String, By> references = null;
	
	/**
	 * Method to read locators from excel sheet and store them in a hash map.
	 */
	public static void initializeLocators() {
		try {
			FileInputStream fis = new FileInputStream(LOCATOR_REFERENCES_FILE_LOCATION);
			workbook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		references = new HashMap<String, By>();
		
		sheetCount = workbook.getNumberOfSheets();
		for(int i = 0; i < sheetCount; i++) {
			sheet = workbook.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			for(int j = 1; j <= sheet.getLastRowNum(); j++) {
				String alias = sheetName + " " + sheet.getRow(j).getCell(0).getStringCellValue();
				String type = sheet.getRow(j).getCell(1).getStringCellValue();
				String value = sheet.getRow(j).getCell(2).getStringCellValue();
				By val = getBy(type, value);
				references.put(alias, val); 
				//System.out.println(alias + ":"+ value);
			}
		}
	}
	
	private static By getBy(String type, String value) {
		if(type.equals(CLASS_NAME)) {
			return By.className(value);
		}
		else if(type.equals(CSS_SELECTOR)) {
			return By.cssSelector(value);
		}
		else if(type.equals(ID)) {
			return By.id(value);
		}
		else if(type.equals(LINK_TEXT)) {
			return By.linkText(value);
		}
		else if(type.equals(NAME)) {
			return By.name(value);
		}
		else if(type.equals(PARTIAL_LINK_TEXT)) {
			return By.partialLinkText(value);
		}
		else if(type.equals(TAG_NAME)) {
			return By.tagName(value);
		}
		else if(type.equals(XPATH)) {
			return By.xpath(value);
		}
		return null;
	}
}
