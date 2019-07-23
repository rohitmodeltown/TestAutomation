package com.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.constant.Generic;
import com.constant.TestConstant;
import com.report.Log;

public class HeaderAndFooter {

	 
	public static WebElement superCharged;

	public static WebElement poweredBy;

	public static WebElement homeaffairs;

	public static WebElement airtelPaymentsBank;

	public static WebDriverWait wait;

	
	public static WebElement home;

	public static WebElement userManual;

	public static WebElement aboutUs;

	public static WebElement headerLogo;

	/** Header methods of the page */
	public static void headers() throws Exception {

		Log.info("Verifing the headers of the cybersafe login page");
		wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);
		
		Thread.sleep(1000);
		headerLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.headerLogoElementField))));
		Assert.assertEquals(headerLogo, true, "Correct © Supercharged by SuiteCRM Captured");
		Assert.assertEquals(headerLogo.isEnabled(), true, "Correct © Supercharged by SuiteCRM Enabled");
		Assert.assertEquals(headerLogo.isDisplayed(), true, "Correct © Supercharged by SuiteCRM Displayed");
		Generic.takeScreenshot(TestConstant.driver, "headerLogo");
		if (headerLogo.equals(TestConstant.headerLogoElementField)) {
			System.out.println("<--------© headerLogo ------>");
		} else {
			System.out.println("xxxxxxxxxxx © headers not available xxxxxxxxxxx");
		}
		
		Thread.sleep(1000);
		home = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.homeELementField))));
		Assert.assertEquals(home, true, "Correct HOME Captured");
		Assert.assertEquals(home.isEnabled(), true, "Correct HOME Captured Enabled");
		Assert.assertEquals(home.isDisplayed(), true, "Correct HOME Captured Displayed");
		Generic.takeScreenshot(TestConstant.driver, "home");
		if (home.equals(TestConstant.homeELementField)) {
			System.out.println("<--------© home ------>");
		home.click();
		} else {
			System.out.println("xxxxxxxxxxx © headers not available xxxxxxxxxxx");
		}
		Thread.sleep(1000);
		userManual = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.userManualElementFiled))));
		Assert.assertEquals(userManual, true, "Correct © Supercharged by SuiteCRM Captured");
		Assert.assertEquals(userManual.isEnabled(), true, "Correct © Supercharged by SuiteCRM Enabled");
		Assert.assertEquals(userManual.isDisplayed(), true, "Correct © Supercharged by SuiteCRM Displayed");
		Generic.takeScreenshot(TestConstant.driver, "userManual");
		if (userManual.equals(TestConstant.userManualElementFiled)) {
			System.out.println("<--------© userManual ------>");
			userManual.click();
		} else {
			System.out.println("xxxxxxxxxxx © headers not available xxxxxxxxxxx");
		}
		Thread.sleep(1000);
		aboutUs = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.aboutUsElementFiled))));
		Assert.assertEquals(aboutUs, true, "Correct © Supercharged by SuiteCRM Captured");
		Assert.assertEquals(aboutUs.isEnabled(), true, "Correct © Supercharged by SuiteCRM Enabled");
		Assert.assertEquals(aboutUs.isDisplayed(), true, "Correct © Supercharged by SuiteCRM Displayed");
		Generic.takeScreenshot(TestConstant.driver, "aboutUs");
		if (aboutUs.equals(TestConstant.aboutUsElementFiled)) {
			System.out.println("<--------© aboutUs ------>");
			aboutUs.click();
		} else {
			System.out.println("xxxxxxxxxxx © headers not available xxxxxxxxxxx");
		}

	}

	
	/** Footer methods of the page */
	@SuppressWarnings("unlikely-arg-type")
	public static void footers() throws Exception {

		Log.info("Verifing the footers of the cybersafe login page");
		wait = new WebDriverWait(TestConstant.driver, TestConstant.pageload);

		Thread.sleep(2000);

		superCharged = TestConstant.driver.findElement(By.id("admin_options"));
		Assert.assertEquals(superCharged, true, "Correct © Supercharged by SuiteCRM Captured");
		Assert.assertEquals(superCharged.isEnabled(), true, "Correct © Supercharged by SuiteCRM Enabled");
		Assert.assertEquals(superCharged.isDisplayed(), true, "Correct © Supercharged by SuiteCRM Displayed");
		if (superCharged.equals(TestConstant.superCharged)) {
			System.out.println("<--------© Supercharged by SuiteCRM------>");
		} else {
			System.out.println("xxxxxxxxxxx © Footer not available xxxxxxxxxxx");
		}

		Thread.sleep(1000);

		poweredBy = TestConstant.driver.findElement(By.id("powered_by"));
		Assert.assertEquals(poweredBy, true, "Correct © Powered By SugarCRM");
		Assert.assertEquals(poweredBy.isEnabled(), true, "© Powered By SugarCRM Enabled");
		Assert.assertEquals(poweredBy.isDisplayed(), true, "© Powered By SugarCRM Displayed");
		if (poweredBy.equals(TestConstant.poweredBy)) {
			System.out.println("<--------© Powered By SugarCRM ------>");
		} else {
			System.out.println("xxxxxxxxxxx © Footer not available xxxxxxxxxxx");
		}

		Thread.sleep(1000);

		homeaffairs = TestConstant.driver.findElement(By.id("initiative_of"));
		Assert.assertEquals(homeaffairs, true, "Correct ©In initiative of Home Affairs");
		Assert.assertEquals(homeaffairs.isEnabled(), true, "©In initiative of Home Affairs Enabled");
		Assert.assertEquals(homeaffairs.isDisplayed(), true, "©In initiative of Home Affairs Displayed");
		if (homeaffairs.equals(TestConstant.homeaffairs)) {
			System.out.println("<--------©In initiative of Home Affairs ------>");
		} else {
			System.out.println("xxxxxxxxxxx © Footer not available xxxxxxxxxxx");
		}

		Thread.sleep(1000);

		airtelPaymentsBank = TestConstant.driver.findElement(By.id("technology_partner"));
		Assert.assertEquals(airtelPaymentsBank, true, "Correct ©Technology Partner Airtel Payments Bank");
		Assert.assertEquals(airtelPaymentsBank.isEnabled(), true, "©Technology Partner Airtel Payments Bank Enabled");
		Assert.assertEquals(airtelPaymentsBank.isDisplayed(), true,
				"©Technology Partner Airtel Payments Bank Displayed");
		if (airtelPaymentsBank.equals(TestConstant.airtelPaymentsBank)) {
			System.out.println("<--------©Technology Partner Airtel Payments Bank ------>");
		} else {
			System.out.println("xxxxxxxxxxx © Footer not available xxxxxxxxxxx");
		}

	}

}
