/**
 * 
 */
package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.base.BaseTest;

/**
 * @author A1SKIVA4
 *
 */
public class EntityRegistration extends BaseTest {

	@FindBy(xpath = "//strong[contains(text(),'Entity Registration')]")
	WebElement entity_Registration;

	@FindBy(id = "name")
	WebElement entityname;

	@FindBy(xpath = "//input[@id='phone_alternate']")
	WebElement entitymobile;

	@FindBy(name = "phone_office_std")
	WebElement entitySTD;

	@FindBy(xpath = "//input[@id='phone_office']")
	WebElement Landline;

	@FindBy(name = "email")
	WebElement EmailAddress;

	@FindBy(name = "website")
	WebElement Website;

	@FindBy(name = "type_of_entity")
	WebElement EntityType;

	@FindBy(name = "registered_add_line1")
	WebElement AddLine1;

	@FindBy(id = "registered_add_line2")
	WebElement AddLine2;

	@FindBy(xpath = "//input[@id='registered_add_pincode']")
	WebElement Pincode;

	@FindBy(name = "auth_signatory_first_name")
	WebElement Auth_FirstName;

	@FindBy(id = "auth_signatory_last_name")
	WebElement Auth_LastName;

	@FindBy(xpath = "//input[@id='auth_signatory_mobile']")
	WebElement Auth_Mobile;

	@FindBy(xpath = "//input[@id='auth_signatory_email']")
	WebElement Auth_EmailID;

	public EntityRegistration() {

		PageFactory.initElements(driver, this);
	}

	public void entityRegisterform() {

		entity_Registration.click();
	}

	/* Details of Entity  */
	public void entityDetails(String entityName, String mobile, String stdcode, String phonenumber, String email, String entType, String add1, String add2,
			String pin, String Auth_FName, String Auth_LName, String Auth_email, String Auth_Mob) {

		entityname.sendKeys(entityName);
		entitymobile.sendKeys(toString());
		entitySTD.sendKeys(stdcode);
		Landline.sendKeys(phonenumber);
		EmailAddress.sendKeys(email);

		Select type = new Select(EntityType);
		type.selectByValue(entType);

		AddLine1.sendKeys(add1);
		AddLine2.sendKeys(add2);
		Pincode.sendKeys(pin);
		Auth_FirstName.sendKeys(Auth_FName);
		Auth_LastName.sendKeys(Auth_LName);
		Auth_Mobile.sendKeys(Auth_Mob);
		Auth_EmailID.sendKeys(Auth_email);

	}

}
