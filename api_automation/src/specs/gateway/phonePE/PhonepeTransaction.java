package specs.gateway.phonePE;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.phonePE.Customer;
import helpers.gateway.phonePE.Helper;

public class PhonepeTransaction extends Helper{

	@Test(dataProvider="transactionSuccess", groups = {"sanity","regression"}) 
	public void successfulyGenerateTransaction(String channel, String partnerMobileNo, String customerMobileNo, String salt, String mode,String paymentRefNo,String txnAmount, String txnDate, String endChannel, String errorCode, String errorMsg, String refNo,String timestamp) {
		Customer cust = new Customer();
		cust.generateCustomerTransaction(channel, partnerMobileNo,customerMobileNo,salt, mode, paymentRefNo, txnAmount, txnDate,endChannel,errorCode, errorMsg);
		assertEquals(cust.errorCode, errorCode);
		assertEquals(cust.errorMsg, errorMsg);
	}
}
