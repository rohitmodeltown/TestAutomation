var dashboard_page = requirePage('dashboard_page');
var transfer_page = requirePage('transfer_page');
// var Ib = requireHelper('ib');

class P2pPage {

  constructor() {
    this.txt_mobile = element(by.model('P2pCtrl.dataObject.beneMobileNo'));
    this.txt_amount = element(by.model('P2pCtrl.dataObject.paymentAmt'));
    this.btn_send_now = element(by.buttonText('SEND NOW'));
  }

  visit() {
    dashboard_page.visit();
    dashboard_page.click_transfer_tab();
    transfer_page.click_p2p_icon();
  }

  populate_form(data) {
    if (data.mobile) {
      this.txt_mobile.sendKeys(data.mobile);
    }

    if (data.amount) {
      this.txt_amount.sendKeys(data.amount);
    }
  }

  click_send_now_btn() {
    this.btn_send_now.click();
  }
}

module.exports = new P2pPage();
