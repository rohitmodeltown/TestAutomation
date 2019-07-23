package com.ui.pages;

/**
 * @author A1SKIVA4
 *
 */

import org.openqa.selenium.*;

import com.common.Log4j;
import com.constant.Generic;
import com.constant.TestConstant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;

public class UserManagement {

	public static Generic generic;

	private static String randomEmail() {

		return "CS-" + UUID.randomUUID() + "@yopmail.com";
	}

	public void createUserLandingPage() throws Exception {
		Log4j.info("Landing on Create User form");

		TestConstant.userHeaderClick = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userHeaderClickElementFiled)));
		Assert.assertEquals(TestConstant.userHeaderClick.getText(), "USER MANAGEMENT");
		TestConstant.userHeaderClick.click();
		generic.takeScreenshot(TestConstant.driver, "HeaderClick");

		TestConstant.userSubMenuHeader = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userSubMenuHeaderClickElementFiled)));
		// Assert.assertEquals(TestConstant.userHeaderClick.getText(), "Users");
		TestConstant.userSubMenuHeader.click();
		generic.takeScreenshot(TestConstant.driver, "SubMenuHeader");

		Thread.sleep(1000);

		Thread.sleep(1000);

		Log4j.info("Page Refresh");

		TestConstant.driver.navigate().refresh();

	}

	public void createUserForm() throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();

		Log4j.info("Landing on Create User form");

		TestConstant.userCreateTab = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userCreateTabElementField)));
		Assert.assertEquals(TestConstant.userHeaderClick.getText(), "Create Tab");
		TestConstant.userCreateTab.click();
		generic.takeScreenshot(TestConstant.driver, "CreateTab");

		// Enter First Name
		TestConstant.userFirstName = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userFirstNameElementField)));
		TestConstant.userFirstName.sendKeys("Balaswamimurgan");
		generic.takeScreenshot(TestConstant.driver, "UserFirstName");

		// Enter Last Name
		TestConstant.userLastName = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userLastNameElementField)));
		TestConstant.userLastName.sendKeys("VirupatiIyyer");
		generic.takeScreenshot(TestConstant.driver, "UserLastName");

		// Enter Email ID
		final String randomEmail = randomEmail();

		TestConstant.userEmail = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userEmailElementField)));
		TestConstant.userEmail.sendKeys(randomEmail);
		generic.takeScreenshot(TestConstant.driver, "UserEmailID");

		TestConstant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter DOB
		TestConstant.driver.findElement(By.xpath("//input[@id=\"dob\"]")).click();
		TestConstant.driver.findElement(By.xpath("//div[@id='ui-datepicker-div']")).click();
		Select month = new Select(TestConstant.driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByVisibleText("Aug");
		Select year = new Select(TestConstant.driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByVisibleText("1947");
		TestConstant.driver.findElement(By.xpath("//a[contains(text(),'15')]")).click();
		generic.takeScreenshot(TestConstant.driver, "UserEmailID");

		// Description
		TestConstant.description = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.UserDescriptionElementField)));
		TestConstant.description.sendKeys("On" + "***" + dateFormat.format(date) + "***" + "Level 1 User Created");
		generic.takeScreenshot(TestConstant.driver, "Description");

		// Mobile
		TestConstant.userMobile = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userMobileElementField)));
		TestConstant.userMobile.sendKeys("9810000000");
		generic.takeScreenshot(TestConstant.driver, "UserMobile");

		// Status
		Select status = new Select(TestConstant.driver.findElement(By.xpath("//select[@id='custom_status']")));
		status.selectByVisibleText("Inactive");
		Thread.sleep(1000);
		status.selectByVisibleText("Active");
		generic.takeScreenshot(TestConstant.driver, "UserStatus");

		// Entity
		TestConstant.userEntityName = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userEntityNameElementField)));
		TestConstant.userEntityName.sendKeys(TestConstant.userEntityNameValue);

		TestConstant.userEntityName.sendKeys(Keys.TAB);

		generic.takeScreenshot(TestConstant.driver, "UserEntityName");
		Thread.sleep(1000);

		WebElement code = TestConstant.driver.findElement(By.xpath("//input[@id='entity_code']"));
		System.out.println(code.getText());

		WebElement type = TestConstant.driver.findElement(By.xpath("//input[@id='type_of_entity']"));
		System.out.println(type.getText());

		// Click to Cancel Button of Entity.

		TestConstant.driver
				.findElement(By.xpath("//img[@src='themes/SuiteP/images/id-ff-clear.png?v=0O-9i6wcD4_tm-CNHS8OFA']"))
				.click();

		// Click to Arrow Button of Entity.
		TestConstant.driver
				.findElement(By.xpath("//img[@src='themes/SuiteP/images/id-ff-select.png?v=0O-9i6wcD4_tm-CNHS8OFA']"))
				.click();

		String mainWindlow = TestConstant.driver.getWindowHandle();
		for (String childWindow : TestConstant.driver.getWindowHandles()) {

			TestConstant.driver.switchTo().window(childWindow);
			TestConstant.driver.findElement(By.xpath("/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[1]/a[1]")).click();
		}

		TestConstant.driver.switchTo().window(mainWindlow);

		generic.takeScreenshot(TestConstant.driver, "EntityDetails");
		Thread.sleep(2000);

		// Select Check box to copy same address as Entity Registered Address.
		TestConstant.driver.findElement(By.id("copy_address")).click();
		Thread.sleep(2000);
		generic.takeScreenshot(TestConstant.driver, "CopyAddress");
		Thread.sleep(2000);
		TestConstant.entitySaveButton = TestConstant.driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.userSaveButtonElementField)));
		TestConstant.entitySaveButton.click();

		TestConstant.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		WebElement confirmation = TestConstant.driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"));
		System.out.println(confirmation.getText());

		generic.takeScreenshot(TestConstant.driver, "SaveUser");

		WebElement ok = TestConstant.driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
		ok.click();

		TestConstant.driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

		TestConstant.driver.navigate().back();

	}

	public static void labels() throws Exception {

		String FirstName = TestConstant.driver.findElement(By.xpath("//div[@data-label='LBL_FIRST_NAME']")).getText();
		Assert.assertEquals(FirstName, "First Name: *");

		String LBL_LastName = TestConstant.driver.findElement(By.xpath("//div[@data-label='LBL_LAST_NAME']")).getText();
		Assert.assertEquals(LBL_LastName, "Last Name:");

		String LBL_EMAIL = TestConstant.driver.findElement(By.xpath("//div[@data-label=\"LBL_EMAIL\"]")).getText();
		Assert.assertEquals(LBL_EMAIL, "Email: *");

		String LBL_DOB = TestConstant.driver.findElement(By.xpath("//div[@data-label=\"LBL_DOB\"]")).getText();
		Assert.assertEquals(LBL_DOB, "DOB:");

		String LBL_DESC = TestConstant.driver.findElement(By.xpath("//div[@data-label=\"LBL_DESCRIPTION\"]")).getText();
		Assert.assertEquals(LBL_DESC, "Description:");

		String LBL_Mobile = TestConstant.driver.findElement(By.xpath("//div[@data-label=\"LBL_MOBILE\"]")).getText();
		Assert.assertEquals(LBL_Mobile, "Mobile: *");

		String LBL_Status = TestConstant.driver.findElement(By.xpath("//div[@data-label=\"LBL_STATUS\"]")).getText();
		Assert.assertEquals(LBL_Status, "Status: *");

		String LBL_Level = TestConstant.driver.findElement(By.xpath("//div[@data-label=\"LBL_LEVEL\"]")).getText();
		Assert.assertEquals(LBL_Level, "Level: *");

		String LBL_Entity = TestConstant.driver
				.findElement(By.xpath("//div[@data-label='LBL_AIR_USER_ACCOUNTS_FROM_ACCOUNTS_TITLE']")).getText();
		Assert.assertEquals(LBL_Entity, "Entities: *");

		String LBL_EntityCode = TestConstant.driver.findElement(By.xpath("//div[@data-label='LBL_ENTITY_CODE']"))
				.getText();
		Assert.assertEquals(LBL_EntityCode, "Entity Code: *");

		String LBL_EntityType = TestConstant.driver.findElement(By.xpath("//div[@data-label='LBL_TYPE_OF_ENTITY']"))
				.getText();
		Assert.assertEquals(LBL_EntityType, "Type of Entity: *");

		// Registered Address Label xpath and verification.
		String LBL_Reg_Line1 = TestConstant.driver.findElement(By.xpath("//div[@data-label='LBL_REGISTRED_ADD_LINE1']"))
				.getText();

		String LBL_Reg_Line2 = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]"))
				.getText();

		String LBL_Reg_Pincode = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[5]/div[1]"))
				.getText();
		String LBL_Reg_City = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[6]/div[1]"))
				.getText();
		String LBL_Reg_State = TestConstant.driver
				.findElement(By.xpath("//div[@data-label=\"LBL_REGISTRED_ADD_STATE\"]")).getText();
		String LBL_Reg_District = TestConstant.driver
				.findElement(By.xpath("//div[@data-label='LBL_REGISTRED_ADD_DISTRICT']")).getText();
		String LBL_Reg_SubDistrict = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[13]/div[1]"))
				.getText();
		String LBL_Reg_Country = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[14]/div[1]"))
				.getText();

		Assert.assertEquals(LBL_Reg_Line1, "Line1: *");
		Assert.assertEquals(LBL_Reg_Line2, "Line2:");
		Assert.assertEquals(LBL_Reg_Pincode, "Pincode: *");
		Assert.assertEquals(LBL_Reg_City, "City: *");
		Assert.assertEquals(LBL_Reg_State, "State: *");
		Assert.assertEquals(LBL_Reg_District, "District: *");
		Assert.assertEquals(LBL_Reg_SubDistrict, "Sub District:");
		Assert.assertEquals(LBL_Reg_Country, "Country:");

		// Checkbox same as Address Label xpath and verification.
		String LBL_Same_as_registered = TestConstant.driver
				.findElement(By.xpath("//div[contains(text(),'Same as registered:')]")).getText();
		Assert.assertEquals(LBL_Same_as_registered, "Same as registered:");

		// Corresponding Address Label xpath and verification.
		String LBL_Corr_Line1 = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[5]/div[1]"))
				.getText();
		String LBL_Corr_Line2 = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[6]/div[1]"))
				.getText();
		String LBL_Corr_Pincode = TestConstant.driver.findElement(By.xpath(
				" /html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[9]/div[1]"))
				.getText();
		String LBL_Corr_City = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[10]/div[1]"))
				.getText();
		String LBL_Corr_State = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[13]/div[1]"))
				.getText();
		String LBL_Corr_District = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[14]/div[1]"))
				.getText();
		String LBL_Corr_SubDistrict = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[17]/div[1]"))
				.getText();
		String LBL_Corr_Country = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[18]/div[1]"))
				.getText();

		Assert.assertEquals(LBL_Corr_Line1, "Line1: *");
		Assert.assertEquals(LBL_Corr_Line2, "Line2:");
		Assert.assertEquals(LBL_Corr_Pincode, "Pincode: *");
		Assert.assertEquals(LBL_Corr_City, "City: *");
		Assert.assertEquals(LBL_Corr_State, "State: *");
		Assert.assertEquals(LBL_Corr_District, "District: *");
		Assert.assertEquals(LBL_Corr_SubDistrict, "Sub District:");
		Assert.assertEquals(LBL_Corr_Country, "Country:");

	}

	public static void modifyUser() throws Exception {

	}


/*	public static void desabledUser() throws Exception {

	}

	public static void enabledUser() throws Exception {

	}

	public static void userDetails() throws Exception {

	}*/

	public static void desabledUser() throws Exception {

	}

	public static void enabledUser() throws Exception {

	}

	public static void userDetails() throws Exception {

	}

}
