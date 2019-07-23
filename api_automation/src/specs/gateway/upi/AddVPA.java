package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class AddVPA extends UpiHelper{
	@Test(dataProvider="addVpaDataProvider")
	public void checkVpa(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpa, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.addVpa(ver, channel, appVersion, vpa);
		//assertEquals(upi.messageText, "SUCCESS");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
