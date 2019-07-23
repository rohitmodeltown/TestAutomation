package helpers.gateway.payments.retailerPortal;


import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

public class SplitTransactionHelper extends Helper {
	RetailerPortalJson json = new RetailerPortalJson();
	Gson gson = new Gson();
	public String splitTxnAction = readFromPropertiesFile(actionPropertiesFileLocation, "splitTxnAction");
	public String splitTransactionFilePath = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "splitTxnDataFileName");
	public String splitTransactionSheetName = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "splitTxnDataSheetName");
	public String transactionAmount = "totalTxnAmount";
	public String transactionCharges = "totalTxnCharge";
	
	@DataProvider
	public String[][] splitTxnData() throws IOException {
		String[][] data = readFromExcel(splitTransactionFilePath, splitTransactionSheetName);
		return data;
	}
	
	public String splitTxnJSON(String langId, String customerId, String txnType,String totalTxnAmount, String opMode) {
		json.setFeSessionId();
		json.setLanguageId(langId);
		json.setCustomerId(customerId);
		json.setTxnType(txnType);
		json.setTotalTxnAmount(totalTxnAmount);
		json.setOpMode(opMode);
		return gson.toJson(json).toString();
	}
}
