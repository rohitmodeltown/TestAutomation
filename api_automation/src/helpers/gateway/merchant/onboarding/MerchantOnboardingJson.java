package helpers.gateway.merchant.onboarding;

import java.util.concurrent.ThreadLocalRandom;
import helpers.MyJson;

public class MerchantOnboardingJson extends MyJson {

	private String pincode;
	private String ifscCode;
	private String accountNo;
	
	//Code Added by PankajD
	private String otp;
	private String verificationToken;
	private String lastName;
	private String subCategory;
	private String shopCategory;
	private String manualAddress;
	private String panNo;
	private String permanentState;
	private String accountHolderName;
	private String firstName;
	private String permanentZipCode;
	private String permanentAddress1;
	private String permanentCountry;
	private String settlementAccountNo;
	private String permanentCity;
	private String panCardName;
	private String shopCompanyName;
	private String lat;
	private String longt;
	
	
	public String getFeSessionId() {
		return feSessionId;
	}
	public void setFeSessionId() {
		this.feSessionId = generateFeSessionId();
	}
	
	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public String getIfsc() {
		return ifscCode;
	}
	
	public void setIfsc(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public void setManualAddress(String manualAddress) {
		this.manualAddress = manualAddress;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}
	public void setPermanenZipCode(String permanentZipCode) {
		this.permanentZipCode = permanentZipCode;
	}
	public void setPermanentAddress1(String permanentAddress1) {
		this.permanentAddress1 = permanentAddress1;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}
	public void setSettlementAccountNo(String settlementAccountNo) {
		this.settlementAccountNo = settlementAccountNo;
	}
	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}
	public void setPanCardName(String panCardName) {
		this.panCardName = panCardName;
	}
	public void setShopCompanyName(String shopCompanyName) {
		this.shopCompanyName = shopCompanyName;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public void setLongt(String longt) {
		this.longt = longt;
	}
	
	public String generateFeSessionId() {
		String feSessionId = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return feSessionId;
	}
	
	public String generateVoltTxnId() {
		String voltTxnId = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return voltTxnId;
	}
}
