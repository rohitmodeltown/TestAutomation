package helpers.gateway.onboarding;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

import helpers.MyJson;
import io.restassured.response.Response;

public class VerifyCustInitPartnerHelper extends Helper {

	public String url = baseUrl + "verifyCustInit.action";
	public String VERIFYCUSTINIT_EXCEL_PATH = readFromPropertiesFile(onboardingConfig, "VERIFYCUSTINIT_EXCEL_PATH");
	
	@DataProvider
	public String[][] successData() throws IOException {
		String[][] data = readFromExcel( VERIFYCUSTINIT_EXCEL_PATH , "successOnboarding");
		return data;
	}
	
	public String generateJSON(String customerId, String channel, String mode, String partnerId) {
		Gson gson = new Gson();
		MyJson json = new MyJson();
		json.setVer("1.0");
		json.setFeSessionId();
		json.setLanguageId("001");
		json.setChannel(channel);
		json.setCustomerId(customerId);
		json.setMode(mode);
		json.setPartnerId(partnerId);
		return gson.toJson(json).toString();
	}
	
	public Response getResponseFromAPI(String myjson) {
		return getResponseFromAPIUnencrypted(myjson, url, contentTypeJson);
	}	
}
