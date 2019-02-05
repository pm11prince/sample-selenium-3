package com.seedbank.common.reporting;

import org.testng.ITestResult;

/**
 * @author Pratyush Choudhary
 */
public class Result {

	private ITestResult tr;
	private String suiteName;
	private String testCaseName;
	private String methodName;
	private String result;
	private String resultText;
	private String screenshotText;
	private long time;
	private String testData;

	
	
	
	/**
	 * @param tr
	 *            The testng object that stores various details about the test
	 *            step executed.
	 * @param result
	 *            The result text. Will hold either of Passed, Failed, or
	 *            Skipped.
	 * @param resultText
	 *            The result text based of the result of the test step.
	 */
	public Result(ITestResult tr, String result, String resultText,String xmlTestName) {
		//String className = tr.getMethod().getTestClass().getName();
	//	suiteName = className.substring(className.lastIndexOf('.') + 1);
		suiteName=xmlTestName;
		testCaseName = tr.getMethod().getGroups()[0].toUpperCase();
		methodName = tr.getName();

		int i = 0;
		for (i = methodName.length() - 1; i >= 0; i--) {
			char c = methodName.charAt(i);
			if (c < '0' || c > '9')
				break;
		}
		methodName = camelToSentence(methodName.substring(0, i + 1));
		time = tr.getEndMillis() - tr.getStartMillis();
		this.tr = tr;
		this.result = result;
		this.resultText = resultText;
		screenshotText = "None";
	}

	public void setScreenshotPath(String path) {
		screenshotText = "<div class=\"grow pic\"><a "
				+ "rel=\"lightbox-tc1it1\" href=\"" + path
				+ "\"><img style=\"border:0;\" src=\"" + path
				+ "\" width = 60 height = 100 " + "alt=\"" + path.substring(path.lastIndexOf('\\') + 1)
				+ "\"></a></div>";
	}
	
	
	public String getTestData() {
		return testData;
	}
	
	public String setTestData(String testData) {
		return this.testData= testData;
	}


	public String getScreenshotText() {
		return screenshotText;
	}

	/**
	 * @return Get the result of the test step.
	 */
	public String getResult() {
		return this.result;
	}

	/**
	 * @return Get the result text of the test step.
	 */
	public String getResultText() {
		return this.resultText;
	}

	/**
	 * @return Get the ITestResult object of the test step.
	 */
	public ITestResult getITestResult() {
		return tr;
	}

	/**
	 * @return Get the name of the suite to which this test step belongs.
	 */
	public String getSuiteName() {
		return suiteName;
	}

	/**
	 * @return Get the name of the test case to which this test step belongs.
	 */
	public String getTestCaseName() {
		return testCaseName;
	}

	/**
	 * @return Get the test method name of this step.
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @return Get the time taken in milliseconds to execute the test step.
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param Camel
	 *            case text to convert
	 * @return Converted text
	 */
	public static String camelToSentence(String camel) {
		char[] ch = camel.toCharArray();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < ch.length; i++) {
			if (i == 0) {
				sb.append((char) (ch[i] - ('a' - 'A')));
			} else {
				if (i < ch.length - 2) {
					if ((Character.isUpperCase(ch[i + 1]))
							&& (Character.isDigit(ch[i])
									|| Character.isLowerCase(ch[i]) || Character
										.isLowerCase(ch[i + 2])))
						sb.append(ch[i] + " ");
					else if (Character.isDigit(ch[i + 1])
							&& !Character.isDigit(ch[i]))
						sb.append(ch[i] + " ");
					else {
						sb.append(ch[i]);
					}
				} else {
					sb.append(ch[i]);
				}
			}
		}
		return new String(sb);
	}
}