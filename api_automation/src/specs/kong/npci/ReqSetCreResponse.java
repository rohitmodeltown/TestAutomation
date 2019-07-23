package specs.kong.npci;

import java.util.Hashtable;

import javax.xml.bind.JAXBException;

import org.testng.annotations.Test;

import helpers.kong.npci.NPCI;
import helpers.kong.npci.Helper;


public class ReqSetCreResponse extends Helper{
	
	@Test(dataProvider="dp")
	public void reqSetCreResponse(Hashtable<String, String>data) throws JAXBException
	{
		NPCI npci = new NPCI();
		String api=data.get("api");
		npci.reqSetCre(data,api);
		
	}

}
