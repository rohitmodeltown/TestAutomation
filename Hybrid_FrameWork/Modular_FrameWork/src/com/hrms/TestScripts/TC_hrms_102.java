package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.LIB.General;

public class TC_hrms_102 {
	//public static void main(String as[]) throws Exception {
		@Test(groups="Regression")
		public void TC_2() throws Exception{
			DOMConfigurator.configure("Log4j.xml");
		General g=new General();
		g.openbrowser();
		g.login();
		g.title();
		g.text();
		//g.addEmp();
		g.logout();
		g.closebrowser();
	}

}
