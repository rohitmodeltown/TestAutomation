package helpers.gateway.payments.retailerPortal;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

public class LoginPageHelper extends Helper {
	
	public String generateTokenAction = readFromPropertiesFile(actionPropertiesFileLocation, "generateTokenAction");
	public String loginAction = readFromPropertiesFile(actionPropertiesFileLocation, "loginAction");
	public String loginUserExcelPath = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "generateTokenDataFileName");
	public String loginUserSheetName = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "generateTokenDataSheetName");
	
	RetailerPortalJson json = new RetailerPortalJson();
	Gson gson = new Gson();
	

	@DataProvider
	public String[][] generateTokenData() throws IOException {
		String[][] data = readFromExcel(loginUserExcelPath, loginUserSheetName);
		return data;
	}	
	
	public String generateTokenJSON(String actorId, String actorType, String jwtExpiry,String ver) {
		json.setFeSessionId();
		json.setVer(ver);
		json.setActorId(actorId);
		json.setActorType(actorType);
		json.setJwtExpiry(jwtExpiry);
		return gson.toJson(json).toString();
	}
	
	public String generateLoginJSON(String retailerId, String password) {
		Gson gson = new Gson();
		json.setVer("1.0");
		json.setFeSessionId();
		json.setLanguageId("001");
		json.setCustomerId(retailerId);
		json.setPassword(password);
		return gson.toJson(json).toString();
	}

}
