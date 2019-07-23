/**
 * 
 */
package utility;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author A1SKIVA4
 *
 */
public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			// Set HTML reporting file location
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "\\ExtentReportResults.html", true);
		}
		return extent;
	}
}
