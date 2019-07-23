/**
 * 
 */
package SeleniumDemo;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author A1SKIVA4
 *
 */
public class DoubleClick2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/");
		
		List<WebElement> elements  = driver.findElements(By.tagName("a"));
		
		System.out.println(elements);
		for (int i=0; i<=elements.size();i++) {
			
			System.err.println(i);
			
			
		}
		


	}

}
