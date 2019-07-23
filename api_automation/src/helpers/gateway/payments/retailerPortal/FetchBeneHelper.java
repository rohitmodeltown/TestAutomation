package helpers.gateway.payments.retailerPortal;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

public class FetchBeneHelper extends Helper {
	RetailerPortalJson json = new RetailerPortalJson();
	Gson gson = new Gson();

	public String fetchFavouriteAction = readFromPropertiesFile(actionPropertiesFileLocation, "fetchFavouriteAction");
	public String fetchBeneExcelPath = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "fetchFavouriteDataFileName");
	public String fetchBeneSheetName = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "fetchFavouriteDataSheetName");
	
	
	@DataProvider
	public String[][] fetchFavouiteData() throws IOException {
		String[][] data = readFromExcel(fetchBeneExcelPath, fetchBeneSheetName);
		return data;
	}
	
	public String fetchFavouriteJSON(String channel, String customerId, String appVersion, 
			String languageId, String mode, String ver, String category) {
	    json.setFeSessionId();
		json.setChannel(channel);;
		json.setCustomerId(customerId);
		json.setAppVersion(appVersion);
		json.setFavoriteId("");
		json.setLanguageId(languageId);
		json.setCategory(category);
		json.setSignature("");
		json.setMode(mode);
		json.setVer(ver);
		json.setCount("");
		return gson.toJson(json).toString();
	}

}
