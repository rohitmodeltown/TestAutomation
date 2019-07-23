package helpers.gateway.merchant.onboarding;

//import helpers.gateway.merchant.onboarding.Helper;
import io.restassured.response.Response;

public class Merchant extends Helper {
	public String messageText;
	public String errorMessage;
	public String errorCode;
	public String code;
	public String enableEncryption;
	public String retailerName;
	public String retailerStatus;
	public String retailerCurrentBalance;
	public static String xAccessToken;;
	public String txnId;
	public boolean successScenario = true;
	public static String customerId;
	public static String otp;
	public static String verificationTokens;
	
	public void createOtp(String ver,String channel,String languageID, String customerID ) throws Exception {
		
		String myjson = generateCreateOtpJSON(ver, channel, languageID, customerID);	
		String url = baseUrl + "encCreateOTP.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
		//Below variables will be used in 'verifyprofile.action' API call
		this.otp=customerID.substring(4, 10);
		this.verificationTokens = response.path("verificationToken");		
	}
	
	public void verifyProfile(String ver,String channel, String languageID) {
		String myjson = generateverifyProfileJSON(ver, channel, languageID, otp, verificationTokens);	
		String url = baseUrl + "verifyProfile.action";
		Response response = getResponseFromAPIUnencrypted( myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		System.out.println("code is: " + code +"error code is "+ errorCode);
		
		//Below variable will be used in encMerchantRegister.action API
		this.xAccessToken = response.path("token");
	}
	
	public void viewCategories(String ver,String channel,String languageID ) {
		String myjson = generateViewCatgoriesJSON(ver, channel, languageID);	
		String url = baseUrl + "allCategories.action";
		Response response = getResponseFromAPIUnencrypted( myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		//System.out.println("The API response message is: "+messageText);		
	}
	
	public void validatePinCode(String ver,String channel, String languageID, String pincode ) {
		String myjson = generatePincodeJSON(ver, channel, languageID, pincode);	
		String url = baseUrl + "validatePincode.action";
		Response response = getResponseFromAPIUnencrypted( myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		//System.out.println("The API response message is: "+messageText);		
	}
	
	public void validateIfsc(String ver, String accountNo, String channel, String languageID, String ifsc ) throws Exception {
		String myjson = generateIfscJSON(ver, accountNo, channel, languageID, ifsc);	
		System.out.println(myjson);
		String url = baseUrl + "encValidateIfsc.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		//System.out.println("The API response message is: "+messageText);		
	}
	
	public void merchantRegistration(String lastName, String ver, String subCategory, String manualAddress, String panNo, String channel, String languageId,
			String permanentState, String accountHolderName, String shopCategory, String firstName, String permanentZipCode, String permanentAddress1,
			String permanentCountry, String settlementAccountNo, String permanentCity, String panCardName, String ifscCode, String shopCompanyName, String lat, String longt) throws Exception {
		String myjson = generateRegistrationJSON( lastName,  ver,  subCategory,  manualAddress,  panNo,  channel,  languageId,
				 permanentState,  accountHolderName,  shopCategory,  firstName,  permanentZipCode,  permanentAddress1,
				 permanentCountry,  settlementAccountNo,  permanentCity,  panCardName,  ifscCode,  shopCompanyName,  lat,  longt);	
		String url = baseUrl + "encRegisterMerchant.action";
		Response response = getResponseFromAPIEncryptedWithHeader(myjson, url,"x-access-token", xAccessToken, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");	
	}
	
}
