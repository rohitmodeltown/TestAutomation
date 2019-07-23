package specs.gateway.phonePE;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import helpers.gateway.phonePE.Customer;
import helpers.gateway.phonePE.Helper;

//import src.specs.gateway.onboarding.Test;

public class getCustomerOtp extends Helper {
	
	@Test(dataProvider="getCustomerOtpSuccess", groups = {"sanity","regression"}) 
	public void successfulyGenerateOtp(String channel, String partnerMobile, String customerMobile, String salt, String ver, String errorCode, String errorMsg, String merchantAuthNeeded, String redirectionNeeded, String redirectUrl) {
		Customer cust = new Customer();
		cust.getCustomerOtp(channel, partnerMobile, customerMobile, salt, ver);
		
		assertEquals(cust.errorCode, errorCode);
		assertEquals(cust.errorMsg, errorMsg);
		assertEquals(String.valueOf(cust.merchantAuthNeeded), merchantAuthNeeded);
		assertEquals(String.valueOf(cust.redirectionNeeded), redirectionNeeded);
		assertNull(cust.redirectUrl);
	}
}
