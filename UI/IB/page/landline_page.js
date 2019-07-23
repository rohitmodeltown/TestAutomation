var dashboard_page = requirePage('dashboard_page');
var payment_and_recharges_page = requirePage('payment_and_recharges_page');
var Ib = requireHelper('ib');

class PostpaidPage {

  constructor() {
    this.txt_mobile = element(by.model('RechargeCtrl.billData.number'));
    this.dwn_operator = element(by.model('RechargeCtrl.billData.biller'));
    this.txt_amount = element(by.model('RechargeCtrl.billData.amount'));
    this.btn_proceed = element(by.buttonText('PROCEED'));
  }

  visit() {
    dashboard_page.visit();
    dashboard_page.click_payment_and_recharges();
    payment_and_recharges_page.click_landline_icon();
  }

  select_operator(operator) {
    this.dwn_operator.click();
    this.dwn_operator.element(by.xpath('//option[@label=' + '"' + operator + '"' + ']')).click();
  }

  populate_form(data) {
    Ib.wait_for_element_present(this.txt_mobile).sendKeys(data.mobile);
    this.select_operator(data.operator);
    this.txt_amount.click().sendKeys(data.amount);
  }

  click_proceed_btn() {
    this.btn_proceed.click();
  }
}

module.exports = new PostpaidPage();