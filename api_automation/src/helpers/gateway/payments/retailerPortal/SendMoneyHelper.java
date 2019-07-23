package helpers.gateway.payments.retailerPortal;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

public class SendMoneyHelper extends Helper {
	RetailerPortalJson json = new RetailerPortalJson();
	Gson gson = new Gson();	

	public String sendMoneyAction = readFromPropertiesFile(actionPropertiesFileLocation, "sendMoneyAction");
	public String sendMoneyExcelPath = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "successImpsDataFileName");
	public String sendMoneySheetName = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "successImpsDataSheetName");
	
	@DataProvider
	public String[][] successImpsData() throws IOException {
		String[][] data = readFromExcel(sendMoneyExcelPath, sendMoneySheetName);
		return data;
	}
	
	public String sendMoneyJSON(String channel, String languageId, String customerId, String merchantId, String reference1, String beneToken,
			String merchantUserName, String retailerId, String beneMobNo, String beneAcctNo, String ifsc, String beneName,
			String bankName,String amount, String loadAmount, String mpin, String reqType,
			String txnType, String retryFlag, String txnCharges, String totalTxnAmt, String mode, String otp, String otpReq) {
		    json.setFeSessionId();
		    json.setChannel(channel);
			json.setLanguageId(languageId);;
			json.setCustomerId(customerId);
			json.setMerchantId(merchantId);
			json.setReference1(reference1);
			json.setBeneToken(beneToken);
			json.setMerchantUserName(merchantUserName);
			json.setRetailerId(retailerId);
			json.setBeneMobNo(beneMobNo);
			json.setBeneAccNo(beneAcctNo);
			json.setIfsc(ifsc);
			json.setBeneName(beneName); 
			json.setBankName(bankName); 
			json.setAmount(amount);
			json.setLoadAmount(loadAmount); 
			json.setMpin(mpin); 
			json.setRefVoltTxnId();
			json.setReqType(reqType);
			json.setTxnType(txnType);
			json.setRetryFlag(retryFlag);
			json.setTxnCharges(txnCharges);
			json.setTotalTxnAmt(totalTxnAmt);
			json.setMode(mode);
			json.setOtp(otp);
			json.setOtpReq(otpReq);
			return gson.toJson(json).toString();
	}
}
