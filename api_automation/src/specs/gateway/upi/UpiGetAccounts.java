package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiGetAccounts extends UpiHelper {
	
	@Test(dataProvider="upiGetAccountsDataProvider")
	public void upiGetAccounts(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpaId, String iin, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.upiGetAccounts(ver, channel, appVersion, vpaId, iin);
		//assertEquals(upi.messageText,"SUCCESS");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
