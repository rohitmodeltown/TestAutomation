package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiToken extends UpiHelper {

	// Blocked Test case
	
	/*@Test(dataProvider="upiTokenDataProvider")
	public void regPoll(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String challenge, String ctype, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.upiToken(mode, ver, channel, customerID, languageID, partnerId, appVersion, challenge, ctype);
		//assertEquals("Success", upi.messageText);		
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}
*/
}
