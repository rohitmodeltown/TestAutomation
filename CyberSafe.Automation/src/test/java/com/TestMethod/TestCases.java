package com.TestMethod;


import org.testng.annotations.Test;
import com.ui.page.LoginAndLogout;
import com.report.Log;
import com.constant.Generic;
import com.constant.TestConstant;
import com.report.ExcelUtils;

import com.ui.page.InitializeWebDriver;


public class TestCases {
	
/*	 @Test (priority = 0, description = "Verify first page of cyberSafe is being loaded")
	 public void openURL() {
		 
		 InitializeWebDriver.initializeWebDriver();
	 }
 	
    @Test (priority = 0, description = "Verify first page of cyberSafe is being loaded")   
	public void verifyCyberSafeHomePage() throws Exception {
	  
      System.out.println("TEST CASE NO : 1");
	  LoginAndLogout.openBrowser();
	  Log.info("Browser is getting open");
	  Generic.takeScreenshot(TestConstant.driver, "CybersSafeHomepage");
	  Thread.sleep(5000);
	  InitializeWebDriver.closeSession();
		
	}
  
  @Test ( priority = 1, description = "Verify the logo on Cybersafe home page should be enabled and displayed" )
    public void verifyCyberSafeLogo() throws Exception{
	  System.out.println("TEST CASE NO : 2");
    	LoginAndLogout.openBrowser();
     	LoginAndLogout.logo();
     	Log.info("CyberSafe Logo is enabled and displayed ");
    	InitializeWebDriver.closeSession();
    	
    }
    */
 
    @Test (priority = 2, description = "Verifing the login and logout functionality of users" )
    public void verifyLogintoCyberSafe() throws Exception{
    	 System.out.println("TEST CASE NO : 3");
    	
    	LoginAndLogout.openBrowser();
		LoginAndLogout.loginToCyberSafe();
   	  LoginAndLogout.logOut();
   	  InitializeWebDriver.closeSession();
    	  
    	
    }
    
  /*  @Test (priority = 3, description = "verifying the forget password fields")
    public void verifyForgetPasswordEnabled() throws Exception{
    	LoginAndLogout.openBrowser();
    	Log.info("Browser is getting open");
    //	LoginAndLogout.forgetpaa
    	
    }
    */
    
    
}

