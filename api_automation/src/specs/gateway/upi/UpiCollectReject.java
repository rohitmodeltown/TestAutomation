package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiCollectReject extends UpiHelper {
	
	@Test(dataProvider="upiCollectRejectDataProvider")
	public void upiCollectReject(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String vpaFdid, String appVersion, String chId, String upiTxnId, String vpaId, String refId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.upiCollectReject( ver, channel, vpaFdid, appVersion, chId, upiTxnId, vpaId, refId);		
		//assertEquals(upi.messageText,"Success");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
