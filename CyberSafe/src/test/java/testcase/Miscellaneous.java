/**
 * 
 */
package testcase;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.BaseTest;
import com.common.Log4j;

import com.ui.pages.EntityRegistration;
import com.ui.pages.LoginModule;
import com.ui.pages.UserRegistration;

import utility.ExtentTestManager;
import java.lang.reflect.Method;

/**
 * @author A1SKIVA4
 *
 */
public class Miscellaneous extends BaseTest {

	BaseTest test;
	BasePage page;
	LoginModule logged;
	EntityRegistration entityregister;
	UserRegistration userregister;

	public Miscellaneous() {
		super();

	}

	@BeforeTest
	public void startTestCase() {

		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		Log4j.info("****************************************************************************************");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX           " + "-S-T-A-R-T-" + "           XXXXXXXXXXXXXXXXXXXXXX");
		initializeDriver();

	}

	@AfterTest
	public void endTestCase() {
		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX           " + "-E---N---D-" + "           XXXXXXXXXXXXXXXXXXXXXX");
		Log4j.info("****************************************************************************************");
		terminate();

	}

	@Test(enabled = true)
	public void loginTitle(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
		Log4j.info("Verify that Address(URL) of the application");
		String Title = driver.getTitle();
		Log4j.info(Title);
	}

	@Test(enabled = true)
	public void logo(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
		Log4j.info(" Verify that logo is enabled and displayed");
		logged = new LoginModule();
		logged.validateLogo();
	}

	@Test(enabled = true)
	public void goAndEntityRegistrationPage(Method method) {
		ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty username and password.");

		Log4j.info("Verify that user able to navigate Home & Entity Registration and then Back to Login");

		entityregister = new EntityRegistration();
		page = new BasePage();
		entityregister.entityRegisterform();
		Log4j.info(driver.getTitle());
		driver.navigate().back();
		Log4j.info(driver.getTitle());

	}

	@Test(enabled = true)
	public void goAndBackToUserRegistrationPage(Method method) {
		ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
		Log4j.info("Verify that user able to navigate Home & User Registration and then Back to Login");
		userregister = new UserRegistration();
		userregister.userRegisterform();
		Log4j.info(driver.getTitle());
		driver.navigate().back();
		Log4j.info(driver.getTitle());
	}

	@Test(enabled = true)
//	@Parameters({"name","value"})
	public void forget_reset_Password() throws Exception {
		Log4j.info(" Verify that User able to change forget password.");
		logged = new LoginModule();
		logged.forgetPassword("LEA00001-200001", "TestLEAleveltwo@yopmail.com");
	}

	/*
	 * @Test public void verifyLoginPageWebElement() {
	 * 
	 * Log4j.
	 * info("Verify that all visible webelment should be enabled on Login page");
	 * page.footers(); page.headers();
	 * 
	 * }
	 */

	
	
	  @Test(priority = 4, description =
	  "TEST CASE - 5 : Verify that footers at login page", enabled = true) public
	  void footerAtLogin() throws Exception {
	  Log4j.info("TEST CASE - 5 : Verify that footers at login page");
	  
	  initializeDriver(); page = new BasePage(); page.footers();
	  
	  }
	 

	/*
	 * @Test(priority = 5, description =
	 * "TEST CASE - 6 : Verify that headers at login page", enabled = false) public
	 * void headerAtLogin() throws Exception {
	 * Log4j.info("TEST CASE - 6 : Verify that headers at login page");
	 * 
	 * initializeDriver(); page = new BasePage(); page.headers();
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 6, description =
	 * "TEST CASE - 7 : Verify that all lable present into login page", enabled =
	 * false) public void labelText() throws Exception {
	 * Log4j.info("TEST CASE - 7 : Verify that all lable present into login page");
	 * 
	 * initializeDriver();
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 10, description =
	 * "TEST CASE - 8 : Verify that error message on session expired", enabled =
	 * false) public void expireSession() throws Exception {
	 * Log4j.info("TEST CASE - 8 : Verify that error message on session expired");
	 * initializeDriver(); logged.sessionTimeOut();
	 * 
	 * }
	 */
}
