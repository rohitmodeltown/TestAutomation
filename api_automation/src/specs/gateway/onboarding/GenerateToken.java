package specs.gateway.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import helpers.gateway.onboarding.Helper;
import helpers.gateway.onboarding.Retailer;

public class GenerateToken extends Helper {
	@Test(dataProvider="generateTokenSuccess", groups = {"sanity"})
	public void successfullyGenerateToken(String channel, String jwt_expiry, String retailer, String actor_type, String messageText, String errorCode, String code, String enableEncryption) throws Exception {
		Retailer ret = new Retailer();
		ret.generateToken(channel, retailer, actor_type, jwt_expiry);
		
		assertEquals(messageText, ret.messageText);
		assertEquals(errorCode, ret.errorCode);
		assertEquals(code, ret.code);
		assertEquals(enableEncryption, ret.enableEncryption);
		assertEquals(ret.retailerName, getRetailerNameFromDb(retailer));
		assertEquals(ret.retailerStatus, getStatus(retailer));
//		assertEquals(ret.retailerCurrentBalance, getRetailerBalanceFromDb(retailer));
	}
}