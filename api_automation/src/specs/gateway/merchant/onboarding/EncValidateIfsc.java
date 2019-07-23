package specs.gateway.merchant.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.merchant.onboarding.Helper;
import helpers.gateway.merchant.onboarding.Merchant;

public class EncValidateIfsc extends Helper{
	
	
	@Test(dataProvider="ifscDataProvider")
	public void validatePinCode(String ver, String accountNo, String channel, String languageID, String ifsc, String message, String code, String errorCode) throws Exception {
		Merchant merchant = new Merchant();
		merchant.validateIfsc(ver, accountNo, channel, languageID, ifsc);
		//assertEquals(merchant.messageText,"IFSC valid and IMPS enabled");
		assertEquals(merchant.messageText,message);
		assertEquals(merchant.code,code);
		assertEquals(merchant.errorCode,errorCode);
	}

}













