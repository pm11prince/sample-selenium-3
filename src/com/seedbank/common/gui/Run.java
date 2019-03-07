package com.seedbank.common.gui;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Logger;

/**
 * <copyright file="Run.java" company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author Deepa Elenor Mathias
 */

public class Run {

	public static LinkedHashMap<String, ArrayList<String>> groupnamesMap = new LinkedHashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		formXML();
}

	/**
	 * formXML() method contructs testng xml file based on the inputs provided
	 * in Driver.xlsx
	 * 
	 * @author 11763
	 */

	public static void formXML() {

		groupnamesMap = ReadTestFlowsSheet.readTestFlowSheets();
		String xml = "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">"
				+ "<suite name=\"SeedBank TestSuites\">" + "<parameter name=\"OS\" value=\"Android\"/>"
				+ "<parameter name=\"deviceID\" value=\"" + Values.settings.get("deviceID") + "\" />" + "<listeners>"
				+ "<listener class-name=\"com.seedbank.common.reporting.CustomListener\" />" + "</listeners>";

	/*	xml += "<test name=\"Setup class\" preserve-order=\"true\"><groups><run>";
		xml += "<include name=\"setup\" />";
		xml += "</run></groups>";
		xml += "<classes><class name=\"com.seedbank.base.TestCaseBase\" /></classes>";
		xml += "</test>";
*/
		Set<String> setOfKeySet = groupnamesMap.keySet();

		
		for (String key : setOfKeySet) {
			Logger.log("\nTest name : " + key + "\nList of TestNames of " + key + ":");

			for (String groupClassName : groupnamesMap.get(key)) {
				String[] groupClassArray = groupClassName.split("\\$");
				String groupName = groupClassArray[0];
				String className = groupClassArray[1];
				xml += "<test name=\"" + key + "::" + groupClassName + "\" " + "preserve-order=\"true\">";
				xml += "<groups><run><include name=\"" + groupName + "\"/></run></groups>";
				xml += "<classes><class name=\"com.seedbank.common.tests." + className + "\"/></classes>";
				xml += "</test>";

			}
		}
		xml += "</suite>";

		Logger.log("Constructed XML::"+xml);
		execute(xml);
	}

	/**
	 * execute() method converts the string xml constructed by formXML() method
	 * to xml and writes it in text.xml file and instructs testng framework to
	 * execute the same
	 * 
	 * @author Deepa Elenor Mathias
	 */
	private static void execute(String xml) {
		try {
			String PATH = "text.xml";
			File f = new File(PATH);
			if (!f.exists())
				f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
			bw.write(xml);
			bw.close();
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add(PATH);
			testng.setTestSuites(suites);
			testng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
