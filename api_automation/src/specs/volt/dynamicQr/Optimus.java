package specs.volt.dynamicQr;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.volt.dynamicQr.Helper;
import io.restassured.response.Response;

// Automation of Optimus API
public class Optimus extends Helper {

	public String subscribercode;
	public String lobMobility;
	public String lobTelemedia;
	public String prepaidMobile;
	public String postpaidMobile;
	public String landlineNumber;
	public String nonAirtelMobileNo;
	public String notRegisteredAirtelPrepaidMobile;
	public String notRegisteredAirtelPostpaidMobile;
	public String notRegisteredLandlineNo;
	
	@BeforeMethod
	public void initializeValues() {
		subscribercode = "8E4B1B9562811CA1FF4B87FA1BCFBD18A556C46B66F7DAE79E23C4075C5AA9A1";
		lobMobility = "Mobility";
		postpaidMobile = "9815602053";
		prepaidMobile = "9928454369";
		landlineNumber = "01244007922";
		nonAirtelMobileNo = "8368039164";
		notRegisteredAirtelPrepaidMobile = "9717089271";
		notRegisteredAirtelPostpaidMobile = "8586903212";
		notRegisteredLandlineNo = "01296270692";
		lobTelemedia = "Telemedia";
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println(
				"THE TEST JUST RUN WAS : " + this.getClass().getName() + "." + result.getMethod().getMethodName());
		System.out.println("____________________________________________________________________________");
		System.out.println("____________________________________________________________________________");
	}

	@Test
	public void successForPrepaidTest() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(prepaidMobile, lobMobility)).then().log().all().extract().response();

		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "Success");
		assertNotNull("params.requestId");
		assertEquals(response.path("params.uri"), getOptimusContextPath(prepaidMobile, lobMobility));
		assertEquals(response.path("services[0].si"), "91" + prepaidMobile);
		assertEquals(response.path("services[0].circle"), "Rajasthan");
		assertEquals(response.path("services[0].si_lob"), "PREPAID");
		assertNotNull(response.path("services[0].devices"));
	}

	@Test
	public void successForPostpaidTest() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(postpaidMobile, lobMobility)).then().log().all().extract().response();

		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "Success");
		assertNotNull("params.requestId");
		assertEquals(response.path("params.uri"), getOptimusContextPath(postpaidMobile, lobMobility));
		assertEquals(response.path("services[0].si"), "91" + postpaidMobile);
		assertEquals(response.path("services[0].circle"), "Delhi");
		assertEquals(response.path("services[0].si_lob"), "POSTPAID");
		assertNotNull(response.path("services[0].devices"));
	}

	@Test
	public void successForFixedLineTest() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(landlineNumber, lobTelemedia)).then().log().all().extract().response();
		
		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "Success");
		assertNotNull("params.requestId");
		assertEquals(response.path("params.uri"), getOptimusContextPath(landlineNumber, lobMobility));
		assertEquals(response.path("services[0].si"), landlineNumber);
		assertEquals(response.path("services[0].circle"), "Delhi");
		assertEquals(response.path("services[0].si_lob"), "FLVOICE");
		assertNotNull(response.path("services[0].devices"));
	}
	
	@Test
	public void failureNonAirtelMobileTest() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(nonAirtelMobileNo, lobMobility)).then().log().all().extract().response();
		
		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "No data found");
		assertNotNull(response.path("params.requestId"));
		assertEquals(response.path("params.uri"), getOptimusContextPath(nonAirtelMobileNo, lobMobility));
	}

	@Test
	public void failureInvalidMobileTest() {
		String invalidMobile = "876567";
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(invalidMobile, lobMobility)).then().log().all().extract().response();
		
		assertEquals(response.path("status_info.code"), "400");
		assertEquals(response.path("status_info.message"), "Generic Exception Invalid Msisdn Series format [Valid format: 91**********]");
		assertNotNull(response.path("params.requestId"));
		assertEquals(response.path("params.uri"), getOptimusContextPath(invalidMobile, lobMobility));
		assertNotNull(response.path("services"));
	}

	@Test
	public void failureAirtelPrepaidMobileNotRegisteredInOptimus() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(notRegisteredAirtelPrepaidMobile, lobMobility)).then().log().all().extract().response();
		
		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "No data found");
		assertNotNull(response.path("params.requestId"));
		assertEquals(response.path("params.uri"), getOptimusContextPath(notRegisteredAirtelPrepaidMobile, lobMobility));
	}

	@Test
	public void failureAirtelPostpaidMobileNotRegisteredInOptimus() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(notRegisteredAirtelPostpaidMobile, lobMobility)).then().log().all().extract().response();
		
		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "No data found");
		assertNotNull(response.path("params.requestId"));
		assertEquals(response.path("params.uri"), getOptimusContextPath(notRegisteredAirtelPostpaidMobile, lobMobility));
	}
	
	@Test
	public void failureAirtelLandlineNotRegisteredInOptimus() {
		Response response = given().header("subscribercode", subscribercode).log().all().when()
				.get(getOptimusUrl(notRegisteredLandlineNo, lobTelemedia)).then().log().all().extract().response();
		
		assertEquals(response.path("status_info.code"), "200");
		assertEquals(response.path("status_info.message"), "No data found");
		assertNotNull(response.path("params.requestId"));
		assertEquals(response.path("params.uri"), getOptimusContextPath(notRegisteredLandlineNo, lobTelemedia));
	}

}
