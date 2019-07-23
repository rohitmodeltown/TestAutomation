var dashboard_page = requirePage('dashboard_page');
var transfer_page = requirePage('transfer_page');
var Ib = requireHelper('ib');

class P2bPage {

  constructor() {
    this.txt_bank_name = element(by.model('P2bCtrl.dataObject.selectedBank'));
    this.first_bank = element(by.xpath('(//input[@ng-model="P2bCtrl.dataObject.selectedBank"]/following-sibling::ul//a)[1]'));
    this.txt_account_no = element(by.model('P2bCtrl.dataObject.beneAccNo'));
    this.txt_bene_account_no = element(by.model('P2bCtrl.dataObject.reBeneAccNo'));
    this.txt_bene_mobile = element(by.model('P2bCtrl.dataObject.beneMobNo'));
    this.txt_amount = element(by.model('P2bCtrl.dataObject.amount'));
    this.txt_bene_name = element(by.model('P2bCtrl.dataObject.beneName'));
    this.btn_send_now = element(by.buttonText('SEND NOW'));
    this.btn_proceed = element(by.buttonText('PROCEED'));
  }

  visit() {
    dashboard_page.visit();
    dashboard_page.click_transfer_tab();
    transfer_page.click_p2b_icon();
  }

  select_bank(bank) {
    Ib.wait_for_element_present(this.txt_bank_name).sendKeys(bank);
    Ib.wait_for_element_present(this.first_bank).click();
  }

  populate_form(data) {
    if (data.bank_name) {
      this.select_bank(data.bank_name);
    }
    if (data.account_no) {
      this.txt_account_no.sendKeys(data.account_no);
    }

    if (data.confirm_account_no) {
      this.txt_bene_account_no.sendKeys(data.confirm_account_no);
    }

    if (data.mobile_no) {
      this.txt_bene_mobile.sendKeys(data.mobile_no);
    }

    if (data.amount) {
      this.txt_amount.sendKeys(data.amount);
    }

    if (data.bene_name) {
      this.txt_bene_name.sendKeys(data.bene_name);
    }
  }

  click_send_now_btn() {
    this.btn_send_now.click();
  }

  click_proceed_btn() {
    Ib.wait_for_element_present(this.btn_proceed).click();
  }
}

module.exports = new P2bPage();
