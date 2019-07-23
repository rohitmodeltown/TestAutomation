package helpers;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

import Util.Encrypt;

public class MyJson {
	private String customerId;
	private String ver;
	protected String feSessionId;
	private String languageId;
	private String channel;
	private String mode;
	private String hash;
	private String partnerId;
	private String actorId;
	private String actorType;
	private String category;
	private String merchantId;
	private String retailerId;	
	private String voltTxnId;
	private String password;
	private String langId;
	private String jwtExpiry;
	private String amount;
	private String mobile;
	private String segment;
	private String accountStatus;
	private String poiType;
	private String poiNumber;
	
	
	
	public String getVoltTxnId() {
		return voltTxnId;
	}
	public void setVoltTxnId(String voltTxnId) {
		this.voltTxnId = voltTxnId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getPoiType() {
		return poiType;
	}
	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}
	public String getPoiNumber() {
		return poiNumber;
	}
	public void setPoiNumber(String poiNumber) {
		this.poiNumber = poiNumber;
	}
	public void setFeSessionId(String feSessionId) {
		this.feSessionId = feSessionId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		Encrypt e=new Encrypt();
		try {
			this.hash = e.generateSha512Hash(hash);
			System.out.println("Generated SHA 512 Hash:"+hash);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getFeSessionId() {
		return feSessionId;
	}
	public void setFeSessionId() {
		this.feSessionId = generateFeSessionId();
	}
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getActorType() {
		return actorType;
	}
	public void setActorType(String actorType) {
		this.actorType = actorType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerID){
		this.retailerId = retailerID;
	}
	public String getRefVoltTxnId() {
		return voltTxnId;
	}
	public void setRefVoltTxnId(){
		this.voltTxnId = generateVoltTxnId();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String generateFeSessionId() {
		String feSessionId = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return feSessionId;
	}
	
	public String generateVoltTxnId() {
		String voltTxnId = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return voltTxnId;
	}
	public String getLangId() {
		return langId;
	}
	public void setLangId(String langId) {
		this.langId = langId;
	}
	public String getJwtExpiry() {
		return jwtExpiry;
	}
	public void setJwtExpiry(String jwtExpiry) {
		this.jwtExpiry = jwtExpiry;
	}
	
}
