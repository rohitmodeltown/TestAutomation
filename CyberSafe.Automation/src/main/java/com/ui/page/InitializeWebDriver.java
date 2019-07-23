package com.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constant.TestConstant;


public class InitializeWebDriver {
	
	public static WebDriver getInstance() throws Exception{
		
		if(TestConstant.driver == null || ((RemoteWebDriver) TestConstant.driver).getSessionId() == null)
		initializeWebDriver();
		return TestConstant.driver;	
		
}
	
	public static void initializeWebDriver() {
		
		System.setProperty(TestConstant.driver_chomre, TestConstant.setProperty_chrome);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		// this line of code is to resolve protected mode issue 
		//capabilities.setCapability(ChromeDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("enablePersistentHover", false);
		TestConstant.driver = new ChromeDriver();	
		
}
	
	public static void closeSession() {
		
		TestConstant.driver.manage().deleteAllCookies();
		TestConstant.driver.close();
		TestConstant.driver.quit();
		
	}

}
