var landline_page = requirePage('landline_page');
var Ib = requireHelper('ib');
var success_transaction_page = requirePage('success_transaction_page');
var landline_data = Ib.read_from_excel('valid_data', 'landline');

describe('Landline bill payment', function() {
  
  beforeEach(() => {
    browser.get(Ib.url());
  })

  landline_data.forEach(function(data, index) {
    it('successful dth recharge', function() {
      landline_page.visit();
      landline_page.populate_form(data);
      landline_page.click_proceed_btn();
      expect(success_transaction_page.greeting_message_text()).toEqual(data.message);
      expect(success_transaction_page.get_amount()).toEqual(data.amount);
    })
  })
})