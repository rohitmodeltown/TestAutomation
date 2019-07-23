var login_page = requirePage('login_page');
var Ib = requireHelper('ib');
var user = Ib.read_from_excel('login', 'global')[0];

class DashboardPage {
  constructor() {
    this.greeting = element(by.className('user-details')).element(by.tagName('span'));
    this.lnk_payment_and_recharges = element(by.linkText('PAYMENTS & RECHARGES'));
    this.lnk_transfer = element(by.linkText('TRANSFER'));
  }

  //Methods
  greeting_message() {
    return this.greeting.getText();
  }

  click_payment_and_recharges() {
    this.lnk_payment_and_recharges.click();
  }

  click_transfer_tab() {
    this.lnk_transfer.click();
  }

  visit() {
    login_page.login(user);
  }



}

module.exports = new DashboardPage();