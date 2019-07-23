var dashboard_page = requirePage('dashboard_page');
var payment_and_recharges_page = requirePage('payment_and_recharges_page');
var Ib = requireHelper('ib');

class PrepaidPage {
  //Elements
  constructor() {
    this.txt_mobile = element(by.model('RechargeCtrl.billData.number'));
    this.dwn_operator = element(by.model('RechargeCtrl.billData.biller'));
    this.dwn_circle = element(by.model('RechargeCtrl.billData.circle'));
    this.txt_amount = element(by.model('RechargeCtrl.billData.amount'));
    this.btn_proceed = element(by.buttonText('PROCEED'));
  }

  select_operator(operator) {
    this.dwn_operator.click();
    this.dwn_operator.element(by.xpath('//option[@label=' + '"' + operator + '"' + ']')).click();
  }

  select_circle(circle) {
    this.dwn_circle.click();
    this.dwn_circle.element(by.xpath('//option[@label=' + '"' + circle + '"' + ']')).click();
  }

  //Methods
  visit() {
    dashboard_page.visit();
    dashboard_page.click_payment_and_recharges();
    payment_and_recharges_page.click_prepaid_icon();
  }

  populate_form(data) {
    Ib.wait_for_element_present(this.txt_mobile).sendKeys(data.mobile);
    this.select_operator(data.operator);
    this.select_circle(data.circle);
    this.txt_amount.click().sendKeys(data.amount);
  }

  submit() {
    this.btn_proceed.click();
  }
}

module.exports = new PrepaidPage();