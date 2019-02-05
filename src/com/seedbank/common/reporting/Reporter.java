package com.seedbank.common.reporting;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;


import com.seedbank.base.TestCaseBase;
import com.seedbank.common.utils.Logger;

/**
 * @author Pratyush Choudhary
 */
public class Reporter {
	public static final String PASS_TEXT = "Passed";
	public static final String FAIL_TEXT = "Failed";
	public static final String SKIP_TEXT = "Skipped";

	private static final String TITLE = "Seedbank Test Automation Report";
	private static final String TITLE_PLACEHOLDER = "#TITLE#";
	private static final String TOTAL_TEST_SUITES_PLACEHOLDER = "#TOTALTESTSUITS#";
	private static final String PASSED_TEST_SUITES_PLACEHOLDER = "#PASSEDTESTSUITS#";
	private static final String FAILED_TEST_SUITES_PLACEHOLDER = "#FAILEDTESTSUITS#";
	private static final String DATE_TIME_PLACEHOLDER = "#DATETIME#";
	private static final String PASS_PERCENT_PLACEHOLDER = "#PASSPERCENTAGE#";
	private static final String RESULT_PLACEHOLDER = "#RESULTDETAILS#";
	private static final String ADD_ANIME_DIV_PLACEHOLDER = "#ADDANIMEDIV#";
	private static final String SHOW_HIDE_ALL_PLACEHOLDER = "#SHOW_HIDE_ALL#";
	private static final String EXECUTION_START_TIME_PLACEHOLDER = "#EXECUTIONSTARTTIME#";
	private static final String EXECUTION_END_TIME_PLACEHOLDER = "#EXECUTIONENDTIME#";
	private static final String TOTAL_EXECUTION_TIME_PLACEHOLDER = "#TOTALEXECUTIONTIME#";
	private static final String OS_PLACEHOLDER = "#OS#";
	private static final String BROWSER_PLACEHOLDER = "#BROWSER#";
	private static final String APPURL_PLACEHOLDER = "#APPURL#";
	private static final String TCTOTAL_PLACEHOLDER = "#TCTOTAL#";
	private static final String TCPASS_PLACEHOLDER = "#TCPASS#";
	private static final String TCFAIL_PLACEHOLDER = "#TCFAIL#";
	private static final String TCPASSPERCENTAGE_PLACEHOLDER = "#TCPASSPERCENTAGE#";
	private static final String TEMPLATE_PATH = "template\\template.html";
	private static final String HTML_REPORT_PATH = "reports\\";
	private static DecimalFormat round = new DecimalFormat("##.00");
	private static int tcTotal = 0, tcPass = 0, tcFail = 0;
	private static int 	passed = 0, failed = 0, total = 0;
	private static long totalTime = 0;

	public static String currentDate;

	private static List<String> suiteNames;
	private static HashMap<String, TestSuites> suites;

	static {
		currentDate = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss")
				.format(new Date());
	}

	/**
	 * Initialize objects to store the results of different suites
	 */
	public static void initialize() {
		System.out.println("In reporter class");
		suiteNames = new ArrayList<>();
		suites = new HashMap<>();
	}

