package com.TestMethod;

import org.testng.annotations.Test;

import com.ui.page.EntityManagement;
import com.ui.page.InitializeWebDriver;
import com.ui.page.LoginAndLogout;


public class EntityManagementTestCases {

	@Test(description = "Entity Creation", priority = 0)
	public void verifyEntityLandingPage() throws Exception{
		
		LoginAndLogout.openBrowser();
		LoginAndLogout.loginToCyberSafe();
		EntityManagement.createEntityLandingPage();
		EntityManagement.createEntity();
		
		
		
	}
	
}
