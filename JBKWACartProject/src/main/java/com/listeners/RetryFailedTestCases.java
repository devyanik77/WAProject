package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{
	private int count=0;
	private int maxLimit=0;

	public boolean retry(ITestResult result) {
		if(count<maxLimit) {
			System.out.println("Retrying " + result.getName() + " again and the count is " + (count+1));
			count++;
			return true;
		}
		return false;
	}

}
