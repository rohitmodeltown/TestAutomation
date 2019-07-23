package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import com.hrms.LIB.General;

public class TC_hrms_104_TestNG {
	@Test(description="Orange HRM Login and Employee Info")
	public void TC_104() throws Exception{
		DOMConfigurator.configure("Log4j.xml");
		General g=new General();
		g.openbrowser();
		g.login();
		g.title();
		g.text();
		g.addEmp();
		g.emplist();
		g.empinfo();
		g.logout();
		g.closebrowser();
		
	}
}
