var page = requireHelper('page');
var retailer_login_page = require('../page/retailer_page.js');
var db = require('../database');

//excel data
var retailer_login_xltc8 = page.read_from_excel( 'tc8', 'retailer');
var retailer_login_xltc11 = page.read_from_excel('tc11','retailer');
var retailer_login_xltc1315 = page.read_from_excel('tc13-15','retailer');
var retailer_login_xltc14  = page.read_from_excel('tc14','retailer');
var retailer_login_xltc1223 = page.read_from_excel('tc12-23','retailer');
//test case discribtion start
describe('retailer foregt', function() {

// before each test execution	
	beforeEach(() => {
		browser.get('http://10.56.110.172/RetailerPortal_BugFix_MultipleReciept_Timeout/#');
		browser.sleep(1000);
	});

    //TC#17 - verify fields on signUp
		it('verify fields on signUp',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.signUP_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_getOtp_linkText), 10000) //wait until OTP sent message box is displayed
		                .then(function(){
                        expect(retailer_login_page.forgetPage_mobileNumber_inputBox.isDisplayed()).toBe(true);
                        expect(retailer_login_page.forgetPage_otp_inputBox.isDisplayed()).toBe(true);
                        expect(retailer_login_page.forgetPage_newPassword_inputBox.isDisplayed()).toBe(true);
                        expect(retailer_login_page.forgetPage_confirmNewPassword_inputBox.isDisplayed()).toBe(true);
                        expect(retailer_login_page.forgetPage_login_linkText.isDisplayed()).toBe(true);
                        expect(retailer_login_page.signUp_page_btn.isDisplayed()).toBe(true);	

                })
					
			})
		});
    
        //TC#18- verify navigation from forget page to login page
		it('verify navigation ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPasswordLink_linkText), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
				retailer_login_page.signUP_linkText.click();
				browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_resetPassword_btn), 10000) //wait until OTP sent message box is displayed
		        	.then(function(){
						retailer_login_page.forgetPage_login_linkText.click();
						expect(retailer_login_page.signUP_linkText.isDisplayed()).toBe(true);	
			})
		});
		})




   //tc#22 - Verify SIGN UP button is Enabled
   retailer_login_xltc11.forEach(function(data, index) {
    it('verify sign up button',function(){
        browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
            .then(function(){
                retailer_login_page.signUP_linkText.click();
                browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                .then(function(){
                    retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                    retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                    retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                    retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                    retailer_login_page.signUp_page_btn.isEnabled().then(function(isLoginEnabledStatus){
                        expect(isLoginEnabledStatus).toBe(true);
                    })

        })
        })
    });
})

    //tc#23 - Verify error msg for invalid otp on sign up page
    retailer_login_xltc1223.forEach(function(data, index) {
		it('verify error msg for invalid otp ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.signUP_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                        retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                        retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                        retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                        retailer_login_page.signUp_page_btn.click();
                        retailer_login_page.get_toast_msg().then(function(toastMsg){
                            expect(toastMsg).toBe(data.msg);
                        })

            })
			})
		});
    })

    //tc#28 - Verify error msg for alredy registered user
    retailer_login_xltc28.forEach(function(data, index) {
		fit('verify error msg for alredy registered user ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.signUP_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                        retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                        retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                        retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                        retailer_login_page.signUp_page_btn.click();
                        retailer_login_page.get_toast_msg().then(function(toastMsg){
                            expect(toastMsg).toBe(data.msg);
                        })

            })
			})
		});
    })

    //tc#29 - Verify error msg for not registered as retailer
    retailer_login_xltc29.forEach(function(data, index) {
		fit('verify error msg for not register as retailer',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.signUP_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                        retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                        retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                        retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                        retailer_login_page.signUp_page_btn.click();
                        retailer_login_page.get_toast_msg().then(function(toastMsg){
                            expect(toastMsg).toBe(data.msg);
                        })

            })
			})
		});
    })


});

