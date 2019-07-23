package helpers.gateway.onboarding;

import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;

public class Retailer extends Helper {
	
	public String messageText;
	public String errorMessage;
	public String errorCode;
	public String code;
	public String enableEncryption;
	public String retailerName;
	public String retailerStatus;
	public String retailerCurrentBalance;
	public String xAccessToken;
	public String verificationToken;
	public String otp;
	public String txnId;
	public boolean successScenario = true;
	
	public void generateToken(String channel, String retailer, String actor_type, String jwt_expiry) {
		String myjson = generateTokenJSON(channel, retailer, actor_type, jwt_expiry);
		String url = baseUrl + "generateToken.action";
		Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
		this.messageText = response.path("messageText");
		this.errorCode = response.path("errorCode");
		this.code = response.path("code");
		this.enableEncryption = response.path("enableEncryption");
		this.retailerName = response.path("Name");
		this.retailerStatus = response.path("status");
		this.retailerCurrentBalance = response.path("currentBal");
		this.xAccessToken = response.path("token");
	}
	
	public void generateOTP(String ucid,String ver,String customer_id,String channel,String partner_id) {
		String myjson = generateOTPJSON(ucid, ver, customer_id, channel, partner_id);
		String url = baseUrl + "generateOTP.action";
		Response response = getResponseFromAPIUnencryptedWithHeader(myjson, url, "x-access-token", this.xAccessToken, contentTypeJson);
		this.messageText = response.path("messageText");
		this.errorCode = response.path("errorCode");
		this.code = response.path("code");
		this.verificationToken = response.path("verificationToken");
		this.otp = getLastSixDigits(customer_id);
	}
	
	public void getProfileWithOTP(String ver,String  channel,String  partner_id) {
		String myjson = getProfileWithOTPJSON(ver, this.otp, this.verificationToken, channel, partner_id);
		String url = baseUrl + "getProfileWithOTP.action";
		Response response =  getResponseFromAPIUnencryptedWithHeader(myjson, url, "x-access-token", this.xAccessToken, contentTypeJson);
		this.messageText = response.path("messageText");
		this.errorCode = response.path("errorCode");
		this.code = response.path("code");
		this.xAccessToken = response.path("token");
	}
	
	public void aadhaarRegWallet(Customer cust, String aadhaar_number, String cust_msisdn, String txn_type_enquiry, String aadhaar_timestamp, String biometric_data, String certificate_identifier, String hmac, String registered_device_code, String registered_device_model_id, String registered_device_provider_code, String registered_device_public_key_certificate, String registered_device_service_id, String registered_device_service_version, String service_code, String skey, String unique_device_code, String channel) throws Exception {
		String myjson = aadhaarRegWalletJSON(aadhaar_number, cust_msisdn, txn_type_enquiry, aadhaar_timestamp, biometric_data, certificate_identifier, hmac, registered_device_code, registered_device_model_id, registered_device_provider_code, registered_device_public_key_certificate, registered_device_service_id, registered_device_service_version, service_code, skey, unique_device_code, channel);
		String url = baseUrl + "aadhaarReg.action";
		Response response = getResponseFromAPIEncryptedWithHeader(myjson, url, "x-access-token", this.xAccessToken, contentTypeJson);
		this.errorMessage = response.path("errorMessage");
		this.errorCode = response.path("errorCode");
		this.code = response.path("code");
		this.txnId = response.path("txnId");
		
		// Set customer data
		cust.name = response.path("custName");
		cust.dob = response.path("custDOB");
		cust.gender = response.path("custGender");
		cust.email = response.path("custEmail");
		cust.house = response.path("custHouse");
		cust.street = response.path("custStreet");
		cust.landmark = response.path("custLandmark");
		cust.locality = response.path("custLocality");
		cust.vtc = response.path("custVTC");
		cust.subDistrict = response.path("custSubDistrict");
		cust.district = response.path("custDistrict");
		cust.state = response.path("custState");
		cust.pincode = response.path("custPincode");
	}
	
	public void aadhaarRegBank(Customer cust, String aadhaar_number, String cust_msisdn, String txn_type_register, String aadhaar_timestamp, String biometric_data, String certificate_identifier, String hmac, String registered_device_code, String registered_device_model_id, String registered_device_provider_code, String registered_device_public_key_certificate, String registered_device_service_id, String registered_device_service_version, String service_code, String skey, String unique_device_code, String channel, String agriculturalIncome, String amount, String annualIncome, String dbtConsent, String fatherName, String gaurdianDob, String gaurdianFname, String gaurdianLname, String gaurdianMname, String localAddress1, String localAddress2, String localAddress3, String localAddress4, String localCity, String localDistrict, String localPostalCode, String localState, String maritalStatus, String motherMaidenName, String mpin, String nomineeAddress1, String nomineeAddress2, String nomineeAddress3, String nomineeAddress4, String nomineeCity, String nomineeDistrict, String nomineeDob, String nomineeFname, String nomineeLname, String nomineeMname, String nomineePostalCode, String nomineeRelationship, String nomineeState, String nonAgriculturalIncome, String occupation, String panAckNo, String panApplicationDate) throws Exception {
		String myjson = aadhaarRegBankJSON(aadhaar_number, cust_msisdn, txn_type_register, aadhaar_timestamp, biometric_data, certificate_identifier, hmac, registered_device_code, registered_device_model_id, registered_device_provider_code, registered_device_public_key_certificate, registered_device_service_id, registered_device_service_version, service_code, skey, unique_device_code, channel, agriculturalIncome, amount, annualIncome, dbtConsent, fatherName, gaurdianDob, gaurdianFname, gaurdianLname, gaurdianMname, localAddress1, localAddress2, localAddress3, localAddress4, localCity, localDistrict, localPostalCode, localState, maritalStatus, motherMaidenName, mpin, nomineeAddress1, nomineeAddress2, nomineeAddress3, nomineeAddress4, nomineeCity, nomineeDistrict, nomineeDob, nomineeFname, nomineeLname, nomineeMname, nomineePostalCode, nomineeRelationship, nomineeState, nonAgriculturalIncome, occupation, panAckNo, panApplicationDate);
		String url = baseUrl + "aadhaarReg.action";
		Response response = getResponseFromAPIEncryptedWithHeader(myjson, url, "x-access-token", this.xAccessToken, contentTypeJson);
		this.errorMessage = response.path("errorMessage");
		this.errorCode = response.path("errorCode");
		this.code = response.path("code");
		
		//Set customer data
		cust.balance = response.path("custBalance");
	}
	
}
