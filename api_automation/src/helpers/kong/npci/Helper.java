package helpers.kong.npci;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import helpers.GlobalHelper;


public class Helper extends GlobalHelper {
	
	public String upiConfigFile = "./resources/upiConfig/config.properties";
	public String baseUrl =  readFromPropertiesFile(configPath, "NPCI.UPI.BASEURL");
	public String npci_UPI_EXCEL_PATH = readFromPropertiesFile(upiConfigFile, "NPCI_UPI_EXCEL_PATH");	
	public static ExcelReader excel = new ExcelReader("./src/testDataSheets/kong/npci/ReqOtp.xlsx");
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> parentTest= new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLog = new ThreadLocal<ExtentTest>();	
	public Map<String, ExtentTest> map = new HashMap<String, ExtentTest>();
	
	@BeforeSuite
	public void setUp()
	{
		//setWorkingDirectory (System.getProperty("user.dir"));
		extent = ExtentManager.GetExtent();			
	}
	
	@BeforeClass
	public void beforeClass()
	{
		String className = getClass().getName();
		className = className.substring(className.lastIndexOf(".")+1);
		ExtentTest parent = extent.createTest(className);
		parentTest.set(parent);
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		/*ExtentTest child = parentTest.get().createNode(method.getName());
		testLog.set(child);
		testLog.get().log(Status.INFO, "Execution of "+method.getName()+ " started");*/
				
	}
	
	@AfterMethod
	public void afterMethod()
	{
		extent.flush();
	}
	
	@AfterSuite
	public void afterSuite()
	{	
	}
	
	public void assertStatusCode(int statusCode, String expectedStatusCode)
	{
		String expectedcode = expectedStatusCode.split(".")[0];
		Assert.assertEquals(Integer.toString(statusCode), expectedcode);
	}
	
	public String getExpStatusCode(String expectedcode) 
	{
		return expectedcode.substring(0, expectedcode.indexOf('.'));	
	}
	
	public void assignAuthor(String authorName)
	{
		testLog.get().assignAuthor(authorName);
	}
	
	public void assignCategory(String category)
	{
		testLog.get().assignCategory(category);
	}
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method method)
	{
		String sheetName = method.getName();		
		int rowCount = excel.getRowCount(sheetName);
		int columnCount = excel.getColumnCount(sheetName);		
		Object[][] data = new Object[rowCount-1][1];		
		Hashtable<String, String> table = null;
		for(int rowNum =2; rowNum<=rowCount; rowNum++)
		{
			table = new Hashtable<String, String>();
			for(int cellNum =0; cellNum<columnCount; cellNum++)
			{
				table.put(excel.getCellData(sheetName, cellNum, 1), excel.getCellData(sheetName, cellNum, rowNum));
				data[rowNum-2][0]= table; 	
			}
		}			
		//System.out.println(data);
		return data;
		
	}
	
	public static String genrateRandomNumber() {
		String number = Integer.toString(ThreadLocalRandom.current().nextInt(11111111, 99999999));
		return number;

	}

}
