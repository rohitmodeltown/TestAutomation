package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;

import com.hrms.LIB.General;

public class TC_hrms_103 {
	public void TC_3() throws Exception{
		DOMConfigurator.configure("Log4j.xml");
		General g=new General();
		g.openbrowser();
		g.login();
		g.title();
		g.text();
		g.emplist();
		g.empinfo();
		g.logout();
		g.closebrowser();
	}

}
