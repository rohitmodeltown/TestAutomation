package specs.gateway.upi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class FetchUpiTxnHistory extends UpiHelper{
	
		@Test(dataProvider="fetchUpiTxnHistoryDataProvider")
		public void checkVpa(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String from, String to, String maxRecords, String message, String code, String errorCode) throws Exception {
			UPI upi = new UPI();
			upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);			
			upi.fetchUpiTxnHistory(ver, channel, appVersion, from, to, maxRecords );
			assertTrue(upi.messageText.contains(message));	
			//assertEquals(upi.messageText, message);	
			assertEquals(upi.code, code);	
			assertEquals(upi.errorCode, errorCode);	
		}

}
