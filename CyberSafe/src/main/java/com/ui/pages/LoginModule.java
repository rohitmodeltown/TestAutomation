package com.ui.pages;

import com.constant.Generic;

/**
 * @author A1SKIVA4
 *
 */

import com.constant.TestConstant;
import com.base.BasePage;
import com.base.BaseTest;
import com.common.Log4j;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginModule extends BaseTest {

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	WebDriverWait wait = new WebDriverWait(driver, 30000);

	@FindBy(how = How.ID, using = "user_name")
	WebElement userid;

	@FindBy(name = "username_password")
	WebElement password;

	@FindBy(xpath = "//input[@id='open_otp_popup']")
	WebElement loginbtn;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'companylogo')]")
	WebElement CYSlogo;

	@FindBy(how = How.XPATH, using = "//div[@id='otp_modal']//div[@class='modal-body']")
	public WebElement otp_model;

	@FindBy(how = How.XPATH, using = "//input[@id='opt_pass']")
	WebElement otp;

	@FindBy(how = How.XPATH, using = "//input[@id='bigbutton']")
	WebElement otp_btn;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Forgot Password?')]")
	WebElement forgetPasswordlink;

	@FindBy(id = "fp_user_name")
	WebElement forget_username;

	@FindBy(id = "fp_user_mail")
	WebElement forget_email;

	@FindBy(how = How.XPATH, using = "//input[@id='generate_pwd_button']")
	WebElement forget_btn;

	@FindBy(xpath = "//*[contains(text(),'Password reset URL sent on your Email')]")
	WebElement reset_successMsg;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Invalid Username or Email ID')]")
	WebElement reset_failMsg;
	
	
	Actions action = new Actions(driver);

	public LoginModule() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateLogo() {

		CYSlogo.isDisplayed();
		return CYSlogo.isEnabled();

	}

	public void loginToCybersafe(String user, String pass) {

		userid.sendKeys(user);
		password.sendKeys(pass);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginbtn.click();
	}

	public void otp() {

		wait.until(ExpectedConditions.visibilityOf(otp_model));
		otp_model.isDisplayed();
		otp.sendKeys("995813");
		otp_btn.click();

	}

	public void forgetPassword(String forget_user, String forget_mailID) throws Exception {

		Log4j.info("Forget password link for the user to reset password");
		forgetPasswordlink.click();
		driver.manage().timeouts().pageLoadTimeout(8000, TimeUnit.MILLISECONDS);
		forget_username.sendKeys(forget_user);
		forget_email.sendKeys(forget_mailID);
		Thread.sleep(20000);
		forget_btn.click();
		String forgetSuccessMsg = wait.until(ExpectedConditions.visibilityOf(reset_successMsg)).getText();
		Log4j.info(forgetSuccessMsg);
		if (forgetSuccessMsg == "Password reset URL sent on your Email") {
			Assert.assertEquals(forgetSuccessMsg, true, "Password reset URL sent on your Email");
		} else if (forgetSuccessMsg == "Enter captcha") {
			Assert.assertFalse(false);
		}

	}


	public void sessionTimeOut() {

		driver.manage().timeouts().implicitlyWait(11, TimeUnit.MINUTES);
		String session_expire_msg = driver
				.findElement(
						By.xpath("//p[contains(text(),'You have been logged out because your session has expired.')]"))
				.getText();
		if (session_expire_msg == "You have been logged out because your session has expired.") {
			Log4j.info("Your session has expired, Please reload the page and login.");
		}
		Assert.assertTrue(false);
	}

	public void autoLogout() throws Exception {

		Log4j.info("Verifying auto-Logout");
		Log4j.info("Auto Logout will be done in 10 minutes");
		Thread.sleep(600500);
		Log4j.info("You are Logged Out");
		if (driver.getTitle() == TestConstant.cybersafe_URL) {
			Log4j.info("CyberSafe Login Page");

		} else {

			Log4j.info(driver.getTitle());
		}
	}

}

/*
 * 
 * 
 * public void loginUser() throws Exception {
 * 
 * try {
 * 
 * FileInputStream fstream = new FileInputStream( new
 * File("D:\\Airtel\\Requirement\\Test Data\\Type of All Data.xlsx"));
 * 
 * XSSFWorkbook workbook = new XSSFWorkbook(fstream);
 * 
 * XSSFSheet sheet = workbook.getSheetAt(1);
 * 
 * XSSFRow row = sheet.getRow(12); XSSFCell cell1 = row.getCell(0); XSSFCell
 * cell2 = row.getCell(1);
 * 
 * Uname = cell1.toString(); Pswrd = cell2.toString(); fstream.close();
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace(); }
 * 
 * // Enter Username TestConstant.username =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(
 * By.xpath(utility.ConfigurationFile.getProperty(TestConstant.
 * usernameElementField)))); TestConstant.username.sendKeys(Uname);
 * 
 * // Enter Password TestConstant.password =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(
 * By.xpath(utility.ConfigurationFile.getProperty(TestConstant.
 * passwordElementField)))); TestConstant.password.sendKeys(Pswrd);
 * 
 * TestConstant.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * 
 * // Login button TestConstant.login_btn =
 * wait.until(ExpectedConditions.elementToBeClickable(
 * By.xpath(utility.ConfigurationFile.getProperty(TestConstant.
 * ButtonElementField)))); TestConstant.login_btn.click();
 * 
 * Thread.sleep(4000);
 * 
 * // OTP Pop up
 * 
 * TestConstant.driver.findElement(By.xpath(
 * "//div[@id='otp_modal']//div[@class='modal-body']")); String OTP_Message =
 * TestConstant.driver.findElement(By.xpath("//p[@class='otp_msg']")).getText();
 * Log4j.info("" + OTP_Message); TestConstant.OTP_Digit =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(
 * By.xpath(utility.ConfigurationFile.getProperty(TestConstant.
 * OTP_DigitElementField)))); // TestConstant.OTP_Digit.sendKeys("123456");
 * Thread.sleep(12000);
 * 
 * String OTP_Count =
 * TestConstant.driver.findElement(By.xpath("//div[@class='countdown']")).
 * getText(); Log4j.info("Count down of OTP : " + OTP_Count);
 * TestConstant.driver.findElement(By.xpath("//input[@id='bigbutton']")).click()
 * ; Log4j.info("User clicked on OTP popup submit button");
 * 
 * }
 */
