//package specs.volt.onboarding;
//
//import static org.testng.Assert.assertEquals;
//
//import org.testng.annotations.Test;
//
//import helpers.volt.onboarding.KuaHelper;
//import io.restassured.response.Response;
//
//public class Kua extends KuaHelper {
//	@Test(dataProvider="successData")
//	public void success_onbaording(String version, String Languageid, String cust_msisdn, String retailer_msisdn, String txn_type, String aadhaarId, String aadhaar_timestamp, String biometric_data, String skey, String hmac, String pan) {
//		System.out.println("0000000000000000");
//		String myjson = generateXML(version, Languageid, cust_msisdn, retailer_msisdn, txn_type, aadhaarId, aadhaar_timestamp, biometric_data, skey, hmac, pan);
//		System.out.println("222222222222222");
//		Response response = getResponseFromAPI(myjson);
//		System.out.println("%%%%%%%%%%%%%");
//		System.out.println("%%%%%%%%%%%%%");
//		System.out.println("%%%%%%%%%%%%%");
//		System.out.println(response);
////	    
////		assertEquals(response.path("messageText"), "SUCCESS");
////		assertEquals(response.path("errorCode"), "0000");
////		assertEquals(response.path("code"), "0");
//		
//	}
//}