	/**
	 * @param actualValue
	 *            The actual value that was found after test step execution.
	 * @param expectedValue
	 *            The expected value after test execution.
	 * @param tr
	 *            The testng object that stores various details about the test
	 *            step executed.
	 * @param status
	 *            The enum that holds the result of the test step executed. It
	 *            can be either of PASSED, FAILED or SKIPPED.
	 */
	public static void report(String actualValue, String expectedValue,
			ITestResult tr, Status status,String xmlTestCaseName) {
		Result result = null;
		Values.testCaseName = tr.getMethod().getGroups()[0];
		if (status.equals(Status.PASSED)) {
			result = new Result(tr, PASS_TEXT, "Actual value '" + actualValue
					+ "' matches expected value",xmlTestCaseName);
		} else if (status.equals(Status.FAILED)) {
			result = new Result(tr, FAIL_TEXT, "Actual value '" + actualValue
					+ "' does not match expected value '" + expectedValue + "'",xmlTestCaseName);
			/*String path = takeScreenShot();
			result.setScreenshotPath(path);*/
		} else if (status.equals(Status.SKIPPED)) {
			result = new Result(tr, SKIP_TEXT, "Case Skipped Altogether",xmlTestCaseName);
		}
		String suitName = result.getSuiteName();

		String testCaseName = result.getTestCaseName();
		if (suites.containsKey(suitName)) {
			TestSuites ts = suites.get(suitName);
			if (ts.testCaseExists(testCaseName)) {
				TestCases tc = ts.getTestCase(testCaseName);
				result.setTestData(Values.tcTestData);
				tc.addStep(result);
			} else {
				TestCases tc = new TestCases(result.getTestCaseName(),
						Values.tcDescription);
				result.setTestData(Values.tcTestData);
				tc.addStep(result);
				ts.addTestCase(result.getTestCaseName(), tc);
			}
		} else {
			TestSuites ts = new TestSuites(result.getSuiteName());
			TestCases tc = new TestCases(result.getTestCaseName(),
					Values.tcDescription);
			result.setTestData(Values.tcTestData);
			tc.addStep(result);
			ts.addTestCase(result.getTestCaseName(), tc);
			suites.put(result.getSuiteName(), ts);
			suiteNames.add(result.getSuiteName());
		}
	}

