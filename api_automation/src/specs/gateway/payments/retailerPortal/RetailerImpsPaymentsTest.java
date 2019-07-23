package specs.gateway.payments.retailerPortal;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import helpers.gateway.payments.retailerPortal.FetchBeneHelper;
import helpers.gateway.payments.retailerPortal.LoginPageHelper;
import helpers.gateway.payments.retailerPortal.RetailerImpsPaymentsHelper;
import helpers.gateway.payments.retailerPortal.SendMoneyHelper;
import helpers.gateway.payments.retailerPortal.SplitTransactionHelper;
import io.restassured.response.Response;


public class RetailerImpsPaymentsTest extends RetailerImpsPaymentsHelper {
	
	LoginPageHelper loginPageHelper = new LoginPageHelper();
	FetchBeneHelper fetchBeneHelper = new FetchBeneHelper();
	SplitTransactionHelper splitTransactionHelper = new SplitTransactionHelper();
	SendMoneyHelper sendMoneyHelper = new SendMoneyHelper();
	
	private String tokenValue;
	private String beneToken;
	private String beneId;
	private String voltTxnId;
	
	@Test(dataProvider="impsSuccessData")
	public void successImpsTransaction(String retailerId, String actorType, String jwtExpiry, String ver, String txnType, 
			String totalTxnAmount, String opMode, String channel, String customerId, String appVersion, String mode,
			String category, String langId, String merchantId, String reference1, String merchantUserName, String amount, 
			String loadAmount, String mpin, String reqType, String txnCharges, String totalTxnAmt, String otpReq) throws Exception 
	{
		
		// Generate Retailer Token
		/*String loginJson = loginPageHelper.generateLoginJSON(retailerId, "Airtel@123");
		Response loginResponse = loginPageHelper.getResponseFromAPIUnencrypted(loginJson,
				loginPageHelper.baseUrl + loginPageHelper.loginAction);	*/
		
		String generateTokenJson = loginPageHelper.generateTokenJSON(retailerId, actorType, jwtExpiry, appVersion);
		Response generateTokenResponse = loginPageHelper.getResponseFromAPIUnencrypted(generateTokenJson,
				loginPageHelper.baseUrl + loginPageHelper.generateTokenAction, contentTypeJson);		
		assertEquals(generateTokenResponse.path("messageText"), "Token generated successfully.");
		
		// Extract Token value from response
		tokenValue = loginPageHelper.getTagValueFromApiResponse(generateTokenResponse, "token");
		
		// Perform Fetch Favorite
		String fetchFavouiteJson = fetchBeneHelper.fetchFavouriteJSON(channel, customerId, appVersion, langId, mode, ver, 
				category);
		Response fetchFavouiteResponse = fetchBeneHelper.getResponseFromAPIUnencryptedWithHeader(fetchFavouiteJson, 
				fetchBeneHelper.baseUrl+fetchBeneHelper.fetchFavouriteAction, fetchBeneHelper.tokenHeaderName, tokenValue, contentTypeJson);
		
		System.out.println("fetchFavourite response: "+fetchFavouiteResponse.getBody().asString());
		
		// Extract Bene Token from response
		beneToken = fetchFavouiteResponse.path("favoritelist.favorite.beneToken[0]");
		beneId = fetchFavouiteResponse.path("favoritelist.favorite.id[0]");
		
		// Perform Split transaction to fetch charges for transaction
		String splitTxnJson = splitTransactionHelper.splitTxnJSON(langId, retailerId, txnType, totalTxnAmount, opMode);
		Response splitTxnResponse = splitTransactionHelper.getResponseFromAPIUnencryptedWithHeader(splitTxnJson, 
				splitTransactionHelper.baseUrl + splitTransactionHelper.splitTxnAction, splitTransactionHelper.tokenHeaderName, tokenValue, contentTypeJson);
		
		System.out.println("split response: "+splitTxnResponse.getBody().asString());
		
		// Extract Token value from response
		tokenValue = splitTransactionHelper.getTagValueFromApiResponse(splitTxnResponse, "token");
		String transactionAmount = splitTransactionHelper.getTagValueFromApiResponse
				(splitTxnResponse, splitTransactionHelper.transactionAmount);
		String transactionCharges = splitTransactionHelper.getTagValueFromApiResponse
				(splitTxnResponse, splitTransactionHelper.transactionCharges);
		String totalLoadAmount =  Float.toString(Integer.parseInt(transactionAmount)+Float.parseFloat(transactionCharges));
		
		System.out.println("transactionAmount: "+transactionAmount+" transactionCharges: "+transactionCharges+" totalLoadAmount: "+ totalLoadAmount);
		
		//assertEquals(splitTxnResponse.path("messageText"), "Token generated successfully.");
		
		// Perform actual Send money transaction
		String sendMoneyJson = sendMoneyHelper.sendMoneyJSON(channel, langId, customerId, merchantId, beneId, 
				beneToken, merchantUserName, "", "", "", "", "", "", transactionAmount, totalLoadAmount, mpin, 
				reqType, txnType, "", transactionCharges,totalLoadAmount, "", "", otpReq);
		Response sendMoneyResponse = sendMoneyHelper.getResponseFromAPIEncryptedWithHeader(sendMoneyJson, 
      splitTransactionHelper.baseUrl + sendMoneyHelper.sendMoneyAction, sendMoneyHelper
				.tokenHeaderName, 
				tokenValue, contentTypeJson);
		
		System.out.println("send money response: "+sendMoneyResponse.getBody().asString());
		voltTxnId = sendMoneyResponse.path("voltTxnId");
		System.out.println("voltTxnId : "+voltTxnId);
		
		
	}
}
