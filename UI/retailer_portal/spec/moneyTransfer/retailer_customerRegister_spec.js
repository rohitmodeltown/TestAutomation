var page = requireHelper('page');
var retailer_login_page = require('../../page/retailer_page');
var retailer_home_page = require('../../page/retailer_home');
var retailer_register_page = require('../../page/moneyTransfer/retailer_customerRegister');
var retailer_addBeneficary_IMPS_page = require('../../page/moneyTransfer/addBeneficary_IMPS');
var db = require('../../database');

//excel data
var retailer_home_xltc1 = page.read_from_excel( 'tc1M', 'retailer');
var retailer_home_xltc6 = page.read_from_excel('tc6M','retailer');
var retailer_register_xltc7 = page.read_from_excel('tc7M','customerRegister');
var retailer_register_xltc8 = page.read_from_excel('tc8M','customerRegister');
var retailer_register_xltc10 = page.read_from_excel('tc10M','customerRegister');
var retailer_register_xltc11 = page.read_from_excel('tc11M','customerRegister');




//test case discribtion start
describe('retailer walk-In customer registeration', function() {

// before each test execution	
	beforeEach(() => {
		browser.get('http://10.56.110.150/RetailerPortal/#/app');
		browser.sleep(1000);
	});

   
    //TC#1 - verify money transfer page
    retailer_home_xltc1.forEach(function(data, index) {
		it('verify money transfer page',function(){
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
                            expect(retailer_register_page.register_moneyTransfer_text.isDisplayed()).toBe(true);
                            expect(retailer_register_page.register_enterDetails_text.isDisplayed()).toBe(true);
                            expect(retailer_register_page.register_beneficiary_text.isDisplayed()).toBe(true);
                            expect(retailer_register_page.register_mobileNumber_inputBox.isDisplayed()).toBe(true);
                            expect(retailer_register_page.register_proceed_btn.isDisplayed()).toBe(true);	
                        })  
                    }) 
			      })
		    });
    })

        //TC#2 - check error msg on mobile no field
        retailer_home_xltc1.forEach(function(data, index) {
          fit('check error msg on mobile no field',function(){
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
                                    retailer_register_page.register_mobileNumber_inputBox.sendKeys(data.customerNumber);
                                      expect(data.msg).toBe("Please enter a valid mobile number.");
                                   })   
      
                      })
                
            })
          });
          })
      
 //TC#3 - proceed button get enable
 retailer_home_xltc1.forEach(function(data, index) {
  it('proceed btn is enabled',function(){
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
                            retailer_register_page.register_proceed_btn.isEnabled().then(function(isLoginEnabledStatus){
                              expect(isLoginEnabledStatus).toBe(true);
                          }) 
                    })   
              })
    })
  });
  })


  //TC#4 - check avilabel component
 retailer_home_xltc1.forEach(function(data, index) {
  it('check avilabel component',function(){
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
                                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                  .then(function(){
                                      
                                    retailer_register_page.register_customerFilledMobileNo.getText().then(function(text){
                                        var confirm = '+91 '+data.fullCustomerNumber;
                                        expect(retailer_register_page.register_customerRegister_text.isDisplayed()).toBe(true);
                                        expect(retailer_register_page.register_customerMobileNo_text.isDisplayed()).toBe(true);
                                        expect(text).toBe(confirm);
                                        expect(retailer_register_page.register_customerFirstName_inputBox.isDisplayed()).toBe(true);
                                        expect(retailer_register_page.register_customerLastName_inputBox.isDisplayed()).toBe(true);
                                      })
                                      
                                  })
                          
                          })   

              })
        
    })
  });
  })

 //TC#5 - verify error msg on pincode field
 retailer_home_xltc1.forEach(function(data, index) {
  it('verify error msg on pincode field',function(){
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
                                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                  .then(function(){
                                    retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                      expect(data.pinMsg).toBe('PIN Code should be 6 digit long.');
                                  })
                          
                          })   

              })
        
    })
  });
  })


//TC#6 - verify otp popup
retailer_home_xltc6.forEach(function(data, index) {
  it('verify otp popup',function(){
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
                                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                  .then(function(){
                                    retailer_register_page.register_customerFirstName_inputBox.sendKeys(data.firstName);
                                    retailer_register_page.register_customerLastName_inputBox.sendKeys(data.lastName);
                                    retailer_register_page.register_customerDateOfbirth_inputBox.click();
                                    retailer_register_page.register_customer_callender_arrow_btn.click();
                                    element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '1993')).click();
                                    element(by.cssContainingText('[ng-click="select(dt.date)"] > span', 'January')).click();
                                    element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '01')).click();                                    
                                    retailer_register_page.register_customerAddress_inputBox.sendKeys(data.address);  
                                    retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                     retailer_register_page.register_submit_btn.click();
                                     browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_enterOtp_inputBox), 10000) //wait until OTP sent message box is displayed
                                     .then(function(){
                                      expect(retailer_register_page.register_enterOtp_inputBox.isDisplayed()).toBe(true);
                                      expect(retailer_register_page.register_resendLink_linkText.isDisplayed()).toBe(true);
                                      retailer_register_page.register_submitOtp_btn.isEnabled().then(function(isLoginEnabledStatus){
                                        console.log(isLoginEnabledStatus);
                                        expect(isLoginEnabledStatus).toBe(false);
                                    }) 

                                     })  
                                  })
                          
                          })   

              })
        
    })
  });
  })



  //TC#7 - verify resend otp functionality
