package helpers.gateway.upi;

import io.restassured.response.Response;

public class UPI extends UpiHelper {
	public String messageText;
	public String errorMessage;
	public String errorCode;
	public String code;
	public String enableEncryption;
	public String retailerName;
	public String retailerStatus;
	public String retailerCurrentBalance;
	public String xAccessToken;;
	public String txnId;
	public String primaryVpaId;
	public static String deviceId;
	public boolean successScenario = true;

	public void getDeviceID(String mode, String ver, String channel, String customerID, String languageID, String partnerId) {
		String myjson = generateDeviceIdJSON(mode, ver, channel, customerID, languageID, partnerId);	
		String url = baseUrl + "createDeviceId.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		this.deviceId = response.path("deviceId");
	}
	
	public void fetchVpa(String ver, String channel) throws Exception {
		String myjson = generateFetchVpaJSON(ver,  channel, deviceId);	
		String url = baseUrl + "fetchVPAs.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");	
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void mobileLogin(String ver, String channel, String appVersion, String languageID, String simId, String slotId, String osApiVersion, String platform) throws Exception {
		String myjson = generateMobileLoginJSON(ver,  channel,  appVersion, deviceId,  languageID,  simId, slotId, osApiVersion, platform);	
		String url = baseUrl + "MobileLogin.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		this.primaryVpaId = response.path("primaryVpaId");	
	}
	
