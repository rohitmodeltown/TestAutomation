package com.constant;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.TestConstant;

import com.ui.page.InitializeWebDriver;

import bsh.org.objectweb.asm.Type;

public class Generic {

	// This is Constructor
	public Generic() throws Exception // Constructor
	{
		TestConstant.driver = InitializeWebDriver.getInstance();

	}

	// This is method is to take a screenshot of the page
	public static void takeScreenshot(WebDriver driver, String screenshottaken) throws Exception {

		try {

			TakesScreenshot screen = (TakesScreenshot) TestConstant.driver;
			File srcfile = screen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("./screenshot/" + screenshottaken + ".jpeg"));
			System.out.println("Screenshot" + "---" + screenshottaken + ".jpeg");

		} catch (WebDriverException ex) {
			ex.printStackTrace();
			System.out.println("Exception occure while taking a screenshot" + ex.getMessage());
		}

	}

	public static void genericPageNavigation(String type) throws Exception{
		
		try {
			WebDriverWait wait  =  new WebDriverWait(TestConstant.driver, TestConstant.pageload);
			
			if(type.equals("HEamder")) {
				TestConstant.entityHeaderClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.entityHeaderClickElementFiled))));
				TestConstant.entityHeaderClick.click();
			}
			
			
			
		}finally {
			
		}
		
			
	
			
		
	}

}
