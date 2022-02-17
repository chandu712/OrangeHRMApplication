package com.OrangeHRM.utilities;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public  class ExtentReportManager implements ITestListener {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;

	public void onStart(ITestResult testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //Time Stamp
		repName = "OrangeHRM-Report-"+timeStamp+".html";
		
		htmlReporter = new ExtentHtmlReporter(".\\reports\\"+repName); //Specify location of the report
		
		htmlReporter.config().setDocumentTitle("Orange HRM Automation Report"); //Title of report
		htmlReporter.config().setReportName("Orange HRM Regression Testing");  // Name of the project
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "chand");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());  // Create new entry in the report
		test.log(Status.PASS, "Test Passed");
		
		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(screenshotPath);  // Adding screen shot
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getName());  // Create new entry in the report
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(screenshotPath);  // Adding screen shot
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}

	