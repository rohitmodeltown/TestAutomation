package helpers.gateway.upi;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

import helpers.GlobalHelper;


public class UpiHelper extends GlobalHelper{	
	public String upiConfigFile = "./resources/upiConfig/config.properties";
	public String baseUrl =  readFromPropertiesFile(configPath, "UPI.BASEURL");
	
	public String fetchVPAs_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "fetchVPAs_EXCEL_PATH");
	public String MobileLogin_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "MobileLogin_EXCEL_PATH");
	public String regPoll_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "regPoll_EXCEL_PATH");
	public String upiToken_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiToken_EXCEL_PATH");
	public String checkVPA_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "checkVPA_EXCEL_PATH");
	public String upiRegistration_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiRegistration_EXCEL_PATH");
	public String upidateDI_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upidateDI_EXCEL_PATH");
	public String addVPA_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "addVPA_EXCEL_PATH");
	public String viewCustBanks_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "viewCustBanks_EXCEL_PATH");
	public String getAcProv_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "getAcProv_EXCEL_PATH");
	public String upiGetAccounts_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiGetAccounts_EXCEL_PATH");
	public String upiRequestOTP_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiRequestOTP_EXCEL_PATH");
	public String upiMobReg_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiMobReg_EXCEL_PATH");
	public String upiForgotMpin_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiForgotMpin_EXCEL_PATH");
	public String addBank_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "addBank_EXCEL_PATH");
	public String upiPay_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiPay_EXCEL_PATH");
	public String upiSetPrimaryVpa_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiSetPrimaryVpa_EXCEL_PATH");	
	public String upiCollect_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiCollect_EXCEL_PATH");
	public String upiPendingCollect_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiPendingCollect_EXCEL_PATH");
	public String upiCollectAuth_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiCollectAuth_EXCEL_PATH");
	public String upiCollectReject_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "upiCollectReject_EXCEL_PATH");	
	public String resetUPIMpin_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "resetUPIMpin_EXCEL_PATH");
	public String fetchUPITxnHistory_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "fetchUPITxnHistory_EXCEL_PATH");
	public String changePrimaryAccount_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "changePrimaryAccount_EXCEL_PATH");
	public String deActivateBank_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "deActivateBank_EXCEL_PATH");
	public String fetchUPIBal_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "fetchUPIBal_EXCEL_PATH");
	public String deRegisterUPI_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "deRegisterUPI_EXCEL_PATH");
	public String deActivateVPA_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "deActivateVPA_EXCEL_PATH");
	public String validateBeneVPA_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "validateBeneVPA_EXCEL_PATH");
	public String blockSenderVPA_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "blockSenderVPA_EXCEL_PATH");
	
	
	
	
	// Methods for generateDeviceId.acion API
	public String generateDeviceIdJSON(String mode, String ver, String channel, String customerID, String languageID, String partnerId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setMode(mode);
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setCustomerId(customerID);
		json.setLanguageId(languageID);
		json.setPartnerId(customerID);
		return gson.toJson(json).toString();
	}
	
	//Methods for fetchVpa.action
	public String generateFetchVpaJSON(String ver, String channel, String deviceId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setDeviceId(deviceId);
		json.setFeSessionId();
		json.setVer(ver);		
		json.setChannel(channel);
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] fetchVpaDataProvider() throws IOException {
		String[][] data = readFromExcel( fetchVPAs_EXCEL_PATH , "fetchVpa");
		return data;
	}
	
	// Methods for mobileLogin.acion API
	public String generateMobileLoginJSON(String ver, String channel, String appVersion,String deviceId, String languageID, String simId,String slotId, String osApiVersion, String platform) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setAppVersion(appVersion);
		json.setDeviceId(deviceId);
		json.setLanguageId(languageID);
		json.setSimId(simId);
		json.setSlotId(slotId);
		json.setOsApiVersion(osApiVersion);
		json.setPlatform(platform);
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] mobileLoginDataProvider() throws IOException {
		String[][] data = readFromExcel( MobileLogin_EXCEL_PATH , "mobileLogin");
		return data;
	}
	
	// Methods for regPoll.action API
	
	public String generateRegPollJSON(String ver, String channel, String appVersion,String deviceId, String smsToken) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setAppVersion(appVersion);
		json.setDeviceId(deviceId);
		json.setSmsToekn(smsToken);		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] regPollDataProvider() throws IOException {
		String[][] data = readFromExcel( regPoll_EXCEL_PATH , "regPoll");
		return data;
	}
	
//Methods for upiToken.action API
	
	public String generateUpiTokenJSON(String ver, String channel, String appVersion,String deviceId, String challenge, String ctype) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setAppVersion(appVersion);
		json.setDeviceId(deviceId);
		json.setChallenge(challenge);
		json.setCtype(ctype);
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] upiTokenDataProvider() throws IOException {
		String[][] data = readFromExcel( upiToken_EXCEL_PATH , "upiToken");
		return data;
	}
	
