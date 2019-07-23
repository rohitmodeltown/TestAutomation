package helpers.gateway.ecom;

import java.io.IOException;


import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

import helpers.GlobalHelper;

public class Helper extends GlobalHelper {
	public String baseUrl =  readFromPropertiesFile(configPath, "ECOM.BASEURL");
	// path to ecom config file
	public String ecomConfig = "./resources/ecom/ecom_config.properties";
	public String ECOM_REVERSAL_EXCEL_PATH = readFromPropertiesFile(ecomConfig, "ECOM_REVERSAL_EXCEL_PATH");
	public String ECOM_ENQUIRY_EXCEL_PATH = readFromPropertiesFile(ecomConfig, "ECOM_ENQUIRY_EXCEL_PATH");
	
	public String generateEcomReversalJSON(String txnId,String txnDate,  String merchantId, String hash, String amount, String refundRefNo) {
		Gson gson = new Gson();
		EcomJson json = new EcomJson();
		json.setFeSessionId();
		json.setTxnId(txnId);
		json.setTxnDate(txnDate);
		json.setMerchantId(merchantId);
		json.setHash(hash);
		json.setAmount(amount);
		json.setRefundRefNo(refundRefNo);
		return gson.toJson(json).toString();
	}
	
	public String generateEcomEnquiryJSON(String txnRefNO,String txnDate,  String merchantId, String hash, String amount, String refundRefNo) {
		Gson gson = new Gson();
		EcomJson json = new EcomJson();
		json.setFeSessionId();
		json.setTxnRefNO(txnRefNO);
		json.setTxnDate(txnDate);
		json.setMerchantId(merchantId);
		json.setHash(hash);
		json.setAmount(amount);
		json.setRefundRefNo(refundRefNo);
		return gson.toJson(json).toString();
	}
	
	@DataProvider
	public String[][] ecomReversalSuccess() throws IOException {
		String[][] data = readFromExcel( ECOM_REVERSAL_EXCEL_PATH , "Success");
		return data;
	}
	
	@DataProvider
	public String[][] ecomReversalExceedAmount() throws IOException {
		String[][] data = readFromExcel( ECOM_REVERSAL_EXCEL_PATH , "ExceedAmount");
		return data;
	}
	
	@DataProvider
	public String[][] ecomReversalZeroAmount() throws IOException {
		String[][] data = readFromExcel( ECOM_REVERSAL_EXCEL_PATH , "ZeroAmount");
		return data;
	}
	
	@DataProvider
	public String[][] ecomEnquirySuccess() throws IOException {
		String[][] data = readFromExcel( ECOM_ENQUIRY_EXCEL_PATH , "Success");
		return data;
	}
	
}

