package com.TestMethod;

import org.testng.annotations.Test;

import com.report.Log;
import com.ui.page.InitializeWebDriver;
import com.ui.page.LoginAndLogout;
import com.ui.page.UserManagement;


public class UserManagementTestCases {
	
	
 @Test
  public void verifyCreateUser() throws Exception{
	  
	  Log.info("Create User form");
	  
	 
	  LoginAndLogout.openBrowser();
	  LoginAndLogout.loginToCyberSafe();
	  UserManagement.createUserLandingPage();
	  UserManagement.createUserForm();
	
	  
  }
  
 /*@Test
  public void verifyLabelUsers() throws Exception{
	  
	  
	  LoginAndLogout.openBrowser();
	  LoginAndLogout.loginToCyberSafe();
	  UserManagement.createUserLandingPage();
	  UserManagement.labels();
	  
  }
  
	// @Test (groups = {"Sanity","Regression"})
	 @Test 
	  public void verifyLoginInfo() throws Exception{
		  
		  InitializeWebDriver.initializeWebDriver();
		  LoginAndLogout.openBrowser();
		  LoginAndLogout.loginToCyberSafe();
		  LoginAndLogout.loginInfo();
		  InitializeWebDriver.closeSession();
		  
	  }*/
  
}
