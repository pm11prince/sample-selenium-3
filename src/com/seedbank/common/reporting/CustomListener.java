package com.seedbank.common.reporting;

import javax.xml.transform.TransformerException;

import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.seedbank.base.TestCaseBase;
import com.seedbank.common.reporting.Reporter;
import com.seedbank.common.reporting.Status;
import com.seedbank.common.reporting.Values;
import com.seedbank.common.utils.Action;
import com.seedbank.common.utils.AppiumServerUtils;
import com.seedbank.common.utils.DataReference;
import com.seedbank.common.utils.LocatorReferences;
import com.seedbank.common.utils.Logger;

/**
 * @author Pratyush Choudhary
 */
public class CustomListener extends TestListenerAdapter implements
		IExecutionListener {

	public String xmlTestcaseName="";
	@Override
    public void onStart(ITestContext testContext) {
		Logger.log("Test case name--->"+testContext.getName());
		String[] fullName=testContext.getName().split("::");
		xmlTestcaseName=fullName[0];
		
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		Logger.log(tr.getName() + " ----> Failed");
		Logger.log(tr.getThrowable().toString());
		Reporter.report(Values.actual, Values.expected, tr, Status.FAILED,xmlTestcaseName);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		Logger.log(tr.getName() + " ----> Skipped");
		Reporter.report(Values.actual, Values.expected, tr, Status.SKIPPED,xmlTestcaseName);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		Logger.log(tr.getName() + " ----> Success");
		Reporter.report(Values.actual, Values.expected, tr, Status.PASSED,xmlTestcaseName);
	}

	
	@Override
	public void onExecutionStart() {
		System.out.println("onExecutionStart");
		//AppiumServerUtils.startServer();
		Logger.log("Starting Appium Server");
		//Action.waitALittle(10000);
		Logger.log("Starting Test Execution");
		Logger.log("Initializing locators from excel sheet...");
		LocatorReferences.initializeLocators();
		if (LocatorReferences.references != null)
			Logger.log("Initializing locators from excel sheet completed successfully!");
		else
			Logger.log("Initializing locators from excel sheet failed!");

		Logger.log("Initializing data from excel sheet...");
		DataReference.initializeData();
		if (DataReference.references != null)
			Logger.log("Initializing data from excel sheet completed successfully!");
		else
			Logger.log("Initializing data from excel sheet failed!");
       System.out.println("----------------------------------------------------------------");
		Reporter.initialize();
		Values.initializeStartTime();
	}

	@Override
	public void onExecutionFinish() {
		Logger.log("Ending Execution...");
		Logger.log("Trying to close Webdriver...");
		try {
			TestCaseBase.getAndroidDriver().quit();
			Logger.log("Selenium Webdriver closed successfully!");
			//AppiumServerUtils.stopServer();
			Logger.log("Appium server is shutdown successfully");
			Action.waitALittle(10000);
		} catch(Exception e) {
			Logger.log("Error closing the drivers!");
		}
		Logger.log("Writing Results and Logs to file...");
		try {
			Reporter.writeResults();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}