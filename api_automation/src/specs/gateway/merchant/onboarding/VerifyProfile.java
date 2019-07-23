package specs.gateway.merchant.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.merchant.onboarding.Helper;
import helpers.gateway.merchant.onboarding.Merchant;

public class VerifyProfile extends Helper{
		
	@Test(dataProvider="verifyProfileDataProvider")
	public void verifyProfile(String ver, String channel, String languageID, String customerId, String message, String code, String errorCode) throws Exception {
		Merchant merchant = new Merchant();
		merchant.createOtp(ver, channel, languageID, customerId);
		merchant.verifyProfile(ver, channel, languageID );
		//assertEquals(merchant.messageText,"Profile Not Fetched !!");
		assertEquals(merchant.messageText,message);
		assertEquals(merchant.code,code);
		assertEquals(merchant.errorCode,errorCode);
	}
}













