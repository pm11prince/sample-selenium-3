package com.seedbank.common.gui;


/**
 * <copyright file="ExecutionSheetObject.java" company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * ExecutionSheet object holds sheet name and test name values from Execution sheet of the Driver.xslx
 * 
 * @author Deepa Elenor Mathias
 */



public class ExecutionSheetObject {

	String sheetName, testName;


	public ExecutionSheetObject(String sheetName, String testName) {
		this.sheetName=sheetName;
		this.testName=testName;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}


	
	
	
}
