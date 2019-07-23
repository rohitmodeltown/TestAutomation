package helpers.gateway.ecom;

import com.google.gson.Gson;

import io.restassured.response.Response;

public class Merchant extends Helper{
	
	public String status;
	public String messageText;
	public String code;
	public String errorCode;
	public String txnRefNo;
	public String feSessionId;
	public boolean successScenario = true;
	
	public void generateEcomEnquiry(String txnRefNo, String txnDate, String merchantId,String hash,String amount, String refundRefNo)
	{
	   String myjson = generateEcomEnquiryJSON(txnRefNo, txnDate, merchantId,hash,amount,refundRefNo);
	   String url = baseUrl + "EcomEnquiry.action";
	   Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
	   System.out.println("Response:"+response.prettyPrint());
	   this.messageText = response.path("messageText");
	   this.errorCode = response.path("errorCode");
	   this.code = response.path("code");
	   this.txnRefNo=response.path("txnRefNo");
	}
	
	
	public EcomJson generateEcomReversal(String txnId, String txnDate, String merchantId,String hash,String amount, String refundRefNo)
	{
	   String myjson = generateEcomReversalJSON(txnId, txnDate, merchantId,hash,amount,refundRefNo);
	   Gson gson=new Gson();
	   EcomJson ecomJson=gson.fromJson(myjson, EcomJson.class);
	   String url = baseUrl + "ecomReversal.action";
	   Response response = getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
	   System.out.println("Response:"+response.prettyPrint());
	   this.messageText = response.path("messageText");
	   this.errorCode = response.path("errorCode");
	   this.code = response.path("code");
	   this.status=response.path("status");
	   this.feSessionId=response.path("feSessionId");
	   return ecomJson;
	}

}