//Methods for checkVpa.action API
	
	public String generateCheckVpaJSON(String ver, String vpa, String appVersion,String channel, String deviceId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setFeSessionId();
		json.setVer(ver);
		json.setVpa(vpa);
		json.setAppVersion(appVersion);
		json.setChannel(channel);		
		json.setDeviceId(deviceId);
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] checkVpaDataProvider() throws IOException {
		String[][] data = readFromExcel( checkVPA_EXCEL_PATH , "checkVpa");
		return data;
	}
	
  //Methods for upiRegistration.action API
	
	public String generateUpiRegistrationJSON(String screenHeight, String platform, String osVersion, String vpa, String imei, String deviceModel, String ver, String deviceMake,
			String username , String screenWidth, String email , String appVersion , String name, String channel, String deviceId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setScreenHeight(screenHeight);
		json.setPlatform(platform);
		json.setOsVersion(osVersion);
		json.setVpa(vpa);
		json.setImei(imei);
		json.setDeviceModel(deviceModel);
		json.setVer(ver);
		json.setDeviceMake(deviceMake);
		json.setUserName(username);
		json.setFeSessionId();
		json.setScreenWidth(screenWidth);
		json.setEmailId(email);
		json.setAppVersion(appVersion);
		json.setName(name);
		json.setChannel(channel);	
		json.setDeviceId(deviceId);
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] upiRegistrationDataProvider() throws IOException {
		String[][] data = readFromExcel( upiRegistration_EXCEL_PATH , "upiRegistration");
		return data;
	}
	
	 //Methods for updateUpiRegistration.action API

	@DataProvider
	public String[][] updateUpiRegistrationDataProvider() throws IOException {
		String[][] data = readFromExcel( upiRegistration_EXCEL_PATH , "upiRegistration");
		return data;
	}
	
//Methods for updateDI.action API
	
	public String generateUpdateDiJSON(String appVersion, String imei, String slotId, String simId,  String ver,  String languageID,  String channel, String deviceId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setFeSessionId();
		json.setAppVersion(appVersion);
		json.setImei(imei);
		json.setSlotId(slotId);
		json.setSimId(simId);
		json.setVer(ver);
		json.setLanguageId(languageID);
		json.setChannel(channel);		
		json.setDeviceId(deviceId);
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] updateDiDataProvider() throws IOException {
		String[][] data = readFromExcel( upidateDI_EXCEL_PATH , "updateDI");
		return data;
	}
	
//Methods for addVpa.action API
	
	public String generateAddVpaJSON(String ver, String channel, String appVersion, String deviceId, String vpa) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);	
		json.setAppVersion(appVersion);
		json.setImei(appVersion);			
		json.setDeviceId(deviceId);
		json.setVpa(vpa);		
		
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] addVpaDataProvider() throws IOException {
		String[][] data = readFromExcel( addVPA_EXCEL_PATH , "addVpa");
		return data;
	}
	
	//Methods for viewCustBanks.action API
		public String generateViewCustBanksJSON(String ver, String channel, String deviceId, String vpaId) {
			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setVer(ver);
			json.setFeSessionId();
			json.setChannel(channel);				
			json.setDeviceId(deviceId);
			json.setVpaId(vpaId);		
			
			return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] viewCustBanksDataProvider() throws IOException {
		String[][] data = readFromExcel( viewCustBanks_EXCEL_PATH , "viewCustBanks");
		return data;
	}
	
//Methods for getAcProv.action API
		public String generateGetAcProvJSON(String ver, String channel, String deviceId) {
			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setVer(ver);
			json.setFeSessionId();
			json.setChannel(channel);				
			json.setDeviceId(deviceId);			
			return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] getAcProvDataProvider() throws IOException {
		String[][] data = readFromExcel( getAcProv_EXCEL_PATH , "getAcProv");
		return data;
	}
	
//Methods for addBank.action API
	public String generateAddBankJSON(String ver, String channel,
			String appVersion, String deviceId, String vpa, String vpaId,
			String accountHolderName, String accountNumber, String ifsc,
			String txnLimit, String bankName, String isDefault, String nickName,
			String credType, String credLen, String credSubType, String dType) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);		
		json.setAppVersion(appVersion);
		json.setDeviceId(deviceId);	
		json.setVpa(vpa);
		json.setVpaId(vpaId);
		json.setAccountHolderName(accountHolderName);
		json.setAccountNumber(accountNumber);
		json.setIfsc(ifsc);
		json.setTxnLimit(txnLimit);
		json.setBankName(bankName);
		json.setIsDefault(isDefault);
		//json.setNickname(nickName);
		json.setCredType(credType);
		json.setCredLen(credLen);
		json.setSubType(credSubType);
		json.setDType(dType);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] addBankDataProvider() throws IOException {
		String[][] data = readFromExcel( addBank_EXCEL_PATH , "addBank");
		return data;
	}
	
