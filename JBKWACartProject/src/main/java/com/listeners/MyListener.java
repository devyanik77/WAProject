package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utilities.ScreenshotUtil;
public class MyListener extends TestBase implements ITestListener{



	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.INFO, "-------TESTCASE "+result.getName()+" START------- ");	
		Log.info("====================================="+result.getName()+" TEST START=========================================");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "-------TESTCASE "+result.getName()+" is Passed------- ");
		Log.info("====================================="+result.getName()+" TEST PASSED=========================================");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "-----TESTCASE "+result.getName()+" is failed ");
		String path=ScreenshotUtil.getScreenshot(result.getName());	
		test.addScreenCaptureFromPath(path);
		Log.info("====================================="+result.getName()+" TEST FAILED=========================================");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "-----TESTCASE "+result.getName()+" is skipped & skip reason is "+result.getThrowable());
		Log.info("====================================="+result.getName()+" TEST SKIPPED=========================================");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		reportSetup();		
	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}



}
