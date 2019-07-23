package com.ui.pages;

/**
 * @author A1SKIVA4
 *
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.TestConstant;
import com.common.Log4j;

public class Notifications {

	public void notifictionLandingPage() throws Exception {

		WebDriverWait wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);

		TestConstant.notificationAlert = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				utility.ConfigurationFile.getProperty(TestConstant.notificationAlertElementField))));
		TestConstant.notificationAlert.click();
		String nofificationHeader = TestConstant.driver.findElement(By.xpath("//h2[contains(text(),'Notifications')]"))
				.getText().trim();
		System.out.println(nofificationHeader);
		if (nofificationHeader.equals("NOTIFICATIONS")) {

			System.out.println("Notification Header");
		} else {
			System.out.println("Notification Header Not Found");
			TestConstant.driver.quit();
		}
	}

	public void showNotificationFromFruadTicket() throws Exception {

		WebElement FT = TestConstant.driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/form[2]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]"));
		FT.click();

		String lblType_Of_Fraud ;
		WebElement FieldValue = TestConstant.driver
				.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[1]/div[1]/div[2]"));
		lblType_Of_Fraud = FieldValue.getText();

		Log4j.info("Type of Fraud:" + "" + lblType_Of_Fraud);
		
		
		String lblType_of_Card = TestConstant.driver
				.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[2]/div[1]/div[2]")).getText();
		String lblCard_Issuing_Bank = TestConstant.driver
				.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[3]/div[1]/div[2]")).getText();
		String lblFirst_six_digits_of_card = TestConstant.driver
				.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[4]/div[1]/div[2]")).getText();
		String lblDate_Time = TestConstant.driver
				.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[5]/div[1]/div[2]")).getText();
		String lblLEA_ID = TestConstant.driver.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[6]/div[1]/div[2]"))
				.getText();
		String lblTicket_Status = TestConstant.driver
				.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[1]/div[2]/div[2]")).getText();
		String lblCard_Issuer = TestConstant.driver.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[2]/div[2]/div[2]")).getText();
		String lblRef_No = TestConstant.driver.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[3]/div[2]/div[2]")).getText();
		String lbllast_four_digits_of_card = TestConstant.driver.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[4]/div[2]/div[2]")).getText();
		
		
		Log4j.info("Type of Fraud:" + "" + lblType_Of_Fraud);
		Log4j.info("Type of Card:" + "" + lblType_of_Card);
		Log4j.info("Card Issuing Bank:" + "" + lblCard_Issuing_Bank);
		Log4j.info("First six digits of card:" + "" + lblFirst_six_digits_of_card);
		Log4j.info("Date & Time:" + "" + lblDate_Time);
		Log4j.info("LEA ID:" + "" + lblLEA_ID);
		Log4j.info("Ticket Status:" + "" + lblTicket_Status);
		Log4j.info("Card Issuer:" + "" + lblCard_Issuer);
		Log4j.info("Ref No:" + "" + lblRef_No);
		Log4j.info("Last four digits of card:" + "" + lbllast_four_digits_of_card);
		

	}

	public void viewFraudTicket() {
		
	List<WebElement> viewTicket = TestConstant.driver.findElements(By.tagName("button"));
	for(WebElement ticket : viewTicket) {
		System.out.println(ticket.getAttribute("abc"));
	}
	

	

		
	}

}
