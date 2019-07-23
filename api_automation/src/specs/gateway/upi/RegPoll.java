package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class RegPoll extends UpiHelper{
	
	// Blocked
	
	/*@Test(dataProvider="regPollDataProvider")
	public void regPoll(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String smsToken, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.regPoll(mode, ver, channel, customerID, languageID, partnerId, appVersion, smsToken);
		//assertEquals(upi.messageText, "Success");		
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}*/

}
