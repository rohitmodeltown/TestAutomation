var postpaid_page = requirePage('postpaid_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var postpaid_data = Ib.read_from_excel('valid_data', 'postpaid');

describe('Postpaid bill payment', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  postpaid_data.forEach(function(data, index) {
    it('successful dth recharge', function() {
      postpaid_page.visit();
      postpaid_page.populate_form(data);
      postpaid_page.click_proceed_btn();
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })
})