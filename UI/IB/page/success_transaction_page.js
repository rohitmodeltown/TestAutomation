var Ib = requireHelper('ib');

class SuccessTransactionPage {

  constructor() {
    this.greeting_message = element(by.xpath('//div[@class="sucmessage"]/p'));
    this.amount = element(by.xpath('(//div[@class="gray_container"]//p[@class="ng-binding"])[2]'));
  }

  //Methods
  greeting_message_text() {
    return Ib.wait_for_element_present(this.greeting_message).getText().then(function(text) {
      return text.replace(/(\r\n|\n|\r)/gm," ").trim();
    })
  }

  get_amount() {
    return this.amount.getText().then(function(text) {
      return text.replace ( /[^\d.]/g, '' ).trim();
    })
  }
}

module.exports = new SuccessTransactionPage();