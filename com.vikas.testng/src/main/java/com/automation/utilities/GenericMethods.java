package com.automation.utilities;

import java.io.File;
import java.time.LocalTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class GenericMethods extends Reports {

	public static SoftAssert soft = new SoftAssert();
	
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
			//isElementDisplayed(ele);
			ele.click();
			ele.clear();
			ele.sendKeys(testData);
			logger.log(Status.INFO, "Entered " + testData + " in " + fieldName);
		} catch (Exception e) {

			e.printStackTrace();
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
	
	public static String getText(WebElement ele) {
		String txt = null;
		try {
			txt = ele.getText();
		} catch (Exception e) {
			Assert.fail("Unable to retrieve text from "+ele);
		}
		return txt;
	}
	
	public static void selectValue(WebElement ele, String type,int index, String value, String text,String fieldName) {
		
		try {
			switch (type.toUpperCase()) {
			case "INDEX":
				new Select(ele).selectByIndex(index);
				break;
			case "VALUE":
				new Select(ele).selectByValue(value);
				break;
			case "VISIBLETEXT":
				new Select(ele).selectByVisibleText(text);
				break;
			default:
				logger.log(Status.FAIL, "Please Provide Valid Type");
				break;
			}
		} catch (Exception e) {
			Assert.fail("Unable to Select value from  "+ele+ "Error "+e.getMessage());
		}
		
	}
	
	public static void selectByVisibleText(WebElement ele,String data,String fieldName) {
		
		try {
			new Select(ele).selectByVisibleText(data);
			logger.log(Status.INFO, "Selected "+data+" From "+fieldName);
		} catch (Exception e) {
			Assert.fail("Unable to Select "+data+" from "+fieldName);
		}
	}
	
	public static void softAssertEqual(Object actual,Object expected) {
		try {
			soft.assertEquals(actual, expected);
			soft.assertAll();
		} catch (Exception e) {
			
		}
	}
	
	public static String getAttributeValue(WebElement ele,String attributeName,String fieldName) {
		String value = null;
		try {
			ele.getAttribute(attributeName);
			logger.log(Status.INFO, attributeName+ "Value From "+fieldName);
		} catch (Exception e) {
			
		}
		return value;	
	}
	
	public static String getAttributeValue(WebElement ele,String fieldName) {
		String value = null;
		try {
			ele.getAttribute("innerHTML");
			logger.log(Status.INFO, "Retrieved Inner Text From "+fieldName);
		} catch (Exception e) {
			
		}
		return value;	
	}
	
	public static void getScreenShot(String name) {		
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"/ScreenShots/"+name+".png"));
		} catch (Exception e) {
			
		}
	}
	
	public static void getScreenShot() {		
		String time = LocalTime.now().toString();
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"/ScreenShots/"+time+".png"));
		} catch (Exception e) {
			
		}
	}
	
	

}
