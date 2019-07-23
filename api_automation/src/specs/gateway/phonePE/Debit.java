package specs.gateway.phonePE;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.gateway.phonePE.Helper;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Debit extends Helper {
	public String feSessionId;
	public String mobile;

	public String merchantId = "";
	public String salt = "";
	public String paymentRefNo;
	public String expiry = "";
	public String delFlag = "";
	public String fciAmount = "";
	public String channel;
	public String accept;
	public String endChannel;
	public String amount;
	

	@BeforeMethod
	public void createFeSessionId() {
		feSessionId = generateRandomNumber();
		mobile = generateRandomMobile();
		expiry = "2020-12-09 01:01:01";
		delFlag = "0";
		merchantId = "1000058480";
		salt = "9ccdd856";
		fciAmount = "100";
		channel = "ANDROID";
		accept = "application/v1+json";
		endChannel = "ALL";
		amount = "1.0";
		paymentRefNo = generateRandomMobile();

		try {
			allowMerchantForSBA(merchantId, "BOTH");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	  System.out.println("THE TEST JUST RUN WAS : " + this.getClass().getName() + "." +result.getMethod().getMethodName());
	  System.out.println("____________________________________________________________________________");
	  System.out.println("____________________________________________________________________________");
	}
	
	@Test(dataProvider = "debitSuccess", groups = { "sanity", "regression" })
	public void custDebitSuccess(String customerType, String allowMerchantFor,
			String code, String description,
			String txnChargeDetails, String comment) throws ClassNotFoundException, IOException, SQLException {
		
		String customerId = getCustomerId(customerType, fciAmount);

		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		updateBalance(customerId.substring(2, 12), amount);

		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		allowMerchantForSBA(merchantId, allowMerchantFor);
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertEquals(response2.path("data.txnChargeDetails"), txnChargeDetails);
		assertEquals(response2.path("data.feSessionId"), feSessionId);
		assertEquals(beforeBalance - new Float(amount), afterBalance);
		assertEquals(response2.path("data.txnTaxDetails"), "");
		assertNotEquals(response2.path("data.hash"), "");
		assertNotEquals(response2.path("data.txnDateTime"), "");
		assertNotEquals(response2.path("data.ampTxnId"), "");
	}

	
	@Test(dataProvider = "similarTxn", groups = { "sanity", "regression" })
	public void similarTxnTest(String txnNo, String allowMerchantFor,
			String code, String description)
			throws ClassNotFoundException, IOException, SQLException {
		paymentRefNo = "REFPAY123456";
		amount = "2.0";
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		updateBalance(customerId.substring(2, 12), amount);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		allowMerchantForSBA(merchantId, allowMerchantFor);
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);
		// success debit txn
		given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();
		
		// similat txn with same txnRefNo
		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}

	@Test(dataProvider = "tokenExpired", groups = { "sanity", "regression" })
	public void tokenExpiredTest(String allowMerchantFor,
			String code, String description,
			String comment) throws ClassNotFoundException, IOException, SQLException {
		
		String customerId = getCustomerId("SBA", amount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		allowMerchantForSBA(merchantId, allowMerchantFor);
		updateTokenExpiryData(customerId, "2022-12-12 01:01:10");
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		updateTokenExpiryData(customerId, "2018-09-01 01:01:01");

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);

	}

	@Test(dataProvider = "maxTxnCount", groups = { "sanity", "regression" })
	public void maxTxnCountTest(String code, String description, String comment)
			throws ClassNotFoundException, IOException, SQLException {

		String customerId = getCustomerId("SBA", amount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		updateUsedAndMaxTokenCount("1", "1", customerId);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);

	}

	@Test(dataProvider = "customerDoesNotExist", groups = { "sanity", "regression" })
	public void customerDoesNotExistTest(String merchantId, String allowMerchantFor,
			String salt, String code, String description, String comment)
			throws ClassNotFoundException, IOException, SQLException {
		String customerId = mobile;
		allowMerchantForSBA(merchantId, allowMerchantFor);

		String alias = "9123454345678";
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), "Customer id: 91"+customerId+ " is not available");

	}

	@Test(dataProvider = "invalidChannel", groups = { "sanity", "regression" })
	public void invalidChannelTest(String code, String description, String txnChargeDetails, String comment)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		String invalidChannel = "TEST";
		String customerId = getCustomerId("SBA", amount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, invalidChannel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "blankMerchantId", groups = { "sanity", "regression" })
	public void blankMerchantIdTest(String customerId, String code, String description, String txnChargeDetails, String comment)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		merchantId = "";
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "invalidMerchantId", groups = { "sanity", "regression" })
	public void invalidMerchantIdTest(String code, String description,
			String comment) throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		String debitMerchantId = "19898801";
		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, debitMerchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description + " " + debitMerchantId);
	}

	@Test(dataProvider = "InvalidEndChannel", groups = { "sanity", "regression" })
	public void InvalidEndChannelTest(String invalidEndChannel, String txnChargeDetails, String code, String description, String comment)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, invalidEndChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertEquals(response2.path("data.txnChargeDetails"), txnChargeDetails);
		assertEquals(response2.path("data.feSessionId"), feSessionId);
		assertEquals(beforeBalance - new Float(amount), afterBalance);
		assertEquals(response2.path("data.txnTaxDetails"), "");
		assertNotEquals(response2.path("data.hash"), "");
		assertNotEquals(response2.path("data.txnDateTime"), "");
		assertNotEquals(response2.path("data.ampTxnId"), "");
	}

	@Test(dataProvider = "blankHash", groups = { "sanity", "regression" })
	public void blankHashTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().header("accept", accept).header("feSessionId", feSessionId)
				.header("channel", channel).header("merchantId", merchantId).header("endChannel", endChannel)
				.header("hash", "").contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}

	@Test(dataProvider = "hashNotPresent", groups = { "sanity", "regression" })
	public void hashNotPresentTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {

		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().header("accept", accept).header("feSessionId", feSessionId)
				.header("channel", channel).header("merchantId", merchantId).header("endChannel", endChannel)
				.contentType("application/json").body(body).log().all().when().post(getDebitUrl(customerId)).then()
				.log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
	}

	@Test(dataProvider = "merchantIdNotPresent", groups = { "sanity", "regression" })
	public void merchantIdNotPresentTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);
		String hash = getHashForCustDebit(merchantId, feSessionId, customerId, endChannel, channel, alias, paymentRefNo, amount, salt);

		Response response2 = given().header("accept", accept).header("feSessionId", feSessionId)
				.header("channel", channel).header("endChannel", endChannel).header("hash", hash)
				.contentType("application/json").body(body).log().all().when().post(getDebitUrl(customerId)).then()
				.log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "invalidHash", groups = { "sanity", "regression" })
	public void invalidHashTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().header("accept", accept).header("feSessionId", feSessionId)
				.header("channel", channel).header("merchantId", merchantId).header("endChannel", endChannel)
				.header("hash", "invalidHash").contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}

	@Test(dataProvider = "blankChannel", groups = { "sanity", "regression" })
	public void blankChannelTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);
		String hash = getHashForCustDebit(merchantId, feSessionId, customerId, endChannel, channel, alias, paymentRefNo, amount, salt);

		Response response2 = given().header("accept", accept).header("feSessionId", feSessionId).header("channel", "")
				.header("merchantId", merchantId).header("endChannel", endChannel).header("hash", hash)
				.contentType("application/json").body(body).log().all().when().post(getDebitUrl(customerId)).then()
				.log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "blankFeSessionId", groups = { "sanity", "regression" })
	public void blankFeSessionIdTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);
		String hash = getHashForCustDebit(merchantId, feSessionId, customerId, endChannel, channel, alias, paymentRefNo, amount, salt);

		Response response2 = given().header("accept", accept).header("feSessionId", "").header("channel", channel)
				.header("merchantId", merchantId).header("endChannel", endChannel).header("hash", hash)
				.contentType("application/json").body(body).log().all().when().post(getDebitUrl(customerId)).then()
				.log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "blankCustAlias", groups = { "sanity", "regression" })
	public void blankCustAliasTest(String customerId, String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {

		String alias = "";
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "blankAmount", groups = { "sanity", "regression" })
	public void blankAmountTest(String customerId, String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		amount = "";
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "invalidAmount", groups = { "sanity", "regression" })
	public void invalidAmountTest(String customerId, String code)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		amount = "abc";
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.getStatusCode(), Integer.parseInt(code));
	}

	@Test(dataProvider = "invalidPaymentRefNo", groups = { "sanity", "regression" })
	public void invalidPaymentRefNoTest(String customerId, String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		String PaymentRefNo = " ";
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, PaymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "invalidPaymentRefNo", groups = { "sanity", "regression" })
	public void blankPaymentRefNoTest(String customerId, String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		String PaymentRefNo = "";
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, PaymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "invalidFeSessionId", groups = { "sanity", "regression" })
	public void invalidFeSessionIdTest(String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		
		String customerId = getCustomerId("SBA", amount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		feSessionId = "a";
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		String body = getDebitCustJson(alias, paymentRefNo, amount);
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "blankEndChannel", groups = { "sanity", "regression" })
	public void blankEndChannelTest(String txnChargeDetails, String code, String description)
			throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		String customerId = getCustomerId("SBA", amount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		updateBalance(customerId.substring(2, 12), amount);
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		endChannel = "";
		String body = getDebitCustJson(alias, paymentRefNo, amount);
		String endChannelForHash = "NULL";
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannelForHash, customerId,
				feSessionId, alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertEquals(response2.path("data.txnChargeDetails"), txnChargeDetails);
		assertEquals(response2.path("data.feSessionId"), feSessionId);
		assertEquals(beforeBalance - new Float(amount), afterBalance);
		assertEquals(response2.path("data.txnTaxDetails"), "");
		assertNotEquals(response2.path("data.hash"), "");
		assertNotEquals(response2.path("data.txnDateTime"), "");
		assertNotEquals(response2.path("data.ampTxnId"), "");
	}

	@Test(dataProvider = "invalidCustAlias", groups = { "sanity", "regression" })
	public void invalidCustAliasTest(String code, String description)
			throws ClassNotFoundException, IOException, SQLException {

		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		String alias = "9111111111111";
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}
	
	@Test(dataProvider = "insufficientAmount", groups = { "sanity", "regression" })
	public void insufficientAmountTest(String customerType, String code, String description,
			String txnChargeDetails, String redirectionLink, String comment) throws ClassNotFoundException, IOException, SQLException {
		fciAmount = "1";
		amount = "10.0";
		String customerId = getCustomerId(customerType, fciAmount);

		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		
		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
		assertTrue(response2.path("redirectionLink").toString().contains(redirectionLink));
	}

	@Test(dataProvider = "customerAcctFailure", groups = { "sanity", "regression" })
	public void customerAcctFailureTest(String customerId, String code, String description,
			String txnChargeDetails, String comment) throws ClassNotFoundException, IOException, SQLException {

		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		allowMerchantForSBA(merchantId, "BOTH");

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("meta.code"), code);
		assertEquals(response2.path("meta.description"), description);
		assertNotEquals(response2.path("data.hash"), "");
	}

	@Test(dataProvider = "customerIsNotComplient", groups = { "sanity", "regression" })
	public void customerIsNotComplientTest(String customerType, String code, String description, String comment)
			throws ClassNotFoundException, IOException, SQLException {

		String customerId = getCustomerId(customerType, fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		String alias = "9112323432123";
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}

	// If merchant is not authorized to make txn for the customer type
	@Test(dataProvider = "unauthorizeDebitTxn", groups = { "sanity", "regression" })
	public void unauthorizeDebitTxnTest(String profileTxnCustState, String debitTxnCustState, String customerType, String code, String description, String txnChargeDetails, String comment)
			throws ClassNotFoundException, IOException, SQLException {
		
		String customerId = getCustomerId(customerType, fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		
		allowMerchantForSBA(merchantId, profileTxnCustState);

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		allowMerchantForSBA(merchantId, debitTxnCustState);
		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}

	@Test(dataProvider = "maxAllowedTxnAmount", groups = { "sanity", "regression" })
	public void maxAllowedTxnAmountTest(String customerId, String code, String description, String comment)
			throws ClassNotFoundException, IOException, SQLException {
		amount = "90.0";
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));
		
		allowMerchantForSBA(merchantId, "BOTH");

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description);
	}

	@Test(dataProvider = "customerConcentDeactive", groups = { "sanity", "regression" })
	public void customerConcentDeactiveTest(String code, String description, String comment)
			throws ClassNotFoundException, IOException, SQLException {

		String customerId = getCustomerId("SBA", fciAmount);
		insertVoltTxnToken(customerId, expiry, merchantId, delFlag);
		
		Float beforeBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		updateDelFlagVolt(customerId, "0");
		allowMerchantForSBA(merchantId, "BOTH");

		Response response1 = getCustProfile(accept, channel, merchantId, salt, endChannel, customerId);
		String alias = response1.path("data.alias");
		Headers headers = getHeadersForCustDebit(accept, channel, merchantId, salt, endChannel, customerId,
				feSessionId, alias, paymentRefNo, amount);
		String body = getDebitCustJson(alias, paymentRefNo, amount);

		updateDelFlagVolt(customerId, "1");

		Response response2 = given().headers(headers).contentType("application/json").body(body).log().all().when()
				.post(getDebitUrl(customerId)).then().log().all().extract().response();

		Float afterBalance = Float.parseFloat(getBalance(customerId.substring(2, 12)));

		assertEquals(beforeBalance, afterBalance);
		assertEquals(response2.path("code"), code);
		assertEquals(response2.path("description"), description + " " + customerId);
	}

}
