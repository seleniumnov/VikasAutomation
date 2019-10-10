package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilities.GenericMethods;
import com.aventstack.extentreports.Status;

import applicationPages.LoginPage;

public class SampleTest extends GenericMethods {

	
	@Test(priority = 1)
	public void login() {

		logger = logger.assignAuthor("Suresh");

		logger = logger.assignCategory("Smoke");

		logger.log(Status.INFO, "Successfully Configured Extent Report");

	}

	@Test(priority = 2)
	public void hmsLogin() {

		LoginPage login = new LoginPage(driver);

		input(login.getUserName(), "admin", "User Name");
		
		Assert.fail("Failing");

	}

}
