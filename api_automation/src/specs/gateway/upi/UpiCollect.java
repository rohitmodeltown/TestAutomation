package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiCollect extends UpiHelper {
	@Test(dataProvider="upiRequestOTPDataProvider")
	public void upiCollect(String mode, String ver, String channel, String customerID, String languageID, String partnerId,String vpaId, String vfaId, String remarks, String toVpa, String toName, String amount, String latitude, String longitude, String location, String feature, String locality, String 	admin, String countryCode, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.upiCollect(ver, channel, vpaId, vfaId,  remarks , toVpa , toName, amount , latitude, longitude, location, feature, locality, admin, countryCode);	
		//assertEquals(upi.messageText,"SUCCESS");
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
