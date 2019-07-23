package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class URL {

	public static void main(String[] args) {

		System.setProperty("webdriver.firefox.marionette",
				"D:\\Software\\Selenium Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		// comment the above 2 lines and uncomment below 2 lines to use Chrome

		WebDriver driver = new FirefoxDriver();
		driver.get("https://apbuat.airtelbank.com/Cybersafe");
		String url = "https://apbuat.airtelbank.com/Cybersafe";
		String partOfUrl = url.substring(url.indexOf(".") + 1, url.length());
		System.out.println(partOfUrl.substring(0, (partOfUrl.indexOf(".") + 2)));

	}

}
