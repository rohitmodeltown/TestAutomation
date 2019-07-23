package specs.gateway.merchant.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.merchant.onboarding.Helper;
import helpers.gateway.merchant.onboarding.Merchant;

public class ValidatePincode extends Helper{
	
	@Test(dataProvider="pincodeDataProvider")
	public void validatePinCode(String ver, String channel, String languageID, String pincode, String message, String code, String errorCode) throws Exception {
		Merchant merchant = new Merchant();
		merchant.validatePinCode(ver, channel, languageID, pincode);
		//assertEquals(merchant.messageText,"Pincode exists.");
		assertEquals(merchant.messageText,message);
		assertEquals(merchant.code,code);
		assertEquals(merchant.errorCode,errorCode);
	}
	
}













