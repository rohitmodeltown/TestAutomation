/**
 * 
 */
package com.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.Log4j;

import com.base.BaseTest;
import com.base.BasePage;

/**
 * @author A1SKIVA4
 *
 */
public class HomePage extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, 30000);
	BasePage page = new BasePage();


	@FindBy(how = How.ID, using = "last-login-datetime")
	WebElement userLastLogin;

	@FindBy(how = How.LINK_TEXT, using = "//a[@id='grouptab_0']")
	WebElement Fraud_Management;

	@FindBy(how = How.LINK_TEXT, using = "//a[@id='grouptab_1]")
	WebElement User_Management;

	@FindBy(how = How.LINK_TEXT, using = "//a[@id='grouptab_2']")
	WebElement Entity_Management;

	@FindBy(how = How.LINK_TEXT, using = "//a[@id='grouptab_3']")
	WebElement Suspect_Database;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Fraud Tickets')]")
	public WebElement fraudModuleHeader;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Entities')]")
	public WebElement entityModuleHeader;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Users')]")
	public WebElement userModuleHeader;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),' SUSPECT DATABASE')]")
	public WebElement suspectModuleHeader;

	@FindBy(how = How.XPATH, using = "//div[@class='desktop-bar']//ul[@id='toolbar']//li[@id='globalLinks']//ul[@class='dropdown-menu user-dropdown']//li//a[contains(text(),'Profile')]")
	WebElement user_profile;

	@FindBy(how = How.XPATH, using = "//div[@class='desktop-bar']//ul[@id='toolbar']//li[@id='globalLinks']//ul[@class='dropdown-menu user-dropdown']//li//a[contains(text(),'Log Out')]")
	WebElement user_logOut;
	/*
	 * @FindBy(how = How.XPATH, using =
	 * "//div[@class='desktop-bar']//ul[@id='toolbar']//li[@id='globalLinks']//ul[@class='dropdown-menu user-dropdown']//li//a[@id='logout_link']"
	 * ) WebElement user_logOut;
	 */

	@FindBy(how = How.XPATH, using = "//div[@class='desktop-bar']//li[@id='globalLinks']")
	WebElement globalLink;

	@FindBy(how = How.CSS, using = "#logo_c_file")
	WebElement upload;

	Actions action = new Actions(driver);

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void homePageHeaders() {
		String FM = Fraud_Management.getText();
		Log4j.info(FM);

		String UM = User_Management.getText();
		/*
		 * User_Management.isEnabled(); User_Management.isDisplayed();
		 */
		Log4j.info(UM);

		String EM = Entity_Management.getText();
		/*
		 * Entity_Management.isEnabled(); Entity_Management.isDisplayed();
		 */
		Log4j.info(EM);

		String SD = Suspect_Database.getText();
		/*
		 * Suspect_Database.isEnabled(); Suspect_Database.isDisplayed();
		 */
		Log4j.info(SD);

	}

	public void fraudManagement() {
		Fraud_Management.isEnabled();
		Fraud_Management.isDisplayed();
		Log4j.info("Fraud Management");
	}

	public void UserManagement() {
		User_Management.isEnabled();
		User_Management.isDisplayed();
		Log4j.info("User Management");
	}

	public void EntityManagement() {
		Entity_Management.isEnabled();
		Entity_Management.isDisplayed();
		Log4j.info("Entity Management");
	}

	public void lastLoginUserInfo() {

		Log4j.info("Verifing who is Logged in and last login date & time");
		String Last_Login = userLastLogin.getText();
		Log4j.info(Last_Login);

	}

	public void profile() throws InterruptedException {

		Log4j.info("User Profile");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		action.moveToElement(globalLink).build().perform();
		globalLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(user_profile).build().perform();
		user_profile.click();
		Thread.sleep(2000);

	}

	public void logOut() {

		Log4j.info("Verify User Log Out");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

		action.moveToElement(globalLink).build().perform();
		globalLink.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		action.moveToElement(user_logOut).build().perform();
		user_logOut.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * // *[@id="Logout_link"] Actions act = new Actions(driver);
		 * action.moveToElement(TestConstant.log_out_username).build().perform();
		 * TestConstant.log_out_username.click(); Thread.sleep(1000);
		 * 
		 * TestConstant.log_out = TestConstant.driver
		 * .findElement(By.xpath(utility.ConfigurationFile.getProperty(TestConstant.
		 * logOutUserIconElementField)));
		 * 
		 * action.moveToElement(TestConstant.log_out).build().perform(); //
		 * action.click();
		 */

		/*
		 * if (TestConstant.log_out.isDisplayed()) {
		 * 
		 * TestConstant.log_out.click(); Log4j.info("Clicked on Log Out button.");
		 * 
		 * } else { Log4j.info("LogOut element is not accessible."); }
		 */
	}

	public void profile_edit() {

		/* Action dropdown link */
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		/* Edit Button */
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#edit_button")))).click();
	}

	public void uploadFiles(String imagePath) {
		wait.until(ExpectedConditions.elementToBeClickable(upload));
		upload.click();
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
