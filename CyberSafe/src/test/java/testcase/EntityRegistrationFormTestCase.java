/**
 * 
 */
package testcase;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.common.Log4j;
import com.ui.pages.EntityRegistration;

/**
 * @author A1SKIVA4
 *
 */
public class EntityRegistrationFormTestCase extends BaseTest {

	EntityRegistration entityregister;

	public EntityRegistrationFormTestCase() {

		super();
	}

	@BeforeTest
	public void startTC() {

		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		Log4j.info("*****************************************************************************************************");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX                  " + "-S-T-A-R-T-" + "                 XXXXXXXXXXXXXXXXXXXXXX");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX           " + "Entity Registration Form" + "           XXXXXXXXXXXXXXXXXXXXXX");

	}

	@AfterTest
	public void endTC() {
		DOMConfigurator.configure("D:\\Eclipse\\CyberSafe\\log4j.xml");
		Log4j.info("XXXXXXXXXXXXXXXXXXXXXXX                 " + "-E---N---D-" + "                  XXXXXXXXXXXXXXXXXXXXXX");
		Log4j.info("*****************************************************************************************************");
		terminate();
	}
	
	@Test
	public void createEntityRegistrationForm() {
		Log4j.info("Entity Registration from to create new entity");
		initializeDriver();
		entityregister = new EntityRegistration();
		entityregister.entityRegisterform();
		entityregister.entityDetails("TestAutoEntity", "9834936443", "022", "34633525", "TestAutoEntity@yopmail.com",
				"MER", "AB-23/65", "Mall Road", "411001", "Modi", "Kejriwal", "modikejiwaltest@yopmail.com",
				"9847654457");

	}

}
