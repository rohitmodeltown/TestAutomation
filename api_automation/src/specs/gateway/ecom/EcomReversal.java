package specs.gateway.ecom;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.ecom.EcomJson;
import helpers.gateway.ecom.Helper;
import helpers.gateway.ecom.Merchant;


public class EcomReversal extends Helper {
	
	public String status;
	public String messageText;
	public String code;
	public String errorCode;
	public String feSessionId;
	public boolean successScenario = true;
	
	@Test(dataProvider="ecomReversalSuccess", groups = {"sanity"})
	public void doEcomReversal(String txnId,String txnDate,  String merchantId, String hash, String amount, String refundRefNo,String messageText, String errorCode, String code,String status) {
		Merchant mer=new Merchant();
		EcomJson ecomJson=mer.generateEcomReversal(txnId, txnDate, merchantId,hash,amount,refundRefNo);
		
		assertEquals(errorCode, mer.errorCode);
		assertEquals(messageText, mer.messageText);
		assertEquals(status, mer.status);
		assertEquals(ecomJson.getFeSessionId().toString(),mer.feSessionId);
		assertEquals(code, mer.code);
	}
	
	@Test(dataProvider="ecomReversalExceedAmount", groups = {"sanity"})
	public void doEcomReversalExceedAmount(String txnId,String txnDate,  String merchantId, String hash, String amount, String refundRefNo,String messageText,String errorCode, String code,String status) {
		Merchant mer=new Merchant();
		EcomJson ecomJson=mer.generateEcomReversal(txnId, txnDate, merchantId,hash,amount,refundRefNo);
		
		assertEquals(errorCode, mer.errorCode);
		assertEquals(messageText, mer.messageText);
		assertEquals(status, mer.status);
		assertEquals(ecomJson.getFeSessionId().toString(),mer.feSessionId);
		assertEquals(code, mer.code);
	}
	
	@Test(dataProvider="ecomReversalZeroAmount", groups = {"sanity"})
	public void doEcomReversalZeroAmount(String txnId,String txnDate,  String merchantId, String hash, String amount, String refundRefNo,String messageText,String errorCode, String code,String status) {
		Merchant mer=new Merchant();
		EcomJson ecomJson=mer.generateEcomReversal(txnId, txnDate, merchantId,hash,amount,refundRefNo);
		
		assertEquals(errorCode, mer.errorCode);
		assertEquals(messageText, mer.messageText);
		assertEquals(status, mer.status);
		assertEquals(ecomJson.getFeSessionId().toString(),mer.feSessionId);
		assertEquals(code, mer.code);
	}
}
