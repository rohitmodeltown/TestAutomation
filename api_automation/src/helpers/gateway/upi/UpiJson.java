package helpers.gateway.upi;

import helpers.MyJson;

public class UpiJson extends MyJson{

	private String pincode;
	private String ifscCode;
	private String accountNo;
	private String otp;
	private String verificationToken;
	private String appVersion;
	private String deviceId;
	private String simId;
	private String slotId;
	private String osApiVersion;
	private String platform;
	private String smsToken;
	private String challenge;
	private String ctype;
	private String vpa;
	private String screenHeight;
	private String osVersion;
	private String imei;
	private String deviceModel;
	private String deviceMake;
	private String username;
	private String screenWidth;
	private String email;
	private String name;
	private String vpaId;
	//UPI fields
	private String accountHolderName;
	private String ifsc;
	private String txnLimit;
	private String isDefault;
	private String dType;
	private String credSubType;
	private String credLen;
	private String bankName;
	private String from;
	private String to;
	private String maxRecords;
	private String vpaFdid;
	private String vfaId;
	private String toName;
	private String amount;
	private String location;
	private String longitude;
	private String latitude;
	private String feature;
	private String admin;
	private String locality;
	private String countryCode;
	private String chId;
	private String upiTxnId;
	private String redId;
	private String iin;
	private String countryName;
	private String addressLine;
	private String accountNumber;
	private String vpaFdId;
	private String refId;
	private String remarks;
	private String toVpa;

	

	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public void setSimId(String simId) {
		this.simId = simId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public void setOsApiVersion(String osApiVersion) {
		this.osApiVersion = osApiVersion;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public void setSmsToekn(String smsToken) {
		this.smsToken = smsToken;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	public void setChallenge(String challenge){
		this.challenge = challenge;
	}
	public void setCtype(String ctype){
		this.ctype = ctype;
	}
	public void setVpa(String vpa){
		this.vpa = vpa;
	}
	public void setScreenHeight(String screenHeight) {
		this.screenHeight = screenHeight;
		
	}
	public void setName(String name) {
		this.name=name;	
	}
	public void setEmailId(String email) {
		this.email=email;	
	}
	public void setScreenWidth(String screenWidth) {
		this.screenWidth=screenWidth;		
	}
	public void setUserName(String username) {
		this.username=username;
		
	}
	public void setDeviceMake(String deviceMake) {
		this.deviceMake=deviceMake;		
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel=deviceModel;		
	}
	public void setImei(String imei) {
		this.imei=imei;	
	}
	public void setOsVersion(String osVersion) {
		this.osVersion=osVersion;	
	}
	public void setVpaId(String vpaId) {
		this.vpaId=vpaId;
		// TODO Auto-generated method stub
		
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName=accountHolderName;
		
	}
	public void setIfsc(String ifsc) {
		this.ifsc=ifsc;
		
	}
	public void setTxnLimit(String txnLimit) {
		this.txnLimit=txnLimit;
		
	}
	public void setBankName(String bankName) {
		this.bankName=bankName;
		
	}
	public void setIsDefault(String isDefault) {
		this.isDefault=isDefault;
		
	}
	public void setNickname(String nickName) {
		// TODO Auto-generated method stub
		
	}
	public void setCredType(String credType) {
		this.credSubType=credType;
		
	}
	public void setCredLen(String credLen) {
		this.credLen=credLen;
		
	}
	public void setSubType(String credSubType) {
		this.credSubType=credSubType;
		
	}
	public void setDType(String dType) {
		this.dType=dType;
		
	}
	public void setMaxrecords(String maxRecords) {
		this.maxRecords=maxRecords;
		
	}
	public void setTo(String to) {
		this.to=to;
		
	}
	public void setFrom(String from) {
		this.from = from;		
	}
	public void setVpaFdId(String vpaFdid) {
		this.vpaFdId=vpaFdid;
	}
	
	public void setVfaId(String vfaId) {
		this.vfaId = vfaId;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getVpaFdid() {
		return vpaFdid;
	}

	public void setVpaFdid(String vpaFdid) {
		this.vpaFdid = vpaFdid;
	}
	public String getChId() {
		return chId;
	}

	public void setChId(String chId) {
		this.chId = chId;
	}
	public String getUpiTxnId() {
		return upiTxnId;
	}

	public void setUpiTxnId(String upiTxnId) {
		this.upiTxnId = upiTxnId;
	}
	public String getRedId() {
		return redId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	public String getIin() {
		return iin;
	}

	public void setIin(String iin) {
		this.iin = iin;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setRemarks(String remarks) {
		this.remarks=remarks;
		
	}
	public void setToVpa(String toVpa) {
		this.toVpa=toVpa;
		
	}
}
