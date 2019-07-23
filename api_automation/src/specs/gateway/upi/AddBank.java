package specs.gateway.upi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.upi.UPI;
import helpers.gateway.upi.UpiHelper;

public class AddBank extends UpiHelper {
	
	@Test(dataProvider="addBankDataProvider")
	public void addBank(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String vpa, String vpaId, String accountHolderName, String accountNumber, String ifsc, String txnLimit, String bankName, String isDefault, String nickName, String credType, String credLen, String credSubType, String dType, String message, String code, String errorCode) throws Exception {
		UPI upi = new UPI();
		upi.getDeviceID(mode, ver, channel, customerID, languageID, partnerId);
		upi.addBank(ver, channel, appVersion, vpa, vpaId, accountHolderName, accountNumber, ifsc, txnLimit, bankName, isDefault, nickName, credType, credLen, credSubType, dType );
		assertEquals(upi.messageText, message);	
		assertEquals(upi.code, code);	
		assertEquals(upi.errorCode, errorCode);	
	}

}