	private static String takeScreenShot() {
		String path = generateUniquePath();
		WebDriver augmentedDriver = new Augmenter().augment(TestCaseBase.getAndroidDriver());
		File scrFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path), true);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return path.substring(path.indexOf('\\') + 1);
	}

	private static String generateUniquePath() {
		String path = "";
		File f = null;
		do {
			path = "reports\\screenshots\\";
			Random random = new Random();
			char[] list = "0123456789abcdef".toCharArray();
			for (int i = 0; i < 32; i++) {
				path += list[random.nextInt(list.length)];
			}
			path += ".png";
			f = new File(path);
		} while (f.exists());
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * Write the results to the HTML file.
	 * @throws TransformerException 
	 */
	public static void writeResults() throws TransformerException {

		try {
			currentDate = Values.initializeEndTime();
			String reportIn = new String(Files.readAllBytes(Paths
					.get(TEMPLATE_PATH)));
			reportIn = reportIn.replace(DATE_TIME_PLACEHOLDER, Values.endTime);

			StringBuffer details = new StringBuffer();
			ArrayList<String> expList = new ArrayList<String>();

			for (int i = 0; i < suites.size(); i++) {
				expList.add("ts" + (i + 1));
				String suiteName = suiteNames.get(i);
				TestSuites ts = suites.get(suiteName);
				details.append("<div class=\"testcasepadding\" style=\"overflow:hidden\"><p><a href=\"javascript:animatedcollapse.toggle('ts"
						+ (i + 1)
						+ "')\" style=\"text-decoration: none; font-size: 2em; color: "
						+ (ts.isPassed() ? "green" : "red")
						+ "\" name=\"testsuite"
						+ (i + 1)
						+ "\"><b>"
						+ suiteName
						+ "</b></a></p></div><div id=\"ts"
						+ (i + 1) + "\" class=\"texter\">");
				details.append("<table name=\"SummaryTable-ts"
						+ (i + 1)
						+ "\" style=\"table-layout: fixed; width: 50%\" align=\"center\" id=\"summarytable-tc"
						+ (i + 1)
						+ "\" cellpadding=\"10\" cellspacing=\"0\" summary=\"Summary table for Test Case\"><br>");
				details.append("<tbody>");
				details.append("    <tr>");
				details.append("        <th class=\"blue\" width=\"30%\">Total Test Cases</th>");
				details.append("        <td style=\"border-top-right-radius:10px\">"
						+ ts.getNoOfTestCases() + "</td>");
				details.append("    </tr>");
				details.append("    <tr>");
				details.append("        <th class=\"blue\" width=\"30%\">Test Cases Passed</th>");
				details.append("        <td>" + (ts.getNoOfPassedTestCases())
						+ "</td>");
				details.append("    </tr>");
				details.append("  <tr>");
				details.append("<th class=\"blue\" width=\"30%\">Test Cases Failed</th>");
				details.append("<td>" + (ts.getNoOfFailedTestCases()) + "</td>");
				details.append("</tr>");
				details.append("  <tr>");
				details.append("<th class=\"blue\" width=\"30%\">Pass Percentage</th>");
				details.append("<td>"
						+ round.format(100 * ts.getNoOfPassedTestCases()
								/ (float) ts.getNoOfTestCases()) + "%"
								+ "</td>");
				details.append("</tr>");
				details.append(" <tr>");
				details.append("<th class=\"blue\" width=\"30%\">Total Duration</th>");
				details.append("   <td>" + (ts.getTimeTaken() / 1000)
						+ "s</td>");
				details.append("</tr>");
				details.append("</tbody>");
				details.append("</table>");
				details.append("<p></p>");
				for (int j = 0; j < ts.getNoOfTestCases(); j++) {
					TestCases tc = ts.getTestCaseAt(j);
					tcTotal++;
					if (tc.isPassed())
						tcPass++;
					else
						tcFail++;
					expList.add("ts" + (i + 1) + "tc" + (j + 1));
					String cls = tc.isPassed() ? "pass" : "fail";

					details.append("<div class=\"iterationpadding\" style=\"overflow:hidden\"><a href=\"javascript:animatedcollapse.toggle('ts"
							+ (i + 1)
							+ "tc"
							+ (j + 1)
							+ "')\" style=\"text-decoration: none; font-size: 1.5em; color: "
							+ (tc.isPassed() ? "green" : "red")
							+ "\"><b>"
							+ tc.getName()
							+ "</b></a></div><div id=\"ts"
							+ (i + 1) + "tc" + (j + 1) + "\" class=\"texter\">");

					details.append("<table name=\"SummaryTable-ts"
							+ (i + 1)
							+ "tc"
							+ (j + 1)
							+ "\" style=\"table-layout: fixed; width: 50%\" align=\"center\" id=\"summarytable-tc"
							+ (i + 1)
							+ "\" cellpadding=\"10\" cellspacing=\"0\" summary=\"Summary table for Test Case\"><br>");
					details.append("<tbody>");
					details.append("    <tr>");
					details.append("        <th class=\"blue\" width=\"30%\">Description</th>");
					details.append("        <td style=\"border-top-right-radius:10px\">"
							+ tc.getDescription() + "</td>");
					details.append("    </tr>");
					details.append("</tbody>");
					details.append("</table>");
					details.append("<p></p>");

					details.append("<table name=\"table-ts"
							+ (i + 1)
							+ "tc"
							+ (j + 1)
							+ "\" style=\"table-layout: fixed; width: 90%\" align=\"center\" id=\"table-ts"
							+ (i + 1)
							+ "tc"
							+ (j + 1)
							+ "\" cellpadding=\"10\" cellspacing=\"0\" summary=\"Summary table for Iteration\"><br><thead><tr><th class=\""
							+ cls
							+ "\" style=\"width:8%\">Test Step Number</th><th class=\""
							+ cls + "\">Test Step</th><th class=\"" + cls
							+ "\">Test Data</th><th class=\"" + cls
							+ "\">Execution Status</th><th class=\"" + cls
							+ "\">Screenshots</th></tr></thead><tbody>");
					for (int k = 0; k < tc.getNoOfSteps(); k++) {
						Result res = tc.getResultAt(k);
						totalTime += res.getTime();
						details.append("<tr>");
						details.append("<td>" + (k + 1) + "</td>");
						details.append("<td>" + res.getMethodName() + "</td>");
						details.append("<td>" + (res.getTestData()) + "</td>");
						details.append("<td><font color=\""
								+ ((res.getResult().equals(Reporter.FAIL_TEXT)) ? "red"
										: (res.getResult().equals(
												Reporter.PASS_TEXT) ? "green"
														: "gray")) + "\"><b>"
														+ res.getResult() + "</b></font></td>");
						details.append("<td>" 
								+ res.getScreenshotText() + ((res.getResult().equals(Reporter.FAIL_TEXT)) ? res
										.getITestResult().getThrowable()
										.getMessage()
										: "") + "</td>");
						details.append("</tr>");


					}
					details.append("</tbody>");
					details.append("</table>");
					details.append("</div>");
					details.append("<p></p>");
				}
				details.append("</div>");
			}

			String addDivStatements = "";
			String showHideAll = "";
			for (int i = 0; i < expList.size(); i++) {
				addDivStatements = addDivStatements
						+ "animatedcollapse.addDiv('" + expList.get(i)
						+ "', 'fade=1')\n";
				showHideAll += "'" + expList.get(i) + "',";
			}
			showHideAll = showHideAll.substring(0, showHideAll.length() - 1);


			for (int i = 0; i < suiteNames.size(); i++) {
				TestSuites s = suites.get(suiteNames.get(i));
				if (s.isPassed())
					passed++;
				else
					failed++;
				total++;
			}
			String tcPassPercentage = round.format(100 * tcPass
					/ (float) tcTotal)
					+ "%";
			reportIn = reportIn.replace(OS_PLACEHOLDER, Values.os);
			reportIn = reportIn.replace(BROWSER_PLACEHOLDER, Values.browser);
			reportIn = reportIn.replace(APPURL_PLACEHOLDER, Values.app);
			reportIn = reportIn.replace(TCTOTAL_PLACEHOLDER,
					String.valueOf(tcTotal));
			reportIn = reportIn.replace(TCPASS_PLACEHOLDER,
					String.valueOf(tcPass));
			reportIn = reportIn.replace(TCFAIL_PLACEHOLDER,
					String.valueOf(tcFail));
			reportIn = reportIn.replace(TCPASSPERCENTAGE_PLACEHOLDER,
					tcPassPercentage);
			reportIn = reportIn.replace(EXECUTION_START_TIME_PLACEHOLDER,
					Values.startTime);
			reportIn = reportIn.replace(EXECUTION_END_TIME_PLACEHOLDER,
					Values.endTime);
			reportIn = reportIn.replace(TOTAL_EXECUTION_TIME_PLACEHOLDER,
					String.valueOf(totalTime / 1000) + "s");
			reportIn = reportIn.replace(TOTAL_TEST_SUITES_PLACEHOLDER,
					String.valueOf(total));
			reportIn = reportIn.replace(PASSED_TEST_SUITES_PLACEHOLDER,
					String.valueOf(passed));
			reportIn = reportIn.replace(FAILED_TEST_SUITES_PLACEHOLDER,
					String.valueOf(failed));
			reportIn = reportIn.replace(PASS_PERCENT_PLACEHOLDER,
					String.valueOf(100 * passed / total) + "%");
			reportIn = reportIn.replace(SHOW_HIDE_ALL_PLACEHOLDER, showHideAll);
			reportIn = reportIn.replace(TITLE_PLACEHOLDER, TITLE);
			reportIn = reportIn.replace(ADD_ANIME_DIV_PLACEHOLDER,
					addDivStatements);
			reportIn = reportIn
					.replace(RESULT_PLACEHOLDER, new String(details));

			String reprtDirectory= createReportDirectory();

			String htmlReportPath = reprtDirectory + "\\report_" + currentDate
					+ ".html";
			new File(Logger.LOG_FILE).renameTo(new File("log\\log_"
					+ currentDate + ".txt"));
			new File(Logger.LOG_FILE).delete();
			Files.write(Paths.get(htmlReportPath), reportIn.getBytes(),
					StandardOpenOption.CREATE);
			File htmlFile = new File(htmlReportPath);
			createXML(reprtDirectory);
			Desktop.getDesktop().browse(htmlFile.toURI());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method creates a DOM object with required structure and saves the transformed DOM to XML
	 * file into the report directory  
	 * 
	 * @param reportDirectory 
	 * 		  Directory path where XML file to be saved 	
	 */

	public static void createXML(String reportDirectory) throws IOException, TransformerException
	{
		XMLBuffer xmlBuff= new XMLBuffer();
		xmlBuff.initializeXMLDocument();

		String tcPassPercentage = round.format(100 * tcPass
				/ (float) tcTotal)
				+ "%";
		xmlBuff.CreateRootElement("SeedBankTestFramework");
		xmlBuff.AddExecutionMetadataNode();
		xmlBuff.AddExecutionMetadata("AutomationTool", "Appium");
		xmlBuff.AddExecutionMetadata("Platform", Values.os);
		xmlBuff.AddExecutionMetadata("PlatformVerion", Values.version);
		xmlBuff.AddExecutionMetadata("TotalTestSuiteExecuted",	String.valueOf(total) );
		xmlBuff.AddExecutionMetadata("TestSuitePassPercentage", String.valueOf(100 * passed / total) + "%");
		xmlBuff.AddExecutionMetadata("TotalTestCases", String.valueOf(Reporter.tcTotal));
		xmlBuff.AddExecutionMetadata("TestCasesPassed", String.valueOf(Reporter.tcPass));
		xmlBuff.AddExecutionMetadata("TestCasesFailed", String.valueOf(Reporter.tcFail));
		xmlBuff.AddExecutionMetadata("TestCasePassPercentage", tcPassPercentage);
		xmlBuff.AddExecutionMetadata("ExecutionStartTime", Values.startTime);
		xmlBuff.AddExecutionMetadata("ExecutionEndTime", Values.endTime);
		xmlBuff.AddExecutionMetadata("TotalExecutionTime", String.valueOf(totalTime / 1000) + "s");

		for (int i = 1; i <= Reporter.suites.size(); i++) {
			String suiteName = Reporter.suiteNames.get((i-1));
			TestSuites ts = Reporter.suites.get(suiteName);
			xmlBuff.AddTestSuite(i);
			xmlBuff.AddTestSuiteMetadataNode(i);
			xmlBuff.AddTestSuiteMetadata(i, "Name", suiteName);
			xmlBuff.AddTestSuiteMetadata(i, "TotalTestCases", String.valueOf(ts.getNoOfTestCases()));
			xmlBuff.AddTestSuiteMetadata(i, "TestCasesPassed", String.valueOf(ts.getNoOfPassedTestCases()));
			xmlBuff.AddTestSuiteMetadata(i, "TestCasesFailed", String.valueOf(ts.getNoOfFailedTestCases()));
			xmlBuff.AddTestSuiteMetadata(i, "PassPercentage", round.format(100 * ts.getNoOfPassedTestCases()
					/ (float) ts.getNoOfTestCases()) + "%");
			xmlBuff.AddTestSuiteMetadata(i, "TotalDuration", String.valueOf(ts.getTimeTaken() / 1000));



			for (int j = 1; j <= ts.getNoOfTestCases(); j++) {
				TestCases tc = ts.getTestCaseAt(j-1);
				xmlBuff.AddTestCase(i,j);
				xmlBuff.AddTestCaseMetadataNode(i, j);
				xmlBuff.AddTestCaseMetadata(i, j, "TestCaseName", tc.getName());
				xmlBuff.AddTestCaseMetadata(i, j, "TestCaseDescription", tc.getDescription());

				for (int k = 1; k <= tc.getNoOfSteps(); k++) {
					Result res = tc.getResultAt(k-1);

					xmlBuff.AddStep(i,j,k);
					xmlBuff.AddStepMetadata(i, j, k, "TestStepDescription", res.getMethodName());
					xmlBuff.AddStepMetadata(i, j, k, "TestData", res.getTestData());
					xmlBuff.AddStepMetadata(i, j, k, "ExecutionStatus", res.getResult());
				}
			}
		}

		xmlBuff.SaveXML(reportDirectory + "\\XMLReport_" + currentDate
				+ ".xml");
	}

	/**
	 * This method creates a new directory for saving HTML & XML reports	
	 */
	private static String createReportDirectory() throws IOException
	{

		String reportDirectory=HTML_REPORT_PATH + "/" + "reports_"
				+ currentDate;
		File dir = new File(reportDirectory);
		dir.mkdirs();
		return reportDirectory;

	}
}