/**
 * 
 */
package SeleniumDemo;

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
public class DoubleClick {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");

		Actions act = new Actions(driver);
		WebElement doubleclickdemo = driver
				.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		act.doubleClick(doubleclickdemo).perform();
		
		Alert al = (Alert)driver;
		driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();

	}

}
