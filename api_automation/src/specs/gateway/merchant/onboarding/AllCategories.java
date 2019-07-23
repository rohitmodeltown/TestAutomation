package specs.gateway.merchant.onboarding;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import helpers.gateway.merchant.onboarding.Helper;
import helpers.gateway.merchant.onboarding.Merchant;

public class AllCategories extends Helper{
	
	
	@Test(dataProvider="viewCategoriesDataProvider")
	public void viewCategories(String ver, String channel, String languageID, String message, String code, String errorCode) throws Exception {
		Merchant merchant = new Merchant();
		merchant.viewCategories(ver, channel, languageID);

		assertEquals(merchant.messageText,message);
		assertEquals(merchant.code,code);
		assertEquals(merchant.errorCode,errorCode);
	}
}







