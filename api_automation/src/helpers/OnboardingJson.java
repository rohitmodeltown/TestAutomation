package helpers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="req" )

public class OnboardingJson extends MyJson {
	private String cust_msisdn;
	private String retailer_msisdn;
	private String txn_type;
	private String biometric_data;
	private String aadhaar_timestamp;
	private String pan;
	
	
	private String aadhaarId;
	private String skey;
	private String hmac;
	private String agriculturalIncome;
	private String amount;
	private String annualIncome;
	private String custMsisdn;
	private String dbtConsent;
	private String emailId;
	private String fatherName;
	private String gaurdianDob;
	private String gaurdianFname;
	private String gaurdianLname;
	private String gaurdianMname;
	private String localAddress1;
	private String localAddress2;
	private String localAddress3;
	private String localAddress4;
	private String localCity;
	private String localDistrict;
	private String localPostalCode;
	private String localState;
	private String maritalStatus;
	private String motherMaidenName;
	private String mpin;
	private String msme;
	private String nomineeAddress1;
	private String nomineeAddress2;
	private String nomineeAddress3;
	private String nomineeAddress4;
	private String nomineeCity;
	private String nomineeDistrict;
	private String nomineeDob;
	private String nomineeFname;
	private String nomineeLname;
	private String nomineeMname;
	private String nomineePostalCode;
	private String nomineeRelationship;
	private String nomineeState;
	private String nonAgriculturalIncome;
	private String occupation;
	private String panAckNo;
	private String panApplicationDate;
	private String txnType;
	private String aadhaarTimestamp;
	private String biometricData;
	private String certificateIdentifier;
	private String registeredDeviceCode;
	private String registeredDeviceModelID;
	private String registeredDeviceProviderCode;
	private String registeredDevicePublicKeyCertificate;
	private String registeredDeviceServiceID;
	private String registeredDeviceServiceVersion;
	private String serviceCode;
	private String uniqueDeviceCode;	
	private String verificationToken;
	private String otp;
	
	public void initializeParameters() {
		aadhaarId="";
		skey="";
		hmac="";
		agriculturalIncome="";
		amount="10";
		annualIncome="";
		custMsisdn="";
		dbtConsent="";
		emailId="";
		fatherName="";
		gaurdianDob="";
		gaurdianFname="";
		gaurdianLname="";
		gaurdianMname="";
		localAddress1="";
		localAddress2="";
		localAddress3="";
		localAddress4="";
		localCity="";
		localDistrict="";
		localPostalCode="";
		localState="";
		maritalStatus="";
		motherMaidenName="";
		mpin="";
		msme="";
		nomineeAddress1="";
		nomineeAddress2="";
		nomineeAddress3="";
		nomineeAddress4="";
		nomineeCity="";
		nomineeDistrict="";
		nomineeDob="";
		nomineeFname="";
		nomineeLname="";
		nomineeMname="";
		nomineePostalCode="";
		nomineeRelationship="";
		nomineeState="";
		nonAgriculturalIncome="";
		occupation="";
		panAckNo="";
		panApplicationDate="";
		txnType="";
		aadhaarTimestamp="";
		biometricData="";
		certificateIdentifier="";
		registeredDeviceCode="";
		registeredDeviceModelID="";
		registeredDeviceProviderCode="";
		registeredDevicePublicKeyCertificate="";
		registeredDeviceServiceID="";
		registeredDeviceServiceVersion="";
		serviceCode="";
		uniqueDeviceCode="";
	}

	public String getCust_msisdn() {
		return cust_msisdn;
	}

	public void setCust_msisdn(String cust_msisdn) {
		this.cust_msisdn = cust_msisdn;
	}

	public String getRetailer_msisdn() {
		return retailer_msisdn;
	}

	public void setRetailer_msisdn(String retailer_msisdn) {
		this.retailer_msisdn = retailer_msisdn;
	}

