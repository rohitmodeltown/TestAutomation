package helpers.gateway.onboarding;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.JAXB;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

import helpers.GlobalHelper;
import helpers.MyJson;
import helpers.OnboardingJson;
import helpers.gateway.onboarding.stub.DataArea;
import helpers.gateway.onboarding.stub.EbmHeader;
import helpers.gateway.onboarding.stub.GetAadhaarProfileResponse;
import helpers.gateway.onboarding.stub.GetUserAadharProfileResponse;
import helpers.gateway.onboarding.stub.ResidentIdentity;
import helpers.gateway.onboarding.stub.Status;

public class Helper extends GlobalHelper {
	public String baseUrl =  readFromPropertiesFile(configPath, "ONBOARDING.GATEWAY.BASEURL");
	// path to onboarding config file
	public String onboardingConfig = "./resources/onboarding/onboarding_config.properties";
	public String ucid = readFromPropertiesFile(onboardingConfig, "ONBOARDING.UCID");
	public String GENERATETOKEN_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "GENERATETOKEN_EXCEL_PATH");
	public String GENERATEOTP_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "GENERATEOTP_EXCEL_PATH");
	public String GETPROFILEWITHOTP_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "GETPROFILEWITHOTP_EXCEL_PATH");
	public String AADHAARREG_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "AADHAARREG_EXCEL_PATH");
	
	
	public String generateFeSessionId() {
		String feSessionId = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return feSessionId;
	}
	
	public String readDB(String query, String server) throws ClassNotFoundException, SQLException, IOException {
		ResultSet rs = getDatafromDB(query, server);
		String value = "";
		if (rs.next()) {
			 value = rs.getString(1);
		}
		return value;
	}
	
	public String getLastSixDigits(String customer_id) {
		return customer_id.substring(4);
	}
	
	public String getStatus(String mobile) throws ClassNotFoundException, SQLException, IOException {
		String statusCode = getRetailerStatusFromDb(mobile);
		String status = "";
		System.out.println(statusCode);
		if (statusCode.equals("8")) {
			status = "ACTIVE";
		} else {
			status = "INACTIVE";
		}
		return status;
	}
	
	public String getRetailerStatusFromDb(String mobile) throws ClassNotFoundException, SQLException, IOException {
		//Returns 8 for Active
		String query = String.format("select COD_ACCT_STAT from FCRHOST.CH_ACCT_MAST where COD_CUST = (select COD_CUST_ID from FCRHOST.CH_X_MOBILE_ACCT_XREF where COD_CUST_NATL_ID = '%s')", mobile);
		return readDB(query, "CBSSIT");
	}
	
	public String getCustTypeFromDb(String mobile) throws ClassNotFoundException, SQLException, IOException {
		String query = String.format("select COD_CUST_TYP from FCRHOST.CH_X_MOBILE_ACCT_XREF where COD_CUST_NATL_ID = '%s'", mobile);
		return readDB(query, "CBSSIT");
	}
	
	public String getRetailerNameFromDb(String mobile) throws ClassNotFoundException, SQLException, IOException {
		String query = String.format("select COD_ACCT_TITLE from FCRHOST.CH_ACCT_MAST where COD_CUST = (select COD_CUST_ID from FCRHOST.CH_X_MOBILE_ACCT_XREF where COD_CUST_NATL_ID = '%s')", mobile);
		return readDB(query, "CBSSIT");
	}
	
	public String getRetailerBalanceFromDb(String mobile) throws ClassNotFoundException, SQLException, IOException {
		String query = String.format("select BAL_AVAILABLE from FCRHOST.CH_ACCT_MAST where COD_CUST = (select COD_CUST_ID from FCRHOST.CH_X_MOBILE_ACCT_XREF where COD_CUST_NATL_ID = '%s')", mobile);
		return readDB(query, "CBSSIT");
	}
	
	public String getOtpFromDb(String customer_id) throws ClassNotFoundException, SQLException, IOException {
		String query = String.format("SELECT * FROM ( SELECT otpcode FROM onetimepasswordproduct WHERE msisdn =\'91%s' ORDER BY GENERATED_ON DESC) WHERE rownum <=1", customer_id);
		return readDB(query, "GWSIT");
	}
	
	public String createXMLgetAadhaarResponse(String consumerName, String lob, String programmeName, String statusCode, String statusDescription, String responseCode, String responseTimeStamp, String action, String name, String dob, String gender, String phone, String email, String careOf, String house, String street, String landMark, String locality, String vtc, String subDistrict, String district, String state, String pincode, String photo) {
		GetAadhaarProfileResponse getAadhaarProfileResponse = new GetAadhaarProfileResponse();
		EbmHeader ebmHeader = new EbmHeader();
		DataArea dataArea = new DataArea();
		GetUserAadharProfileResponse getUserAadharProfileResponse = new GetUserAadharProfileResponse();
		ResidentIdentity residentIdentity = new ResidentIdentity();
		Status status = new Status();
		
		status.setStatusCode(statusCode);
		status.setStatusDescription(statusDescription);
		
		getAadhaarProfileResponse.setEbmHeader(ebmHeader);
		getAadhaarProfileResponse.setDataArea(dataArea);
		ebmHeader.setConsumerName(consumerName);
		ebmHeader.setConsumerTransactionId();
		ebmHeader.setLob(lob);
		ebmHeader.setProgrammeName(programmeName);
		dataArea.setGetUserAadharProfileResponse(getUserAadharProfileResponse);
		
		getUserAadharProfileResponse.setAction(action);
		getUserAadharProfileResponse.setPhoto(photo);
		getUserAadharProfileResponse.setResidentIdentity(residentIdentity);
		getUserAadharProfileResponse.setResponseCode(responseCode);
		getUserAadharProfileResponse.setResponseTimeStamp(responseTimeStamp);
		getUserAadharProfileResponse.setStatus(status);
		
		residentIdentity.setCareOf(careOf);
		residentIdentity.setDistrict(district);
		residentIdentity.setDob(dob);
		residentIdentity.setEmail(email);
		residentIdentity.setGender(gender);
		residentIdentity.setHouse(house);
		residentIdentity.setLandMark(landMark);
		residentIdentity.setLocality(locality);
		residentIdentity.setName(name);
		residentIdentity.setPhone(phone);
		residentIdentity.setPincode(pincode);
		residentIdentity.setPostOfficeName("");
		residentIdentity.setState(state);
		residentIdentity.setStreet(street);
		residentIdentity.setSubDistrict(subDistrict);
		residentIdentity.setVtc(vtc);
		
		
		StringWriter sw = new StringWriter();
		JAXB.marshal(getAadhaarProfileResponse, sw);
		String xmlString = sw.toString(); 
		System.out.println(xmlString);
		return xmlString;
	}
	
	public void updateGetAadhaarStub(String consumerName, String lob, String programmeName, String statusCode, String statusDescription, String responseCode, String responseTimeStamp, String action, String name, String dob, String gender, String phone, String email, String careOf, String house, String street, String landMark, String locality, String vtc, String subDistrict, String district, String state, String pincode, String photo) throws ClassNotFoundException, SQLException, IOException {
		String xml = createXMLgetAadhaarResponse(consumerName, lob, programmeName, statusCode, statusDescription, responseCode, responseTimeStamp, action, name, dob, gender, phone, email, careOf, house, street, landMark, locality, vtc, subDistrict, district, state, pincode, photo);
		String query = String.format("update mock_service_config set responseText = '%s' where freefield2Input = 'getAadhaar'", xml);
		updateSQLDB(query, "ONBSTUB");
	}
	
	
	public String generateTokenJSON(String channel, String retailer, String actor_type, String jwt_expiry) {
		Gson gson = new Gson();
		MyJson json = new MyJson();
		json.setVer("1.0");
		json.setFeSessionId();
		json.setLanguageId("001");
		json.setChannel(channel);
		json.setActorId(retailer);
		json.setActorType(actor_type);
		json.setJwtExpiry(jwt_expiry);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] generateTokenSuccess() throws IOException {
		String[][] data = readFromExcel( GENERATETOKEN_EXCEL_PATH , "success");
		return data;
	}
	
	public String generateOTPJSON(String ucid, String ver, String customer_id, String channel, String partner_id) {
		Gson gson = new Gson();
		MyJson json = new MyJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setCustomerId(customer_id);
		json.setPartnerId(partner_id);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] generateOTPSuccess() throws IOException {
		String[][] data = readFromExcel( GENERATEOTP_EXCEL_PATH , "success");
		return data;
	}
	
	public String getProfileWithOTPJSON(String ver,String  otp,String  verificationToken,String  channel,String  partner_id) {
		Gson gson = new Gson();
		OnboardingJson json = new OnboardingJson();
		json.setVer(ver);
		json.setFeSessionId();
		json.setChannel(channel);
		json.setVerificationToken(verificationToken);
		json.setOtp(otp);
		json.setPartnerId(partner_id);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] getProfileWithOTPSuccess() throws IOException {
		String[][] data = readFromExcel( GETPROFILEWITHOTP_EXCEL_PATH , "success");
		return data;
	}
	
	
	@DataProvider
	public String[][] aadhaarRegSuccessWallet() throws IOException {
		String[][] data = readFromExcel( AADHAARREG_EXCEL_PATH , "successWallet");
		return data;
	}
	
	@DataProvider
	public String[][] aadhaarRegSuccessBank() throws IOException {
		String[][] data = readFromExcel( AADHAARREG_EXCEL_PATH , "successBank");
		return data;
	}
	
	public String aadhaarRegWalletJSON(String aadhaar_number, String cust_msisdn, String txn_type, String aadhaar_timestamp, String biometric_data, String certificate_identifier, String hmac, String registered_device_code, String registered_device_model_id, String registered_device_provider_code, String registered_device_public_key_certificate, String registered_device_service_id, String registered_device_service_version, String service_code, String skey, String unique_device_code, String channel) {
		Gson gson = new Gson();
		OnboardingJson json = new OnboardingJson();
		json.initializeParameters();
		json.setAadhaarId(aadhaar_number);
		json.setFeSessionId();
		json.setBiometricData(biometric_data);
		json.setCustMsisdn(cust_msisdn);
		json.setTxnType(txn_type);
		json.setAadhaarTimestamp(aadhaar_timestamp);
		json.setCertificateIdentifier(certificate_identifier);
		json.setHmac(hmac);
		json.setRegisteredDeviceCode(registered_device_code);
		json.setRegisteredDeviceModelID(registered_device_model_id);
		json.setRegisteredDeviceProviderCode(registered_device_provider_code);
		json.setRegisteredDevicePublicKeyCertificate(registered_device_public_key_certificate);
		json.setRegisteredDeviceServiceID(registered_device_service_id);
		json.setRegisteredDeviceServiceVersion(registered_device_service_version);
		json.setServiceCode(service_code);
		json.setSkey(skey);
		json.setUniqueDeviceCode(unique_device_code);
		json.setChannel(channel);
		json.setLangId("001");
		json.setVer("1.0");
		return gson.toJson(json).toString();
	}
	
	public String aadhaarRegBankJSON(String aadhaar_number, String cust_msisdn, String txn_type, String aadhaar_timestamp, String biometric_data, String certificate_identifier, String hmac, String registered_device_code, String registered_device_model_id, String registered_device_provider_code, String registered_device_public_key_certificate, String registered_device_service_id, String registered_device_service_version, String service_code, String skey, String unique_device_code, String channel, String agriculturalIncome, String amount, String annualIncome, String dbtConsent, String fatherName, String gaurdianDob, String gaurdianFname, String gaurdianLname, String gaurdianMname, String localAddress1, String localAddress2, String localAddress3, String localAddress4, String localCity, String localDistrict, String localPostalCode, String localState, String maritalStatus, String motherMaidenName, String mpin, String nomineeAddress1, String nomineeAddress2, String nomineeAddress3, String nomineeAddress4, String nomineeCity, String nomineeDistrict, String nomineeDob, String nomineeFname, String nomineeLname, String nomineeMname, String nomineePostalCode, String nomineeRelationship, String nomineeState, String nonAgriculturalIncome, String occupation, String panAckNo, String panApplicationDate) {
		Gson gson = new Gson();
		OnboardingJson json = new OnboardingJson();
		json.setAadhaarId(aadhaar_number);
		json.setFeSessionId();
		json.setBiometricData(biometric_data);
		json.setCustMsisdn(cust_msisdn);
		json.setTxnType(txn_type);
		json.setAadhaarTimestamp(aadhaar_timestamp);
		json.setCertificateIdentifier(certificate_identifier);
		json.setHmac(hmac);
		json.setRegisteredDeviceCode(registered_device_code);
		json.setRegisteredDeviceModelID(registered_device_model_id);
		json.setRegisteredDeviceProviderCode(registered_device_provider_code);
		json.setRegisteredDevicePublicKeyCertificate(registered_device_public_key_certificate);
		json.setRegisteredDeviceServiceID(registered_device_service_id);
		json.setRegisteredDeviceServiceVersion(registered_device_service_version);
		json.setServiceCode(service_code);
		json.setSkey(skey);
		json.setUniqueDeviceCode(unique_device_code);
		json.setChannel(channel);
		json.setLangId("001");
		json.setAgriculturalIncome(agriculturalIncome);
		json.setAmount(amount);
		json.setAnnualIncome(annualIncome);
		json.setDbtConsent(dbtConsent);
		json.setFatherName(fatherName);
		json.setGaurdianDob(gaurdianDob);
		json.setGaurdianFname(gaurdianFname);
		json.setGaurdianLname(gaurdianLname);
		json.setGaurdianMname(gaurdianMname);
		json.setLocalAddress1(localAddress1);
		json.setLocalAddress2(localAddress2);
		json.setLocalAddress3(localAddress3);
		json.setLocalAddress4(localAddress4);
		json.setLocalCity(localCity);
		json.setLocalDistrict(localDistrict);
		json.setLocalPostalCode(localPostalCode);
		json.setLocalState(localState);
		json.setMaritalStatus(maritalStatus);
		json.setMotherMaidenName(motherMaidenName);
		json.setMpin(mpin);
		json.setMsme("");
		json.setNomineeAddress1(nomineeAddress1);
		json.setNomineeAddress2(nomineeAddress2);
		json.setNomineeAddress3(nomineeAddress3);
		json.setNomineeAddress4(nomineeAddress4);
		json.setNomineeCity(nomineeCity);
		json.setNomineeDistrict(nomineeDistrict);
		json.setNomineeDob(nomineeDob);
		json.setNomineeFname(nomineeFname);
		json.setNomineeMname(nomineeMname);
		json.setNomineeLname(nomineeLname);
		json.setNomineePostalCode(nomineePostalCode);
		json.setNomineeRelationship(nomineeRelationship);
		json.setNomineeState(nomineeState);
		json.setNonAgriculturalIncome(nonAgriculturalIncome);
		json.setOccupation(occupation);
		json.setPanAckNo(panAckNo);
		json.setPanApplicationDate(panApplicationDate);
		json.setVer("1.0");
		return gson.toJson(json).toString();
	}
	
	
	
	
}
