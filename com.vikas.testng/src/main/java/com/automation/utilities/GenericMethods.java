package com.automation.utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class GenericMethods extends Reports {

	

	public static void isElementDisplayed(WebElement ele) {

		try {
			for (int i = 0; i < 60; i++) {
				Thread.sleep(1000);
				if (ele.isDisplayed()) {
					break;
				}
			}
		} catch (Exception e) {

			logger.log(Status.FAIL, ele + " is Not displayed");
			Assert.fail(ele + " is Not displayed");
		}
	}
	
	public static void delay(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			
		}
	}
	
	
	/*
	 * Selenium Concept: sendKeys() Param: WebElement, TestData, FieldName
	 * 
	 */
	public static void input(WebElement ele, String testData, String fieldName) {

		try {
			isElementDisplayed(ele);
			ele.click();
			ele.clear();
			ele.sendKeys(testData);
			logger.log(Status.INFO, "Entered " + testData + " in " + fieldName);
		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}
	
	public static void click(WebElement ele,String fieldName) {
		
		try {
			isElementDisplayed(ele);
			ele.click();
			logger.log(Status.INFO, "Clicked on "+fieldName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

}
