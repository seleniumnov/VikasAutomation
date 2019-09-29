package com.automation.utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GlobalVariables {
	
	
	public static WebDriver driver = null;
	
	// Browser Keys
	public static String chromeKey = "webdriver.chrome.driver";
	public static String firefoxKey = "webdriver.gecko.driver";
	public static String ieKey = "webdriver.ie.driver";
	
	// Browser Values
	public static String chromeValue = System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe";
	public static String firefoxValue = System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe";
	public static String ieValue = System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe";
	
	
	// Extent Report ConfigFile and Variables
	public static String reportConfig = System.getProperty("user.dir")+"/ExtentReports/Extent-Config.xml";
	
	public static String extentReport = System.getProperty("user.dir")+"/ExtentReports/extentReport.html";
	
	public static ExtentHtmlReporter html = null;
	public static ExtentReports report = null;
	public static ExtentTest logger = null;
	

}
