package com.ui.page;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.constant.Generic;
import com.constant.TestConstant;
import com.report.Log;
import com.report.GenerateData;

public class FraudManagement {

	private static String victimEmail() {

		return "victim" + UUID.randomUUID() + "yopmail.com";

	}

	private static String fraudsterEmail() {

		return "frdtr" + UUID.randomUUID() + "yopmail.com";
	}

	public static void fraudTicketLandingPage() throws Exception {

		Log.info("Landing on Create Fraud Ticket form");

		TestConstant.fraudHeaderClick = TestConstant.driver.findElement(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.fraudHeaderClickElementFiled)));
		Assert.assertEquals(TestConstant.fraudHeaderClick.getText(), "FRAUD MANAGEMENT");
		TestConstant.fraudHeaderClick.click();
		Generic.takeScreenshot(TestConstant.driver, "HeaderClick");

		TestConstant.fraudSubMenuHeader = TestConstant.driver.findElement(By.xpath(
				configurationfilepath.ConfigurationFile.getProperty(TestConstant.fraudSubMenuHeaderClickElementFiled)));
		Assert.assertEquals(TestConstant.fraudSubMenuHeader.getText(), "Fraud Tickets");
		TestConstant.fraudSubMenuHeader.click();
		Generic.takeScreenshot(TestConstant.driver, "SubMenuHeader");


		Thread.sleep(2000);

		Log.info("Page Refresh");
		TestConstant.driver.navigate().refresh();

	}

	public static void createFraudTicket() throws Exception {

		WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);
		GenerateData genData = new GenerateData();

		TestConstant.createFraudTicket = TestConstant.driver.findElement(By.xpath(
				configurationfilepath.ConfigurationFile.getProperty(TestConstant.createFraudTicketElementField)));
		Assert.assertEquals(TestConstant.createFraudTicket.getText(), "Create Fraud Ticket");
		TestConstant.createFraudTicket.click();
		Generic.takeScreenshot(TestConstant.driver, "CreateTab");
		
		
		TestConstant.victimFirstName = TestConstant.driver.findElement(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimFirstNameElementField)));
		TestConstant.victimFirstName.sendKeys(genData.generateRandomString(30).toUpperCase());
		Generic.takeScreenshot(TestConstant.driver, "victimFirstName");

		TestConstant.victimMiddleName = TestConstant.driver.findElement(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimMiddleNameElementField)));
		TestConstant.victimMiddleName.sendKeys(genData.generateRandomString(30).toUpperCase());
		Generic.takeScreenshot(TestConstant.driver, "victimMiddleName");
		Thread.sleep(1000);

		
		TestConstant.victimLastName = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimLastNameElementField)));
		TestConstant.victimLastName.sendKeys(genData.generateRandomString(30).toUpperCase());
		Generic.takeScreenshot(TestConstant.driver, "victimLastName");
		
		if (TestConstant.victimLastName.isDisplayed() && TestConstant.victimLastName.isEnabled()) {

		} else {
			Log.info("Element Locator is not visible");
			TestConstant.driver.quit();

		}
		TestConstant.victimMobile = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimMobileElementField)));
		TestConstant.victimMobile.sendKeys(genData.generateRandomNumber(10));
		Generic.takeScreenshot(TestConstant.driver, "victimMobile");

		TestConstant.victimLandline = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimLandlineElementField)));
		TestConstant.victimLandline.sendKeys(genData.generateRandomNumber(6));
		Generic.takeScreenshot(TestConstant.driver, "victimLandline");

		TestConstant.victimEmail = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimEmailElementField)));
		TestConstant.victimEmail.sendKeys(genData.generateEmail(15));
		Generic.takeScreenshot(TestConstant.driver, "victimEmail");

		TestConstant.victimLine1 = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimLine1ElementField)));
		TestConstant.victimLine1.sendKeys("House No: " + genData.generateRandomNumber(4));
		Generic.takeScreenshot(TestConstant.driver, "victimLine1");

		TestConstant.victimLine2 = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimLine2ElementField)));
		TestConstant.victimLine2.sendKeys("Street No: " + genData.generateRandomNumber(2));
		Generic.takeScreenshot(TestConstant.driver, "victimLine2");

		TestConstant.victimPincode = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.victimPincodeElementField)));
		TestConstant.victimPincode.sendKeys("110008");
		Generic.takeScreenshot(TestConstant.driver, "victimPincode");

		TestConstant.victimTransactionDetails = TestConstant.driver
				.findElement(By.xpath(configurationfilepath.ConfigurationFile
						.getProperty(TestConstant.victimTransactionDetailsElementField)));
		TestConstant.victimTransactionDetails.click();
		Generic.takeScreenshot(TestConstant.driver, "victimTransactionDetails");

		TestConstant.driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]")).click();
		TestConstant.driver.findElement(By.xpath("//a[contains(text(),'2')]")).click();

		Select hour = new Select(
				TestConstant.driver.findElement(By.xpath("//select[@id='date_of_transaction_hours']")));
		hour.selectByVisibleText("11");
		Select minute = new Select(
				TestConstant.driver.findElement(By.xpath("//select[@id='date_of_transaction_minutes']")));
		minute.selectByVisibleText("15");
		Select meridiem = new Select(
				TestConstant.driver.findElement(By.xpath("//select[@id='date_of_transaction_meridiem']")));
		meridiem.selectByVisibleText("PM");

		Select DOT = new Select(TestConstant.victimTransactionDetails);

		TestConstant.cardSixDigit = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.cardSixDigitElementField)));
		TestConstant.cardSixDigit.sendKeys(genData.generateRandomNumber(6));
		Generic.takeScreenshot(TestConstant.driver, "cardSixDigit");

		TestConstant.cardFourDigit = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.cardFourDigitElementField)));
		TestConstant.cardFourDigit.sendKeys(genData.generateRandomNumber(4));
		Generic.takeScreenshot(TestConstant.driver, "cardFourDigit");

		TestConstant.addTransactions = TestConstant.driver.findElement(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.addTransactionsElementField)));
		TestConstant.addTransactions.sendKeys("Balaswamimurgan");
		Generic.takeScreenshot(TestConstant.driver, "addTransactions");

		TestConstant.fraudsterMobile = TestConstant.driver.findElement(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.fraudsterMobileElementField)));
		TestConstant.fraudsterMobile.sendKeys(genData.generateRandomNumber(10));
		Generic.takeScreenshot(TestConstant.driver, "fraudsterMobile");

		TestConstant.fraudsterEmail = TestConstant.driver.findElement(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.fraudsterEmailElementField)));
		TestConstant.fraudsterEmail.sendKeys(genData.generateEmail(16));
		Generic.takeScreenshot(TestConstant.driver, "fraudsterEmail");

		TestConstant.Description = TestConstant.driver.findElement(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.DescriptionFraudElementField)));
		TestConstant.Description.sendKeys("Balaswamimurgan");
		Generic.takeScreenshot(TestConstant.driver, "Description");

	}

	public static void modifyFraudTicket() throws Exception {

	}

	public static void deleteFraudTicket() throws Exception {

	}
	
	
	public static void viewFraudTicket() throws Exception{
		
		
	assertEquals(TestConstant.driver.findElement(By.xpath("//h2[contains(text(),'Fraud Tickets')]")).getText().trim(),"FRAUD TICKETS");
	
	List<WebElement> headerLink = TestConstant.driver.findElements(By.tagName("a"));
	
	for(WebElement allLink : headerLink) {
		
		System.out.println(allLink.getAttribute("href"));
		System.out.println(allLink.getText());
		
	}
	
	
		
		
	}

}
