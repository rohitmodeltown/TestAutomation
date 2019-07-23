package specs.volt.dynamicQr;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import com.aerospike.client.Bin;
import com.aerospike.client.Record;

import helpers.Aspike;
import helpers.volt.dynamicQr.Helper;

public class Val extends Helper {
	public String vpa;
	public String vpaNotRegisteredMobile;
	public String vpaNonAirtelMobile;
	public String mobile;
	public String salt;
	public String contentType;
	public String channel;
	public String reqType;
	public String userName;
	public String nameSpace;
	public String setName1;
	public String setName2;
	public String circleCode;
	public String mccCode;
	public String classBinName;
	public String feSessionId;

	public Bin bin1;
	public Bin bin2;
	public Bin bin3;
	public Bin bin4;
	public Bin bin5;
	public Bin bin6;

	@BeforeMethod
	public void initializeValues() {
		vpa = "9815602053.POST@apbl";
		vpaNotRegisteredMobile = "8586903212.POST@apbl";
		vpaNonAirtelMobile = "8368039164.POST@apbl";
		mobile = "9928454369";
		salt = "apb";
		contentType = "application/v1+json";
		channel = "API";
		reqType = "VAL";
		userName = "mobileware";
		nameSpace = "test";
		setName1 = "UPICustBillDetails";
		setName2 = "UPIPartnerBillerDetails";
		circleCode = "Delhi";
		mccCode = "6012";
		classBinName = "com.airtelbank.upi.qr.entity.UPICustBillDetails";
		feSessionId = generateRandomNumber();

		bin1 = new Bin("@user_key", vpa);
		bin2 = new Bin("vpa", vpa);
		bin3 = new Bin("@_class", classBinName);
		bin4 = new Bin("circleCode", circleCode);
		bin5 = new Bin("mccCode", mccCode);
		bin6 = new Bin("beneAccNo", mobile);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	  System.out.println("THE TEST JUST RUN WAS : " + this.getClass().getName() + "." +result.getMethod().getMethodName());
	  System.out.println("____________________________________________________________________________");
	  System.out.println("____________________________________________________________________________");
	}

	@Test
	public void firstTimeCustomerSuccessTest() throws InterruptedException {
		// delete record for new customer
		(new Aspike(nameSpace, setName1, vpa)).deleteRecord();

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors"), null);
		assertEquals(response.path("meta.errorCode"), "000");
		assertEquals(response.path("meta.description"), "SUCCESS");
		assertEquals(response.path("meta.code"), 0);
		assertEquals(response.path("data.virtualAddress"), vpa);
		assertEquals(response.path("data.maskName"), "Airtel");

		// Aerospike Assersions
		Record rec = (new Aspike(nameSpace, setName1, vpa)).getRecord();
		assertEquals(rec.bins.get("vpa"), vpa);
		assertEquals(rec.bins.get("@user_key"), vpa);
		assertEquals(rec.bins.get("@_class"), classBinName);
		assertEquals(rec.bins.get("circleCode"), circleCode);

	}

	@Test
	public void repeatCustomerSuccessTest() {
		// insert record for customer
		(new Aspike(nameSpace, setName1, vpa)).insertRecord(bin1, bin2, bin3, bin4);

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors"), null);
		assertEquals(response.path("meta.errorCode"), "000");
		assertEquals(response.path("meta.description"), "SUCCESS");
		assertEquals(response.path("meta.code"), 0);
		assertEquals(response.path("data.virtualAddress"), vpa);
		assertEquals(response.path("data.maskName"), "Airtel");

		// Aerospike Assersions
		Record rec = (new Aspike(nameSpace, setName1, vpa)).getRecord();
		assertEquals(rec.bins.get("vpa"), vpa);
		assertEquals(rec.bins.get("@user_key"), vpa);
		assertEquals(rec.bins.get("@_class"), classBinName);
		assertEquals(rec.bins.get("circleCode"), circleCode);

	}
	
