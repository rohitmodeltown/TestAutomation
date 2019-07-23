package com.ui.pages;

/**
 * @author A1SKIVA4
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.constant.TestConstant;
import com.base.BaseTest;
import com.common.GenerateData;

public class EntityManagement extends BaseTest {

	/*private static String EntityName = null;
	private static String Mobile = null;
	private static String Landline = null;
	private static String Email = null;
	private static String Website = null;*/

	WebDriverWait wait = new WebDriverWait(driver,TestConstant.pageload);
	
	public static DateFormat dateformat = new SimpleDateFormat("HH:MM:SS , DD/MM/YYY");
	Date d = new Date();

	/*
	 * private static String entityEmail() {
	 * 
	 * return "entity" +UUID.randomUUID() + "yopmail.com"; }
	 * 
	 * private static String entityAuthEmail() {
	 * 
	 * return "auth"+UUID.randomUUID()+"yopmail.com"; }
	 * 
	 */

	public EntityManagement() {

		PageFactory.initElements(driver, this);
	}

	public  void entityModule() throws Exception {

		// Log4j.info("Verify the create entity landing page");

		TestConstant.entityHeaderClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityHeaderClickElementFiled))));
		Assert.assertEquals(TestConstant.entityHeaderClick.getText(), "ENTITY MANAGEMENT");
		TestConstant.entityHeaderClick.click();

		TestConstant.entitySubMenuHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entitySubMenuHeaderClickElementFiled))));
		Assert.assertEquals(TestConstant.entitySubMenuHeader.getText(), "Entities");
		TestConstant.entitySubMenuHeader.click();

	}

	public static void entityLandingPage() throws Exception {

		Assert.assertEquals(
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/h2[1]")).getText().trim(),
				"ENTITIES");

	}

	/* Entity Creation Form */
	// (DataProvider ="passData")
	public  void createEntity() throws Exception {

		GenerateData genData = new GenerateData();

		try {
			FileInputStream fStream = new FileInputStream(
					new File("D:\\Airtel\\Requirement\\Test Data\\Type of All Data.xlsx"));
			// Enter the path to your excel here

			// Create workbook instance referencing the file created above
			XSSFWorkbook workbook = new XSSFWorkbook(fStream);

			// Get your first or desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(2); // getting first sheet

			XSSFRow row = sheet.getRow(1);
			XSSFCell cell1 = row.getCell(0);
			XSSFCell cell2 = row.getCell(1);
			XSSFCell cell3 = row.getCell(2);
			XSSFCell cell4 = row.getCell(3);
			XSSFCell cell5 = row.getCell(4);

		/*	EntityName = cell1.toString();
			Mobile = cell2.toString();
			Landline = cell3.toString();
			Email = cell4.toString();
			Website = cell5.toString();*/

			// Pswrd = cell2.toString();
			fStream.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Create Entity Tab

		TestConstant.entityCreateTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityCreateTabElementField))));
		Assert.assertEquals(TestConstant.entityCreateTab.getText(), "Create Entity");
		TestConstant.entityCreateTab.click();

		// Entity Name

		TestConstant.entityName = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityFirstNameElementField)));
		// TestConstant.entityName.sendKeys("Entity"+
		 genData.generateRandomString(6).toUpperCase();
		//TestConstant.entityName.sendKeys(EntityName);

		// Entity Mobile

		TestConstant.entityMobile = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityMobileElementField)));
		TestConstant.entityMobile.sendKeys("8" + genData.generateRandomNumber(9));

		// Entity STD

		TestConstant.entitySTD = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entitySTDElementField)));
		TestConstant.entitySTD.sendKeys("0" + genData.generateRandomNumber(3));

		// Entity Landline

		TestConstant.entityLandline = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityPhoneElementField)));
		TestConstant.entityLandline.sendKeys("3" + genData.generateRandomNumber(6));

		// Entity Email

		TestConstant.entityEmailID = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityEmailElementField)));
		// TestConstant.entityEmailID.sendKeys("En" + genData.generateEmail(15));
		//TestConstant.entityEmailID.sendKeys(Email);

		// website

		TestConstant.entityWebsite = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityWebsiteElementField)));
		//TestConstant.entityWebsite.sendKeys(Website);

		// Type of entity

		Select type_of_entity = new Select(driver.findElement(By.xpath("//select[@name='type_of_entity']")));
		type_of_entity.selectByVisibleText("BNK");

		// Entity Status

		Select entity_status = new Select(driver.findElement(By.xpath("//select[@id='entity_status']")));
		entity_status.selectByVisibleText("Active");

		// Address

		TestConstant.entityLine1 = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityRegAddressLine1ElementField)));
		TestConstant.entityLine1.sendKeys("House No: " + genData.generateRandomNumber(4));

		TestConstant.entityLine2 = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityRegAddressLine2ElementField)));
		TestConstant.entityLine2.sendKeys("Street No:" + genData.generateRandomNumber(2));

		// Pincode

		TestConstant.entityPincode = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityPincodeElementField)));
		TestConstant.entityPincode.sendKeys("110001");

		// Authorize signatory

		TestConstant.entityAuthSignFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSignFirstElementField))));
		TestConstant.entityAuthSignFirstName.sendKeys(genData.generateRandomString(7).toUpperCase());

		TestConstant.entityAuthSignMiddleName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSignMidElementField))));
		TestConstant.entityAuthSignMiddleName.sendKeys(genData.generateRandomString(7).toUpperCase());

		TestConstant.entityAuthSignLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSignLastElementField))));
		TestConstant.entityAuthSignLastName.sendKeys(genData.generateRandomString(7));

		TestConstant.entityAuthSignMobile = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSignMobileElementField)));
		TestConstant.entityAuthSignMobile.sendKeys("8" + genData.generateRandomNumber(9));

		TestConstant.entityAuthSTD = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSinghSTDElementField)));
		TestConstant.entityAuthSTD.sendKeys("0" + genData.generateRandomNumber(3));

		TestConstant.entityAuthSignlandline = driver
				.findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSignLandline)));
		TestConstant.entityAuthSignlandline.sendKeys("2" + genData.generateRandomNumber(6));

		TestConstant.entityAuthSignEmail = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityAuthSignEmailElementField)));
		TestConstant.entityAuthSignEmail.sendKeys("Auth" + genData.generateEmail(15));

		// Description

		TestConstant.entityDescription = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityDescriptionElementField)));
		TestConstant.entityDescription.sendKeys("New Entity has been created" + dateformat);
	}

	public static void modifyEntity() throws Exception {

	}

	public static void desableEntity() throws Exception {

		Select entity_status = new Select(driver.findElement(By.xpath("//select[@id='entity_status']")));
		entity_status.selectByVisibleText("Inactive");

	}

	/* Save Form */
	public static void saveForm() throws Exception {
		TestConstant.entitySaveButton = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entitySaveButtonElementField)));
		TestConstant.entitySaveButton.click();

	}

	/* Cancel Form */
	public void cancelFrom() throws Exception {
		TestConstant.entityCancelButton = driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.entityCancelButtonElementField)));
		TestConstant.entityCancelButton.click();
	}

}
