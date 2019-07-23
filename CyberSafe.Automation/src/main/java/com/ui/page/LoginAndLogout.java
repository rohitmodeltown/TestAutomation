package com.ui.page;

import com.constant.Generic;
import com.constant.TestConstant;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.report.ExcelUtils;
import com.report.Log;

import configurationfilepath.ConfigurationFile;

public class LoginAndLogout {

	public static void openBrowser() throws Exception {

		InitializeWebDriver.initializeWebDriver();
		TestConstant.driver.manage().window().maximize();
		TestConstant.driver.get(TestConstant.cybersafe_URL);
		TestConstant.windowtitle = TestConstant.driver.getTitle();
		Generic.takeScreenshot(TestConstant.driver, "BrowserOpenWithTitle");

		if (TestConstant.windowtitle.equals("Cyber Safe")) {

			System.out.println(TestConstant.windowtitle);

			Log.info(TestConstant.windowtitle);

		} else {

			Log.info("Title of the page is incorrect.");
		}
		TestConstant.windowURL = TestConstant.driver.getCurrentUrl();
		Generic.takeScreenshot(TestConstant.driver, "WindowURLTaken");
		System.out.println("Screenshot taken," + "the URL of the page is:" + TestConstant.windowURL);

	}

	public static void logo() throws Exception {

		Log.info("Verifing the logo of cybersafe");
		WebDriverWait wait = new WebDriverWait(TestConstant.driver, 2000);
		try {
			TestConstant.cyber_logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.cyber_logo_ElementField))));
			Generic.takeScreenshot(TestConstant.driver, "beforePageLoad");
			Assert.assertEquals(TestConstant.cyber_logo.isDisplayed(), true, "Logo Displayed");
			Assert.assertEquals(TestConstant.cyber_logo.isEnabled(), true);
			Generic.takeScreenshot(TestConstant.driver, "Logopresent");
		} catch (ElementNotFoundException el) {
			el.printStackTrace();
		}
	}

	public static void loginToCyberSafe() throws Exception {
		Log.info("Verify the login page");
		WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);
		Log.info("Please wait until page loaded");

		System.out.println("User Enters a username");

		TestConstant.username = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(ConfigurationFile.getProperty(TestConstant.usernameElementField))));
		TestConstant.username.sendKeys(ExcelUtils.getCellData(0, 5, 8));
		Thread.sleep(1000);
		Generic.takeScreenshot(TestConstant.driver, "userNameEntered");
		System.out.println("User Enters a password");
		TestConstant.password = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(ConfigurationFile.getProperty(TestConstant.passwordElementField))));
		TestConstant.password.sendKeys("admin");
		Thread.sleep(1000);
		Generic.takeScreenshot(TestConstant.driver, "passwordEntered");
		System.out.println("User clicks on login button");
		TestConstant.login_btn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(ConfigurationFile.getProperty(TestConstant.ButtonElementField))));
		Thread.sleep(1000);
		Assert.assertEquals(TestConstant.login_btn.isDisplayed(), true, "Login button displayed.");
		Assert.assertEquals(TestConstant.login_btn.isEnabled(), true, "Login button enabled.");

		if ((TestConstant.username.equals("")) && (TestConstant.password.equals(""))) {
			Thread.sleep(1000);
			TestConstant.login_btn.click();
			Assert.assertEquals(false,
					"Oh--You have not entered any value into login field, please enter correct value");
		} else {
			TestConstant.login_btn.click();
			System.out.println("OTP PopUp ");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		WebElement popupmessage = TestConstant.driver.findElement(By.xpath("//*[@id=\"otp_modal\"]/div/div/div[2]/p"));
		popupmessage.getText();
		System.out.println(popupmessage.getText());
		WebElement popup = TestConstant.driver.findElement(By.xpath("//*[@id=\"opt_pass\"]"));
		popup.sendKeys("123456");
		WebElement popup_btn = TestConstant.driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
		Generic.takeScreenshot(TestConstant.driver, "OTP_Popup");
		popup_btn.click();

		Assert.assertEquals(TestConstant.driver.getTitle().equalsIgnoreCase("Cyber Safe"), true, "Cyber Safe");

	}

	public static void logOut() throws Exception {
		System.out.println("Log Out");
		WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);
		Log.info("User Click on LogOut icon");
		
		TestConstant.log_out_username = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.log_out_usernameElementField)));
		
		TestConstant.log_out_username.click();
		Thread.sleep(1000);

		TestConstant.log_out = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.logOutUserIconElementField)));

		Generic.takeScreenshot(TestConstant.driver, "LogOutScreenshot");

		TestConstant.log_out.click();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(TestConstant.driver.getTitle(), "Cyber Safe");
		
		try {

		} catch (AssertionError ex) {
			ex.printStackTrace();

		}

	}
	
	
	public static void autoLogout() throws Exception{
		  Log.info("Verifying auto-logout");
		  Log.info("Auto logout will be done in 10 minutes");
		  Thread.sleep(11000);
		  TestConstant.driver.getTitle();
		  if(TestConstant.driver.getTitle()==TestConstant.cybersafe_URL) {
			  Log.info("CyberSafe Login Page");
			  
		  }else {
			  
			 TestConstant.driver.getTitle();
		  }
	}
	

	public static void forgetPassword() throws Exception {

		Log.info("Checking forget password link for the user");
		WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);
		Assert.assertEquals(TestConstant.forget_password.isDisplayed(), true,
				"forget password link enabled and displayed.");
		TestConstant.forget_password = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.forgetLinkElementField))));
		TestConstant.forget_password.click();
		Thread.sleep(2000);
		// TestConstant.forget_username =

	}
	
	public static void loginInfo() throws Exception{
		
		Log.info("Verifing which is login and last login day & time");
		
		String Last_Login = TestConstant.driver.findElement(By.xpath("//div[@id='last-login']")).getText();
		Log.info(Last_Login);
		
	}

}