	@Test
	public void blankPasswordInHeaderTest() {

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", "")
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();
		
		assertEquals(response.path("meta.errors[0].field"), "PASSWORD");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Password is incorrect");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.code"), 1);

	}
	
	@Test
	public void invalidPasswordInHeaderTest() {
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", "INVALID")
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();
		
		assertEquals(response.path("meta.errors[0].field"), "PASSWORD");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Password is incorrect");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.code"), 1);

	}
	
	@Test
	public void blankUsernameInHeaderTest() {
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", "").contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();
		
		assertEquals(response.path("meta.errors[0].field"), "username");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void usernameNotPresentInHeaderTest() {
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();
		
		assertEquals(response.path("meta.errors[0].field"), "username");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Mandatory header is missing in request");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void customerMobileNotRegisteredTest() throws InterruptedException {
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpaNotRegisteredMobile, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpaNotRegisteredMobile)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors"), null);
		assertEquals(response.path("meta.errorCode"), "MUP003");
		assertEquals(response.path("meta.description"), "Invalid VPA");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void customerMobileNotAirtelTest() throws InterruptedException {
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpaNonAirtelMobile, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpaNonAirtelMobile)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors"), null);
		assertEquals(response.path("meta.errorCode"), "MUP003");
		assertEquals(response.path("meta.description"), "Invalid VPA");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidPartnerAbbreviationTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		vpa = "9928454369.tt@apbl";

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "validateVPA.arg0");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid VPA");
		assertEquals(response.path("meta.errorCode"), "MUP002");
		assertEquals(response.path("meta.description"), "Invalid VPA Format. Regex not valid");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidHandleInVPATest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		vpa = "9928454369.POST@testhandle";

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "validateVPA.arg0");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid VPA");
		assertEquals(response.path("meta.errorCode"), "MUP002");
		assertEquals(response.path("meta.description"), "Invalid VPA Format. Regex not valid");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidFormatOfVPATest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		vpa = "9928454369.ppapbl";

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "validateVPA.arg0");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid VPA");
		assertEquals(response.path("meta.errorCode"), "MUP002");
		assertEquals(response.path("meta.description"), "Invalid VPA Format. Regex not valid");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidSaltTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		salt = "test";

		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "PASSWORD");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Password is incorrect");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidChannelTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		channel = "INVALID";
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "channel");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void channelNotPresentInHeaderTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		Response response = given().header("feSessionid", feSessionId)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "channel");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Mandatory header is missing in request");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void blankChannelTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		channel = "";
		Response response = given().header("feSessionid", feSessionId).header("channel", channel)
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt))
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "channel");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void feSessionIdNotPresentInHeaderTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		
		Response response = given()
				.header("reqType", reqType).header("password", getPassword(feSessionId, vpa, salt)).header("channel", channel)
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "fesessionid");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Mandatory header is missing in request");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	
	@Test
	public void blankFeSessionIdTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		feSessionId = "";
		Response response = given()
				.header("reqType", reqType).header("feSessionid", feSessionId).header("password", getPassword(feSessionId, vpa, salt)).header("channel", channel)
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "fesessionid");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value. Length Should be between 1-20");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidFeSessionIdTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		feSessionId = "77777777777777777777777777777777777777777777777777788898989898999999999999999999";
		Response response = given()
				.header("reqType", reqType).header("feSessionid", feSessionId).header("password", getPassword(feSessionId, vpa, salt)).header("channel", channel)
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "fesessionid");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value. Length Should be between 1-20");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void blankReqTypeTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		reqType = "";
		Response response = given()
				.header("reqType", reqType).header("feSessionid", feSessionId).header("password", getPassword(feSessionId, vpa, salt)).header("channel", channel)
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "reqtype");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void invalidReqTypeTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		reqType = "invalid";
		Response response = given()
				.header("reqType", reqType).header("feSessionid", feSessionId).header("password", getPassword(feSessionId, vpa, salt)).header("channel", channel)
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "reqtype");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Invalid header value");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
	@Test
	public void reqTypeNotPresentTest() throws InterruptedException {
		// abbreviation other than pp or fl is invalid
		Response response = given()
				.header("feSessionid", feSessionId).header("password", getPassword(feSessionId, vpa, salt)).header("channel", channel)
				.header("username", userName).contentType(contentType).log().all().when().get(getUrl(vpa)).then().log()
				.all().extract().response();

		assertEquals(response.path("meta.errors[0].field"), "reqtype");
		assertEquals(response.path("meta.errors[0].errorMessage"), "Mandatory header is missing in request");
		assertEquals(response.path("meta.errorCode"), "MUP001");
		assertEquals(response.path("meta.description"), "Invalid Request Format");
		assertEquals(response.path("meta.code"), 1);
	}
	
}
