package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {
	
  @Test
  @Parameters({"TestDataSearch"})
  public void testParameter(@Optional("HCL Technologies") String TestDataSearch) {
	  
	  System.setProperty("webdriver.chrome.driver",
				"D:\\Software\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
	  
	  WebDriver driver = new  ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  
	  WebElement seachText = driver.findElement(By.xpath("//input[@name='q']"));
	  seachText.sendKeys(TestDataSearch);
	  
  }
}
