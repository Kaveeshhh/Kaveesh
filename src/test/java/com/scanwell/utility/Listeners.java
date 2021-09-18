package com.scanwell.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.scanwell.commands.Commands;

public class Listeners implements ITestListener {
	Commands helper = new Commands();

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		// hey i am done
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// screenshot

		try {
			helper.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
