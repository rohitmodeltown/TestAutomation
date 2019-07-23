package helpers.volt.dynamicQr;

import helpers.GlobalHelper;

public class Helper extends GlobalHelper {
	public String optimusDomain = "http://10.5.247.53:7001/";
	public String optimusMobilityUrl = optimusDomain + "v1/services/919815602053?lineOfBusiness=Mobility";
	
	public String getOptimusUrl(String mobile, String lineOfBusiness) {
		String url = "";
		if ("Telemedia".equals(lineOfBusiness)) {
			url = optimusDomain + "v1/services/"+mobile+"?lineOfBusiness="+lineOfBusiness;
		} else if ("Mobility".equals(lineOfBusiness)) {
			url = optimusDomain + "v1/services/91"+mobile+"?lineOfBusiness="+lineOfBusiness;
		}
		return url;
	}
	
	public String getOptimusContextPath(String mobile, String lineOfBusiness) {
		String contextPath = "";
		if ("Telemedia".equals(lineOfBusiness)) {
			contextPath = "/v1/services/"+mobile+"?lineOfBusiness="+lineOfBusiness;
		} else if ("Mobility".equals(lineOfBusiness)) {
			contextPath = "/v1/services/91"+mobile+"?lineOfBusiness="+lineOfBusiness;
		}
		return contextPath;
	}
	
	public String getUrl(String vpa) {
		return "http://10.56.110.174:8083/apb/paymentAddressDetails/" + vpa;
	}
	
	public String getPassword(String feSessionId, String vpa, String salt) {
		return encHashSha512(feSessionId+"#"+vpa+"#"+salt);
	}
	
}
