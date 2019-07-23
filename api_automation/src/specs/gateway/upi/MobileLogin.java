package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class MobileLogin extends UpiHelper{

	
	@Test(dataProvider="mobileLoginDataProvider")
	public void mobileLogin(String mode, String customerID, String ver, String channel, String appVersion, String languageID, String simId,String slotId, String osApiVersion, String platform, String partnerId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.mobileLogin( ver,  channel,  appVersion, languageID,  simId, slotId, osApiVersion, platform);
		//assertEquals(upi.primaryVpaId,"3308");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}
	
}
