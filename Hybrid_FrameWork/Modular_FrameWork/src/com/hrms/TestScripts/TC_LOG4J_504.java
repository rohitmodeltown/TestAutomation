package com.hrms.TestScripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.LIB.General;

public class TC_LOG4J_504 {
	@Test
	public void log4jlogin() throws Exception{
		DOMConfigurator.configure("Log4j.xml");
		General g=new General();
		g.openbrowser();
		g.login();
		g.title();
		g.text();
		g.closebrowser();
	}

}
