package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class ChangePrimaryAccount extends UpiHelper{

		@Test(dataProvider="changePrimaryAccountDataProvider")
		public void checkVpa(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpaId, String vpaFdId, String message, String code, String errorCode) throws Exception {
			UPI upi = new UPI();
			upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
			upi.changePrimaryAccount(ver, channel, appVersion, languageID, vpaId, vpaFdId);
			//assertEquals(upi.messageText,"Primary Bank Account updated successfully.");	
			assertEquals(upi.messageText, message);	
			assertEquals(upi.code, code);	
			assertEquals(upi.errorCode, errorCode);	
		}

}
