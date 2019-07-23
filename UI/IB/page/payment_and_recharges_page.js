var Ib = requireHelper('ib');

class PaymentAndRecharges {
  //Elements
  constructor() {
    this.prepaid_icon = element(by.xpath('//a[@ui-sref="app.banking.prepaidRechargePAR"]'));
    this.electricity_icon = element(by.xpath('//a[@ui-sref="app.banking.utilityElectricityPAR"]'));
    this.dth_icon = element(by.xpath('//a[@ui-sref="app.banking.dthRechargePAR"]'));
    this.data_card_recharges_icon = element(by.xpath('//a[@ui-sref="app.banking.datacardRechargePAR"]'));
    this.postpaid_icon = element(by.xpath('//a[@ui-sref="app.banking.postpaidBillPAR"]'));
    this.landline_icon = element(by.xpath('//a[@ui-sref="app.banking.landlineBillPAR"]'));
    this.data_card_utility_icon = element(by.xpath('//a[@ui-sref="app.banking.dataCardBillPAR"]'));
    this.gas_icon = element(by.xpath('//a[@ui-sref="app.banking.utilityGasPAR"]'));
    this.insurance_icon = element(by.xpath('//a[@ui-sref="app.banking.utilityInsurancePAR"]'));
  }

  //Methods
  click_prepaid_icon() {
    Ib.wait_for_element_present(this.prepaid_icon).click();
  }

  click_electricity_icon() {
    Ib.wait_for_element_present(this.electricity_icon).click(); 
  }

  click_dth_icon() {
    Ib.wait_for_element_present(this.dth_icon).click();
  }

  click_data_card_recharges_icon() {
    Ib.wait_for_element_present(this.data_card_recharges_icon).click(); 
  }

  click_postpaid_icon() {
    Ib.wait_for_element_present(this.postpaid_icon).click();
  }

  click_landline_icon() {
    Ib.wait_for_element_present(this.landline_icon).click();
  }

  click_data_card_utility_icon() {
    Ib.wait_for_element_present(this.data_card_utility_icon).click();
  }

  click_gas_icon() {
    Ib.wait_for_element_present(this.gas_icon).click();
  }

  click_insurance_icon() {
    Ib.wait_for_element_present(this.insurance_icon).click();
  }
  
}

module.exports = new PaymentAndRecharges(); 