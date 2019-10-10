package com.automation.utilities;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports extends DriverInitialization {

	@BeforeSuite(alwaysRun = true)
	public void initExtentReport() {

		html = new ExtentHtmlReporter(GlobalVariables.extentReport);

		html.loadXMLConfig(GlobalVariables.reportConfig);

		report = new ExtentReports();

		report.attachReporter(html);
	}

	@AfterSuite(alwaysRun = true)
	public void endReport() {

		report.flush();

	}

	@BeforeClass(alwaysRun = true)
	public void init() {
		launchBrowser(GlobalVariables.BROWSER);
		launchApplication(GlobalVariables.APPLICATION);
	}
	
	@AfterClass(alwaysRun = true)
	public void teriminate() {
		
		driver.close();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void initReportName(Method name) {
		
		logger = report.createTest(name.getName());
	}
	
	@AfterMethod(alwaysRun = true)
	public void verifyTestCaseStatus(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			
			System.out.println(result.getName() +"is Passed");
			
		}else if(result.getStatus() == ITestResult.FAILURE) {
			
			System.out.println(result.getName() +"is Failed");
			System.out.println(result.getThrowable());
			
		}else if(result.getStatus() == ITestResult.SKIP) {
			
			System.out.println(result.getName() +"is Skipped");
		}
		
	}

	public void launchBrowser(String browserName) {

		switch (browserName.toUpperCase()) {
		case "CHROME":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			break;
		case "FIREFOX":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			break;
		case "IE":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			break;

		default:
			logger.log(Status.FAIL, "Please Provide Valid Browser Name");
			break;
		}
		
		driver.manage().window().maximize();
		
	}
	
	public void launchApplication(String url) {
		
		switch (url.toUpperCase()) {
		case "HMS":
			driver.get("http://selenium4testing.com/hms/");
			break;

		default:
			break;
		}
		
	}

}
