package com.base;

import java.util.concurrent.TimeUnit;

/**
 * @author A1SKIVA4
 *
 */
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constant.TestConstant;

public class BaseTest {

	public static WebDriver driver;

	public WebDriver getInstance() throws Exception {

		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null)
			initializeDriver();
		return driver;

	}

	public void initializeDriver() {

		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		System.setProperty(TestConstant.driver_chrome, TestConstant.setProperty_chrome);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		// this line of code is to resolve protected mode issue
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("enablePersistentHover", false);
		capabilities.setCapability("browser", "chorme");
		capabilities.setPlatform(Platform.WIN10);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(TestConstant.cybersafe_URL);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

	}

	public void terminate() {

		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

	}

}
