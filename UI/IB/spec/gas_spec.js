var gas_page = requirePage('gas_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var gas_data = Ib.read_from_excel('valid_data', 'gas');

describe('Gas bill payment', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  gas_data.forEach(function(data, index) {
    it('successful dth recharge', function() {
      gas_page.visit();
      gas_page.select_operator(data.operator);
      gas_page.populate_form(data);
      gas_page.click_fetch_bill_btn();
      // expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      // expect(success_transaction_page.get_amount()).toEqual(data.amount);
      browser.sleep(5000);
    })
  })
})