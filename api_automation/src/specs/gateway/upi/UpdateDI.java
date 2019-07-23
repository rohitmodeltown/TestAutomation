package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpdateDI extends UpiHelper{
	@Test(dataProvider="updateDiDataProvider")
	public void updateDI(String mode,  String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String imei, String slotId, String simId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.updateDI( appVersion, imei,  slotId, simId, ver, languageID, channel);
		//assertEquals(upi.messageText, "SUCCESS");		
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
