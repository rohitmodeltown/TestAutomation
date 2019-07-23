package specs.gateway.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.onboarding.Customer;
import helpers.gateway.onboarding.Helper;
import helpers.gateway.onboarding.Retailer;

public class AadhaarReg extends Helper {
	
	@Test(dataProvider="aadhaarRegSuccessWallet", groups = {"sanity"})
	public void successfullyRegisterWalletCustomer(String ver, String partner_id, String aadhaar_number, String cust_msisdn, String txn_type, String aadhaar_timestamp, String biometric_data, String certificate_identifier, String hmac, String registered_device_code, String registered_device_model_id, String registered_device_provider_code, String registered_device_public_key_certificate, String registered_device_service_id, String registered_device_service_version, String service_code, String skey, String unique_device_code, String channel, String jwt_expiry, String retailer, String actor_type, String consumerName, String lob, String programmeName, String statusCode, String statusDescription, String responseCode, String responseTimeStamp, String action, String name, String dob, String gender, String phone, String email, String careOf, String house, String street, String landMark, String locality, String vtc, String subDistrict, String district, String state, String pincode, String photo) throws Exception {
//		updateGetAadhaarStub(consumerName, lob, programmeName, statusCode, statusDescription, responseCode, responseTimeStamp, action, name, dob, gender, phone, email, careOf, house, street, landMark, locality, vtc, subDistrict, district, state, pincode, photo);
		Retailer ret = new Retailer();
		Customer cust = new Customer();
		ret.generateToken(channel, retailer, actor_type, jwt_expiry);
		ret.generateOTP(ucid, ver, cust_msisdn, channel, partner_id);
		ret.getProfileWithOTP(ver, channel, partner_id);
		ret.aadhaarRegWallet(cust, aadhaar_number, cust_msisdn, txn_type, aadhaar_timestamp, biometric_data, certificate_identifier, hmac, registered_device_code, registered_device_model_id, registered_device_provider_code, registered_device_public_key_certificate, registered_device_service_id, registered_device_service_version, service_code, skey, unique_device_code, channel);
		
		assertEquals("Thank You, Bank Account opening request has been submitted successfully. Customer would receive account status SMS shortly.", ret.errorMessage);
		assertEquals("000", ret.errorCode);
		assertEquals("0", ret.code);
		assertEquals(name, cust.name);
		assertEquals(gender, cust.gender);
		assertEquals(email, cust.email);
//		assertEquals(response.path("custCareOf"), careOf);
		assertEquals(house, cust.house);
		assertEquals(street, cust.street);
		assertEquals(landMark, cust.landmark);
		assertEquals(locality, cust.locality);
		assertEquals(vtc, cust.vtc);
		assertEquals(subDistrict, cust.subDistrict);
		assertEquals(district, cust.district);
		assertEquals(state, cust.state);
		assertEquals(pincode, cust.pincode);
		assertEquals(district, cust.district);
	}
	
	@Test(dataProvider="aadhaarRegSuccessBank", groups = {"sanity"})
	public void successfullyRegisterBankCustomer(String ucid, String ver, String partner_id, String aadhaar_number, String cust_msisdn, String txn_type_enquiry, String txn_type_register, String aadhaar_timestamp, String biometric_data, String certificate_identifier, String hmac, String registered_device_code, String registered_device_model_id, String registered_device_provider_code, String registered_device_public_key_certificate, String registered_device_service_id, String registered_device_service_version, String service_code, String skey, String unique_device_code, String channel, String jwt_expiry, String retailer, String actor_type, String agriculturalIncome, String amount, String annualIncome, String dbtConsent, String fatherName, String gaurdianDob, String gaurdianFname, String gaurdianLname, String gaurdianMname, String localAddress1, String localAddress2, String localAddress3, String localAddress4, String localCity, String localDistrict, String localPostalCode, String localState, String maritalStatus, String motherMaidenName, String mpin, String nomineeAddress1, String nomineeAddress2, String nomineeAddress3, String nomineeAddress4, String nomineeCity, String nomineeDistrict, String nomineeDob, String nomineeFname, String nomineeLname, String nomineeMname, String nomineePostalCode, String nomineeRelationship, String nomineeState, String nonAgriculturalIncome, String occupation, String panAckNo, String panApplicationDate, String consumerName, String lob, String programmeName, String statusCode, String statusDescription, String responseCode, String responseTimeStamp, String action, String name, String dob, String gender, String phone, String email, String careOf, String house, String street, String landMark, String locality, String vtc, String subDistrict, String district, String state, String pincode, String photo) throws Exception {
//		updateGetAadhaarStub(consumerName, lob, programmeName, statusCode, statusDescription, responseCode, responseTimeStamp, action, name, dob, gender, phone, email, careOf, house, street, landMark, locality, vtc, subDistrict, district, state, pincode, photo);
		Retailer ret = new Retailer();
		Customer cust = new Customer();
		ret.generateToken(channel, retailer, actor_type, jwt_expiry);
		ret.generateOTP(ucid, ver, cust_msisdn, channel, partner_id);
		ret.getProfileWithOTP(ver, channel, partner_id);
		ret.aadhaarRegWallet(cust, aadhaar_number, cust_msisdn, txn_type_enquiry, aadhaar_timestamp, biometric_data, certificate_identifier, hmac, registered_device_code, registered_device_model_id, registered_device_provider_code, registered_device_public_key_certificate, registered_device_service_id, registered_device_service_version, service_code, skey, unique_device_code, channel);
		
		assertEquals("Thank You, Bank Account opening request has been submitted successfully. Customer would receive account status SMS shortly.", ret.errorMessage);
		assertEquals("000", ret.errorCode);
		
		ret.aadhaarRegBank(cust, aadhaar_number, cust_msisdn, txn_type_register, aadhaar_timestamp, biometric_data, certificate_identifier, hmac, registered_device_code, registered_device_model_id, registered_device_provider_code, registered_device_public_key_certificate, registered_device_service_id, registered_device_service_version, service_code, skey, unique_device_code, channel, agriculturalIncome, amount, annualIncome, dbtConsent, fatherName, gaurdianDob, gaurdianFname, gaurdianLname, gaurdianMname, localAddress1, localAddress2, localAddress3, localAddress4, localCity, localDistrict, localPostalCode, localState, maritalStatus, motherMaidenName, mpin, nomineeAddress1, nomineeAddress2, nomineeAddress3, nomineeAddress4, nomineeCity, nomineeDistrict, nomineeDob, nomineeFname, nomineeLname, nomineeMname, nomineePostalCode, nomineeRelationship, nomineeState, nonAgriculturalIncome, occupation, panAckNo, panApplicationDate);
		
		assertEquals("Thank You, Bank Account opening request has been submitted successfully. Customer would receive account status SMS shortly.", ret.errorMessage);
		assertEquals("000", ret.errorCode);
		assertEquals("0", ret.code);
	}
}
