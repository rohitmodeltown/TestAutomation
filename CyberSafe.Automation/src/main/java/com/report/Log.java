package com.report;

import java.util.logging.Logger;

//TODO: Auto-generated Javadoc
/**
* The Class Log.
*/
public class Log {
	
	//Initialize Log4j logs
	 
 /** The Log. */
	private static Logger Log = Logger.getLogger(Log.class.getName()); 

//This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

/**
* Start test case.
*
* @param sTestCaseName the s test case name
*/
public static void startTestCase(String sTestCaseName){

Log.info("****************************************************************************************");

Log.info("****************************************************************************************");

Log.info("$$$$$$$$$$$$$$$$$$$$$             "+sTestCaseName+ "           $$$$$$$$$$$$$$$$$$$$$$$$$");

Log.info("****************************************************************************************");

Log.info("****************************************************************************************");

}

//This is to print log for the ending of the test case

/**
 * End test case.
 *
 * @param sTestCaseName the s test case name
 */
public static void endTestCase(String sTestCaseName){

Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

Log.info("X");

Log.info("X");

Log.info("X");

Log.info("X");

}

// Need to create these methods, so that they can be called  

/**
 * Info.
 *
 * @param message the message
 */
public static void info(String message) {

    Log.info(message);

    }

public static void error(String message) {
	// TODO Auto-generated method stub
	Log.info(message);

}


}
