package helpers.gateway.payments.retailerPortal;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class RetailerImpsPaymentsHelper  extends Helper{
	
	public String successImpsExcelPath = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "impsDataFileName");
	public String successImpsSheetname = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "impsDataSheetName");
	
	@DataProvider
	public String[][] impsSuccessData() throws IOException {
		String[][] data = readFromExcel(successImpsExcelPath,successImpsSheetname);
		return data;
	}	

}