retailer_register_xltc7.forEach(function(data, index) {
  it('verify resend otp functionality',function(){
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
                                  browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                  .then(function(){
                                    retailer_register_page.register_customerFirstName_inputBox.sendKeys(data.firstName);
                                    retailer_register_page.register_customerLastName_inputBox.sendKeys(data.lastName);
                                    retailer_register_page.register_customerDateOfbirth_inputBox.click();
                                    retailer_register_page.register_customer_callender_arrow_btn.click();
                                    element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '1993')).click();
                                    element(by.cssContainingText('[ng-click="select(dt.date)"] > span', 'January')).click();
                                    element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '01')).click();                                    
                                    retailer_register_page.register_customerAddress_inputBox.sendKeys(data.address);  
                                    retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                     retailer_register_page.register_submit_btn.click();
                                     browser.wait(browser.ExpectedConditions.elementToBeClickable(retailer_register_page.register_submitOtp_btn), 10000) //wait until OTP sent message box is displayed
                                     .then(function(){
                                      browser.ignoreSynchronization =true; 
                                      retailer_register_page.register_submitOtp_btn.click();
                                       retailer_register_page.get_toast_msg().then(function(toastMsg){
                                       console.log("msg is: "+toastMsg);
                                       expect(toastMsg).toBe(data.msg);
                                   })

                                     })  
                                  })
                          
                          })   

              })
        
    })
  });
  })


