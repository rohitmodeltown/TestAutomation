package helpers.gateway.payments.retailerPortal;

import helpers.MyJson;

public class RetailerPortalJson extends MyJson{
	
	private String jwtExpiry;
	private String txnType;
	private String totalTxnAmount;
	private String opMode;
	private String token;
	private String appVersion;
	private String favoriteId;
	private String count;
	private String signature;
	private String reference1;
	private String beneToken;
	private String merchantUserName;
	private String beneMobNo;
	private String beneAccNo;
	private String ifsc;
	private String beneName; 
	private String bankName; 
	private String amount; 
	private String loadAmount; 
	private String mpin; 
	private String reqType;
	private String retryFlag;
	private String txnCharges;
	private String totalTxnAmt;
	private String otp;
	private String otpReq;
	
	public String getJwtExpiry() {
		return jwtExpiry;
	}
	public void setJwtExpiry(String jwtExpiry) {
		this.jwtExpiry = jwtExpiry;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getTotalTxnAmount() {
		return totalTxnAmount;
	}
	public void setTotalTxnAmount(String totalTxnAmount) {
		this.totalTxnAmount = totalTxnAmount;
	}
	public String getOpMode() {
		return opMode;
	}
	public void setOpMode(String opMode) {
		this.opMode = opMode;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getReference1(){
		return reference1;
	}	
	public void setReference1(String reference1){
		this.reference1 = reference1;
	}
	public String getBeneToken(){
		return beneToken;
	}
	public void setBeneToken(String beneToken){
		this.beneToken = beneToken;
	}
	public String getMerchantUserName(){
		return merchantUserName;
	}
	public void setMerchantUserName(String merchantUserName){
		this.merchantUserName = merchantUserName;
	}
	public String getBeneMobNo(){
		return beneMobNo;
	}
	public void setBeneMobNo(String beneMobNo){
		this.beneMobNo = beneMobNo;
	}
	public String getBeneAccNo(){
		return beneAccNo;
	}
	public void setBeneAccNo(String beneAccNo){
		this.beneAccNo = beneAccNo;
	}
	public String getIfsc(){
		return ifsc;
	}
	public void setIfsc(String ifsc){
		this.ifsc = ifsc;
	}
	public String getBeneName(){
		return beneName;
	} 
	public void setBeneName(String beneName){
		this.beneName = beneName;
	} 
	public String getBankName(){
		return bankName;
	} 
	public void setBankName(String bankName){
		this.bankName = bankName;
	} 
	public String getAmount(){
		return amount;
	}
	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getLoadAmount(){
		return loadAmount;
	}
	public void setLoadAmount(String loadAmount){
		this.loadAmount = loadAmount;
	} 
	public String getMpin(){
		return mpin;
	}
	public void setMpin(String mpin){
		this.mpin = mpin;
	}
	public String getReqType(){
		return reqType;
	}
	public void setReqType(String reqType){
		this.reqType = reqType;
	}
	public String getRetryFlag(){
		return retryFlag;
	}
	public void setRetryFlag(String retryFlag){
		this.retryFlag = retryFlag;
	}
	public String getTxnCharges(){
		return txnCharges;
	}
	public void setTxnCharges(String txnCharges){
		this.txnCharges = txnCharges;
	}
	public String getTotalTxnAmt(){
		return totalTxnAmt;
	}
	public void setTotalTxnAmt(String totalTxnAmt){
		this.totalTxnAmt = totalTxnAmt;
	}
	public String getOtp(){
		return otp;
	}
	public void setOtp(String otp){
		this.otp = otp;
	}
	public String getOtpReq(){
		return otpReq;
	}
	public void setOtpReq(String otpReq){
		this.otpReq = otpReq;
	}
}
