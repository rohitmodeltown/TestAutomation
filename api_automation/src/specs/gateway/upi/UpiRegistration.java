package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class UpiRegistration extends UpiHelper {
	
	@Test(dataProvider="upiRegistrationDataProvider")
	public void upiRegistration(String mode, String customerID, String languageID, String partnerId, String screenHeight, String platform, String osVersion, String vpa, String imei, String deviceModel, String ver, String deviceMake,
			String username , String screenWidth, String email , String appVersion , String name, String channel, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, appVersion, channel, customerID, languageID, partnerId);
		upi.upiRegistration(screenHeight, platform, osVersion, vpa, imei, deviceModel, ver, deviceMake, username, screenWidth, email, appVersion, name, channel);
		//assertEquals(upi.messageText, "SUCCESS");	
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
