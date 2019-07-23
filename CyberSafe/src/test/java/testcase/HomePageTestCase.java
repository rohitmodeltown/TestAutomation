/**
 * 
 */
package testcase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.BaseTest;
import com.common.Log4j;
import com.constant.TestConstant;
import com.ui.pages.HomePage;
import com.ui.pages.LoginModule;

import junit.framework.Assert;

/**
 * @author A1SKIVA4
 *
 */
public class HomePageTestCase extends BaseTest {

	BasePage page;
	LoginModule logged;
	HomePage homepage;

	public HomePageTestCase() {

		super();
	}

	@BeforeTest
	public void startTC() {

		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		Log4j.info(
				"*****************************************************************************************************");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX                  " + "-S-T-A-R-T-"
				+ "                 XXXXXXXXXXXXXXXXXXXXXX");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX           " + "HOME PAGE" + "           XXXXXXXXXXXXXXXXXXXXXX");
		initializeDriver();

	}

	@AfterTest
	public void endTC() {
		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX                 " + "-E---N---D-"
				+ "                  XXXXXXXXXXXXXXXXXXXXXX");
		Log4j.info(
				"*****************************************************************************************************");
		// terminate();
	}

	@Test(enabled = true)
	public void userLastLoginInfo() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, TestConstant.pageload);
		logged = new LoginModule();
		Log4j.info("Verify that Last Logged-in info displayed");
		logged.loginToCybersafe("CYS00001-100001", "Cybersafe#$100");
		wait.until(ExpectedConditions.visibilityOf(logged.otp_model));
		logged.otp();
		homepage = new HomePage();
		homepage.lastLoginUserInfo();

	}

	@Test(enabled = true)
	public void homePageLandingPage() {

		Log4j.info("Verify that Element visible to HomePage Landing page");
		logged = new LoginModule();
		logged.loginToCybersafe("CYS00001-100001", "Cybersafe#$100");
		logged.otp();
		homepage = new HomePage();
		homepage.homePageHeaders();

	}

	@Test(enabled = true)
	public void userProfile() throws InterruptedException {

		Log4j.info("Verify that user profile info");
		logged = new LoginModule();

		logged.loginToCybersafe("LEA00001-300001", "Cybersafe#$100");
		logged.otp();
		Thread.sleep(6000);
		homepage = new HomePage();
		Assert.assertEquals("Cyber Safe", driver.getTitle());
		homepage.profile();
	}

	@Test(enabled = true)
	public void logout() {

		Log4j.info("TEST CASE - 4 : Verify that user able to do log Out from application");
		logged = new LoginModule();
		logged.loginToCybersafe("CYS00001-100001", "Cybersafe#$100");
		logged.otp();
		homepage = new HomePage();
		homepage.logOut();
	}

	@Test(enabled = true)
	public void editProfile() throws InterruptedException {

		Log4j.info("Verify that user edit profile ");
		logged = new LoginModule();
		logged.loginToCybersafe("LEA00001-300001", "Cybersafe#$100");
		logged.otp();
		Thread.sleep(3000);
		homepage = new HomePage();
		homepage.profile();
		homepage.profile_edit();

	}

	@Test(enabled = true)
	public void uploadLogo() throws InterruptedException {

		Log4j.info("Verify that user edit profile ");
		logged = new LoginModule();
		logged.loginToCybersafe("LEA00001-200001", "India@123");
		logged.otp();
		Thread.sleep(3000);
		homepage = new HomePage();
		homepage.profile();
		homepage.profile_edit();
		homepage.uploadFiles("D:\\Airtel\\Requirement\\Test Data\\IB Director pic.jpg");
		driver.findElement(By.cssSelector("#SAVE_HEADER")).submit();

	}

}