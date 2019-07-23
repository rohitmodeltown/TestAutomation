package specs.gateway.upi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class ViewCustBanks extends UpiHelper {
	
	@Test(dataProvider="viewCustBanksDataProvider")
	public void viewCustBanks(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String vpaId, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.viewCustBanks(ver, channel, vpaId);
		//assertTrue(upi.messageText.contains("account available"));		
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}
	
	

}
