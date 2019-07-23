package com.ui.pages;

/**
 * @author A1SKIVA4
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constant.TestConstant;
import com.common.Log4j;

public class InitializeWebDriver {

	/*public WebDriver getInstance() throws Exception {

		if (TestConstant.driver == null || ((RemoteWebDriver) TestConstant.driver).getSessionId() == null)
			initializeDriver();
		return TestConstant.driver;

	}
*/
/*	public void initializeDriver() {

		System.setProperty(TestConstant.driver_chomre, TestConstant.setProperty_chrome);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		// this line of code is to resolve protected mode issue
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("enablePersistentHover", false);
		TestConstant.driver = new ChromeDriver();

	}
*/
	public static void openBrowser() throws Exception {

		TestConstant.driver.manage().window().maximize();
		TestConstant.driver.get(TestConstant.cybersafe_URL);
		TestConstant.windowURL = TestConstant.driver.getCurrentUrl();
		Log4j.info("The URL of the page is:" +" "+ TestConstant.windowURL.toUpperCase());

	}

	public static void closeSession() {

		TestConstant.driver.manage().deleteAllCookies();
		Log4j.info("All Cookies are now deleting");
		TestConstant.driver.close();
		

	}
}
