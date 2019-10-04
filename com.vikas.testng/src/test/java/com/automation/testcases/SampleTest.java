package com.automation.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.automation.utilities.GenericMethods;
import com.aventstack.extentreports.Status;

import applicationPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest extends GenericMethods {
	
	LoginPage login = new LoginPage();
	
	@Test(priority = 1)
	public void login() {
		
		logger = report.createTest("User Login");
		
		logger = logger.assignAuthor("Suresh");
		
		logger = logger.assignCategory("Smoke");
		
		logger.log(Status.INFO, "Successfully Configured Extent Report");
		
	}
	
	
	@Test(priority = 2)
	public void hmsLogin() {
		
		
		
		logger = report.createTest("HMS Login");
		
		
		
		//System.setProperty("", "");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium4testing.com/hms/");
		input(login.userName1,"admin","User Name");
		
		
	}

}
