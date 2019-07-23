package helpers.gateway.phonePE;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Helper extends Data {
	public String baseUrl =  readFromPropertiesFile(configPath, "PHONEPE.BASEURL");
	public String baseUrl2 =  readFromPropertiesFile(configPath, "PHONEPE.BASEURL2");
	// path to onboarding config file
	public String phonepeConfig = "./resources/phonepe/phonepe_config.properties";
//	public String ucid = readFromPropertiesFile(phonepeConfig, "ONBOARDING.UCID");
	public String GETCUSTOMEROTP_EXCEL_PATH = readFromPropertiesFile(phonepeConfig, "GETCUSTOMEROTP_EXCEL_PATH");
	public String VERIFYOTP_EXCEL_PATH = readFromPropertiesFile(phonepeConfig, "VERIFYOTP_EXCEL_PATH");
	public String REFUND_EXCEL_PATH = readFromPropertiesFile(phonepeConfig, "REFUND_EXCEL_PATH");
	public String TRANSACTION_EXCEL_PATH=readFromPropertiesFile(phonepeConfig, "TRANSACTION_EXCEL_PATH");
	public String PROFILE_EXCEL_PATH=readFromPropertiesFile(phonepeConfig, "PROFILE_EXCEL_PATH");
	public String DEBITCUST_EXCEL_PATH=readFromPropertiesFile(phonepeConfig, "DEBITCUST_EXCEL_PATH");
	public String hash = "";
	
	@DataProvider
	public String[][] getCustomerOtpSuccess() throws IOException {
		String[][] data = readFromExcel( GETCUSTOMEROTP_EXCEL_PATH , "getCustomerOtpSuccess");
		return data;
	}
	
	public String getCustomerOtpJSON(String channel, String hash, String ver, String feSessionId) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setChannel(channel);
		json.setHash(hash);
		json.setFeSessionId(feSessionId);
		json.setVer(ver);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] verifyOtpSuccess() throws IOException {
		String[][] data = readFromExcel( VERIFYOTP_EXCEL_PATH , "verifyOtpSuccess");
		return data;
	}
	
	public String verifyOtpJSON(String feSessionId, String authValue, String channel, String count, String expiryDate, String maxAmount, String endChannel, String hash, String otp, String ver, String verificationToken) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		Consent consent = new Consent();
		json.setAuthValue(authValue);
		json.setChannel(channel);
		consent.setCount(count);
		consent.setExpiryDate(expiryDate);
		consent.setMaxAmount(maxAmount);
		json.setConsent(consent);
		json.setEndChannel(endChannel);
		json.setHash(hash);
		json.setOtp(otp);
		json.setFeSessionId(feSessionId);
		json.setVer(ver);
		json.setVerificationToken(verificationToken);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] refundSuccess() throws IOException {
		String[][] data = readFromExcel( REFUND_EXCEL_PATH , "refundSuccess");
		return data;
	}
	
	public String generateCustomerRefundJSON(String feSessionId,String channel, String hash, String paymentRefNo,String txnAmount, String txnDate,String mode,String endChannel ) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		Transaction txn=new Transaction();
		txn.setTxnAmount(txnAmount);
		txn.setTxnDate(txnDate);
		json.setEndChannel(endChannel);
		json.setMode(mode);
		json.setVer("ver");
		json.setChannel(channel);
		json.setHash(hash);
		json.setTxn(txn);
		json.setFeSessionId(feSessionId);
		json.setPaymentRefNo(paymentRefNo);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] transactionSuccess() throws IOException {
		String[][] data = readFromExcel( TRANSACTION_EXCEL_PATH , "transactionSuccess");
		return data;
	}
	
	
	
	public String generateCustomerTransactionJSON(String feSessionId,String channel, String hash, String mode,String paymentRefNo,String txnAmount, String txnDate,String endChannel ) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		Transaction txn=new Transaction();
		txn.setTxnAmount(txnAmount);
		txn.setTxnDate(txnDate);
		txn.setEndChannel(endChannel);
		json.setChannel(channel);
		json.setHash(hash);
		json.setMode(mode);
		json.setTxn(txn);
		json.setFeSessionId(feSessionId);
		json.setPaymentRefNo(paymentRefNo);
		return gson.toJson(json).toString();
	}
	
	public Response getProfileResonse(String url, String accept, String feSessionId, String channel, String merchantId, String endChannel, String hash ) {
		System.out.println("4444444444444444");
		System.out.println("--------------------REQUEST------------------");
		Response response = 
				given().header("accept", accept).header("feSessionId", feSessionId).header("channel", channel).header("merchantId", merchantId).header("endChannel", endChannel).header("hash", hash).contentType("application/json").
				log().all().
				when().get(url).then().extract().response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}
	
	public Response getDebitCustResonse(String url, Headers header, String body, String accept, String feSessionId, String channel, String merchantId, String endChannel, String hash ) {
		System.out.println("4444444444444444");
		System.out.println("--------------------REQUEST------------------");
		Response response = 
//				given().header("accept", accept).header("feSessionId", feSessionId).header("channel", channel).header("merchantId", merchantId).header("endChannel", endChannel).header("hash", hash).contentType("application/json").
				given().headers(header).contentType("application/json").
				body(body).log().all().
				when().post(url).then().extract().response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}
	
	
	
	@DataProvider
	public String[][] profileSuccess() throws IOException {
		String[][] data = readFromExcel( PROFILE_EXCEL_PATH , "profileSuccess");
		return data;
	}
	
	@DataProvider
	public String[][] debitSuccess() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "debitSuccess");
		return data;
	}
	
	@DataProvider
	public String[][] invalidChannel() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidChannel");
		return data;
	}
	
	@DataProvider
	public String[][] blankMerchantId() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankMerchantId");
		return data;
	}
	
	@DataProvider
	public String[][] invalidMerchantId() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidMerchantId");
		return data;
	}
	
	@DataProvider
	public String[][] hashNotPresent() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "hashNotPresent");
		return data;
	}
	
	@DataProvider
	public String[][] merchantIdNotPresent() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "merchantIdNotPresent");
		return data;
	}
	
	@DataProvider
	public String[][] invalidHash() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidHash");
		return data;
	}
	
	@DataProvider
	public String[][] blankChannel() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankChannel");
		return data;
	}
	
	@DataProvider
	public String[][] blankFeSessionId() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankFeSessionId");
		return data;
	}
	
	@DataProvider
	public String[][] blankHash() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankHash");
		return data;
	}
	
	@DataProvider
	public String[][] InvalidEndChannel() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "InvalidEndChannel");
		return data;
	}
	
	@DataProvider
	public String[][] blankCustAlias() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankCustAlias");
		return data;
	}
	
	@DataProvider
	public String[][] blankAmount() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankAmount");
		return data;
	}
	
	@DataProvider
	public String[][] invalidAmount() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidAmount");
		return data;
	}
	
	@DataProvider
	public String[][] invalidPaymentRefNo() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidPaymentRefNo");
		return data;
	}
	
	@DataProvider
	public String[][] invalidFeSessionId() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidFeSessionId");
		return data;
	}
	
	@DataProvider
	public String[][] invalidCustAlias() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "invalidCustAlias");
		return data;
	}
	
	@DataProvider
	public String[][] insufficientAmount() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "insufficientAmount");
		return data;
	}
	
	@DataProvider
	public String[][] customerAcctFailure() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "customerAcctFailure");
		return data;
	}
	
	@DataProvider
	public String[][] customerIsNotComplient() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "customerIsNotComplient");
		return data;
	}
	
	@DataProvider
	public String[][] unauthorizeDebitTxn() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "unauthorizeDebitTxn");
		return data;
	}
	
	@DataProvider
	public String[][] customerDosentExist() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "customerDosentExist");
		return data;
	}
	
	@DataProvider
	public String[][] maxAllowedTxnAmount() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "maxAllowedTxnAmount");
		return data;
	}
	
	@DataProvider
	public String[][] customerConcentDeactive() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "customerConcentDeactive");
		return data;
	}
	
	@DataProvider
	public String[][] similarTxn() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "similarTxn");
		return data;
	}
	
	@DataProvider
	public String[][] tokenExpired() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "tokenExpired");
		return data;
	}
	
	@DataProvider
	public String[][] maxTxnCount() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "maxTxnCount");
		return data;
	}
	
	@DataProvider
	public String[][] customerDoesNotExist() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "customerDoesNotExist");
		return data;
	}
	
	@DataProvider
	public String[][] blankEndChannel() throws IOException {
		String[][] data = readFromExcel( DEBITCUST_EXCEL_PATH , "blankEndChannel");
		return data;
	}
	
	@DataProvider
	public String[][] customerNotRegistered() throws IOException {
		String[][] data = readFromExcel( PROFILE_EXCEL_PATH , "customerNotRegistered");
		return data;
	}
	
	
	
	public String getDebitCustJson(String alias, String paymentRefNo, String amount) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setCustAlias(alias);
		json.setPaymentRefNo(paymentRefNo);
		json.setAmount(amount);
		return gson.toJson(json).toString();
	}
	
	public Headers getHeadersForCustDebit(String accept, String channel, String merchantId, String salt, String endChannel, String customerId, String feSessionId, String alias, String paymentRefNo, String amount) {
		Header h1= new Header("accept", accept);
		Header h2= new Header("feSessionId", feSessionId);
		Header h3= new Header("channel", channel);
		Header h4= new Header("merchantId", merchantId);
		Header h5= new Header("endChannel", endChannel);
		String hash = getHashForCustDebit(merchantId, feSessionId, customerId, endChannel, channel, alias, paymentRefNo, amount, salt);
		Header h6= new Header("hash", hash);
		
		List<Header> list = new ArrayList<Header>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		list.add(h5);
		list.add(h6);
		
		return new Headers(list);
	}
	
	public Headers getHeadersForCustProfile(String accept, String channel, String merchantId, String salt, String endChannel, String customerId, String feSessionId) {
		Header h1= new Header("accept", accept);
		Header h2= new Header("feSessionId", feSessionId);
		Header h3= new Header("channel", channel);
		Header h4= new Header("merchantId", merchantId);
		Header h5= new Header("endChannel", endChannel);
		String hash = getHashForCustProfile(merchantId, feSessionId, customerId, endChannel, channel, salt);
		Header h6= new Header("hash", hash);
		
		List<Header> list = new ArrayList<Header>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		list.add(h5);
		list.add(h6);
		
		return new Headers(list);
	}
	
	public String getHashForCustDebit(String merchantId, String feSessionId, String customerId, String endChannel, String channel, String alias, String paymentRefNo, String amount, String salt ) {
		return encHashSha512(merchantId+"#"+feSessionId+"#"+customerId+"#"+endChannel+"#"+channel+"#"+alias+"#"+paymentRefNo+"#"+amount+ "#"+salt);
	}
	
	public String getHashForCustProfile(String merchantId, String feSessionId, String customerId, String endChannel, String channel, String salt ) {
		return encHashSha512(merchantId+"#"+feSessionId+"#"+customerId+"#"+endChannel+"#"+channel+"#"+salt);
	}
	
	public Response getCustProfile(String accept, String channel, String merchantId, String salt, String endChannel, String customerId) {
		String feSessionId = generateRandomNumber();
		Headers headers = getHeadersForCustProfile(accept, channel, merchantId, salt, endChannel, customerId, feSessionId);
		return given().header("accept", accept).headers(headers).contentType("application/json").
				log().all().
				when().get(getProfileUrl(customerId)).then().log().all().extract().response();
	}
	
	public String getProfileUrl(String customerId) {
		return baseUrl2 + "apbnative/p1/customers/"+customerId+"/profile";
	}
	
	public String getDebitUrl(String customerId) {
		return baseUrl2 + "apbnative/p1/customers/"+customerId+"/account/debit";
	}
	
	public void compareBalanceDb(String beforebalance, String amount, String customerId) throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
		int beforeBalInt = Integer.parseInt(beforebalance);
		int amountInt = Integer.parseInt(amount);
		int expectedTotal = beforeBalInt - amountInt;
		System.out.println("before Int : " + beforeBalInt );
		System.out.println("Amount : " + amountInt );
		System.out.println("Expected Total : " + expectedTotal );
		int currentBal = Integer.parseInt(getBalance(customerId.substring(2, 12)));
		System.out.println("currentBal : " + currentBal );
		assertEquals(currentBal, expectedTotal);
	}
	
	public String getCustomerId(String customerType, String amount) {
		String mobile = generateRandomMobile();
		if ("SBA".equals(customerType)) {
			getSba(mobile, amount);
		} else if ("LKY_MKYC".equals(customerType)) {
			getLky(mobile, true, amount);
		} else if ("LKY_0KYC".equals(customerType)) {
			getLky(mobile, false, amount);
		} else if ("FKY".equals(customerType)) {
			getFky(mobile, amount);
		}
		return "91" + mobile;
	}
}
