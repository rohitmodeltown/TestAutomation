package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.LIB.General;

public class TC_hrms_101 {
	//public static void main(String as[]) throws Exception{
	@Test(groups="Functional")
	public void TC_1() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		General g=new General();
		g.openbrowser();
		g.login();
		g.title();
		g.text();
		g.logout();
		g.closebrowser();
	}

}
