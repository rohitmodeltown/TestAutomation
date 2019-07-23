package com.ui.pages;

/**
 * @author A1SKIVA4
 *
 */ 

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.constant.Generic;
import com.constant.TestConstant;
import com.common.Log4j;
import com.common.GenerateData;

public class FraudManagement {
	
	public static DateFormat dateformat = new SimpleDateFormat("HH:MM:SS , DD/MM/YYY");
	Date d = new Date();

	private static String victimEmail() {

		return "victim" + UUID.randomUUID() + "yopmail.com";

	}

/*	private static String fraudsterEmail() {

		return "frdtr" + UUID.randomUUID() + "yopmail.com";
	}*/

	public  void fraudTicketLandingPage() throws Exception {

	//	Log.info("Landing on Create Fraud Ticket form");

		TestConstant.fraudHeaderClick = TestConstant.driver.findElement(By
				.xpath(utility.ConfigurationFile.getProperty(TestConstant.fraudHeaderClickElementFiled)));
		Assert.assertEquals(TestConstant.fraudHeaderClick.getText(), "FRAUD MANAGEMENT");
		TestConstant.fraudHeaderClick.click();
	

		TestConstant.fraudSubMenuHeader = TestConstant.driver.findElement(By.xpath(
				utility.ConfigurationFile.getProperty(TestConstant.fraudSubMenuHeaderClickElementFiled)));
		Assert.assertEquals(TestConstant.fraudSubMenuHeader.getText(), "View Fraud Tickets");
		TestConstant.fraudSubMenuHeader.click();
		

		TestConstant.createFraudTicket = TestConstant.driver.findElement(By.xpath(
				utility.ConfigurationFile.getProperty(TestConstant.createFraudTicketElementField)));
		Assert.assertEquals(TestConstant.createFraudTicket.getText(), "Create Fraud Ticket");
		TestConstant.createFraudTicket.click();

		//Log.info("Page Refresh");

		TestConstant.driver.navigate().refresh();

	}

	public  void createFraudTicket() throws Exception {

		WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);
		GenerateData genData = new GenerateData();

		/* Victim First Name */
		TestConstant.victimFirstName = TestConstant.driver.findElement(By
				.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimFirstNameElementField)));
		TestConstant.victimFirstName.sendKeys("TEST" + genData.generateRandomString(6).toUpperCase());
		Thread.sleep(1000);

		/* Victim First Name */
		TestConstant.victimMiddleName = TestConstant.driver.findElement(By
				.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimMiddleNameElementField)));
		TestConstant.victimMiddleName.sendKeys(genData.generateRandomString(5).toUpperCase());

		/* Victim Last Name */
		TestConstant.victimLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimLastNameElementField))));
		TestConstant.victimLastName.sendKeys(genData.generateRandomString(7).toUpperCase());

/*		if (TestConstant.victimLastName.isDisplayed() && TestConstant.victimLastName.isEnabled()) {

		} else {
			//Log.info("Element Locator is not visible");
			TestConstant.driver.quit();

		*/

		/* victim Mobile */
		TestConstant.victimMobile = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimMobileElementField)));
		TestConstant.victimMobile.sendKeys("9" + genData.generateRandomNumber(9));
		
