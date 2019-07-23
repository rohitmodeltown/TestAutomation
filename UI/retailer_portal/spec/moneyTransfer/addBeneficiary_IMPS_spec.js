var page = requireHelper('page');
var retailer_login_page = require('../../page/retailer_page');
var retailer_home_page = require('../../page/retailer_home');
var retailer_register_page = require('../../page/moneyTransfer/retailer_customerRegister');
var retailer_addBeneficary_IMPS_page = require('../../page/moneyTransfer/addBeneficary_IMPS');
var db = require('../../database');

//excel data
var retailer_register_xltc12 = page.read_from_excel('tc12','customerRegister');
var retailer_register_xltc13 = page.read_from_excel('tc13','customerRegister');
var retailer_register_xltc14 = page.read_from_excel('tc14','customerRegister');




//test case discribtion start
describe('retailer Add bebeficary', function() {

// before each test execution	
	beforeEach(() => {
		browser.get('http://10.56.110.150/RetailerPortal/#/app');
		browser.sleep(1000);
	});

    
    //TC#12 - Verify beneficary fields
    retailer_home_xltc12.forEach(function(data, index) {
		it('Verify beneficary fields',function(){
    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                  retailer_login_page.mobileNumber_inputBox.sendKeys(data.mobileNumber);
                  retailer_login_page.password_inputBox.sendKeys(data.password);
                  retailer_login_page.login_btn.click();
                  browser.ignoreSynchronization = true;
                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_home_page.register_moneyTransfer_icon), 10000) //wait until OTP sent message box is displayed
		                .then(function(){
                      retailer_home_page.register_moneyTransfer_icon.click();
                      browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_mobileNumber_inputBox),10000)
                        .then(function(){
                            retailer_register_page.register_mobileNumber_inputBox.sendKeys(data.fullCustomerNumber);
                            retailer_register_page.register_proceed_btn.click();
                            browser.wait(browser.ExpectedConditions.visibilityOf(retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox),10000)
                        .then(function(){
                                expect(retailer_addBeneficary_IMPS_page.beneficiary_addBeneficary_text.isDisplayed()).toBe(true);
                                expect(retailer_addBeneficary_IMPS_page.beneficiary_enterDetalis_text.isDisplayed()).toBe(true);
                                expect(retailer_addBeneficary_IMPS_page.beneficiary_text.isDisplayed()).toBe(true);
                                expect(retailer_addBeneficary_IMPS_page.beneficiary_name_inputBox.isDisplayed()).toBe(true);
                                expect(retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox.isDisplayed()).toBe(true);
                            })
                        })  
                    }) 
			      })
		    });
    })



    //TC#13 - Verify invalid mobile number
    retailer_home_xltc13.forEach(function(data, index) {
		it('Verify invalid mobile number',function(){
    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                  retailer_login_page.mobileNumber_inputBox.sendKeys(data.mobileNumber);
                  retailer_login_page.password_inputBox.sendKeys(data.password);
                  retailer_login_page.login_btn.click();
                  browser.ignoreSynchronization = true;
                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_home_page.register_moneyTransfer_icon), 10000) //wait until OTP sent message box is displayed
		                .then(function(){
                      retailer_home_page.register_moneyTransfer_icon.click();
                      browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_mobileNumber_inputBox),10000)
                        .then(function(){
                            retailer_register_page.register_mobileNumber_inputBox.sendKeys(data.fullCustomerNumber);
                            retailer_register_page.register_proceed_btn.click();
                            browser.wait(browser.ExpectedConditions.visibilityOf(retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox),10000)
                        .then(function(){
                                    retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox.sendKeys(data.mobileNo);
                                    expect(data.msg).toBe("Please enter a valid mobile number.");
                            })
                        })  
                    }) 
			      })
		    });
    })
    
//TC#13 - Verify lookup popup fields
    retailer_home_xltc14.forEach(function(data, index) {
		it('Verify lookup popup fields',function(){
    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_login_page.mobileNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
                  retailer_login_page.mobileNumber_inputBox.sendKeys(data.mobileNumber);
                  retailer_login_page.password_inputBox.sendKeys(data.password);
                  retailer_login_page.login_btn.click();
                  browser.ignoreSynchronization = true;
                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_home_page.register_moneyTransfer_icon), 10000) //wait until OTP sent message box is displayed
		                .then(function(){
                      retailer_home_page.register_moneyTransfer_icon.click();
                      browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_mobileNumber_inputBox),10000)
                        .then(function(){
                            retailer_register_page.register_mobileNumber_inputBox.sendKeys(data.fullCustomerNumber);
                            retailer_register_page.register_proceed_btn.click();
                            browser.wait(browser.ExpectedConditions.visibilityOf(retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox),10000)
                        .then(function(){
                                    

//write code
                            
                            })
                        })  
                    }) 
			      })
		    });
    })




});