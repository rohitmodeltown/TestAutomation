package specs.gateway.onboarding;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import helpers.gateway.onboarding.VerifyCustInitPartnerHelper;
import io.restassured.response.Response;


public class VerifyCustInitPartner extends VerifyCustInitPartnerHelper {
	@Test(dataProvider="successData", groups = {"sanity"})
	public void successfullVerification(String customerId, String channel, String mode, String partnerId) throws ClassNotFoundException, SQLException, IOException {
		String myjson = generateJSON(customerId, channel, mode, partnerId);
		Response response = getResponseFromAPI(myjson);
		
		assertEquals(response.path("messageText"), "SUCCESS");
		assertEquals(response.path("errorCode"), "0000");
		assertEquals(response.path("code"), "0");
	}
}
