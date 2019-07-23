package specs.gateway.merchant.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.merchant.onboarding.Helper;
import helpers.gateway.merchant.onboarding.Merchant;

public class EncCreateOTP extends Helper{
	
	@Test(dataProvider="encCreateOtpDataProvider")
	public void encCreateOtp(String ver, String channel, String languageID, String customerID, String message, String code, String errorCode) throws Exception {
		Merchant merchant = new Merchant();
		merchant.createOtp(ver, channel, languageID, customerID);
		
		assertEquals(merchant.messageText,message);
		assertEquals(merchant.code,code);
		assertEquals(merchant.errorCode,errorCode);
	}
}













