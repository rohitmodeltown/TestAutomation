//package helpers.volt.onboarding;
//
//import java.io.IOException;
//import java.io.StringWriter;
//
//import javax.xml.bind.JAXB;
//
//import org.testng.annotations.DataProvider;
//
//import com.google.gson.Gson;
//
//import helpers.MyJson;
//import helpers.OnboardingJson;
//import helpers.gateway.onboarding.Helper;
//import io.restassured.response.Response;
//
//public class KuaHelper extends Helper {
////	public String url = String.format("%svolt?ucId=%s&feSessionId=%s&langId=001" , baseUrl, ucid, generateFeSessionId()); 
//	public String url = baseUrl + ".action";
//	public String KUA_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "KUA_EXCEL_PATH");
//	
//	@DataProvider
//	public String[][] successData() throws IOException {
//		String[][] data = readFromExcel( KUA_EXCEL_PATH , "success");
//		return data;
//	}
//	
////	public String generateXML(String version, String Languageid, String cust_msisdn, String retailer_msisdn, String txn_type, String aadhaarId, String aadhaar_timestamp, String biometric_data, String skey, String hmac, String pan) {
////		OnboardingJson json = new OnboardingJson();
////		json.setFeSessionId();
////		json.setLangId("001");
////		json.setCust_msisdn(cust_msisdn);
////		json.setRetailer_msisdn(retailer_msisdn);
////		json.setTxn_type(txn_type);
////		json.setAadhaarId(aadhaarId);
////		json.setAadhaar_timestamp(aadhaar_timestamp);
////		json.setBiometric_data(biometric_data);
////		json.setSkey(skey);
////		json.setHmac(hmac);
////		json.setPan(pan);
////		StringWriter sw = new StringWriter();
////		JAXB.marshal(json, sw);
////		System.out.println("1111111111111111");
////		String xmlString = sw.toString(); 
////		System.out.println("@@@@@@@@@@@@@@");
////		System.out.println("@@@@@@@@@@@@@@");
////		System.out.println("@@@@@@@@@@@@@@");
////		System.out.println(xmlString);
////		return xmlString;
////	}
//	
//	public Response getResponseFromAPI(String myjson) {
//		return getResponseFromAPIUnencrypted(myjson, url);
//	}	
//}

//public void test() {
//	Stub s = new Stub();
//	ebmheader e = new ebmheader();
//	e.setid();
//	e.setvapadfa();
//	s.seteh
//}
