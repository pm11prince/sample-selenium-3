package com.seedbank.common.reporting;

import java.util.ArrayList;

/**
 * @author Pratyush Choudhary
 */
public class TestCases {

	private ArrayList<Result> steps = new ArrayList<>();
	private boolean passed = true;
	private String name;
	private String description;
	private String testData;

	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}

	/**
	 * @param name
	 *            The name of the testcase.
	 */
	public TestCases(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * @param step
	 *            The object of a test result.
	 */
	public void addStep(Result step) {
		if (step.getResult().equals(Reporter.FAIL_TEXT))
			passed = false;
		steps.add(step);
	}

	/**
	 * @param i
	 *            The index, starting from 0, for which the Result object is
	 *            needed.
	 * @return The Result object at ith index of the testcase.
	 */
	public Result getResultAt(int i) {
		return steps.get(i);
	}

	/**
	 * @return The number of steps in the testcase.
	 */
	public int getNoOfSteps() {
		return steps.size();
	}

	/**
	 * @return The result of the entire testcase. The test case fails if any one
	 *         of the test steps fails.
	 */
	public boolean isPassed() {
		return passed;
	}

	/**
	 * @return The name of the testcase.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Get the total time taken to execute the entire testcase.
	 */
	public long getTimeTaken() {
		long timeTaken = 0;
		for (Result r : steps) {
			timeTaken += r.getTime();
		}
		return timeTaken;
	}

	public String getDescription() {
		return description;
	}
	
	
}