	public void regPoll(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String smsToken) throws Exception {
		String myjson = generateRegPollJSON(ver,  channel,  appVersion, deviceId, smsToken);	
		String url = baseUrl + "RegPoll.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");	
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void upiToken(String mode, String ver, String channel, String customerID, String languageID, String partnerId, String appVersion, String challenge, String ctype) throws Exception {
		String myjson = generateUpiTokenJSON(ver, channel,  appVersion, deviceId, challenge, ctype);	
		String url = baseUrl + "upiToken.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void checkVpa(String ver, String channel, String appVersion, String vpa) throws Exception {
		String myjson = generateCheckVpaJSON(ver, vpa, appVersion, channel, deviceId);	
		String url = baseUrl + "checkVPA.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void upiRegistration(String screenHeight, String platform, String osVersion, String vpa, String imei, String deviceModel, String ver, String deviceMake,
			String username , String screenWidth, String email , String appVersion , String name, String channel) throws Exception {
		String myjson = generateUpiRegistrationJSON(screenHeight,  platform,  osVersion,  vpa,  imei,  deviceModel,  ver,  deviceMake,
				 username ,  screenWidth,  email ,  appVersion ,  name,  channel, deviceId);	
		String url = baseUrl + "upiRegistration.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");	
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void updateUpiRegistration(String screenHeight, String platform, String osVersion, String vpa, String imei, String deviceModel, String ver, String deviceMake,
			String username , String screenWidth, String email , String appVersion , String name, String channel) throws Exception {
		String myjson = generateUpiRegistrationJSON(screenHeight,  platform,  osVersion,  vpa,  imei,  deviceModel,  ver,  deviceMake,
				 username ,  screenWidth,  email ,  appVersion ,  name,  channel, deviceId);	
		String url = baseUrl + "updateUpiRegistration.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");	
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void updateDI(String appVersion, String  imei, String slotId, String simId,  String ver,  String languageID,  String channel) throws Exception {
		String myjson = generateUpdateDiJSON(appVersion, imei,  slotId, simId, ver, languageID, channel, deviceId);	
		String url = baseUrl + "updateDI.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void addVpa(String ver, String channel, String appVersion, String vpa) throws Exception {
		String randomVpa = generateRandom().concat(vpa);
		String myjson = generateAddVpaJSON(ver, channel, appVersion, deviceId, randomVpa);	
		String url = baseUrl + "addVPA.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void viewCustBanks(String ver, String channel, String vpaId) throws Exception {
		String myjson = generateViewCustBanksJSON(ver, channel, deviceId, vpaId);	
		String url = baseUrl + "viewCustBanks.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void getAcProv(String ver, String channel) throws Exception {
		String myjson = generateGetAcProvJSON(ver, channel, deviceId);	
		String url = baseUrl + "getAcProv.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}

	public void addBank(String ver, String channel, String appVersion, String vpa,
			String vpaId, String accountHolderName, String accountNumber, String ifsc,
			String txnLimit, String bankName, String isDefault, String nickName,
			String credType, String credLen, String credSubType, String dType) throws Exception {
		
		String myjson = generateAddBankJSON(ver, channel, appVersion, deviceId, vpa, vpaId, accountHolderName, accountNumber, ifsc, txnLimit, bankName, isDefault, nickName, credType, credLen, credSubType, dType );	
		String url = baseUrl + "addBank.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void fetchUpiTxnHistory(String ver, String channel, String appVersion, String from, String to, String maxRecords) throws Exception {
		String fromDate = dateFormater(from);
		String toDate = dateFormater(to);		
		String myjson = generateFetchUpiTxnHistoryJSON(ver, channel, appVersion, deviceId, fromDate, toDate, maxRecords);	
		String url = baseUrl + "fetchUPITxnHistory.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}

	public void changePrimaryAccount(String ver, String channel,
			String appVersion, String languageID, String vpaId, String vpaFdId) throws Exception {
		String myjson = generateChangePrimaryAccountJSON(ver, channel, appVersion, languageID, deviceId, vpaId, vpaFdId);	
		String url = baseUrl + "changePrimaryAccount.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		
	}

	public void deActivateBank(String ver, String channel,
			String appVersion, String languageID, String vpaFdId) throws Exception {
		String myjson = generateDeActivateBankJSON(ver, channel, appVersion, deviceId, vpaFdId);	
		String url = baseUrl + "deActivateBank.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void deRegisterUpi(String ver, String channel,	String appVersion) throws Exception {
		String myjson = generateDeRegisterUpiJSON(ver, channel, appVersion, deviceId);	
		String url = baseUrl + "deRegisterUPI.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void deActivateVpa(String ver, String channel,	String appVersion, String vpaId) throws Exception {
		String myjson = generateDeActivateVpaJSON(ver, channel, appVersion, deviceId, vpaId);	
		String url = baseUrl + "deActivateVPA.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void validateBeneVPA(String ver, String channel,	String appVersion, String vpaId, String vpa) throws Exception {
		String myjson = generateValidateBeneVPAJSON(ver, channel, appVersion, deviceId, vpaId, vpa);	
		String url = baseUrl + "validateBeneVPA.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void blockSenderVPA(String ver, String channel,	String appVersion, String vpa) throws Exception {
		String myjson = generateBlockSenderVPAJSON(ver, channel, appVersion, deviceId, vpa);	
		String url = baseUrl + "blockSenderVPA.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void upiCollect(String ver, String channel, String vpaId, String vfaId, String remarks, String toVpa,
			String toName, String amount, String latitude, String longitude, String location, String feature,
			String locality, String admin, String countryCode) throws Exception  {
		
		String myjson = generateUPICollectJSON(deviceId, ver, channel, vpaId, vfaId, remarks, toVpa, toName, amount,latitude, longitude, location, feature, locality, admin, countryCode);	
		String url = baseUrl + "upiCollect.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
			
	}
	
	public void upiPendingCollect(String ver, String channel) {
		String myjson = generateUPIPendingCollectJSON(deviceId, ver, channel);	
		String url = baseUrl + "upiPendingCollect.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");	
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}

	
	public void upiCollectReject(String ver, String channel, String vpaFdid, String appVersion, String chId,
			String upiTxnId, String vpaId, String refId) throws Exception {
		
		String myjson = generateUPICollectRejectJSON(deviceId, ver, channel, vpaFdid, appVersion, chId, upiTxnId, vpaId,refId);	
		String url = baseUrl + "upiCollectReject.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
		
	}
	
	public void upiGetAccounts(String ver, String channel, String appVersion, String vpaId, String inn) throws Exception {
		String myjson = generateUPIGetAccountsJSON(ver, channel, appVersion, deviceId, vpaId, inn);	
		String url = baseUrl + "upiGetAccounts.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void upiRequestOTP(String countryName,String countryCode,String ver,String iin,String addressLine,String accountNumber,String appVersion,String admin,String vpaId,String locality,String feature,String longitude,String latitude,String ifsc)
	{
		String myjson = generateUPIRequestOTPJSON(countryName,countryCode,ver,iin,addressLine,accountNumber,appVersion,admin,vpaId,locality,feature,longitude,latitude,deviceId,ifsc);	
		String url = baseUrl + "upiRequestOTP.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}
	
	public void upiSetPrimaryVpa(String ver, String channel, String appVersion, String vpaId) throws Exception
	{
		String myjson = generateUPISetPrimaryVpaJSON(ver,channel,appVersion,deviceId,vpaId);	
		String url = baseUrl + "upiSetPrimaryVpa.action";
		Response response = getResponseFromAPIEncrypted(myjson, url, contentTypeUrlEncoded);
		this.messageText = response.path("messageText");
		this.code = response.path("code");
		this.errorCode = response.path("errorCode");
	}

}
