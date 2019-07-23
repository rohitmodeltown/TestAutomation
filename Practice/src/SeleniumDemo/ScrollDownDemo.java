/**
 * 
 */
package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author A1SKIVA4
 *
 */





public class ScrollDownDemo {
	
	public static void main(String []args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		/*Scroll down on page by using pixals
		*/
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(-1500,0)");
		
		
		
		/*Scroll down by find element of page*/
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.linkText("Career Guru99"));
		js.executeScript("arguments[0].scrollIntoView();",element);
		System.out.println(element.getText());
		element.click();
		
		
		
		/*		
		Scroll down till end of the page.
		 */	
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
		
		/*js.executeScript("window.scrollBy(1500,0)");
		js.executeScript("arguments[0].scrollIntoView;" element);
		js.executeScript("windlow.scrollTo(0,document.body.scrollHeight)");*/
		
		
		
		
	}

}
