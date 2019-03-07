package com.seedbank.common.reporting;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Pratyush Choudhary
 */
public class TestSuites {
	
	private HashMap<String, TestCases> testCases = new HashMap<>();
	private ArrayList<String> testCaseNames = new ArrayList<>();
	private String name;
	
	/**
	 * @param name The name of the test suite.
	 */
	public TestSuites(String name) {
		this.name = name;
	}
	
	/**
	 * @param name The name of the testcase to be added.
	 * @param testCase The testcase object to be added.
	 */
	public void addTestCase(String name, TestCases testCase) {
		testCases.put(name, testCase);
		testCaseNames.add(name);
	}
	
	/**
	 * @param name The name of testcase.
	 * @return Returns true if the provided test case exists in the test suite.
	 */
	public boolean testCaseExists(String name) {
		return testCases.containsKey(name);
	}
	
	/**
	 * @param name The name of testcase.
	 * @return The object of the testcase corresponting to the provided name.
	 */
	public TestCases getTestCase(String name) {
		return testCases.get(name);
	}
	
	/**
	 * @param index The index of testcase in the suite.
	 * @return The object of the testcase corresponting to the provided index.
	 */
	public TestCases getTestCaseAt(int index) {
		return testCases.get(testCaseNames.get(index));
	}
	
	/**
	 * @return Returns the number of test cases in the test suite.
	 */
	public int getNoOfTestCases() {
		return testCaseNames.size();
	}
	
	/**
	 * @return Returns the number of test cases that have passed in the suite.
	 */
	public int getNoOfPassedTestCases() {
		int ctr = 0;
		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(testCaseNames.get(i)).isPassed())
				ctr++;
		}
		return ctr;
	}
	
	/**
	 * @return Returns the number of test cases that have failed in the suite.
	 */
	public int getNoOfFailedTestCases() {
		int ctr = 0;
		for(int i = 0; i < testCases.size(); i++) {
			if(!testCases.get(testCaseNames.get(i)).isPassed())
				ctr++;
		}
		return ctr;
	}
	
	/**
	 * @return Returns the name of the test suite.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Returns true if the entire test suite has passed. The test suite fails if any one of the test cases fails.
	 */
	public boolean isPassed() {
		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(testCaseNames.get(i)).isPassed())
				continue;
			else
				return false;
		}
		return true;
	}

	/**
	 * @return Returns the total time taken to execute the test suite.
	 */
	public long getTimeTaken() {
		long timeTaken = 0;
		for(int i = 0; i < testCaseNames.size(); i++) {
			TestCases tc = testCases.get(testCaseNames.get(i));
			timeTaken += tc.getTimeTaken();
		}
		return timeTaken;
	}
}
