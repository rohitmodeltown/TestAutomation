package com.constant;

/**
 * @author A1SKIVA4
 *
 */

import java.io.File;
import java.sql.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.constant.TestConstant;

public class Generic {

	Generic generic;

	public Generic() {
		// Constructor
	}

	public void waitWebDriver() {

		WebDriverWait wait = new WebDriverWait(TestConstant.driver, 2000);

	}

	/* This is method is to take a screenshot of the page */
	public void takeScreenshot(WebDriver driver, String screenshottaken) throws Exception {

		try {

			TakesScreenshot screen = (TakesScreenshot) TestConstant.driver;
			File srcfile = screen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("./screenshot/" + screenshottaken + ".jpeg"));
			System.out.println("Screenshot" + "---" + screenshottaken + ".jpeg");
			
			
		//	TakesScreenshot screen 

		} catch (WebDriverException ex) {
			ex.printStackTrace();
			System.out.println("Exception occure while taking a screenshot" + ex.getMessage());
		}

	}

	/* @AfterMethod */
	public void failTestCase(ITestResult result) throws Exception {

		if (ITestResult.FAILURE == result.getStatus()) {

			generic.takeScreenshot(TestConstant.driver, result.getName());
		}

	}

	// To verify that the user’s information is successfully saved into the database
	// as soon as the user registers in the application”.

	public void dataBaseConnectivity(String query) throws SQLException, ClassNotFoundException {

		Class.forName("com.odbc.jdbc.Driver");
		Connection con = DriverManager.getConnection("localhost:8080/testDB", "testuser", "test123");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);

	}

	public void genericPageNavigation(String type) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);

			if (type.equals("HEamder")) {
				TestConstant.entityHeaderClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityHeaderClickElementFiled))));
				TestConstant.entityHeaderClick.click();
			}

		} finally {

		}

	}

}
