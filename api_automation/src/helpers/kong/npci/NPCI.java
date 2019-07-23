package helpers.kong.npci;

import static io.restassured.RestAssured.given;
import java.util.Hashtable;
import javax.xml.bind.JAXBException;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class NPCI extends Helper {
	
	public static String responsecode;
	
	public void reqOtp(Hashtable<String, String> data,String api) throws JAXBException
	{
		CreateXml createXMLObj = new CreateXml();		
		String reqBody = createXMLObj.createXML(data,api);
		System.out.println("=============================================== REQUEST ============================================  ");
		System.out.println(reqBody);
		String txnid=genrateRandomNumber();
		String url = baseUrl+"ReqOtp/1.0/urn:txnid:"+txnid;
		
		Response response = given().contentType(ContentType.XML).body(reqBody).post(url);
		String respStr = response.body().asString();
		System.out.println("=============================================== RESPONSE ============================================  ");
		System.out.println(respStr);
		
		
		
	}
	
	
	public void reqSetCre(Hashtable<String, String> data,String api)throws JAXBException
	{
		CreateXml createXMLObj = new CreateXml();		
		String reqBody = createXMLObj.createXML(data,api);
		System.out.println("=============================================== REQUEST ============================================  ");
		System.out.println(reqBody);
				
		String txnid=genrateRandomNumber();
		String url = baseUrl+"ReqSetCre/1.0/urn:txnid:"+txnid;
		Response response = given().contentType(ContentType.XML).body(reqBody).post(url);				
		String respStr = response.body().asString();		
		System.out.println("=============================================== RESPONSE ============================================  ");
		System.out.println(respStr);
		
		
		
	}

	
	public void reqBalEnq(Hashtable<String, String> data,String api)throws JAXBException
	{
		CreateXml createXMLObj = new CreateXml();		
		String reqBody = createXMLObj.createXML(data,api);
		System.out.println("=============================================== REQUEST ============================================  ");
		System.out.println(reqBody);
		String txnid=genrateRandomNumber();
		String url = baseUrl+"ReqBalEnq/1.0/urn:txnid:"+txnid;		
		Response response = given().contentType(ContentType.XML).body(reqBody).post(url);				
		String respStr = response.body().asString();
		System.out.println("==========================================RESPONSE========================================");
		System.out.println(respStr);
				
		
		
	}
	
	public void reqListAccount(Hashtable<String, String> data,String api)throws JAXBException
	{
		
		CreateXml createXMLObj = new CreateXml();
		
		
		String reqBody = createXMLObj.createXML(data,api);
		System.out.println("=============================================== REQUEST ============================================  ");
		System.out.println(reqBody);
		
		String txnid=genrateRandomNumber();
		String url = baseUrl+"ReqListAccount/1.0/urn:txnid:"+txnid;
		Response response = given().contentType(ContentType.XML).body(reqBody).post(url);				
		
		String respStr = response.body().asString();
		
		System.out.println("=============================================== RESPONSE ============================================  ");
		System.out.println(respStr);
		
	}
	
	public void reqHbt(Hashtable<String, String> data,String api)throws JAXBException
	{
		
		CreateXml createXMLObj = new CreateXml();
		
		String reqBody = createXMLObj.createXML(data,api);
		System.out.println("=============================================== REQUEST ============================================  ");
		System.out.println(reqBody);
		
		String txnid=genrateRandomNumber();
		String url = baseUrl+"ReqHbt/1.0/urn:txnid:"+txnid;
		Response response = given().contentType(ContentType.XML).body(reqBody).post(url);				
		
		String respStr = response.body().asString();
		System.out.println("=============================================== RESPONSE ============================================  ");
		System.out.println(respStr);
		
	}
}
