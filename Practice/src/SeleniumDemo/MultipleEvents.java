/**
 * 
 */
package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author A1SKIVA4
 *
 */
public class MultipleEvents {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://artoftesting.com/sampleSiteForSelenium.html");

		System.out.println("Sample WebPage for Automation");

		WebElement This_is_a_link = driver.findElement(By.linkText("This is a link"));
		This_is_a_link.click();

		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		WebElement textbox = driver.findElement(By.name("firstName"));
		textbox.sendKeys("This is Rohit from Airtel");

		Actions act = new Actions(driver);
		WebElement buttonhover = driver.findElement(By.id("idOfButton"));
		act.moveToElement(buttonhover).build().perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		buttonhover.click();

		WebElement doubleclick = driver.findElement(By.id("dblClkBtn"));
		act.doubleClick(doubleclick).perform();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();

		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		WebElement radio = driver.findElement(By.id("male"));
		radio.click();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		WebElement checkbox = driver.findElement(By.xpath("//input[@class='Automation']"));
		checkbox.click();

		WebElement dropdownfield = driver.findElement(By.id("testingDropdown"));
		Select value = new Select(dropdownfield);
		value.selectByIndex(2);;

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		WebElement generateAlert = driver.findElement(By.xpath("//button[contains(text(),'Generate Alert Box')]"));
		generateAlert.click();
		
		driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement confirmbox = driver.findElement(By.xpath("//button[contains(text(),'Generate Confirm Box')]"));
		confirmbox.click();

		driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();

		String success = driver.findElement(By.xpath("//p[@id=\"demo\"]")).getText();
		String msg = "You pressed OK!";

		if (success == msg) {
			System.out.println("THis is correct way");
			
			WebElement from = driver.findElement(By.xpath("//img[@id='sourceImage']"));
			WebElement to = driver.findElement(By.xpath("//div[@id='targetDiv']"));
			
			act.dragAndDrop(from, to).build().perform();
			
		} else {
			System.out.println("EXIT");
		}
		
		
		WebElement from = driver.findElement(By.xpath("//img[@id='sourceImage']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='targetDiv']"));
		//Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();

	}
}
