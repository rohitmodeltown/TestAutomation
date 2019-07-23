package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiSetPrimaryVpa extends UpiHelper {
	
	@Test(dataProvider="upiSetPrimaryVpaDataProvider")
	public void upiSetPrimaryVpa(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpaId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.upiSetPrimaryVpa(ver, channel, appVersion, vpaId);
		//assertEquals(upi.messageText,"Primary VPA updated successfully.");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
