package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiRequestOTP extends UpiHelper {
	
	@Test(dataProvider="upiRequestOTPDataProvider")
	public void upiRequestOTP(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String countryName, String countryCode, String iin, String addressLine, String accountNumber, String appVersion, String admin, String vpaId, String locality, String feature, String longitude, String latitude, String ifsc, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.upiRequestOTP(countryName, countryCode, ver,iin, addressLine, accountNumber, appVersion, admin, vpaId, locality, feature, longitude, latitude, ifsc);
		
		//assertEquals(upi.messageText, "Requesting OTP failed. Please try again.");
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
