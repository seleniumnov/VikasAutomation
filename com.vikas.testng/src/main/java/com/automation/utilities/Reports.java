package com.automation.utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports extends GlobalVariables {
	
	
	@BeforeSuite
	public void initExtentReport() {
		
		html = new ExtentHtmlReporter(extentReport);
		
		html.loadXMLConfig(reportConfig);
		
		report = new ExtentReports();
		
		report.attachReporter(html);
	}
	
	
	@AfterSuite
	public void endReport() {
		
		report.flush();
		
	}

}
