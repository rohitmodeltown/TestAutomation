var db = require('../../database');

class retailer_customerRegister_page {
	
	//Initializing customer registration flow web elements
	constructor() {
    this.toast_msg = $(".toast-message");    

	this.register_moneyTransfer_text = element(by.xpath("//h2[contains(text(),'Money Transfer')]"));
	this.register_enterDetails_text = element(by.xpath("//span[contains(text(),'Enter Details')]"));
	this.register_beneficiary_text = element(by.xpath("//span[contains(text(),'Beneficiary')]"));
	this.register_mobileNumber_inputBox = element(by.model('MTCtrl.data.custMobileNumber'));
	this.register_proceed_btn = element(by.buttonText("PROCEED"));

	this.register_customerRegister_text = element(by.xpath("//h2[contains(text(),'Customer Registration')]"));
	this.register_customerMobileNo_text = element(by.xpath("//label[contains(text(),'Customer Mobile Number')]"));
	this.register_customerFilledMobileNo = $('.fill-text-detail.ng-binding');
	this.register_customerFirstName_inputBox = element(by.model("CRCtrl.data.fName"));
	this.register_customerLastName_inputBox = element(by.model("CRCtrl.data.lName"));
    this.register_customerDateOfbirth_inputBox = element(by.model("CRCtrl.data.dob"));
    this.register_customer_callender_arrow_btn = $('.glyphicon.glyphicon-chevron-left');
	this.register_customerAddress_inputBox = element(by.model("CRCtrl.data.address"));
	this.register_customerPincode_inputBox = element(by.model("CRCtrl.data.pinCode"));
    this.register_submit_btn = element(by.buttonText("submit"));
	this.register_enterOtp_inputBox =element(by.model("TOCRCtrl.data.otp"));
	this.register_resendLink_linkText=element(by.linkText('resend OTP'));
    this.register_submitOtp_btn = element(by.buttonText("Submit"));
    this.register_mpinText = element(by.xpath("//label[contains(text(),'Enter retailer')]"));
	this.register_mpin1_inputBox = element(by.model("mpin1"));
	this.register_mpin2_inputBox = element(by.model("mpin2"));
	this.register_mpin3_inputBox = element(by.model("mpin3"));
	this.register_mpin4_inputBox = element(by.model("mpin4"));
	this.register_mpinNo_linkText = element(by.xpath("//a[@ng-click='MVCtrl.cancel()']"));
	this.register_mpinYes_btn = element(by.buttonText("Yes"));

	this.beneficiary_name_inputBox = element(by.model("AddBCtrl.data.beneName"));
	this.beneficiary_mobileNumber_inputBox = element(by.model("AddBCtrl.data.beneMobileNumber"));
	this.beneficiary_bankName_selectBox = element(by.model("AddBCtrl.data.bankName"));
}

get_toast_msg(){
    browser.sleep(2000);
    return this.toast_msg.getText();		
}
		

}

module.exports = new retailer_customerRegister_page();