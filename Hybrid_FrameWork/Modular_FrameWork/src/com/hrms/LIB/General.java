package com.hrms.LIB;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utility.Log;

public class General extends Global{
	@BeforeClass
	public void openbrowser(){
		Log.info("**********STARTED EXECUTION**********");
		driver=new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		Log.info("Application Opened Successfully");
	}
	public void title(){
		driver.getTitle().equals(lnk_Title);
		System.out.println("Title: "+driver.getTitle());
	}
	public void text(){
		assertTrue(driver.findElement(By.linkText(lnk_Txt)).getText().matches("Welcome Admin"));
	}
	@AfterClass
	public void closebrowser(){
		driver.close();
		Log.info("Application closed sucessfully");
		Log.info("*********END EXECUTION************");
	}
	@Test
	public void login()throws Exception{
		driver.findElement(By.name(username)).sendKeys(un);
		driver.findElement(By.name(password)).sendKeys(pw);
		driver.findElement(By.name(btnlogin)).click();
		System.out.println("Login Completed");
		Thread.sleep(3000);
	}
	@Test
	public void addEmp()throws Exception{
		WebElement element=driver.findElement(By.linkText(pimmenu));
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstName")).sendKeys("Rama");
		driver.findElement(By.name("lastName")).sendKeys("Radhika");
		String empid=driver.findElement(By.name("employeeId")).getAttribute("value");
		System.out.println("Employee ID:"+empid);
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Saved Emp details..");
		Thread.sleep(2000);
	}
	@Test
	public void emplist() throws Exception{
		WebElement element1=driver.findElement(By.linkText(pimmenu));
		Actions ac1=new Actions(driver);
		ac1.moveToElement(element1).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Employee List")).click();
	}
	@Test
	public void empinfo()throws Exception{
		Select drpdwn=new Select(driver.findElement(By.xpath(Empinfo)));
		drpdwn.selectByIndex(3);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("dialogDeleteBtn")).click();
		System.out.println("Deleted Sucessfully");
	}
	/*public void empinfoAlert(){
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}*/
	@Test
	public void logout() throws Exception{
		driver.findElement(By.linkText(lnk_Txt)).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(link_logout)).click();
		System.out.println("Logout Completed");
		
	}
	}
