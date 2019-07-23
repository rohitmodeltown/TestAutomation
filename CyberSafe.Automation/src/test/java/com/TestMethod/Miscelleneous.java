package com.TestMethod;

import org.testng.annotations.*;

import com.constant.TestConstant;
import com.report.Log;
import com.ui.page.LoginAndLogout;

public class Miscelleneous {
	
	@Test
	public void url_Spilt() throws Exception {
		
		LoginAndLogout.openBrowser();
		
		String currentURL = TestConstant.driver.getCurrentUrl();
		
		for (String splitURL : currentURL.split("/"))
		{
		for(String value : splitURL.split("&"))
		{
		for	(String pair : value.split("="))
		{
		System.out.println(pair);
		
	
		
		
		}
		}
		}
		
	}

}
	

