var dashboard_page = requirePage('dashboard_page');
var Ib = requireHelper('ib');

class TransferPage {
  constructor() {
    this.p2p_icon = element(by.linkText('TO OWN BANK'));
    this.p2b_icon = element(by.linkText('TO OTHER BANK'));
  }

  click_p2p_icon() {
    Ib.wait_for_element_present(this.p2p_icon).click();
  }

  click_p2b_icon() {
    Ib.wait_for_element_present(this.p2b_icon).click();
  }

}

module.exports = new TransferPage();