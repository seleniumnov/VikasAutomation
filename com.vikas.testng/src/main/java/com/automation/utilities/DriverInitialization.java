package com.automation.utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DriverInitialization {

	public static WebDriver driver = null;

	public static ExtentHtmlReporter html = null;
	public static ExtentReports report = null;
	public static ExtentTest logger = null;

}
