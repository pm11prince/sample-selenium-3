package com.seedbank.common.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Pratyush Choudhary
 */
public class Values {
	public static final int TEST_STEP_BREAK = 0;
	public static final String WEB = "Web";
	public static final String MOBILE = "Mobile";

	public static String actual = "";
	public static String expected = "";
	public static String browser = "";
	public static String app = "";
	public static String platform = "";
	public static String startTime = "";
	public static String endTime = "";
	public static String author = "";
	public static String PLATFORM = "";
	public static long startTimeMilli = 0;
	public static String os = "";;
	public static String version = "";;
	public static String originalHandle = "";
	public static String testCaseName = "";
	public static String tcDescription = "Test Description";
	public static String tcTestData="";

	private static final String FORMAT = "EEE, MMM dd  yyyy; KK:mm:ss aa";
	private static final String FORMAT_2 = "dd-MM-yyyy_HH_mm_ss";
	
	public static HashMap<String,String> settings = new HashMap<String, String>();
	
	/**
	 * Initialize the time when the test execution starts
	 */
	public static void initializeStartTime() {
		startTimeMilli = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		startTime = sdf.format(new Date());
	}

	/**
	 * @return Returns the time when test execution ends.
	 */
	public static String initializeEndTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		endTime = sdf.format(date);
		SimpleDateFormat sdf_re = new SimpleDateFormat(FORMAT_2);
		return sdf_re.format(date);
	}
}
