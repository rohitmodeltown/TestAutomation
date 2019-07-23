package helpers.gateway.phonePE;

import helpers.MyJson;

public class PhonepeJson extends MyJson {
	private String authValue;
	private String endChannel;
	private String otp;
	private String verificationToken;
	private String paymentRefNo;
	private Transaction txn;
	private Consent consent;
	private String custAlias;
	private String fciAmount;
	
	public String getFciAmount() {
		return fciAmount;
	}

	public void setFciAmount(String fciAmount) {
		this.fciAmount = fciAmount;
	}

	public String getCustAlias() {
		return custAlias;
	}

	public void setCustAlias(String custAlias) {
		this.custAlias = custAlias;
	}

	public String getAuthValue() {
		return authValue;
	}

	public void setAuthValue(String authValue) {
		this.authValue = authValue;
	}

	public Consent getConsent() {
		return consent;
	}

	public void setConsent(Consent consent) {
		this.consent = consent;
	}

	public String getEndChannel() {
		return endChannel;
	}

	public void setEndChannel(String endChannel) {
		this.endChannel = endChannel;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}

	public String getPaymentRefNo() {
		return paymentRefNo;
	}

	public void setPaymentRefNo(String paymentRefNo) {
		this.paymentRefNo = paymentRefNo;
	}

	public void setFeSessionId(String feSessionId) {
		this.feSessionId = feSessionId;
	}

	public Transaction getTxn() {
		return txn;
	}

	public void setTxn(Transaction txn) {
		this.txn = txn;
	}
}
