package helpers.gateway.phonePE;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Customer extends Helper {
	
	public String errorCode;
	public String errorMsg;
	public String authToken;
	public boolean merchantAuthNeeded;
	public boolean redirectionNeeded;
	public String redirectUrl;
	public String alias;
	public String refNo;
	public String timestamp;
	public String paymentRefNo;
	public String code;
	public String description;
	public String feSessionId;
	public String feSessionIdInResponse;
	public String txnChargeDetails;
	public String txnTaxDetails;
	public String hash;
	public String txnDateTime;
	public String ampTxnId;
	
	public String getPaymentRefNo() {
		return paymentRefNo;
	}

	public void setPaymentRefNo(String paymentRefNo) {
		this.paymentRefNo = paymentRefNo;
	}

	public String custStatus;
	public Object avlBalance;
	public Object maxAmount;
	public Object count;
	public Object expiryDate;
	
//	public void getCustProfile(String accept, String channel, String merchantId, String salt, String endChannel, String customerId) {
//		this.feSessionId = generateRandomNumber();
//		String hash =  encHash(merchantId+"#"+this.feSessionId+"#"+customerId+"#"+endChannel+"#"+channel+"#"+salt);
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println(hash);
//		String url = baseUrl2 + "apbnative/p1/customers/"+customerId+"/profile";
//		Response response = getProfileResonse(url, accept, this.feSessionId, channel, merchantId, endChannel, hash);
//		this.code = response.path("meta.code");
//		this.description = response.path("meta.description");
//		this.alias = response.path("data.alias");
//	}
	
//	public void debitCust(String accept, String channel, String merchantId, String salt, String endChannel, String customerId, String amount) {
//		this.feSessionId = generateRandomNumber();
//		String hash =  encHash(merchantId+"#"+this.feSessionId+"#"+customerId+"#"+endChannel+"#"+channel+"#"+salt);
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println(hash);
//		String url = baseUrl2 + "apbnative/p1/customers/"+customerId+"/account/debit";
//		String body = getDebitCustJson(this.alias, generateRandomNumber(), amount);
//
//		Headers header = getHedersForDebitRequest(accept, channel, merchantId, salt, endChannel, customerId, hash);
//		
//		Response response = getDebitCustResonse(url, header, body, accept, this.feSessionId, channel, merchantId, endChannel, hash);
//		this.code = response.path("meta.code");
//		this.description = response.path("meta.description");
//		this.feSessionIdInResponse = response.path("data.feSessionId");
//		this.txnChargeDetails = response.path("data.txnChargeDetails");
//		this.txnTaxDetails = response.path("data.txnTaxDetails");
//		this.hash = response.path("data.hash");
//		this.txnDateTime = response.path("data.txnDateTime");
//		this.ampTxnId = response.path("data.ampTxnId");
//		
//	}
	
//	public void debitCust2(String accept, String channel, String merchantId, String salt, String endChannel, String customerId, String amount) {
//		this.feSessionId = generateRandomNumber();
//		String hash =  encHash(merchantId+"#"+this.feSessionId+"#"+customerId+"#"+endChannel+"#"+channel+"#"+salt);
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		System.out.println(hash);
//		String url = baseUrl2 + "apbnative/p1/customers/"+customerId+"/account/debit";
//		String body = getDebitCustJson(this.alias, generateRandomNumber(), amount);
//
//		Headers header = getHedersForDebitRequest(accept, channel, merchantId, salt, endChannel, customerId, hash);
//		
//		Response response = getDebitCustResonse(url, header, body, accept, this.feSessionId, channel, merchantId, endChannel, hash);
//		this.code = response.path("code");
//		this.description = response.path("description");
//	}
	
	public void getCustomerOtp(String channel, String partnerMobile, String customerMobile, String salt, String ver) {
		String feSessionId = generateRandomNumber();
		String hash = partnerMobile+"#"+feSessionId+"#"+channel+"#"+customerMobile+"#"+salt;
		System.out.println("Generated Hash :  "+hash);
		String myjson = getCustomerOtpJSON(channel, hash, ver, feSessionId);
		String url = baseUrl + "partners/" + partnerMobile + "/customers/" + customerMobile + "/authRequest";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.errorMsg = response.path("meta.errorMsg");
		this.errorCode = response.path("meta.errorCode");
		this.authToken = response.path("data.authToken");
		this.merchantAuthNeeded = response.path("data.merchantAuthNeeded");
		this.redirectionNeeded = response.path("data.redirectionNeeded");
		this.redirectUrl = response.path("data.redirectUrl");
	}
	
	public void verifyOtp(String channel, String partnerMobile, String customerMobile, String otp, String salt, String ver, String authValue, String count, String expiryDate, String maxAmount, String endChannel) {
		String feSessionId = generateRandomNumber();
		String hash = partnerMobile+"#"+channel+"#"+this.authToken+"#"+maxAmount+"#"+count+"#"+expiryDate+"#"+authValue+"#"+endChannel+"#"+feSessionId+"#"+otp+"#"+salt;
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		System.out.println(hash);
		
		String myjson = verifyOtpJSON(feSessionId, authValue, channel, count, expiryDate, maxAmount, endChannel, hash, otp, ver, this.authToken);
		String url = baseUrl + "partners/" + partnerMobile + "/customers/" + customerMobile + "/authToken";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		
		this.errorCode = response.path("meta.errorCode");
		this.errorMsg = response.path("meta.errorMsg");
		this.alias = response.path("data.alias");
		this.custStatus = response.path("data.custStatus");
		this.avlBalance = response.path("data.avlBalance");
		this.maxAmount = response.path("data.concent.maxAmount");
		this.count = response.path("data.concent.count");
		this.expiryDate = response.path("data.concent.expiryDate");
	}
	
	public void generateCustomerRefund(String channel, String partnerMobile,String customerMobileNo,String salt, String paymentRefNo, String refundAmt, String refundTxnDate,String errorCode, String errorMsg, String mode,String endChannel) {	
		String feSessionId = generateRandomNumber();
		paymentRefNo=this.paymentRefNo;
		String hash = partnerMobile+"#"+feSessionId+"#"+channel+"#"+customerMobileNo+"#"+paymentRefNo+"#"+refundAmt+"#"+refundTxnDate+"#"+endChannel+"#"+mode+"#"+salt;
		String myjson = generateCustomerRefundJSON(feSessionId,channel, hash, paymentRefNo,refundAmt, refundTxnDate,mode,endChannel);
		String url = baseUrl + "partners/" + partnerMobile + "/customers/" + customerMobileNo;
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		
		this.errorMsg = response.path("meta.errorMsg");
		this.errorCode = response.path("meta.errorCode");
	}
	
	public void generateCustomerTransaction(String channel, String partnerMobile,String customerMobileNo,String salt, String mode, String paymentRefNo, String txnAmount, String txnDate,String endChannel,String errorCode, String errorMsg) {	
		String feSessionId = generateRandomNumber();
		paymentRefNo=generateRandomNumber();
	    this.paymentRefNo=paymentRefNo;
		String hash = partnerMobile+"#"+feSessionId+"#"+channel+"#"+customerMobileNo+"#"+paymentRefNo+"#"+txnAmount+"#"+txnDate+"#"+endChannel+"#"+mode+"#"+salt;
		String myjson = generateCustomerTransactionJSON(feSessionId,channel, hash, mode,paymentRefNo,txnAmount, txnDate,endChannel);
		String url = baseUrl + "partners/" + partnerMobile + "/customers/" + customerMobileNo;
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		
		this.errorMsg = response.path("meta.errorMsg");
		this.errorCode = response.path("meta.errorCode");
	}
	
//	public Headers getHedersForDebitRequest(String accept, String channel, String merchantId, String salt, String endChannel, String customerId, String hash) {
//		Header h1= new Header("accept", accept);
//		Header h2= new Header("feSessionId", feSessionId);
//		Header h3= new Header("channel", channel);
//		Header h4= new Header("merchantId", merchantId);
//		Header h5= new Header("endChannel", endChannel);
//		Header h6= new Header("hash", hash);
//		
//		List<Header> list = new ArrayList<Header>();
//		list.add(h1);
//		list.add(h2);
//		list.add(h3);
//		list.add(h4);
//		list.add(h5);
//		list.add(h6);
//		
//		return new Headers(list);
//	}
	
}
