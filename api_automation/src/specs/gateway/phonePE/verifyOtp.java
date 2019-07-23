package specs.gateway.phonePE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.phonePE.Customer;
import helpers.gateway.phonePE.Helper;

public class verifyOtp extends Helper {
	
	
	@Test(dataProvider="verifyOtpSuccess", groups = {"sanity","regression"}) 
	public void verifyOtpSuccess(String channel, String partnerMobile, String customerMobile, String otp, String salt, String ver, String authValue, String count, String expiryDate, String maxAmount, String endChannel, String errorCode, String errorMsg, String custStatus) {
		Customer cust = new Customer();
		cust.getCustomerOtp(channel, partnerMobile, customerMobile, salt, ver);
		cust.verifyOtp(channel, partnerMobile, customerMobile, otp, salt, ver, authValue, count, expiryDate, maxAmount, endChannel);
	
		assertEquals(cust.errorCode, errorCode);
		assertEquals(cust.errorMsg, errorMsg);
//		assertEquals(cust.errorCode, custStatus);
	}
}