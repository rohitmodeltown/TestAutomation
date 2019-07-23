/**
 * 
 */
package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

/**
 * @author A1SKIVA4
 *
 */
public class UserRegistration extends BaseTest{

	@FindBy(how= How.XPATH, using = "//strong[contains(text(),'User Registration')]")
	WebElement user_RegistrationForm;
	
	public UserRegistration() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void userRegisterform() {

		user_RegistrationForm.click();
	}
	
}
