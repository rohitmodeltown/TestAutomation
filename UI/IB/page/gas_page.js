var dashboard_page = requirePage('dashboard_page');
var payment_and_recharges_page = requirePage('payment_and_recharges_page');
var Ib = requireHelper('ib');

class GasPage {

  constructor() {
    this.dwn_operator = element(by.model('UtilityCtrl.data.biller'));
    this.first_operator = element(by.xpath('(//input[@ng-model="UtilityCtrl.data.biller"]/following-sibling::ul//a)[1]'));
    this.txt_customer_id = element(by.model('UtilityCtrl.data.biller.references[key].data'));
    this.txt_bill_group_number = element(by.model('UtilityCtrl.data.biller.references[key].data'));
    this.btn_fetch_bill = element(by.buttonText('Fetch Bill'));
  }

  visit() {
    dashboard_page.visit();
    dashboard_page.click_payment_and_recharges();
    payment_and_recharges_page.click_gas_icon();
  }

  select_operator(operator) {
    Ib.wait_for_element_present(this.dwn_operator).click().sendKeys(operator);
    Ib.wait_for_element_present(this.first_operator).click();
  }

  populate_form(data) {
    if (data.customer_id) {
      this.txt_customer_id.sendKeys(data.customer_id);
    }

    if (data.bill_group_number) {
      this.txt_bill_group_number.sendKeys(data.bill_group_number);
    }
  }

  click_fetch_bill_btn() {
    this.btn_fetch_bill.click();
  }
}

module.exports = new GasPage();