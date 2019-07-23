package helpers.gateway.payments.retailerPortal;


import helpers.GlobalHelper;

public class Helper extends GlobalHelper {	
	
	public String actionPropertiesFileLocation = "./resources/payments/retailerPortal/actions.properties";
	public String retailerPortalPropertiesFileLocation = "./resources/payments/retailerPortal/retailerPortal.properties";
	
	public String baseUrl = readFromPropertiesFile(configPath, "REMITTANCE.BASEURL");
	public String tokenHeaderName = readFromPropertiesFile(retailerPortalPropertiesFileLocation, "tokenHeaderName");
}
