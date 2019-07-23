package helpers;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static String filePath = "./API_extentreport.html";
	public static String upiConfigFile = "./resources/upiConfig";

/*
	public static ExtentReports GetExtent() {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());			
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}*/
	
	 public static ExtentReports GetExtent() {
	    	if (extent == null)
	    		createInstance("test-output/extent.html");
	    	
	        return extent;
	    }

	 
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig(upiConfigFile+"/extent-config.xml");
		
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);        
        return extent;
    }
}

