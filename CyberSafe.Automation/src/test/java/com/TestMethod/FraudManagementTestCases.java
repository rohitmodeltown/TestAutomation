package com.TestMethod;

import org.testng.annotations.Test;

import com.ui.page.EntityManagement;
import com.ui.page.FraudManagement;
import com.ui.page.LoginAndLogout;

public class FraudManagementTestCases {
	


/*		@Test(description = "Fraud Creation", priority = 0, invocationCount = 1)
		public void verifyEntityLandingPage() throws Exception{
			
			LoginAndLogout.openBrowser();
			LoginAndLogout.loginToCyberSafe();
			FraudManagement.fraudTicketLandingPage();
			FraudManagement.createFraudTicket();
			
			
			
		}*/
		
		

		@Test(description = "Fraud Creation", priority = 0, invocationCount = 1)
		public void verifyViewLandingPage() throws Exception{
			
			LoginAndLogout.openBrowser();
			LoginAndLogout.loginToCyberSafe();
			FraudManagement.fraudTicketLandingPage();
			FraudManagement.viewFraudTicket();
			
			
			
		}

}
