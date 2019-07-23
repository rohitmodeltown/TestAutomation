package helpers;

import java.io.IOException;
import java.util.Arrays; 

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentTestNGITestListener extends GlobalHelper implements ITestListener, ISuiteListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		 
		/*try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String exceptionMessage = Arrays.toString(arg0.getThrowable().getStackTrace());
		
		testCaseLogger.get().fail("<details>"+ "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see the execption"
				+ "</font>" + "</b>" + "</summary>" +exceptionMessage.replaceAll(",", "<br>")+"</details>"+"\n");
		
		try {
			testCaseLogger.get().fail("<b>"+"<font color=" +"red>" + "ScreenShot of failure"+"</font>"+"</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotPath, TestUtil.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//String exceptionMessage = Arrays.toString(arg0.getThrowable().getStackTrace());

		String exceptionMessage =arg0.getThrowable().getMessage()+"\n"+(Arrays.toString(arg0.getThrowable().getStackTrace()));
			testLog.get().fail("<details>"+ "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see the execption"
				+ "</font>" + "</b>" + "</summary>" +exceptionMessage.replaceAll(",", "<br>")+"</details>"+"\n");
		
		String failureLog ="This Test Case got Failed";
		Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
		testLog.get().log(Status.INFO, m);
		
	}

	public void onTestSkipped(ITestResult arg0) {
		

		String methodName = arg0.getMethod().getMethodName();
		
		String logText = "<b>"+"Test Case:- "+methodName+ " Passed"+ "/<b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		
		testLog.get().skip(m); 
		
		
	}

	public void onTestStart(ITestResult arg0) {
		
		String methodName = arg0.getMethod().getMethodName();
		
		ExtentTest child = parentTest.get().createNode(methodName);
		testLog.set(child);
		
		//testCaseLogger.get().log(Status.INFO, "Starting execution of Test Case:- "+methodName);
		
		testLog.get().info("<b>"+"Starting execution of Test Case:- "+methodName+ "/<b>");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		
		String methodName = arg0.getMethod().getMethodName();
		
		String logText = "<b>"+"Test Case:- " +methodName+ " Passed"+ "/<b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		testLog.get().pass(m);
		
		//extent.flush();
		
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}