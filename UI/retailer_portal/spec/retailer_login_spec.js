var page = requireHelper('page');
var retailer_login_page = require('../page/retailer_page.js');
var retailer_home_page = require('../page/retailer_home.js');
var db = require('../database');

//excel data
var retailer_login_xltc2 = page.read_from_excel( 'tc2', 'retailer');
var retailer_login_xltc3 = page.read_from_excel( 'tc3', 'retailer');
var retailer_login_xltc4 = page.read_from_excel( 'tc4', 'retailer');
var retailer_login_xltc5 = page.read_from_excel('tc5','retailer');


//test case discribtion start
describe('retailer login', function() {

// before each test execution	
	beforeEach(() => {
		browser.get(' http://10.56.110.172/RetailerPortal_Release_14May/#/app');
		browser.sleep(1000);
	});


	//TC#1 - Verify fields on login	
	it('Verify fields on login',function(){
		browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
					expect(retailer_login_page.airtel_logo.isDisplayed()).toBe(true);
					expect(retailer_login_page.mobileNumber_inputBox.isDisplayed()).toBe(true);
					expect(retailer_login_page.password_inputBox.isDisplayed()).toBe(true);
					expect(retailer_login_page.forgetPasswordLink_linkText.isDisplayed()).toBe(true);
					expect(retailer_login_page.signUP_linkText.isDisplayed()).toBe(true);
					expect(retailer_login_page.login_btn.isDisplayed()).toBe(true);	
			})	
	});

	//TC#2 - verify error message for mobile number field
	retailer_login_xltc2.forEach(function(data, index) {
		it('verify error msg for mobile number',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
					retailer_login_page.login_btn.click();
					retailer_login_page.get_toast_msg().then(function(toastMsg){
						console.log("msg is: "+toastMsg);
						expect(toastMsg).toBe(data.msg);
				})
			})
		});
	})

	//TC#3 - verify error message for blank password field
	retailer_login_xltc3.forEach(function(data, index) {
		it('verify error msg for blank password ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
					retailer_login_page.mobileNumber_inputBox.sendKeys(data.mobileNumber);
					retailer_login_page.login_btn.click();
					retailer_login_page.get_toast_msg().then(function(toastMsg){
						expect(toastMsg).toBe(data.msg);
				})
			})
		});
	})
	//TC#4 - verify error message for invalid password
	retailer_login_xltc4.forEach(function(data, index) {
		it('verify error msg for invalid password ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
					retailer_login_page.mobileNumber_inputBox.sendKeys(data.mobileNumber);
					retailer_login_page.password_inputBox.sendKeys(data.password);
					retailer_login_page.login_btn.click();
					retailer_login_page.get_toast_msg().then(function(toastMsg){
						expect(toastMsg).toBe(data.msg);
				})
			})
		});
	})

	//TC#5 - verify succesful login
	retailer_login_xltc5.forEach(function(data, index) {
		it('verify succesful login ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
					retailer_login_page.mobileNumber_inputBox.sendKeys(data.mobileNumber);
					retailer_login_page.password_inputBox.sendKeys(data.password);
					retailer_login_page.login_btn.click();
					browser.wait(browser.ExpectedConditions.visibilityOf(retailer_home_page.register_moneyTransfer_icon),10000)
					.then(function(){
						expect(retailer_home_page.register_moneyTransfer_icon.isDisplayed()).toBe(true);	
					})
			})
		});
	})
	
	//TC#6 - verify forget password page
		it('verify forget password page ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPasswordLink_linkText), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
				retailer_login_page.forgetPasswordLink_linkText.click();
				browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_resetPassword_btn), 10000) //wait until OTP sent message box is displayed
		        	.then(function(){
						expect(retailer_login_page.forgetPage_mobileNumber_inputBox.isDisplayed()).toBe(true);
						expect(retailer_login_page.forgetPage_otp_inputBox.isDisplayed()).toBe(true);
						expect(retailer_login_page.forgetPage_newPassword_inputBox.isDisplayed()).toBe(true);
						expect(retailer_login_page.forgetPage_confirmNewPassword_inputBox.isDisplayed()).toBe(true);
						expect(retailer_login_page.forgetPage_login_linkText.isDisplayed()).toBe(true);
						expect(retailer_login_page.forgetPage_resetPassword_btn.isDisplayed()).toBe(true);	
			})
		});
		})

		//TC#7- verify navigation from forget page to login page
		it('verify navigation ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPasswordLink_linkText), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
				retailer_login_page.forgetPasswordLink_linkText.click();
				browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_resetPassword_btn), 10000) //wait until OTP sent message box is displayed
		        	.then(function(){
						retailer_login_page.forgetPage_login_linkText.click();
						expect(retailer_login_page.signUP_linkText.isDisplayed()).toBe(true);	
			})
		});
		})

});

