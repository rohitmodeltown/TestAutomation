package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class DeActivateVpa extends UpiHelper{
	
	@Test(dataProvider="deActivateVpaDataProvider")
	public void checkVpa(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpaId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.deActivateVpa(ver, channel, appVersion, vpaId);
		//assertEquals(upi.messageText, "VPA deleted Successfully.");
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
