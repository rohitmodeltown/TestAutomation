package com.base;
/**
 * @author A1SKIVA4
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.Log4j;
import com.constant.TestConstant;

import junit.framework.Assert;

public class BasePage {

	WebDriver driver;
	private WebDriverWait wait;

	public static WebElement FCORD_MHA_GOI;
	public static WebElement Partner_APB;

	public static WebElement Home;
	public static WebElement Entity_Registration;
	public static WebElement User_Registration;

	@FindBy(xpath = "//a[@id='initiative_of']")
	WebElement MHA_FCord_foot;

	@FindBy(xpath = "//a[@id='technology_partner']")
	WebElement Partner_APB_foot;

	/* Constructor */
	public BasePage() {
		PageFactory.initElements(driver, this);
	}



	public void visibilityOfElement(By elementBy) {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	/* Click on element */
	public void click(By elementBy) {
		visibilityOfElement(elementBy);
		driver.findElement(elementBy).click();

	}

	/* Read element */
	public String readText(By elementBy) {
		visibilityOfElement(elementBy);
		return driver.findElement(elementBy).getText();

	}

	public String titleOfCurrentPage() {
		return driver.getTitle();
	}

	public boolean footers() {

		FCORD_MHA_GOI = MHA_FCord_foot;
		Partner_APB = Partner_APB_foot;

		if (FCORD_MHA_GOI.isDisplayed()) {
			String MHA_FCord = MHA_FCord_foot.getText().trim();
			Assert.assertTrue(true);
			Log4j.info(" Footer of MHA FCORD is : " + MHA_FCord);
		}
		if (Partner_APB.isDisplayed()) {
			String Technology_partner = Partner_APB_foot.getText().trim();
			Assert.assertTrue(true);
			Log4j.info(" Footer of MHA FCORD is : " + Technology_partner);
		}
		return FCORD_MHA_GOI.isDisplayed() && Partner_APB.isDisplayed();

	}

	public boolean headers() {

		Home = driver.findElement(By.xpath("// strong[contains(text(),'Home')]"));
		Entity_Registration = driver.findElement(By.xpath("//strong[contains(text(),'Entity Registration')]"));
		User_Registration = driver.findElement(By.xpath("//strong[contains(text(),'User Registration')]"));

		return Home.isDisplayed() && Entity_Registration.isDisplayed() && User_Registration.isDisplayed();
	}

}
