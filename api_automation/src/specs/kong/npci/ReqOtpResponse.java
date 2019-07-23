package specs.kong.npci;

import java.util.Hashtable;

import javax.xml.bind.JAXBException;

import org.testng.annotations.Test;

import helpers.kong.npci.NPCI;
import helpers.kong.npci.Helper;



public class ReqOtpResponse extends Helper{
	
	@Test(dataProvider="dp")
	public void reqOtpResponse(Hashtable<String, String>data) throws JAXBException
	{
		NPCI npci = new NPCI();
		String api=data.get("api");
		npci.reqOtp(data, api);
		
		//Assert.assertEquals(reqOtpApis.responsecode, "200");		
		//Assert.assertEquals(reqOtpApis.responsecode, data.get("expectedErrorCode"));
		
	}
	
	
	

}
