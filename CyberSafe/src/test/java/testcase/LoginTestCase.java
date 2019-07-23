package testcase;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.BaseTest;
import com.common.Log4j;

import com.ui.pages.LoginModule;
/**
 * @author A1SKIVA4
 *
 */
public class LoginTestCase extends BaseTest {

	BaseTest test;
	BasePage page;
	LoginModule logged;

	public LoginTestCase() {
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
		terminate();

	}

	@Test
	public void login_Level_1_CYS() {
		Log4j.info("Verify that the Level 1 CYS user able to login ");
		logged = new LoginModule();
		logged.loginToCybersafe("CYS00001-100001", "Cybersafe#$100");

	}

	@Test
	public void login_Level_2_CYS() {
		Log4j.info("Verify that the Level 2 CYS user able to login ");
		logged = new LoginModule();
		logged.loginToCybersafe("CYS00001-200001", "Cybersafe#$100");

	}

	@Test
	public void login_Level_3_CYS() {
		Log4j.info("Verify that the Level 3 CYS user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("CYS00001-300001", "Cybersafe#$100");

	}

	@Test
	public void login_Level_2_LEA() {
		Log4j.info("Verify that the Level 2 LEA user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("LEA00001-200001", "Cybersafe@123");

	}

	@Test
	public void login_Level_3_LEA() {
		Log4j.info("Verify that the Level 3 LEA user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("LEA00001-300001", "Cybersafe@123");

	}

	@Test
	public void login_Level_2_ECO() {
		Log4j.info("Verify that the Level 2 ECO user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("ECO00001-200001", "Cybersafe@123");

	}

	@Test
	public void login_Level_3_ECO() {
		Log4j.info("Verify that the Level 3 ECO user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("ECO00001-300001", "Cybersafe@123");

	}

	@Test
	public void login_Level_2_MER() {
		Log4j.info("Verify that the Level 2 MER user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("MER00001-200001", "Cybersafe@123");

	}

	@Test
	public void login_Level_3_MER() {
		Log4j.info("Verify that the Level 3 MER user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("MER00001-300001", "Cybersafe@123");

	}

	@Test
	public void login_Level_2_PYG() {
		Log4j.info("Verify that the Level 2 PYG user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("PYG00001-200001", "Cybersafe@123");

	}

	@Test
	public void login_Level_3_PYG() {
		Log4j.info("Verify that the Level 3 PYG user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("PYG00001-300001", "Cybersafe@123");

	}

	@Test
	public void login_Level_2_PPI() {
		Log4j.info("Verify that the Level 2 PPI user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("PPI00001-200001", "Cybersafe@123");

	}

	@Test
	public void login_Level_3_PPI() {
		Log4j.info("Verify that the Level 3 PPI user able to login ");

		logged = new LoginModule();
		logged.loginToCybersafe("PPI00001-300001", "Cybersafe@123");

	}

	@Test(enabled = false)
	public void autoLogOut() throws Exception {
		Log4j.info("Verify that auto logout if user is inactive into application");
		logged = new LoginModule();
		logged.loginToCybersafe("PPI00001-200001", "Cybersafe@123");
		logged.autoLogout();
	}

	/*
	 * 
	 * }
	 */

}
