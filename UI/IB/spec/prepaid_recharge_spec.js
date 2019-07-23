var prepaid_page = requirePage('prepaid_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var prepaid_data = Ib.read_from_excel('valid_data', 'prepaid');


describe('Prepaid recharge', function() {

  beforeEach(() => {
    browser.get(Ib.url());
  })

  prepaid_data.forEach(function(data, index) {
    it('successful prepaid recharge', function() {
      prepaid_page.visit();
      prepaid_page.populate_form(data);
      prepaid_page.submit();
      expect(success_transaction_page.greeting_message_text()).toEqual('Thank you! Payment was successful.');
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })
})