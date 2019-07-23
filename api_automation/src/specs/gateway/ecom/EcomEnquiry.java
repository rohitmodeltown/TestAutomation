package specs.gateway.ecom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import helpers.gateway.ecom.Helper;
import helpers.gateway.ecom.Merchant;


public class EcomEnquiry extends Helper {
	
	
	@Test(dataProvider="ecomEnquirySuccess", groups = {"sanity"})
	public void doEcomEnquiry(String txnRefNo,String txnDate,  String merchantId, String hash, String amount, String refundRefNo,String messageText, String errorCode, String code) {
		Merchant mer=new Merchant();
		mer.generateEcomEnquiry(txnRefNo, txnDate, merchantId,hash,amount,refundRefNo);
		
		assertEquals(errorCode, mer.errorCode);
		assertTrue(mer.messageText.contains(messageText));
		assertEquals(txnRefNo,mer.txnRefNo);
		assertEquals(code, mer.code);
	}
	
}
