package com.common;

import org.apache.log4j.Logger;

/**
 * @author A1SKIVA4
 *
 */


import org.apache.log4j.xml.DOMConfigurator;

public class Log4j {
	 
	 
	 private static Logger Log = Logger.getLogger(Log4j.class.getName());
	 

//This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	public static void startTestCase(String sTestCaseName) {

		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");

		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$             " + sTestCaseName + "           $$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");

	}

//This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

	

	}

// Need to create these methods, so that they can be called  

	public static void info(String message) {

		Log.info(message);

	}

	public static void error(String message) {
		// TODO Auto-generated method stub
		Log.info(message);

	}
	
	public static void success(String message) {
		
		Log.info(message);
		Log.getName();
	}
	
	

}
