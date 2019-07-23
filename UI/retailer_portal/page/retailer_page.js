var db = require('../database');

class retailer_login_page {
	
	//Initializing login page web elements
	constructor() {
		//login page
		this.airtel_logo = element(by.xpath("//img[@src='images/airtel-bank-logo.png']"));
		this.mobileNumber_inputBox = element(by.model("LoginCtrl.username"));
		this.password_inputBox = element(by.model("LoginCtrl.password"));
		this.forgetPasswordLink_linkText= element(by.linkText("Forgot Password?"));
		this.signUP_linkText = element(by.linkText("SIGN UP"));
		this.login_btn = element(by.buttonText("Login"));

		this.toast_msg = $(".toast-message");
		
		//forget password page
		this.forgetPage_mobileNumber_inputBox = element(by.model("SignUpCtrl.data.customerId"));
		this.forgetPage_getOtp_linkText =element(by.linkText('GET OTP'));
		this.forgetPage_otp_inputBox = element(by.model("SignUpCtrl.data.otp"));
		this.forgetPage_newPassword_inputBox = element(by.model("SignUpCtrl.data.password"));
		this.forgetPage_newPassword_msg = element(by.xpath("//input[@ng-model=‘SignUpCtrl.data.password’]/following-sibling::div"));
		this.forgetPage_confirmNewPassword_inputBox = element(by.model("SignUpCtrl.data.confirmPassword"));
		this.forgetPage_login_linkText = element(by.xpath("//a[@href='#/app']"));
		this.forgetPage_resetPassword_btn = element(by.buttonText("Reset Password"));
		this.forgetPage_resendOtp_linkText = element(by.linkText('Resend OTP'));
		
		this.signUp_page_btn = element(by.buttonText("Sign Up"));
		
	}

		get_toast_msg(){
					//return this.toast_msg.getText();
					browser.sleep(2000);
					return this.toast_msg.getText();		
			}


}

module.exports = new retailer_login_page();