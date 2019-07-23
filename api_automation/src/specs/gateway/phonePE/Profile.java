package specs.gateway.phonePE;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.gateway.phonePE.Customer;
import helpers.gateway.phonePE.Helper;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Profile extends Helper {
	public String feSessionId;
	public String expiry;
	public String delFlag;

	@BeforeTest
	public void createFeSessionId() {
		feSessionId = generateRandomNumber();
		expiry = "2020-12-09 01:01:01";
		delFlag = "0";
	}

	 @Test(dataProvider="profileSuccess", groups = {"sanity","regression"})
	public void profileFetchSuccess(String accept, String channel, String merchantId, String salt, String endChannel,
			String customerId, String code, String description) throws IOException {
		// insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		Headers headers = getHeadersForCustProfile(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId);
		Response response = given().header("accept", accept).headers(headers).contentType("application/json").log()
				.all().when().get(getProfileUrl(customerId)).then().log().all().extract().response();

		assertEquals(response.path("meta.code"), code);
		assertEquals(response.path("meta.description"), description);
		assertNotNull(response.path("meta.errors"));
		assertNotNull(response.path("meta.hash"));
		assertEquals(response.path("data.accountStatus"), "active");
		assertNotNull(response.path("data.accountBalance"));
		assertNotNull(response.path("data.maxTransactionAmount"));
		assertNotNull(response.path("data.maxTransactionsAllowed"));
		assertNotNull(response.path("data.alias"));
		assertNotNull(response.path("data.tokenExpiryDate"));

	}

	@Test(dataProvider = "customerNotRegistered", groups = { "sanity", "regression" })
	public void customerNotRegistered(String accept, String channel, String merchantId, String salt, String endChannel,
			String customerId, String code) {
		Headers headers = getHeadersForCustProfile(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId);
		Response response = given().header("accept", accept).headers(headers).contentType("application/json").log()
				.all().when().get(getProfileUrl(customerId)).then().log().all().extract().response();

		assertEquals(response.path("code"), code);
		assertEquals(response.path("description"), "Customer id: " + customerId + " is not available. The link is: ");

	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	  System.out.println("THE TEST JUST RUN WAS : " + this.getClass().getName() + "." +result.getMethod().getMethodName());
	  System.out.println("____________________________________________________________________________");
	  System.out.println("____________________________________________________________________________");
	}

}