/*
		 victim Landline 
		TestConstant.victimLandline = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimLandlineElementField)));
		TestConstant.victimLandline.sendKeys(genData.generateRandomNumber(6));*/
	

		/* victim Email */
		TestConstant.victimEmail = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimEmailElementField)));
		TestConstant.victimEmail.sendKeys(genData.generateEmail(15));
		

		/* victim Line1 */
		TestConstant.victimLine1 = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimLine1ElementField)));
		TestConstant.victimLine1.sendKeys("House No: " + genData.generateRandomAlphaNumeric(4)+" "+"Street No"+genData.generateRandomNumber(3));
		

		/* victim Line2 */
		TestConstant.victimLine2 = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimLine2ElementField)));
		TestConstant.victimLine2.sendKeys("Street No: " + genData.generateRandomNumber(2));
	

		/* victim Pincode */
		TestConstant.victimPincode = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.victimPincodeElementField)));
		TestConstant.victimPincode.sendKeys("110008");
	
		/* Type Of Fraud */
		Select typeOfFraud = new Select(TestConstant.driver.findElement(By.xpath("//select[@name=\"type_of_fraud\"]")));
		typeOfFraud.selectByVisibleText("Card Transaction");
		
		/* Card Digit */

		TestConstant.cardSixDigit = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.cardSixDigitElementField)));
		TestConstant.cardSixDigit.sendKeys("5"+genData.generateRandomNumber(5));
			
		TestConstant.cardFourDigit = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.cardFourDigitElementField)));
		TestConstant.cardFourDigit.sendKeys(genData.generateRandomNumber(4));
		

		/* Type of Card */
		Select typeOfCard = new Select(TestConstant.driver.findElement(By.xpath("//select[@name='type_of_card']")));
		typeOfCard.selectByVisibleText("Debit Card");

		
		/* Card Issuer */
		Select cardIssuer = new Select(TestConstant.driver.findElement(By.name("card_issuer")));
		cardIssuer.selectByVisibleText("MASTERCARD");

		/* Card Issuing Bank */
		Select cardIssuingBank = new Select(TestConstant.driver.findElement(By.xpath("//select[@id='card_issuing_bank']")));
		cardIssuingBank.selectByVisibleText("State Bank Of India");

		/* LEA ID */
		String LEA_ID = TestConstant.driver.findElement(By.id("lea_id")).getText();
		System.out.println(LEA_ID);

		/* Card Number Length */

		TestConstant.cardNumberLength = TestConstant.driver.findElement(By.xpath("//input[@id='card_length']"));
		TestConstant.cardNumberLength.sendKeys("16");

		/* Date of Transaction */

		TestConstant.driver.findElement(By.xpath("//input[@id='date_of_transaction']")).click();
		TestConstant.driver.findElement(By.xpath("/html[1]/body[1]/div[6]"));
		TestConstant.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/table[1]/tbody[1]/tr[2]/td[4]/a[1]")).click();

		/* (+) Add Transaction */
		TestConstant.driver.findElement(By.xpath("//button[@id='transaction_counter']")).click();

		// Amount
		WebElement amount = TestConstant.driver.findElement(By.xpath("//input[@id='amount1']"));
		amount.sendKeys(genData.generateRandomNumber(4) + ".00");
		// Money Transferred to
		Select moneyTransferred = new Select(
				TestConstant.driver.findElement(By.xpath("//select[@id='money_transferred_to1']")));
		moneyTransferred.selectByVisibleText("Shopclues");
		// Bank Ref No
		TestConstant.driver.findElement(By.name("ref_id1")).sendKeys("TXN" + genData.generateRandomNumber(8));
		// Time
		Select hour = new Select(TestConstant.driver.findElement(By.xpath("//select[@id='hour1']")));
		hour.selectByVisibleText("11");
		Select minute = new Select(TestConstant.driver.findElement(By.xpath("//select[@id='minutes1']")));
		minute.selectByVisibleText("15");
		Select meridiem = new Select(TestConstant.driver.findElement(By.xpath("//select[@id='meridiem1']")));
		meridiem.selectByVisibleText("PM");

		/* Fraudster Details */
		TestConstant.fraudsterMobile = TestConstant.driver.findElement(By
				.xpath(utility.ConfigurationFile.getProperty(TestConstant.fraudsterMobileElementField)));
		TestConstant.fraudsterMobile.sendKeys("9" + genData.generateRandomNumber(9));

		TestConstant.fraudsterEmail = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.fraudsterEmailElementField)));
		TestConstant.fraudsterEmail.sendKeys(genData.generateEmail(16));
		

		TestConstant.Description = TestConstant.driver.findElement(By
				.xpath(utility.ConfigurationFile.getProperty(TestConstant.DescriptionFraudElementField)));
		TestConstant.Description.sendKeys("New Fraud Ticket has been created on"+ dateformat);
		
	
	}

	public  void confirmTicket() {
		
	WebElement FrautTicketSuccessMessage = TestConstant.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/p[1]"));
	FrautTicketSuccessMessage.getText();
	System.out.println(FrautTicketSuccessMessage.getText());
	
	TestConstant.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	

	}	
	/* (-) Remove Transaction */
	public void removeTrasaction() {

		TestConstant.driver.findElement(By.xpath("//button[@id='transaction_counter_minus1']")).click();
	}

	/* Save to final submitting the fraud ticket */
	public  void saveFraud() throws Exception {

		TestConstant.fraudSaveButton = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.SaveButtonElementField)));
		TestConstant.fraudSaveButton.click();
	}

	/* Cancel Button to canceling the fraud ticket */
	public  void cancelFraud() throws Exception {

		TestConstant.fraudCancelButton = TestConstant.driver.findElement(
				By.xpath(utility.ConfigurationFile.getProperty(TestConstant.CancelButtonElementField)));
		TestConstant.fraudSaveButton.click();
	}
	
	
	public void columnsHeaders() {
		
		List<WebElement> columns = TestConstant.driver.findElements(By.tagName("a"));
		columns.iterator();
		for(WebElement listofColumn : columns) {
			
		System.out.println(listofColumn.getText());	
		}
	}


	
	
	
	public void viewFraudTicket() throws Exception {

		assertEquals(
				TestConstant.driver.findElement(By.xpath("//h2[contains(text(),'Fraud Tickets')]")).getText().trim(),
				"FRAUD TICKETS");

		List<WebElement> headerLink = TestConstant.driver.findElements(By.tagName("a"));

		for (WebElement allLink : headerLink) {

			System.out.println(allLink.getAttribute("href"));
			System.out.println(allLink.getText());

		}

	}

}
