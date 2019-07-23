package com.hrms.LIB;

import org.openqa.selenium.WebDriver;

public class Global {
	//Variables info
public WebDriver driver;
public String url="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
public String un="Admin";
public String pw="admin123";
public String lnk_Title="OrangeHRM";
public String lnk_Txt="Welcome Admin";
	//Objects
public String username="txtUsername";
public String password="txtPassword";
public String btnlogin="Submit";
public String link_logout="Logout";
public String pimmenu="PIM";
public String EmpList="Employee List";
public String Empinfo="//*[@id='empsearch_employee_status']";
}