//Methods for fetchUpiTxnHistory.action API
	public String generateFetchUpiTxnHistoryJSON(String ver, String channel, String appVersion, String deviceId, String from, String to, String maxRecords) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);		
		json.setAppVersion(appVersion);
		json.setDeviceId(deviceId);	
		json.setFrom(from);
		json.setTo(to);
		json.setMaxrecords(maxRecords);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] fetchUpiTxnHistoryDataProvider() throws IOException {
		String[][] data = readFromExcel( fetchUPITxnHistory_EXCEL_PATH , "fetchUpiTxn");
		return data;
	}
	
//Methods for changePrimaryAccount.action API
	public String generateChangePrimaryAccountJSON(String ver, String channel, String appVersion, String languageId, String deviceId,  String vpaId, String vpaFdid) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);		
		json.setAppVersion(appVersion);
		json.setDeviceId(deviceId);	
		json.setLanguageId(languageId);
		json.setVpaId(vpaId);
		json.setVpaFdId(vpaFdid);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] changePrimaryAccountDataProvider() throws IOException {
		String[][] data = readFromExcel( changePrimaryAccount_EXCEL_PATH , "changePrimaryAcc");
		return data;
	}
	
//Methods for DeActivateBank.action API
	public String generateDeActivateBankJSON(String ver, String channel, String appVersion, String deviceId, String vpaFdid) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setFeSessionId();
		json.setVer(ver);
		json.setVpaFdId(vpaFdid);	
		json.setAppVersion(appVersion);
		json.setChannel(channel);		
		json.setDeviceId(deviceId);	
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] deActivateBankDataProvider() throws IOException {
		String[][] data = readFromExcel( deActivateBank_EXCEL_PATH , "deActivateBank");
		return data;
	}
	
//Methods for DeRegisterUpi.action API
	public String generateDeRegisterUpiJSON(String ver, String channel, String appVersion, String deviceId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setFeSessionId();
		json.setVer(ver);	
		json.setAppVersion(appVersion);
		json.setChannel(channel);		
		json.setDeviceId(deviceId);	
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] deRegisterUpiDataProvider() throws IOException {
		String[][] data = readFromExcel( deRegisterUPI_EXCEL_PATH , "deRegisterUpi");
		return data;
	}
	
//Methods for DeActivateVpa.action API
	public String generateDeActivateVpaJSON(String ver, String channel, String appVersion, String deviceId, String vpaId) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);	
		json.setFeSessionId();		
		json.setChannel(channel);	
		json.setAppVersion(appVersion);			
		json.setDeviceId(deviceId);
		json.setVpaId(vpaId);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] deActivateVpaDataProvider() throws IOException {
		String[][] data = readFromExcel( deActivateVPA_EXCEL_PATH , "deActivateVpa");
		return data;
	}
	
//Methods for DeActivateVpa.action API
	public String generateValidateBeneVPAJSON(String ver, String channel, String appVersion, String deviceId, String vpaId, String vpa) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);	
		json.setFeSessionId();		
		json.setChannel(channel);	
		json.setAppVersion(appVersion);			
		json.setDeviceId(deviceId);
		json.setVpaId(vpaId);
		json.setVpa(vpa);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] validateBeneVPADataProvider() throws IOException {
		String[][] data = readFromExcel( validateBeneVPA_EXCEL_PATH , "validateBeneVpa");
		return data;
	}
	
//Methods for DeActivateVpa.action API
	public String generateBlockSenderVPAJSON(String ver, String channel, String appVersion, String deviceId, String vpa) {
		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setVer(ver);	
		json.setFeSessionId();		
		json.setChannel(channel);	
		json.setAppVersion(appVersion);			
		json.setDeviceId(deviceId);
		json.setVpa(vpa);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] blockSenderVPADataProvider() throws IOException {
		String[][] data = readFromExcel( blockSenderVPA_EXCEL_PATH , "blockSenderVpa");
		return data;
	}
	
//Method for UPICollect

	public String generateUPICollectJSON(String deviceId, String ver, String channel, String vpaId, String vfaId,
			String remarks, String toVpa, String toName, String amount, String latitude, String longitude,
			String location, String feature, String locality, String admin, String countryCode) {

		Gson gson = new Gson();
		UpiJson json = new UpiJson();
		json.setDeviceId(deviceId);
		json.setFeSessionId();
		json.setVer(ver);
		json.setChannel(channel);
		json.setVpaId(vpaId);
		json.setVfaId(vfaId);
		json.setRemarks(remarks);
		json.setToVpa(toVpa);		
		json.setToName(toName);
		json.setAmount(amount);
		json.setLatitude(latitude);
		json.setLongitude(longitude);
		json.setLocation(location);
		json.setFeature(feature);
		json.setLocality(locality);
		json.setAdmin(admin);
		json.setCountryCode(countryCode);
		return gson.toJson(json).toString();
	}

	@DataProvider
	public String[][] upiCollectDataProvider() throws IOException {
		String[][] data = readFromExcel(upiCollect_EXCEL_PATH, "upiCollect");
		return data;
	}
	
