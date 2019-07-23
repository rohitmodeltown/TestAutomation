package com.ui.page;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.constant.Generic;
import com.constant.TestConstant;
import com.report.Log;

public class EntityManagement {
	
	private static String entityEmail() {
		
		return "entity" +UUID.randomUUID() + "yopmail.com";
	}
	
	private static String entityAuthEmail() {
		
		return "auth"+UUID.randomUUID()+"yopmail.com";
	}

	public static void createEntityLandingPage() throws Exception {

		Log.info("Verify the create entity landing page");

		WebDriverWait wait = new WebDriverWait(TestConstant.driver, 240);

		TestConstant.entityHeaderClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				configurationfilepath.ConfigurationFile.getProperty(TestConstant.entityHeaderClickElementFiled))));
		Assert.assertEquals(TestConstant.entityHeaderClick.getText(), "ENTITY MANAGEMENT");
		TestConstant.entityHeaderClick.click();
		Generic.takeScreenshot(TestConstant.driver, "entityHeaderClick");
		

		TestConstant.entitySubMenuHeader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(configurationfilepath.ConfigurationFile
						.getProperty(TestConstant.entitySubMenuHeaderClickElementFiled))));
		Assert.assertEquals(TestConstant.entitySubMenuHeader.getText(), "Entities" );
		TestConstant.entitySubMenuHeader.click();
		Generic.takeScreenshot(TestConstant.driver, "entitySubMenuHeader");

		
		TestConstant.entityCreateTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(configurationfilepath.ConfigurationFile.getProperty(TestConstant.entityCreateTabElementField))));
		Assert.assertEquals(TestConstant.entityCreateTab.getText(),"Create Entity");
		TestConstant.entityCreateTab.click();
		Generic.takeScreenshot(TestConstant.driver, "entityCreateTab");
	}

	public static void createEntity() throws Exception {
		
		DateFormat dateformat = new SimpleDateFormat("HH:MM:SS , DD/MM/YYY");
		Date d = new Date();

	}

	public static void modifyEntity() throws Exception {

	}

	public static void deleteEntity() throws Exception {

	}

}
