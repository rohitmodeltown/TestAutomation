var db = require('../../database');

class retailer_addBeneficary_page {
	
	//Initializing add beneficary flow web elements
	constructor() {
    this.toast_msg = $(".toast-message");    

    this.beneficiary_addBeneficary_text = element(by.xpath("//h2[contains(text(),'Add Beneficiary')]"));
    this.beneficiary_enterDetalis_text = element(by.xpath("//span[contains(text(),'Enter Details')]"));
    this.beneficiary_text = element(by.xpath("//span[contains(text(),'Beneficiary')]"));
    this.beneficiary_name_inputBox = element(by.model("AddBCtrl.data.beneName"));
	this.beneficiary_mobileNumber_inputBox = element(by.model("AddBCtrl.data.beneMobileNumber"));
    this.beneficiary_bankName_selectBox = element(by.model("AddBCtrl.data.bankName"));

//    this.beneficiary_lookup_linkText = element(by.linkText('Look Up'));
//    this.                               element(by.model("SICtrl.data.bankName"));
//    this.model                      =   element(by.model());
    
    


}

    get_toast_msg(){
        browser.sleep(2000);
        return this.toast_msg.getText();		
    }
		

}

module.exports = new retailer_addBeneficary_page();