package specs.gateway.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.onboarding.Helper;
import helpers.gateway.onboarding.Retailer;

public class GetProfileWithOTP extends Helper {
	
	@Test(dataProvider="getProfileWithOTPSuccess", groups = {"sanity"})
	public void customerDoesNotExist(String ver, String channel, String partner_id, String ucid, String jwt_expiry, String retailer, String actor_type, String customer_id, String messageText, String errorCode, String code) throws Exception {
		Retailer ret = new Retailer();
		ret.generateToken(channel, retailer, actor_type, jwt_expiry);
		ret.generateOTP(ucid, ver, customer_id, channel, partner_id);
		ret.getProfileWithOTP(ver, channel, partner_id);
		
		assertEquals(messageText, ret.messageText);
		assertEquals(errorCode, ret.errorCode);
		assertEquals(code, ret.code);
	}
	
}
