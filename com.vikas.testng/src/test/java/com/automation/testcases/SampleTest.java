package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.utilities.Reports;
import com.aventstack.extentreports.Status;

public class SampleTest extends Reports {
	
	
	
	@Test
	public void login() {
		
		logger = report.createTest("User Login");
		
		logger = logger.assignAuthor("Suresh");
		
		logger = logger.assignCategory("Smoke");
		
		logger.log(Status.INFO, "Successfully Configured Extent Report");
		
	}

}
