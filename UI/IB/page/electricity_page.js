var dashboard_page = requirePage('dashboard_page');
var payment_and_recharges_page = requirePage('payment_and_recharges_page');
var Ib = requireHelper('ib');

class ElectricityPage {

  // Elements
  constructor() {
    this.txt_operator = element(by.model('UtilityCtrl.data.biller'));
    this.first_operator_option = element(by.xpath('//input[@ng-model="UtilityCtrl.data.biller"]/..//li[1]'));
    this.txt_account = element(by.model('UtilityCtrl.data.biller.references[key].data'));
    this.dwn_cycle = element(by.model('UtilityCtrl.data.biller.references[key].data'));
    this.txt_amount = element(by.model('UtilityCtrl.utilityBillObject.payAmount'));
    this.btn_pay_bill = element(by.buttonText('Pay Bill'));
  }
  
  select_cycle(cycle) {
    this.dwn_cycle.click();
    element(by.xpath('//select[@ng-model="UtilityCtrl.data.biller.references[key].data"]/option[@label="' + cycle + '"]')).click();
  }

  //Methods
  visit() {
    dashboard_page.visit();
    dashboard_page.click_payment_and_recharges();
    payment_and_recharges_page.click_electricity_icon();
  }

  select_operator(keyword) {
    Ib.wait_for_element_present(this.txt_operator).click();
    this.txt_operator.sendKeys(keyword)
    this.first_operator_option.click();
  }

  click_pay_bill_btn() {
    this.btn_pay_bill.click();
  }

  populate_form(data) {
    this.select_operator(data.keyword);
    this.txt_account.sendKeys(data.account);
    this.select_cycle(data.cycle);
    this.txt_amount.sendKeys(data.amount);
  }
}

module.exports = new ElectricityPage();