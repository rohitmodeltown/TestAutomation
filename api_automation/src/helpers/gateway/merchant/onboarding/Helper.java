package helpers.gateway.merchant.onboarding;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import com.google.gson.Gson;

import helpers.GlobalHelper;
//import helpers.MyJson;
import helpers.gateway.merchant.onboarding.MerchantOnboardingJson;


public class Helper extends GlobalHelper {
	//public String baseUrl =  readFromPropertiesFile(configPath, "ONBOARDING.GATEWAY.BASEURL");
	
	// path to onboarding config file
	public String onboardingConfig = "./resources/merchant/onboarding_Merchant.properties";
	public String baseUrl =  readFromPropertiesFile(configPath, "MERCHANTONBOARDING.BASEURL");

	public String CREATEOTP_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "encCreateOtp_EXCEL_PATH");
	public String VERIFYPROFILE_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "verifyProfile_EXCEL_PATH");
	public String ALLCATEGORIES_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "allCategories_EXCEL_PATH");
	public String VALIDATEIFSC_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "encValidateIFSC_EXCEL_PATH");
	public String VALIDATEPINCODE_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "validatePinCode_EXCEL_PATH");
	public String REGISTER_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "encRegister_EXCEL_PATH");
	
	
	// this is for 
	public String generateCreateOtpJSON(String ver, String channel, String languageID, String customerID) {
		Gson gson = new Gson();
		MerchantOnboardingJson json = new MerchantOnboardingJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setLanguageId(languageID);
		json.setCustomerId(customerID);
		return gson.toJson(json).toString();
	}
	
	public String generateverifyProfileJSON(String ver, String channel, String languageID, String otp, String verificationToken) {
		Gson gson = new Gson();
		MerchantOnboardingJson json = new MerchantOnboardingJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setLanguageId(languageID);
		json.setOtp(otp);
		json.setVerificationToken(verificationToken);
		return gson.toJson(json).toString();
	}
	
	// 
	public String generateViewCatgoriesJSON(String ver, String channel, String languageID) {
		Gson gson = new Gson();
		MerchantOnboardingJson json = new MerchantOnboardingJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setLanguageId(languageID);
		return gson.toJson(json).toString();
	}
	
	public String generatePincodeJSON(String ver, String channel, String languageID, String pincode) {
		Gson gson = new Gson();
		MerchantOnboardingJson json = new MerchantOnboardingJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setLanguageId(languageID);
		json.setPincode(pincode);
		return gson.toJson(json).toString();
	}
	
	public String generateIfscJSON(String ver, String accountNo, String channel, String languageID, String ifsc) {
		Gson gson = new Gson();
		MerchantOnboardingJson json = new MerchantOnboardingJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setAccountNo(accountNo);
		json.setChannel(channel);
		json.setLanguageId(languageID);
		json.setIfsc(ifsc);
		return gson.toJson(json).toString();
	}
	
	public String generateRegistrationJSON(String lastName, String ver, String subCategory, String manualAddress, String panNo, String channel, String languageId,
			String permanentState, String accountHolderName, String shopCategory, String firstName, String permanentZipCode, String permanentAddress1,
			String permanentCountry, String settlementAccountNo, String permanentCity, String panCardName, String ifscCode, String shopCompanyName, String lat, String longt) {
		Gson gson = new Gson();
		MerchantOnboardingJson json = new MerchantOnboardingJson();
		json.setLastName(lastName);
		json.setVer(ver);
		json.setSubCategory(subCategory);
		json.setManualAddress(manualAddress);
		json.setPanNo(panNo);
		json.setChannel(channel);
		json.setLanguageId(languageId);
		json.setPermanentState(permanentState);
		json.setAccountHolderName(accountHolderName);
		json.setFirstName(firstName);
		json.setPermanenZipCode(permanentZipCode);
		json.setPermanentAddress1(permanentAddress1);
		json.setPermanentCountry(permanentCountry);
		json.setFeSessionId();
		json.setSettlementAccountNo(settlementAccountNo);
		json.setPermanentCity(permanentCity);
		json.setPanCardName(panCardName);
		json.setIfsc(ifscCode);
		json.setShopCompanyName(shopCompanyName);
		json.setLat(lat);
		json.setLongt(longt);
		return gson.toJson(json).toString();
	}
	
	public String getLastSixDigits(String customer_id) {
		return customer_id.substring(4);
	}
	
	@DataProvider
	public String[][] encCreateOtpDataProvider() throws IOException {
		String[][] data = readFromExcel( CREATEOTP_EXCEL_PATH , "create_otp");
		return data;
	}
	
	@DataProvider
	public String[][] verifyProfileDataProvider() throws IOException {
		String[][] data = readFromExcel( VERIFYPROFILE_EXCEL_PATH , "verify_profile");
		return data;
	}
	
	@DataProvider
	public String[][] viewCategoriesDataProvider() throws IOException {
		String[][] data = readFromExcel( ALLCATEGORIES_EXCEL_PATH , "view_categories");
		return data;
	}
	
	@DataProvider
	public String[][] pincodeDataProvider() throws IOException {
		String[][] data = readFromExcel( VALIDATEPINCODE_EXCEL_PATH , "pincode");
		return data;
	}
	
	@DataProvider
	public String[][] ifscDataProvider() throws IOException {
		String[][] data = readFromExcel( VALIDATEIFSC_EXCEL_PATH , "ifsc");
		return data;
	}
	
	@DataProvider
	public String[][] encRegisterDataProvider() throws IOException {
		String[][] data = readFromExcel( REGISTER_EXCEL_PATH , "registration");
		return data;
	}
	
}
