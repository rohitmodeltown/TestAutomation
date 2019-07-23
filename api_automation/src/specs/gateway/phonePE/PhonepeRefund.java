package specs.gateway.phonePE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.phonePE.Customer;
import helpers.gateway.phonePE.Helper;

public class PhonepeRefund extends Helper{
	

	@Test(dataProvider="refundSuccess", groups = {"sanity","regression"}) 
	public void successfulyGenerateRefund(String channel, String partnerMobileNo, String customerMobileNo, String salt, String paymentRefNo,String txnAmount,String txnDate,String refundAmt, String refundTxnDate,String errorCode, String errorMsg,String mode,String endChannel) {
		Customer cust = new Customer();
		cust.generateCustomerTransaction(channel, partnerMobileNo, customerMobileNo, salt, "REAL", paymentRefNo, txnAmount, txnDate, endChannel, errorCode, errorMsg);
		cust.generateCustomerRefund(channel,partnerMobileNo,customerMobileNo,salt, paymentRefNo,refundAmt, refundTxnDate,errorCode,errorMsg, mode, endChannel);
		assertEquals(cust.errorCode, errorCode);
		assertEquals(cust.errorMsg, errorMsg);
		
	}
}
