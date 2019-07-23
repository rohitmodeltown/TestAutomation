var page = requireHelper('page');
var retailer_login_page = require('../page/retailer_page.js');
var db = require('../database');

//excel data
var retailer_login_xltc8 = page.read_from_excel( 'tc8', 'retailer');
var retailer_login_xltc11 = page.read_from_excel('tc11','retailer');
var retailer_login_xltc1223 = page.read_from_excel('tc12-23','retailer');
var retailer_login_xltc1315 = page.read_from_excel('tc13-15','retailer');
var retailer_login_xltc14  = page.read_from_excel('tc14','retailer');
var retailer_login_xltc16 = page.read_from_excel('tc16','retailer');
var retailer_login_xltc910 = page.read_from_excel('tc9-10','retailer');

//test case discribtion start
describe('retailer foregt', function() {

// before each test execution	
	beforeEach(() => {
		browser.get(' http://10.56.110.172/RetailerPortal_Release_14May/#/app');
		browser.sleep(1000);
	});

    //TC#8 && TC#19- verify error message for mobile number field on forget page & on signUp page
	retailer_login_xltc8.forEach(function(data, index) {
		fit('verify error msg for mobile number',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_getOtp_linkText), 10000) //wait until OTP sent message box is displayed
		                .then(function(){
                            retailer_login_page.forgetPage_getOtp_linkText.click();
                            retailer_login_page.get_toast_msg().then(function(toastMsg){
                                expect(toastMsg).toBe(data.msg);
			        	})

                })
					
			})
		});
    })
  
    //TC#9 - verify GET OTP functionality
    //tc#10 - Verify RESEND OTP functionality
    //tc#20 - verify GET OTP functionality
    //tc21 - Verify RESEND OTP functionality
    retailer_login_xltc910.forEach(function(data, index) {
		it('verify otp functionality',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_getOtp_linkText), 10000) //wait until OTP sent message box is displayed
		                .then(function(){
                            retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                            retailer_login_page.forgetPage_getOtp_linkText.click();
                            retailer_login_page.get_toast_msg().then(function(toastMsg){
                                expect(toastMsg).toBe(data.msg);
                                        retailer_login_page.forgetPage_resendOtp_linkText.click();
                                        retailer_login_page.get_toast_msg().then(function(toastMsg){
                                        expect(toastMsg).toBe(data.resendMsg);
                                    })
                            
                                
                                
			        	})

                })
					
			})
		});
    })



    //tc#11 - Verify RESEND button is Enabled
    retailer_login_xltc11.forEach(function(data, index) {
		it('verify succesful login ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                        retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                        retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                        retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                        retailer_login_page.forgetPage_resetPassword_btn.isEnabled().then(function(isLoginEnabledStatus){
                            expect(isLoginEnabledStatus).toBe(true);
                        })

            })
			})
		});
    })
    
    //tc#12 - Verify error msg for invalid otp on forget page
    retailer_login_xltc1223.forEach(function(data, index) {
		it('verify error msg for invalid otp ',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                        retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                        retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                        retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                        retailer_login_page.forgetPage_resetPassword_btn.click();
                        retailer_login_page.get_toast_msg().then(function(toastMsg){
                            expect(toastMsg).toBe(data.msg);
                        })

            })
			})
		});
    })



//tc#13 && tc#15 && tc#24 && tc26 - Verify password length, minimum 8 char && Verify message on Re-enter Password field.
retailer_login_xltc1315.forEach(function(data, index) {
        it('verify password length and confirm password field',function(){
            browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
                .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        if(data.validationRequired == 'true'){   
                            retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                            retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                            retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                            retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);                                                           
                            expect(data.newpasswordMsg).toBe("New Password should be minimum 8 character long.");
                            expect(data.confirmpasswordMsg).toBe("Re enter password should be same as password.");
                        }
                })
            })
        });
    })


    //tc#14 tc#25 - Verify password formate information
    retailer_login_xltc14.forEach(function(data, index) {
        it('verify password formate information',function(){
            browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
                .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                            retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                            retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                            retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                            expect(data.newpasswordMsg1).toBe("Please enter a valid password.");
                            expect(data.newpasswordMsg2).toBe("should contain at least 1 alphabet, 1 digit, 1 special character, 1 lower case character, 1 upper case character.");
                })
            })
        });
    })


    //tc#16 - Verify successful reset password
    retailer_login_xltc16.forEach(function(data, index) {
		it('verify successful reset password',function(){
			browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                    retailer_login_page.forgetPasswordLink_linkText.click();
                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.forgetPage_otp_inputBox), 10000) //wait until OTP sent message box is displayed
                    .then(function(){
                        retailer_login_page.forgetPage_mobileNumber_inputBox.sendKeys(data.mobileNumber);
                        retailer_login_page.forgetPage_otp_inputBox.sendKeys(data.getOtp);
                        retailer_login_page.forgetPage_newPassword_inputBox.sendKeys(data.newPassword);
                        retailer_login_page.forgetPage_confirmNewPassword_inputBox.sendKeys(data.confirmPassword);
                        retailer_login_page.forgetPage_resetPassword_btn.click();
                        retailer_login_page.get_toast_msg().then(function(toastMsg){
                            expect(toastMsg).toBe(data.msg);
                        })

            })
			})
		});
    })




});