//TC#8 - verify mpin popup fields
  retailer_register_xltc8.forEach(function(data, index) {
    it('verify mpin popup fields',function(){
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
                                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                    .then(function(){
                                      retailer_register_page.register_customerFirstName_inputBox.sendKeys(data.firstName);
                                      retailer_register_page.register_customerLastName_inputBox.sendKeys(data.lastName);
                                      retailer_register_page.register_customerDateOfbirth_inputBox.click();
                                      retailer_register_page.register_customer_callender_arrow_btn.click();
                                      element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '1993')).click();
                                      element(by.cssContainingText('[ng-click="select(dt.date)"] > span', 'January')).click();
                                      element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '01')).click();                                    
                                      retailer_register_page.register_customerAddress_inputBox.sendKeys(data.address);  
                                      retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                      retailer_register_page.register_submit_btn.click();
                                       browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_enterOtp_inputBox), 10000) //wait until OTP sent message box is displayed
                                      .then(function(){
                                          retailer_register_page.register_enterOtp_inputBox.sendKeys(data.popupOtp);
                                          retailer_register_page.register_submitOtp_btn.click();
                                         browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_mpin1_inputBox),10000) 
                                        .then(function(){
                                          expect(retailer_register_page.register_mpinText.isDisplayed()).toBe(true);
                                          expect(retailer_register_page.register_mpin1_inputBox.isDisplayed()).toBe(true);
                                          expect(retailer_register_page.register_mpin2_inputBox.isDisplayed()).toBe(true);
                                          expect(retailer_register_page.register_mpin3_inputBox.isDisplayed()).toBe(true);
                                          expect(retailer_register_page.register_mpin4_inputBox.isDisplayed()).toBe(true);
                                          expect(retailer_register_page.register_mpinNo_linkText.isDisplayed()).toBe(true);
                                          expect(retailer_register_page.register_mpinYes_btn.isDisplayed()).toBe(true);
                                        })
                                        })  
                                    })
                            
                            })   
  
                })
          
      })
    });
    })
  

    //TC#9 - verify navigation on NO btn click
  retailer_register_xltc8.forEach(function(data, index) {
    it('verify navigation on NO btn click',function(){
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
                                    browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                    .then(function(){
                                      retailer_register_page.register_customerFirstName_inputBox.sendKeys(data.firstName);
                                      retailer_register_page.register_customerLastName_inputBox.sendKeys(data.lastName);
                                      retailer_register_page.register_customerDateOfbirth_inputBox.click();
                                      retailer_register_page.register_customer_callender_arrow_btn.click();
                                      element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '1993')).click();
                                      element(by.cssContainingText('[ng-click="select(dt.date)"] > span', 'January')).click();
                                      element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '01')).click();                                    
                                      retailer_register_page.register_customerAddress_inputBox.sendKeys(data.address);  
                                      retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                      retailer_register_page.register_submit_btn.click();
                                       browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_enterOtp_inputBox), 10000) //wait until OTP sent message box is displayed
                                      .then(function(){
                                          retailer_register_page.register_enterOtp_inputBox.sendKeys(data.popupOtp);
                                          retailer_register_page.register_submitOtp_btn.click();
                                         browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_mpin1_inputBox),10000) 
                                        .then(function(){
                                          retailer_register_page.register_mpinNo_linkText.click();
                                          expect(retailer_register_page.register_customerPincode_inputBox.isDisplayed()).toBe(true);
                          
                                        })
                                        })  
                                    })
                            
                            })   
  
                })
          
      })
    });
    })
  

    //TC#10 - verify msg on invalid otp
    retailer_register_xltc10.forEach(function(data, index) {
      it('verify msg on invalid otp',function(){
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
                                      browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                      .then(function(){
                                        retailer_register_page.register_customerFirstName_inputBox.sendKeys(data.firstName);
                                        retailer_register_page.register_customerLastName_inputBox.sendKeys(data.lastName);
                                        retailer_register_page.register_customerDateOfbirth_inputBox.click();
                                        retailer_register_page.register_customer_callender_arrow_btn.click();
                                        element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '1993')).click();
                                        element(by.cssContainingText('[ng-click="select(dt.date)"] > span', 'January')).click();
                                        element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '01')).click();                                    
                                        retailer_register_page.register_customerAddress_inputBox.sendKeys(data.address);  
                                        retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                        retailer_register_page.register_submit_btn.click();
                                         browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_enterOtp_inputBox), 10000) //wait until OTP sent message box is displayed
                                        .then(function(){
                                            retailer_register_page.register_enterOtp_inputBox.sendKeys(data.popupOtp);
                                            retailer_register_page.register_submitOtp_btn.click();
                                            retailer_register_page.get_toast_msg().then(function(toastMsg){
                                              console.log("msg is: "+toastMsg);
                                              expect(toastMsg).toBe(data.msg);
                                          })
                                          })  
                                      })
                              
                              })   
    
                  })
            
        })
      });
      })
    

      //TC#11 - verify succesful customer registration and navigation to add benificiery screen
    retailer_register_xltc11.forEach(function(data, index) {
      it('verify succesful customer registration',function(){
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
                                      browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_customerPincode_inputBox), 10000) //wait until OTP sent message box is displayed
                                      .then(function(){
                                        retailer_register_page.register_customerFirstName_inputBox.sendKeys(data.firstName);
                                        retailer_register_page.register_customerLastName_inputBox.sendKeys(data.lastName);
                                        retailer_register_page.register_customerDateOfbirth_inputBox.click();
                                        retailer_register_page.register_customer_callender_arrow_btn.click();
                                        element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '1993')).click();
                                        element(by.cssContainingText('[ng-click="select(dt.date)"] > span', 'January')).click();
                                        element(by.cssContainingText('[ng-click="select(dt.date)"] > span', '02')).click();                                    
                                        retailer_register_page.register_customerAddress_inputBox.sendKeys(data.address);  
                                        retailer_register_page.register_customerPincode_inputBox.sendKeys(data.pincode);
                                        retailer_register_page.register_submit_btn.click();
                                         browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_enterOtp_inputBox), 10000) //wait until OTP sent message box is displayed
                                        .then(function(){
                                            retailer_register_page.register_enterOtp_inputBox.sendKeys(data.popupOtp);
                                            retailer_register_page.register_submitOtp_btn.click();
                                            browser.wait(browser.ExpectedConditions.visibilityOf(retailer_register_page.register_mpin1_inputBox),10000) 
                                            .then(function(){
                                              retailer_register_page.register_mpin1_inputBox.sendKeys(data.mpinData1);
                                              retailer_register_page.register_mpin2_inputBox.sendKeys(data.mpinData2);
                                              retailer_register_page.register_mpin3_inputBox.sendKeys(data.mpinData3);
                                              retailer_register_page.register_mpin4_inputBox.sendKeys(data.mpinData4);
                                              retailer_register_page.register_mpinYes_btn.click();
                                              browser.wait(browser.ExpectedConditions.visibilityOf(retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox),10000) 
                                              .then(function(){
                                                expect(retailer_addBeneficary_IMPS_page.beneficiary_mobileNumber_inputBox.isDisplayed()).toBe(true);

                                              })     
                                              
                                            })
                                          })  
                                      })
                              
                              })   
    
                  })
            
        })
      });
      })
    





});

