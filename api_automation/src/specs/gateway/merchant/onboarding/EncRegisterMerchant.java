package specs.gateway.merchant.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.merchant.onboarding.Helper;
import helpers.gateway.merchant.onboarding.Merchant;

public class EncRegisterMerchant extends Helper{
	
	@Test(dataProvider="encRegisterDataProvider")
	public void encRegister(String ver, String channel, String languageID,  String customerID, String lastName,  String subCategory,String manualAddress, String panNo,  
			String permanentState, String accountHolderName, String shopCategory, String firstName, String permanentZipCode, String permanentAddress1,
			String permanentCountry, String settlementAccountNo, String permanentCity, String panCardName, String ifscCode, String shopCompanyName, String lat, String longt, String message, String code, String errorCode) throws Exception {
		Merchant merchant = new Merchant();
		merchant.createOtp(ver, channel, languageID, customerID);
		merchant.verifyProfile(ver, channel, languageID);
		merchant.merchantRegistration( lastName,  ver,  subCategory,  manualAddress,  panNo,  channel,  languageID,
				 permanentState,  accountHolderName,  shopCategory,  firstName,  permanentZipCode,  permanentAddress1,
				 permanentCountry,  settlementAccountNo,  permanentCity,  panCardName,  ifscCode,  shopCompanyName,  lat,  longt);
			
		assertEquals(merchant.messageText,message);
		assertEquals(merchant.code,code);
		assertEquals(merchant.errorCode,errorCode);
	}
}