//Method for UPIPendingCollect

		public String generateUPIPendingCollectJSON(String deviceId, String ver, String channel) {

			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setDeviceId(deviceId);
			json.setFeSessionId();
			json.setVer(ver);
			json.setChannel(channel);
			return gson.toJson(json).toString();
		}

		@DataProvider
		public String[][] upiPendingCollectDataProvider() throws IOException {
			String[][] data = readFromExcel(upiPendingCollect_EXCEL_PATH, "upiPendingCollect");
			return data;
		}
		
		//Method for 
		
		public  String generateUPICollectRejectJSON(String deviceId, String ver, String channel, String vpaFdid,
				String appVersion, String chId, String upiTxnId, String vpaId, String refId) {
			
			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setDeviceId(deviceId);
			json.setFeSessionId();
			json.setVer(ver);
			json.setChannel(channel);
			json.setVpaFdid(vpaFdid);
			json.setAppVersion(appVersion);
			json.setChId(chId);
			json.setUpiTxnId(upiTxnId);
			json.setVpaId(vpaId);
			json.setRefId(refId);
			
			return gson.toJson(json).toString();

		}
		
		@DataProvider
		public String[][] upiCollectRejectDataProvider() throws IOException {
			String[][] data = readFromExcel(upiCollectReject_EXCEL_PATH, "upiCollectReject");
			return data;
		}
		
	// Method for UPIGetAccounts

		public String generateUPIGetAccountsJSON(String ver, String channel, String appVersion, String deviceId,
				String vpaId, String iin) {
			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setVer(ver);
			json.setFeSessionId();
			json.setChannel(channel);
			json.setDeviceId(deviceId);
			json.setAppVersion(appVersion);
			json.setIin(iin);
			json.setVpaId(vpaId);
			return gson.toJson(json).toString();
		}

		@DataProvider
		public String[][] upiGetAccountsDataProvider() throws IOException {
			String[][] data = readFromExcel(upiGetAccounts_EXCEL_PATH, "upiGetAccounts");
			return data;
		}

		// Method for upiRequestOTP

		public String generateUPIRequestOTPJSON(String countryName, String countryCode, String ver, String iin,
				String addressLine, String accountNumber, String appVersion, String admin, String vpaId, String locality,
				String feature, String longitude, String latitude, String deviceId, String ifsc) {
			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setFeSessionId();
			json.setCountryName(countryName);
			json.setCountryCode(countryCode);
			json.setVer(ver);
			json.setIin(iin);
			json.setAddressLine(addressLine);
			json.setAccountNumber(accountNumber);
			json.setAppVersion(appVersion);
			json.setAdmin(admin);
			json.setVpaId(vpaId);
			json.setLocality(locality);
			json.setFeature(feature);
			json.setLongitude(longitude);
			json.setLatitude(latitude);			
			json.setDeviceId(deviceId);
			json.setIfsc(ifsc);

			return gson.toJson(json).toString();
		}

		@DataProvider
		public String[][] upiRequestOTPDataProvider() throws IOException {
			String[][] data = readFromExcel(upiRequestOTP_EXCEL_PATH, "upiRequestOTP");
			return data;
		}

		// Method for upiSetPrimaryVpa

		public String generateUPISetPrimaryVpaJSON(String ver, String channel, String appVersion, String deviceId,
				String vpaId) {
			Gson gson = new Gson();
			UpiJson json = new UpiJson();
			json.setFeSessionId();
			json.setVer(ver);
			json.setChannel(channel);
			json.setAppVersion(appVersion);
			json.setDeviceId(deviceId);
			json.setVpaId(vpaId);
			return gson.toJson(json).toString();
		}

		@DataProvider
		public String[][] upiSetPrimaryVpaDataProvider() throws IOException {
			String[][] data = readFromExcel(upiSetPrimaryVpa_EXCEL_PATH, "upiSetPrimaryVpa");
			return data;
		}
		
		public String generateRandom() {
			String randomNumber = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
			return randomNumber;
		}
		
		public String dateFormater(String date) throws ParseException {  
			Date inputDate = new SimpleDateFormat("dd-MMM-yyyy").parse(date);						
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
			String covertedDate = sm.format(inputDate);	
			return covertedDate;
		}

}
