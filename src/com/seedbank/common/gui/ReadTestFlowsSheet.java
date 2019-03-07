package com.seedbank.common.gui;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.ExcelFunctions;
import com.seedbank.common.utils.Logger;


/**
 * <copyright file="ReadTestFlowsSheet.java" company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author Deepa Elenor Mathias
 */
public class ReadTestFlowsSheet {

	public static ArrayList<ExecutionSheetObject> executionList = new ArrayList<ExecutionSheetObject>();

	public static ArrayList<String> groupNameList;
	public static LinkedHashMap<String,ArrayList<String>> groupnamesMap= new LinkedHashMap<String, ArrayList<String>>(); 
	public static XSSFSheet sheet;
	
	
	/**
	 * readTestFlowSheets() method iterates through the list of executionSheetObject's.
	 *  Based on the sheet name, it reads the corresponding flow sheet to get the group name
	 *  and class name. It stores the group names & class names of each flow into array list.
	 * Once all group names of particular flow are read, they are stored into hashmap with key as flow
	 * name
	 * @return HashMap with key as Flow Name and value as "grouname$classname"
	 * @author Deepa Elenor Mathias
	 */
	
	public static LinkedHashMap<String,ArrayList<String>> readTestFlowSheets()
	{
		int sheetNumber,testStartRow,testEndRow;
		String testName;
		executionList=ReadExecutionSheet.readDriverSheet();
		ExcelFunctions.initializeExcelSheet(ReadExecutionSheet.DRIVER_SHEET_LOCATION);

		for(ExecutionSheetObject s : executionList)
		{
			sheetNumber=ExcelFunctions.getSheetNumber(s.sheetName);
			testName=s.getTestName();
			testStartRow=ExcelFunctions.findStartRow(sheetNumber, testName);
			testEndRow=ExcelFunctions.findEndRow(sheetNumber, testStartRow);
			/*		Logger.log("Sheetname"+s.sheetName);
			Logger.log("SheetNumber"+sheetNumber);
			Logger.log("testName"+testName);
			Logger.log("testStartRow"+testStartRow);
			Logger.log("testEndRow"+testEndRow);
			 */		groupNameList=new ArrayList<String>();
			 for(int i=testStartRow;i<testEndRow;i++)
			 {
				 String groupName=ExcelFunctions.getCellData(i, 2, sheetNumber);
				 String className=ExcelFunctions.getCellData(i, 3, sheetNumber);
				 groupNameList.add(groupName+"$"+className);	

			 }


			 groupnamesMap.put(testName, groupNameList);
		}
		Set<String> setOfKeySet = groupnamesMap.keySet();

		// for-each loop
		for(String key : setOfKeySet) {

			Logger.log("\nTest name : "  + key 
					+ "\nList of TestNames of " + key + ":");

			for(String country : groupnamesMap.get(key)) {
				Logger.log("\t\t\t\t" + country);

			}
		}
		readSettings();
		return groupnamesMap;



	}
	
	/**
	 * readSettings() method reads entire Settings sheet under Driver.xlsx
	 * Stores all values in Settings Hashmap
	 * @author Deepa Elenor Mathias
	 */
	public static void readSettings(){

		int sheetNumber;
		
		sheetNumber=ExcelFunctions.getSheetNumber("Settings");
		
		for(int i=1;i<=ExcelFunctions.findLastRow(sheetNumber);i++)
		{
			String type = ExcelFunctions.getCellData(i, 0, sheetNumber);
			String value =  ExcelFunctions.getCellData(i, 1, sheetNumber);
			Values.settings.put(type, value);
		}

		
		for (Map.Entry<String, String> entry : Values.settings.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}

	}


}
