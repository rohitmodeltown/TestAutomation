package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiPendingCollect extends UpiHelper {
	
	@Test(dataProvider="upiPendingCollectDataProvider")
	public void upiPendingCollect(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode,ver, channel, customerID, languageID, partnerId);
		upi.upiPendingCollect(ver, channel);
		
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
