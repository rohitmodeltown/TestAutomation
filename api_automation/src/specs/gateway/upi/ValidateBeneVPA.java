package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class ValidateBeneVPA extends UpiHelper{
	
	@Test(dataProvider="validateBeneVPADataProvider")
	public void checkVpa(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpaId, String vpa, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.validateBeneVPA(ver, channel, appVersion, vpaId, vpa);
		//assertEquals(upi.messageText, "Success");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