	public String getTxn_type() {
		return txn_type;
	}

	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}

	public String getAadhaarId() {
		return aadhaarId;
	}

	public void setAadhaarId(String aadhaarId) {
		this.aadhaarId = aadhaarId;
	}

	public String getAadhaar_timestamp() {
		return aadhaar_timestamp;
	}

	public void setAadhaar_timestamp(String aadhaar_timestamp) {
		this.aadhaar_timestamp = aadhaar_timestamp;
	}

	public String getBiometric_data() {
		return biometric_data;
	}

	public void setBiometric_data(String biometric_data) {
		this.biometric_data = biometric_data;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getHmac() {
		return hmac;
	}

	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAgriculturalIncome() {
		return agriculturalIncome;
	}

	public void setAgriculturalIncome(String agriculturalIncome) {
		this.agriculturalIncome = agriculturalIncome;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCustMsisdn() {
		return custMsisdn;
	}

	public void setCustMsisdn(String custMsisdn) {
		this.custMsisdn = custMsisdn;
	}

	public String getDbtConsent() {
		return dbtConsent;
	}

	public void setDbtConsent(String dbtConsent) {
		this.dbtConsent = dbtConsent;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGaurdianDob() {
		return gaurdianDob;
	}

	public void setGaurdianDob(String gaurdianDob) {
		this.gaurdianDob = gaurdianDob;
	}

	public String getGaurdianFname() {
		return gaurdianFname;
	}

	public void setGaurdianFname(String gaurdianFname) {
		this.gaurdianFname = gaurdianFname;
	}

	public String getGaurdianLname() {
		return gaurdianLname;
	}

	public void setGaurdianLname(String gaurdianLname) {
		this.gaurdianLname = gaurdianLname;
	}

	public String getGaurdianMname() {
		return gaurdianMname;
	}

	public void setGaurdianMname(String gaurdianMname) {
		this.gaurdianMname = gaurdianMname;
	}

	public String getLocalAddress1() {
		return localAddress1;
	}

	public void setLocalAddress1(String localAddress1) {
		this.localAddress1 = localAddress1;
	}

	public String getLocalAddress2() {
		return localAddress2;
	}

	public void setLocalAddress2(String localAddress2) {
		this.localAddress2 = localAddress2;
	}

	public String getLocalAddress3() {
		return localAddress3;
	}

	public void setLocalAddress3(String localAddress3) {
		this.localAddress3 = localAddress3;
	}

	public String getLocalAddress4() {
		return localAddress4;
	}

	public void setLocalAddress4(String localAddress4) {
		this.localAddress4 = localAddress4;
	}

	public String getLocalCity() {
		return localCity;
	}

	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}

	public String getLocalDistrict() {
		return localDistrict;
	}

	public void setLocalDistrict(String localDistrict) {
		this.localDistrict = localDistrict;
	}

	public String getLocalPostalCode() {
		return localPostalCode;
	}

	public void setLocalPostalCode(String localPostalCode) {
		this.localPostalCode = localPostalCode;
	}

	public String getLocalState() {
		return localState;
	}

	public void setLocalState(String localState) {
		this.localState = localState;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMotherMaidenName() {
		return motherMaidenName;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}

	public String getMpin() {
		return mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	public String getMsme() {
		return msme;
	}

	public void setMsme(String msme) {
		this.msme = msme;
	}

	public String getNomineeAddress1() {
		return nomineeAddress1;
	}

	public void setNomineeAddress1(String nomineeAddress1) {
		this.nomineeAddress1 = nomineeAddress1;
	}

	public String getNomineeAddress2() {
		return nomineeAddress2;
	}

	public void setNomineeAddress2(String nomineeAddress2) {
		this.nomineeAddress2 = nomineeAddress2;
	}

	public String getNomineeAddress3() {
		return nomineeAddress3;
	}

	public void setNomineeAddress3(String nomineeAddress3) {
		this.nomineeAddress3 = nomineeAddress3;
	}

	public String getNomineeAddress4() {
		return nomineeAddress4;
	}

	public void setNomineeAddress4(String nomineeAddress4) {
		this.nomineeAddress4 = nomineeAddress4;
	}

	public String getNomineeCity() {
		return nomineeCity;
	}

	public void setNomineeCity(String nomineeCity) {
		this.nomineeCity = nomineeCity;
	}

	public String getNomineeDistrict() {
		return nomineeDistrict;
	}

	public void setNomineeDistrict(String nomineeDistrict) {
		this.nomineeDistrict = nomineeDistrict;
	}

	public String getNomineeDob() {
		return nomineeDob;
	}

	public void setNomineeDob(String nomineeDob) {
		this.nomineeDob = nomineeDob;
	}

	public String getNomineeFname() {
		return nomineeFname;
	}

	public void setNomineeFname(String nomineeFname) {
		this.nomineeFname = nomineeFname;
	}

	public String getNomineeLname() {
		return nomineeLname;
	}

	public void setNomineeLname(String nomineeLname) {
		this.nomineeLname = nomineeLname;
	}

	public String getNomineeMname() {
		return nomineeMname;
	}

	public void setNomineeMname(String nomineeMname) {
		this.nomineeMname = nomineeMname;
	}

	public String getNomineePostalCode() {
		return nomineePostalCode;
	}

	public void setNomineePostalCode(String nomineePostalCode) {
		this.nomineePostalCode = nomineePostalCode;
	}

	public String getNomineeRelationship() {
		return nomineeRelationship;
	}

	public void setNomineeRelationship(String nomineeRelationship) {
		this.nomineeRelationship = nomineeRelationship;
	}

	public String getNomineeState() {
		return nomineeState;
	}

	public void setNomineeState(String nomineeState) {
		this.nomineeState = nomineeState;
	}

	public String getNonAgriculturalIncome() {
		return nonAgriculturalIncome;
	}

	public void setNonAgriculturalIncome(String nonAgriculturalIncome) {
		this.nonAgriculturalIncome = nonAgriculturalIncome;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPanAckNo() {
		return panAckNo;
	}

	public void setPanAckNo(String panAckNo) {
		this.panAckNo = panAckNo;
	}

	public String getPanApplicationDate() {
		return panApplicationDate;
	}

	public void setPanApplicationDate(String panApplicationDate) {
		this.panApplicationDate = panApplicationDate;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getAadhaarTimestamp() {
		return aadhaarTimestamp;
	}

	public void setAadhaarTimestamp(String aadhaarTimestamp) {
		this.aadhaarTimestamp = aadhaarTimestamp;
	}

	public String getBiometricData() {
		return biometricData;
	}

	public void setBiometricData(String biometricData) {
		this.biometricData = biometricData;
	}

	public String getCertificateIdentifier() {
		return certificateIdentifier;
	}

	public void setCertificateIdentifier(String certificateIdentifier) {
		this.certificateIdentifier = certificateIdentifier;
	}

	public String getRegisteredDeviceCode() {
		return registeredDeviceCode;
	}

	public void setRegisteredDeviceCode(String registeredDeviceCode) {
		this.registeredDeviceCode = registeredDeviceCode;
	}

	public String getRegisteredDeviceModelID() {
		return registeredDeviceModelID;
	}

	public void setRegisteredDeviceModelID(String registeredDeviceModelID) {
		this.registeredDeviceModelID = registeredDeviceModelID;
	}

	public String getRegisteredDeviceProviderCode() {
		return registeredDeviceProviderCode;
	}

	public void setRegisteredDeviceProviderCode(String registeredDeviceProviderCode) {
		this.registeredDeviceProviderCode = registeredDeviceProviderCode;
	}

	public String getRegisteredDevicePublicKeyCertificate() {
		return registeredDevicePublicKeyCertificate;
	}

	public void setRegisteredDevicePublicKeyCertificate(String registeredDevicePublicKeyCertificate) {
		this.registeredDevicePublicKeyCertificate = registeredDevicePublicKeyCertificate;
	}

	public String getRegisteredDeviceServiceID() {
		return registeredDeviceServiceID;
	}

	public void setRegisteredDeviceServiceID(String registeredDeviceServiceID) {
		this.registeredDeviceServiceID = registeredDeviceServiceID;
	}

	public String getRegisteredDeviceServiceVersion() {
		return registeredDeviceServiceVersion;
	}

	public void setRegisteredDeviceServiceVersion(String registeredDeviceServiceVersion) {
		this.registeredDeviceServiceVersion = registeredDeviceServiceVersion;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getUniqueDeviceCode() {
		return uniqueDeviceCode;
	}

	public void setUniqueDeviceCode(String uniqueDeviceCode) {
		this.uniqueDeviceCode = uniqueDeviceCode;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}
