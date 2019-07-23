package helpers;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.gson.Gson;

import Util.Encrypt;
import helpers.gateway.phonePE.PhonepeJson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GlobalHelper {
//	String dataServiceBaseUrl =  "https://apbuat.airtelbank.com/dataService/";
	String dataServiceBaseUrl =  "http://10.56.110.174:5050/dataService/";
	public String dbConfigPath = "./resources/config/db.properties";
	public String configPath = "./resources/config/config.properties";
	public String contentTypeJson = "application/json";
	public String contentTypeXml = "text/xml";
	public String contentTypeUrlEncoded = "application/x-www-form-urlencoded";
	

	private Connection con = null;
	private Statement stmt = null;

	// Extent Manager reporting
	/** --------------------EXTENT REPORT CODE - START-------------------- */

	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLog = new ThreadLocal<ExtentTest>();
	public Map<String, ExtentTest> map = new HashMap<String, ExtentTest>();

	@BeforeSuite
	public void setup() {
		extent = ExtentManager.GetExtent();
	}

	@BeforeClass
	public void beforeClass() {
		String className = getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1);
		ExtentTest parent = extent.createTest(className);
		parentTest.set(parent);

	}

	@AfterMethod
	public void afterMethod() {
		extent.flush();
	}

	@AfterSuite
	public void cleanUp() {
		// cleanup code goes here
	}

	/** --------------------EXTENT REPORT CODE - ENDS -------------------- */

	public static String[][] readFromExcel(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook myWB = new XSSFWorkbook(inputStream);
		Sheet sheet = myWB.getSheet(sheetName);
		System.out.println("las row num: " + sheet.getLastRowNum());
		System.out.println("first row: " + sheet.getFirstRowNum());
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		String[][] excel = new String[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				excel[i][j] = row.getCell(j).toString();
			}
		}
		myWB.close();
		return excel;
	}

	public Response getResponseFromAPIUnencrypted(String myjson, String url, String contentType) {
		System.out.println("--------------------REQUEST------------------");
		Response response = given().contentType(contentType).body(myjson).log().all().when().post(url).then().extract()
				.response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}

	// Merge me with getResponseFromAPIUnencrypted
	public Response getResponseFromAPIUnencryptedXML(String myjson, String url, String contentType) {
		System.out.println("4444444444444444");
		System.out.println("--------------------REQUEST------------------");
		Response response = given().contentType(contentType).body(myjson).log().all().when().post(url).then().extract()
				.response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}

	public String encHashSha512(String hash) {
		String hash1 = "";
		Encrypt e = new Encrypt();
		try {
			hash1 = e.generateSha512Hash(hash);
			System.out.println("Generated SHA 512 Hash:" + hash);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return hash1;
	}

	public Response getResponseFromAPIEncrypted(String myjson, String url, String contentType) throws Exception {
		String[] enc_data = Encrypt.encrypt(myjson);
		System.out.println("--------------------REQUEST------------------");
		Response response = given().formParam("data", enc_data[0]).formParam("key", enc_data[1]).log().all().when()
				.post(url).then().extract().response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}

	public Response getResponseFromAPIEncryptedWithHeader(String myjson, String url, String headerName,
			String headerValue, String contentType) throws Exception {
		String[] enc_data = Encrypt.encrypt(myjson);
		System.out.println("--------------------REQUEST------------------");
		Response response = given().formParam("data", enc_data[0]).formParam("key", enc_data[1]).log().all()
				.header(headerName, headerValue).when().post(url).then().extract().response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}

	public Response getResponseFromAPIUnencryptedWithHeader(String myjson, String url, String headerName,
			String headerValue, String contentType) {
		System.out.println("--------------------REQUEST------------------");
		Response response = given().contentType(contentType).body(myjson).log().all().header(headerName, headerValue)
				.when().post(url).then().extract().response();
		System.out.println("----------------------RESPONSE------------------");
		System.out.println(response.asString());
		return response;
	}

	// Method to return tag value from API response
	public String getTagValueFromApiResponse(Response response, String tagName) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String tagValue = jsonPathEvaluator.get(tagName);
		return tagValue;
	}

	// Method to return value from Properties file
	public String readFromPropertiesFile(String fileName, String propertyName) {
		String propertyValue = null;
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(fileName);

			// load a properties file
			prop.load(input);

			// get the property value
			propertyValue = prop.getProperty(propertyName);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return propertyValue;
	}

	public void updateDataInOracleDb(String query, String serverName) throws IOException {
		// try {
		// JDBCStatementUpdateExample.updateRecordIntoDbUserTable(query);
		// } catch (SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		System.out.println(query);
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to a selected database...");
			HashMap<String, String> dbDetails = getDbCredentials(serverName);
			String connectionString = String.format("jdbc:oracle:thin:@%s:%s:%s", dbDetails.get("URL"),
					dbDetails.get("PORT"), dbDetails.get("SERVICENAME"));
			System.out.println("connection String : " + connectionString);
			con = DriverManager.getConnection(connectionString, dbDetails.get("USERNAME"), dbDetails.get("PASSWORD"));
			stmt = con.prepareStatement(query);
			System.out.println("Executing query...");
			stmt.executeUpdate(query);
			System.out.println("Query execution done...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}

	public ResultSet getDatafromDB(String query, String serverName)
			throws ClassNotFoundException, SQLException, IOException {
		ResultSet response = null;
		System.out.println(query);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to a selected database...");
			con = null;
			HashMap<String, String> dbDetails = getDbCredentials(serverName);
			String connectionString = String.format("jdbc:oracle:thin:@%s:%s:%s", dbDetails.get("URL"),
					dbDetails.get("PORT"), dbDetails.get("SERVICENAME"));
			con = DriverManager.getConnection(connectionString, dbDetails.get("USERNAME"), dbDetails.get("PASSWORD"));
			stmt = con.createStatement();
			System.out.println("Executing query...");
			response = stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		
		return response;
	}

	public void updateSQLDB(String query, String project) throws ClassNotFoundException, IOException, SQLException {
		/*
		 * Class.forName("com.mysql.jdbc.Driver"); Connection con = null;
		 * HashMap<String, String> dbDetails = getDbCredentials(project); String
		 * connectionString = String.format("jdbc:mysql:@%s:%s:%s",
		 * dbDetails.get("URL"), dbDetails.get("PORT"), dbDetails.get("SERVICENAME"));
		 * con = DriverManager.getConnection(connectionString,dbDetails.get("USERNAME"),
		 * dbDetails.get("PASSWORD")); Statement stmt=con.createStatement(); ResultSet
		 * response=stmt.executeQuery(query);
		 */
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			con = DriverManager.getConnection("jdbc:mysql://10.56.110.170:3306/volt23?" + "user=root&password=root");
			Statement stmt = con.createStatement();
			int response = stmt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public String generateRandomNumber() {
		String number = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return number;
	}

	public HashMap<String, String> getDbCredentials(String serverName) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(dbConfigPath);
		prop.load(input);
		HashMap<String, String> dbDetails = new HashMap<String, String>();
		dbDetails.put("URL", prop.getProperty(serverName + ".URL"));
		dbDetails.put("PORT", prop.getProperty(serverName + ".PORT"));
		dbDetails.put("USERNAME", prop.getProperty(serverName + ".USERNAME"));
		dbDetails.put("PASSWORD", prop.getProperty(serverName + ".PASSWORD"));
		dbDetails.put("SERVICENAME", prop.getProperty(serverName + ".SERVICENAME"));
		return dbDetails;
	}

	public String generateRandomMobile() {
		return "98" + Integer.toString(ThreadLocalRandom.current().nextInt(10000000, 99999999));
	}

	public String getStringValueFromDb(String query, String server) throws ClassNotFoundException, SQLException, IOException {

		ResultSet rs = getDatafromDB(query, server);
		System.out.println("$$$$$$$$$$$$");
		System.out.println("Resultset : " + rs);
		String value = "test";
		try {

			if (rs.next()) {
				System.out.println("Inside next ....");
				value = rs.getString(1);
			}
		} finally {
			if (rs != null) {
				System.out.println("closing resultset....");
				rs.close();
			}
			
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
			
		}
		return value;
	}
	
	public String getSba(String mobile, String amount) {
		String url = dataServiceBaseUrl+"createBankCust";
		String response = given().contentType("application/json").body(getSbaRequest(mobile, amount)).log().all().when()
				.post(url).then().log().all().extract().response().asString();

		assertTrue(response.contains("\"ErrorCode\":1749"), "Data Service API failed: createBankCust");

		return response;
	}
	
	public String getSbaRequest(String mobile, String amount) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setMobile(mobile);
		json.setFciAmount(amount);
		return gson.toJson(json).toString();
		
	}
	
	public String getFky(String mobile, String amount) {
		String url = dataServiceBaseUrl+"createFky";
		String response = given().contentType("application/json").body(getFkyRequest(mobile, amount)).log().all().when()
				.post(url).then().log().all().extract().response().asString();

		assertTrue(response.contains("\"ErrorCode\":1749"), "Data Service API failed: createFky");

		return response;
	}
	
	public String getFkyRequest(String mobile, String amount) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setMobile(mobile);
		json.setFciAmount(amount);
		return gson.toJson(json).toString();
	}

	public String getLky(String mobile, Boolean isMKYC, String amount) {
		String url = dataServiceBaseUrl+"createWalletCust";

		String response = given().contentType("application/json").body(getLkyRequest(mobile, isMKYC, amount)).log().all().when()
				.post(url).then().log().all().extract().response().asString();

		assertTrue(response.contains("\"ErrorCode\":1749"), "Data Service API failed: createWalletCust");

		return response;
	}
	
	public String getLkyRequest(String mobile, Boolean isMKYC, String amount) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setMobile(mobile);
		json.setFciAmount(amount);
		if (false == isMKYC) {
			json.setPoiType("");
			json.setPoiNumber("");
		}
		return gson.toJson(json).toString();
	}

	public String updateBalance(String mobile, String amount) {
		String url = dataServiceBaseUrl+"updateBalance";

		String response = given().contentType("application/json").body(updateBalanceRequest(mobile, amount)).log().all()
				.when().post(url).then().log().all().extract().response().asString();
		
		assertTrue(response.contains("\"ErrorCode\":0"), "Data Service API failed: updateBalance");
		
		return response;
	}
	
	public String updateBalanceRequest(String mobile, String amount) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setMobile(mobile);
		json.setSegment("CUS");
		json.setAmount(amount);
		return gson.toJson(json).toString();
	}
	

	public String modifyCust(String mobile, String status) {
		String url = dataServiceBaseUrl+"modifyCustomer";

		String response = given().contentType("application/json").body(modifyCustRequest(mobile, status)).log().all()
				.when().post(url).then().log().all().extract().response().asString();

		// assertEquals(response.path("Response.TransactionStatus.ErrorCode"), "1749");

		return response;
	}

	public String modifyCustRequest(String mobile, String status) {
		Gson gson = new Gson();
		PhonepeJson json = new PhonepeJson();
		json.setMobile(mobile);
		json.setSegment("CUS");
		json.setAccountStatus(status);
		return gson.toJson(json).toString();
	}
	
}