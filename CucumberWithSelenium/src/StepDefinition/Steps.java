package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Steps {
	
	WebDriver driver;
	
    @Given("^Open the Firefox and launch the application$")				
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
        System.out.println("This Step open the Firefox and launch the application.");
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
            
        
    }		

    @When("^Enter the Username$")					
    public void enter_the_Username() throws Throwable 							
    {		
       System.out.println("This step enter the Username on the login page.");	
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rohitkumar");
    }		
    
    @And("^Enter The Password$")
    public void enter_the_Password() throws Throwable 							
    {		
       System.out.println("This step enter the Password on the login page.");	
       driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1234567864");
    }

    @Then("^Submit the Button$")					
    public void Submit_the_Button() throws Throwable 							
    {    		
        System.out.println("This step click on the Reset button.");	
        driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
        
    }	
    
    
    @Given("^Open the Chrome and launch the application$")
	public void Open_the_Chrome_and_launch_the_application() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\Software\\\\Selenium Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

	}

	@When("^Enter the firstname$")
	public void Enter_the_firstname() {
		
		driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("RAMKUMAR");
		System.out.println("Enter first name ");

	}

	@And("^Enter the lastname$")
	public void Enter_the_lastname() {

		driver.findElement(By.xpath("//*[@id=\"u_0_l\"]")).sendKeys("VIMALPRASAD");
		System.out.println("Enter Last name");

	}

	@And("^Enter Mobile Number$")
	public void Enter_Mobile_Number() {

		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9586795687");
		System.out.println("Enter Mobile number");

	}

	@And("^Enter The Pass of user$")
	public void Enter_The_Password_of_user() {

		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("mynameisrohit");
		System.out.println("Enter password ");

	}

	@Then("^Submit the Sign Button$")
	public void Submit_the_Sign_Button() {
		
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		System.out.println("Clicked on Signout button.");


	}


}
